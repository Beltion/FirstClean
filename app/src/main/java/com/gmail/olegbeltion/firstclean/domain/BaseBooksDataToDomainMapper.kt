package com.gmail.olegbeltion.firstclean.domain

import com.gmail.olegbeltion.firstclean.core.Book
import com.gmail.olegbeltion.firstclean.data.BooksDataToDomainMapper

class BaseBooksDataToDomainMapper() :
    BooksDataToDomainMapper {
    override fun map(books: List<Book>) = BookDomain.Success(books)
    override fun map(e: Exception) = BookDomain.Fail(e)
}