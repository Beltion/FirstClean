package com.gmail.olegbeltion.firstclean.data

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.domain.BookDomain

interface BookDataToDomainMapper : Abstract.Mapper {
    fun map(id: Int, name: String): BookDomain
}