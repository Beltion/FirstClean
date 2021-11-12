package com.gmail.olegbeltion.firstclean.domain

import com.gmail.olegbeltion.firstclean.data.BookData
import com.gmail.olegbeltion.firstclean.data.BookDataToDomainMapper
import com.gmail.olegbeltion.firstclean.data.BooksDataToDomainMapper
import com.gmail.olegbeltion.firstclean.data.TestamentTemp
import retrofit2.HttpException
import java.net.UnknownHostException

class BaseBooksDataToDomainMapper(private val mapper: BookDataToDomainMapper) :
    BooksDataToDomainMapper {
    override fun map(books: List<BookData>): BooksDomain.Success {

        val data = mutableListOf<BookDomain>()
        val temp = TestamentTemp.Base()
        books.forEach { bookData ->
            if (!bookData.matches(temp)) {
                if (temp.isEmpty())
                    data.add(BookDomain.Testament(TestamentType.OLD))
                else
                    data.add(BookDomain.Testament(TestamentType.NEW))
                bookData.saveTestament(temp)
            }
            data.add(bookData.map(mapper))
        }
        return BooksDomain.Success(data)
    }

    override fun map(e: Exception) = BooksDomain.Fail(
        when (e) {
            is UnknownHostException -> ErrorType.NO_CONNECTION
            is HttpException -> ErrorType.SERVICE_UNAVAILABLE
            else -> ErrorType.GENERIC_ERROR
        }
    )
}