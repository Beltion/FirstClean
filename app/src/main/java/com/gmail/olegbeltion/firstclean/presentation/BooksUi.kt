package com.gmail.olegbeltion.firstclean.presentation

import com.gmail.olegbeltion.firstclean.R
import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.core.Book
import com.gmail.olegbeltion.firstclean.domain.ErrorType

sealed class BooksUi : Abstract.Object<Unit, Abstract.Mapper.Empty>() {
    class Success(
        private val communication: BooksCommunication,
        private val books: List<Book>
    ) : BooksUi() {
        override fun map(mapper: Abstract.Mapper.Empty) = communication.show(books)
    }

    class Fail(
        private val communication: BooksCommunication,
        private val errorType: ErrorType,
        private val resourcesProvider: ResourcesProvider
    ) : BooksUi() {
        override fun map(mapper: Abstract.Mapper.Empty) {
            val msgId = when(errorType){ // TODO: 03.08.2021 move to other class
                ErrorType.NO_CONNECTION -> R.string.no_connection_msg
                ErrorType.SERVICE_UNAVAILABLE -> R.string.services_unavailable
                else -> R.string.something_went_wrong
            }
            communication.show(resourcesProvider.getString(msgId))
        }
    }
}