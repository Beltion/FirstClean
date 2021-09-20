package com.gmail.olegbeltion.firstclean.domain

import com.gmail.olegbeltion.firstclean.data.BookData
import com.gmail.olegbeltion.firstclean.data.BookDataToDomainMapper
import com.gmail.olegbeltion.firstclean.data.BooksDataToDomainMapper

class BaseBooksDataToDomainMapper(private val mapper: BookDataToDomainMapper) :
    BooksDataToDomainMapper {
    override fun map(books: List<BookData>) = BooksDomain.Success(books, mapper)
    override fun map(e: Exception) = BooksDomain.Fail(e)
}