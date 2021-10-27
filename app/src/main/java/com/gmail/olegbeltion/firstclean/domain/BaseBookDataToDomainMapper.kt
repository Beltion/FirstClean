package com.gmail.olegbeltion.firstclean.domain

import com.gmail.olegbeltion.firstclean.data.BookDataToDomainMapper

class BaseBookDataToDomainMapper : BookDataToDomainMapper {
    override fun map(id: Int, name: String) = BookDomain.Base(id, name)
}