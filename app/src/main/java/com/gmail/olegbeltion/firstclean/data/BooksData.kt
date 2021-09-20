package com.gmail.olegbeltion.firstclean.data

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.domain.BooksDomain

sealed class BooksData : Abstract.Object<BooksDomain, BooksDataToDomainMapper> {
    class Success(private val books: List<BookData>) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper): BooksDomain {
            return mapper.map(books)
        }
    }

    class Fail(private val e: Exception) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper): BooksDomain {
            return mapper.map(e)
        }
    }

}