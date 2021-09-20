package com.gmail.olegbeltion.firstclean.domain

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.presentation.BookUi

class BookDomain(private val id: Int,
                 private val name: String): Abstract.Object<BookUi, BookDomainToUiMapper> {
    override fun map(mapper: BookDomainToUiMapper) = mapper.map(id, name)
}