package com.gmail.olegbeltion.firstclean.presentation

import com.gmail.olegbeltion.firstclean.core.Abstract

sealed class BooksUi : Abstract.Object<Unit, BooksCommunication> {
    data class Base(private val books: List<BookUi>) : BooksUi() {
        override fun map(mapper: BooksCommunication) = mapper.map(books)
    }
}