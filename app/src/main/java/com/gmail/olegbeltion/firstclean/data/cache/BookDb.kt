package com.gmail.olegbeltion.firstclean.data.cache

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.data.BookData
import com.gmail.olegbeltion.firstclean.data.ToBookMapper
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class BookDb : RealmObject(), Abstract.Object<BookData, ToBookMapper> {
    @PrimaryKey
    var id: Int = -1
    var name: String = ""

    override fun map(mapper: ToBookMapper) = BookData(id, name)
}