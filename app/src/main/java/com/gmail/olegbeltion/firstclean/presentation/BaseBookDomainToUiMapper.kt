package com.gmail.olegbeltion.firstclean.presentation

import com.gmail.olegbeltion.firstclean.domain.BookDomainToUiMapper

class BaseBookDomainToUiMapper : BookDomainToUiMapper {
    override fun map(id: Int, name: String) = BookUi.Base(id, name)
}