package com.gmail.olegbeltion.firstclean.data.net

import retrofit2.http.GET

interface BookServices {

    @GET("books")
    suspend fun fetchBooks() : List<BookCloud>

}