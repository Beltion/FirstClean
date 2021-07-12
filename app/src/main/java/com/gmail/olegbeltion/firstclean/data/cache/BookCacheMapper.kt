package com.gmail.olegbeltion.firstclean.data.cache

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.core.Book

interface BookCacheMapper : Abstract.Mapper {
    fun map(bookDb: BookDb) : Book

    class Base : BookCacheMapper{
        override fun map(bookDb: BookDb) = Book(bookDb.id, bookDb.name)
    }
}