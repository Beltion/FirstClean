package com.gmail.olegbeltion.firstclean.domain

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.presentation.BooksUi

interface BooksDomainToUiMapper : Abstract.Mapper {
    fun map(books: List<BookDomain>): BooksUi
    fun map(errorType: ErrorType): BooksUi
}