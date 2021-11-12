package com.gmail.olegbeltion.firstclean.presentation

import com.gmail.olegbeltion.firstclean.R
import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.domain.BookDomain
import com.gmail.olegbeltion.firstclean.domain.BookDomainToUiMapper
import com.gmail.olegbeltion.firstclean.domain.ErrorType

sealed class BooksUi : Abstract.Object<Unit, BooksCommunication> {
    data class Success(private val books: List<BookUi>) : BooksUi() {
        override fun map(mapper: BooksCommunication) = mapper.map(books)
    }

    data class Fail(
        private val errorMsg: String
    ) : BooksUi() {
        override fun map(mapper: BooksCommunication) = mapper.map(listOf(BookUi.Fail(errorMsg)))
    }
}