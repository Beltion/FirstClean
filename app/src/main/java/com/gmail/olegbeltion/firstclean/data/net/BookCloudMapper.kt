package com.gmail.olegbeltion.firstclean.data.net

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.core.Book

interface BookCloudMapper : Abstract.Mapper {
    fun map(id: Int, name: String) : Book

    class Base : BookCloudMapper {
        override fun map(id: Int, name: String) = Book(id, name)
    }
}