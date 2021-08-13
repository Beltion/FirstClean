package com.gmail.olegbeltion.firstclean.data.net

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface BookServices {

    @GET("books")
    suspend fun fetchBooks() : ResponseBody

}