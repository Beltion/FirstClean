package com.gmail.olegbeltion.firstclean.domain

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.data.BookData
import com.gmail.olegbeltion.firstclean.data.BookDataToDomainMapper
import com.gmail.olegbeltion.firstclean.data.TestamentTemp
import com.gmail.olegbeltion.firstclean.presentation.BooksUi
import retrofit2.HttpException
import java.net.UnknownHostException

sealed class BooksDomain : Abstract.Object<BooksUi, BooksDomainToUiMapper> {
    data class Success(
        private val books: List<BookDomain>
    ) : BooksDomain() {
        override fun map(mapper: BooksDomainToUiMapper) =  mapper.map(books)
    }

    data class Fail(private val e: ErrorType) : BooksDomain() {
        override fun map(mapper: BooksDomainToUiMapper) = mapper.map(e)
    }

}