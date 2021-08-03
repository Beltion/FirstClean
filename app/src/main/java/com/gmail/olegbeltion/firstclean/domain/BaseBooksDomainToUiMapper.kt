package com.gmail.olegbeltion.firstclean.domain

import com.gmail.olegbeltion.firstclean.core.Book
import com.gmail.olegbeltion.firstclean.presentation.BooksCommunication
import com.gmail.olegbeltion.firstclean.presentation.BooksUi
import com.gmail.olegbeltion.firstclean.presentation.ResourcesProvider

class BaseBooksDomainToUiMapper(
    private val communication: BooksCommunication,
    private val resourcesProvider: ResourcesProvider
) : BooksDomainToUiMapper {
    override fun map(books: List<Book>) = BooksUi.Success(communication, books)

    override fun map(errorType: ErrorType) =
        BooksUi.Fail(communication, errorType, resourcesProvider)
}