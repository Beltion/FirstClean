package com.gmail.olegbeltion.firstclean.core

import android.app.Application
import com.gmail.olegbeltion.firstclean.data.BooksCloudDataSource
import com.gmail.olegbeltion.firstclean.data.BooksCloudMapper
import com.gmail.olegbeltion.firstclean.data.BooksRepository
import com.gmail.olegbeltion.firstclean.data.ToBookMapper
import com.gmail.olegbeltion.firstclean.data.cache.BookDataToDbMapper
import com.gmail.olegbeltion.firstclean.data.cache.BooksCacheDataSource
import com.gmail.olegbeltion.firstclean.data.cache.BooksCacheMapper
import com.gmail.olegbeltion.firstclean.data.cache.RealmProvider
import com.gmail.olegbeltion.firstclean.data.net.BookServices
import com.gmail.olegbeltion.firstclean.domain.BaseBookDataToDomainMapper
import com.gmail.olegbeltion.firstclean.domain.BaseBooksDataToDomainMapper
import com.gmail.olegbeltion.firstclean.domain.BooksInteractor
import com.gmail.olegbeltion.firstclean.presentation.*
import com.google.gson.Gson
import io.realm.Realm
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class BibleApp : Application() {

    private companion object {
        private const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }

    lateinit var mainViewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .build()

        val services = retrofit.create(BookServices::class.java)

        val gson = Gson()
        val cloudBooksDs = BooksCloudDataSource.Base(services, gson)
        val cacheBooksDs =
            BooksCacheDataSource.Base(RealmProvider.Base(), BookDataToDbMapper.Base())
        val toBookMapper = ToBookMapper.Base()
        val booksCloudMapper = BooksCloudMapper.Base(toBookMapper)
        val booksCacheMapper = BooksCacheMapper.Base(toBookMapper)

        val booksRepository = BooksRepository.Base(
            cloudBooksDs,
            cacheBooksDs,
            booksCloudMapper,
            booksCacheMapper,
        )
        val communication = BooksCommunication.Base()
        val booksInteractor = BooksInteractor.Base(booksRepository, BaseBooksDataToDomainMapper(
            BaseBookDataToDomainMapper()
        ))

        mainViewModel = MainViewModel(
            booksInteractor,
            BaseBooksDomainToUiMapper(ResourcesProvider.Base(this), BaseBookDomainToUiMapper()),
            communication
        )
    }

}