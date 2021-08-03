package com.gmail.olegbeltion.firstclean.core

import android.app.Application
import com.gmail.olegbeltion.firstclean.data.BooksCloudDataSource
import com.gmail.olegbeltion.firstclean.data.BooksCloudMapper
import com.gmail.olegbeltion.firstclean.data.BooksRepository
import com.gmail.olegbeltion.firstclean.data.cache.BookCacheMapper
import com.gmail.olegbeltion.firstclean.data.cache.BooksCacheDataSource
import com.gmail.olegbeltion.firstclean.data.cache.BooksCacheMapper
import com.gmail.olegbeltion.firstclean.data.cache.RealmProvider
import com.gmail.olegbeltion.firstclean.data.net.BookCloudMapper
import com.gmail.olegbeltion.firstclean.data.net.BookServices
import com.gmail.olegbeltion.firstclean.domain.BaseBooksDomainToUiMapper
import com.gmail.olegbeltion.firstclean.domain.BooksInteractor
import com.gmail.olegbeltion.firstclean.presentation.BooksCommunication
import com.gmail.olegbeltion.firstclean.presentation.MainViewModel
import com.gmail.olegbeltion.firstclean.presentation.ResourcesProvider
import retrofit2.Retrofit

class BibleApp : Application() {

    private companion object {
        private const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }

    lateinit var mainViewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()


        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()

        val services = retrofit.create(BookServices::class.java)

        val cloudBooksDs = BooksCloudDataSource.Base(services)
        val cacheBooksDs = BooksCacheDataSource.Base(RealmProvider.Base())
        val booksCloudMapper = BooksCloudMapper.Base(BookCloudMapper.Base())
        val booksCacheMapper = BooksCacheMapper.Base(BookCacheMapper.Base())

        val booksRepository = BooksRepository.Base(
            cloudBooksDs,
            cacheBooksDs,
            booksCloudMapper,
            booksCacheMapper,
        )

        val booksInteractor: BooksInteractor = TODO()

        mainViewModel = MainViewModel(
            booksInteractor,
            BaseBooksDomainToUiMapper(BooksCommunication.Base(), ResourcesProvider.Base(this))
        )
    }

}