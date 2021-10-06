package com.gmail.olegbeltion.firstclean.domain

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.data.BookData
import com.gmail.olegbeltion.firstclean.data.BookDataToDomainMapper
import com.gmail.olegbeltion.firstclean.presentation.BooksUi
import retrofit2.HttpException
import java.net.UnknownHostException

sealed class BooksDomain : Abstract.Object<BooksUi, BooksDomainToUiMapper> {
    class Success(
        private val books: List<BookData>,
        private val bookMapper: BookDataToDomainMapper
    ) : BooksDomain() {
        override fun map(mapper: BooksDomainToUiMapper): BooksUi {
            val data = mutableListOf<BookDomain>()
            val ot = "OT"
            val nt = "NT"
            var testament = ""
            books.forEach { bookData ->
                if (!bookData.compare(testament)) {
                    if (testament.isEmpty())
                        data.add(BookDomain.Testament(TestamentType.OLD))
                    else
                        data.add(BookDomain.Testament(TestamentType.NEW))
                    testament = bookData.getTestament()
                }
                data.add(bookData.map(bookMapper))
            }



            return mapper.map(data)
        }
    }

    class Fail(private val e: Exception) : BooksDomain() {
        override fun map(mapper: BooksDomainToUiMapper) = mapper.map(
            when (e) {
                is UnknownHostException -> ErrorType.NO_CONNECTION
                is HttpException -> ErrorType.SERVICE_UNAVAILABLE
                else -> ErrorType.GENERIC_ERROR
            }
        )
    }

}