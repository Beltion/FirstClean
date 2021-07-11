package com.gmail.olegbeltion.firstclean.data.net

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.core.Book

data class BookCloud(
    private val id: Int = -1,
    private val name: String = ""
) : Abstract.Object<Book, BookCloudMapper>() {
    override fun map(mapper: BookCloudMapper) = mapper.map(id, name)
}
