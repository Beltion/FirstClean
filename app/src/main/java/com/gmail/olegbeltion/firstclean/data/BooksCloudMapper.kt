package com.gmail.olegbeltion.firstclean.data

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.core.Book
import com.gmail.olegbeltion.firstclean.data.net.BookCloudMapper
import com.gmail.olegbeltion.firstclean.data.net.BookCloud

interface BooksCloudMapper : Abstract.Mapper {
    fun map(cloudList: List<BookCloud>): List<Book>

    class Base(private val bookCloudMapper: BookCloudMapper) : BooksCloudMapper {
        override fun map(cloudList: List<BookCloud>) = cloudList.map { bookCloud ->
                bookCloud.map(bookCloudMapper)
        }
    }

}