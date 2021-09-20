package com.gmail.olegbeltion.firstclean.data.cache

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.data.BookData
import com.gmail.olegbeltion.firstclean.data.ToBookMapper

interface BooksCacheMapper : Abstract.Mapper {

    fun map(books: List<Abstract.Object<BookData, ToBookMapper>>) : List<BookData>

    class Base(private val toBookMapper: ToBookMapper) : BooksCacheMapper{
        override fun map(books: List<Abstract.Object<BookData, ToBookMapper>>) = books.map {book ->
            book.map(toBookMapper)
        }

    }
}