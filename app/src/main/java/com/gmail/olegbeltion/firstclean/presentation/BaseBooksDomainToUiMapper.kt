package com.gmail.olegbeltion.firstclean.presentation

import com.gmail.olegbeltion.firstclean.R
import com.gmail.olegbeltion.firstclean.domain.BookDomain
import com.gmail.olegbeltion.firstclean.domain.BookDomainToUiMapper
import com.gmail.olegbeltion.firstclean.domain.BooksDomainToUiMapper
import com.gmail.olegbeltion.firstclean.domain.ErrorType

class BaseBooksDomainToUiMapper(
    private val resourcesProvider: ResourcesProvider,
    private val bookMapper: BookDomainToUiMapper
) :
    BooksDomainToUiMapper {
    override fun map(books: List<BookDomain>) = BooksUi.Success(books.map {
        it.map(bookMapper)
    })

    override fun map(errorType: ErrorType): BooksUi.Fail {
        val msgId = when (errorType) {
            ErrorType.NO_CONNECTION -> R.string.no_connection_msg
            ErrorType.SERVICE_UNAVAILABLE -> R.string.services_unavailable
            else -> R.string.something_went_wrong
        }
        val msg = resourcesProvider.getString(msgId)
        return BooksUi.Fail(msg)
    }
}