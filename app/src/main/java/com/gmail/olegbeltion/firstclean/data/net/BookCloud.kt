package com.gmail.olegbeltion.firstclean.data.net

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.data.BookData
import com.gmail.olegbeltion.firstclean.data.ToBookMapper

data class BookCloud(
    private val id: Int = -1,
    private val name: String = "",
    private val testament: String = ""
) : Abstract.Object<BookData, ToBookMapper> {
    override fun map(mapper: ToBookMapper) = mapper.map(id, name, testament)
}
