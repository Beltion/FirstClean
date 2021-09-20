package com.gmail.olegbeltion.firstclean.presentation

import com.gmail.olegbeltion.firstclean.R
import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.domain.BookDomain
import com.gmail.olegbeltion.firstclean.domain.BookDomainToUiMapper
import com.gmail.olegbeltion.firstclean.domain.ErrorType

sealed class BooksUi : Abstract.Object<Unit, BooksCommunication> {
    class Success(private val books: List<BookDomain>, private val bookMapper: BookDomainToUiMapper) : BooksUi() {
        override fun map(mapper: BooksCommunication) {
            val booksUi = books.map {
                 it.map(bookMapper)
            }
            mapper.map(booksUi)
        }
    }

    class Fail(
        private val errorType: ErrorType,
        private val resourcesProvider: ResourcesProvider
    ) : BooksUi() {
        override fun map(mapper: BooksCommunication) {
            val msgId = when (errorType) {
                ErrorType.NO_CONNECTION -> R.string.no_connection_msg
                ErrorType.SERVICE_UNAVAILABLE -> R.string.services_unavailable
                else -> R.string.something_went_wrong
            }
            val msg = resourcesProvider.getString(msgId)
            mapper.map(listOf(BookUi.Fail(msg)))
        }
    }
}