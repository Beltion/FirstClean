package com.gmail.olegbeltion.firstclean.data.cache

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.core.Book

interface BooksCacheMapper : Abstract.Mapper {

    fun map(books: List<BookDb>) :List<Book>

    class Base(private val bookCacheMapper: BookCacheMapper) : BooksCacheMapper{
        override fun map(books: List<BookDb>) = books.map {book ->
            bookCacheMapper.map(book)
        }

    }
}