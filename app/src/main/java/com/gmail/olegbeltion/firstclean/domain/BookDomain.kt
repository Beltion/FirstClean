package com.gmail.olegbeltion.firstclean.domain

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.data.BooksData
import com.gmail.olegbeltion.firstclean.presentation.BookUi

sealed class BookDomain : Abstract.Object<BookUi, Abstract.Mapper.Empty>() {
    class Success(private val books: List<BooksData>) : BookDomain() {
        override fun map(mapper: Abstract.Mapper.Empty): BookUi {
            TODO("Not yet implemented")
        }

    }

    class Fail(private val errorType: Int) : BookDomain() {
        override fun map(mapper: Abstract.Mapper.Empty): BookUi {
            TODO("Not yet implemented")
        }

    }
}