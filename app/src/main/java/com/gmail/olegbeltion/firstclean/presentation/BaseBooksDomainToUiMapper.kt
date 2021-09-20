package com.gmail.olegbeltion.firstclean.presentation

import com.gmail.olegbeltion.firstclean.domain.BookDomain
import com.gmail.olegbeltion.firstclean.domain.BookDomainToUiMapper
import com.gmail.olegbeltion.firstclean.domain.BooksDomainToUiMapper
import com.gmail.olegbeltion.firstclean.domain.ErrorType

class BaseBooksDomainToUiMapper(
    private val resourcesProvider: ResourcesProvider,
    private val bookMapper: BookDomainToUiMapper
) :
    BooksDomainToUiMapper {
    override fun map(books: List<BookDomain>) = BooksUi.Success(books, bookMapper)
    override fun map(errorType: ErrorType) = BooksUi.Fail(errorType, resourcesProvider)
}