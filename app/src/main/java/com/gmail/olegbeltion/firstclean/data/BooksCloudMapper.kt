package com.gmail.olegbeltion.firstclean.data

import com.gmail.olegbeltion.firstclean.core.Abstract

interface BooksCloudMapper : Abstract.Mapper {
    fun map(cloudList: List<Abstract.Object<BookData, ToBookMapper>>): List<BookData>

    class Base(private val toBookMapper: ToBookMapper) : BooksCloudMapper {
        override fun map(cloudList: List<Abstract.Object<BookData, ToBookMapper>>) =
            cloudList.map { bookCloud ->
                bookCloud.map(toBookMapper)
            }
    }

}