package com.gmail.olegbeltion.firstclean.core

import android.app.Application
import com.gmail.olegbeltion.firstclean.data.net.BookServices
import retrofit2.Retrofit

class BibleApp : Application() {

    private companion object{
        private const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }

    override fun onCreate() {
        super.onCreate()


        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()

        val services = retrofit.create(BookServices::class.java)
    }

}