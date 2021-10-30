package com.gmail.olegbeltion.firstclean.domain

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.presentation.BookUi

enum class TestamentType(private val id: Int): Abstract.Object<BookUi, BookDomainToUiMapper>{
    OLD(Int.MIN_VALUE),
    NEW(Int.MAX_VALUE);

    fun matches(id: Int) = this.id == id
    override fun map(mapper: BookDomainToUiMapper) = mapper.map(id, name)
}