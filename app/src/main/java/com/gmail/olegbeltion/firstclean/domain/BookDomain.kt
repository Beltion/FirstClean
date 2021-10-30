package com.gmail.olegbeltion.firstclean.domain

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.presentation.BookUi

sealed class BookDomain : Abstract.Object<BookUi, BookDomainToUiMapper> {

    class Base(
        private val id: Int,
        private val name: String
    ) : BookDomain() {
        override fun map(mapper: BookDomainToUiMapper) = mapper.map(id, name)
    }

    class Testament(
        private val type: TestamentType
    ) : BookDomain() {
        override fun map(mapper: BookDomainToUiMapper) = type.map(mapper)
    }
}

