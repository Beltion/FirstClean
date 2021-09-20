package com.gmail.olegbeltion.firstclean.data

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.domain.BooksDomain

interface BooksDataToDomainMapper : Abstract.Mapper {
    fun map(books: List<BookData>) : BooksDomain
    fun map(e: Exception) : BooksDomain
}