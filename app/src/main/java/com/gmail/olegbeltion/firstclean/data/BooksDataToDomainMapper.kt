package com.gmail.olegbeltion.firstclean.data

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.core.Book
import com.gmail.olegbeltion.firstclean.data.BooksData
import com.gmail.olegbeltion.firstclean.domain.BookDomain
import retrofit2.HttpException
import java.net.UnknownHostException

interface BooksDataToDomainMapper : Abstract.Mapper {
    fun map(books: List<Book>) : BookDomain
    fun map(e: Exception) : BookDomain
}