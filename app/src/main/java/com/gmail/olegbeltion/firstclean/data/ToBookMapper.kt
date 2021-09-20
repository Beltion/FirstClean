package com.gmail.olegbeltion.firstclean.data

import com.gmail.olegbeltion.firstclean.core.Abstract

interface ToBookMapper : Abstract.Mapper {
    fun map(id: Int, name: String) : BookData

    class Base : ToBookMapper {
        override fun map(id: Int, name: String) = BookData(id, name)
    }
}