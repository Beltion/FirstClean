package com.gmail.olegbeltion.firstclean.data.cache

import com.gmail.olegbeltion.firstclean.core.Abstract
import io.realm.Realm

interface BookDataToDbMapper: Abstract.Mapper {
    fun map(id: Int, name: String, realm: Realm): BookDb

    class Base: BookDataToDbMapper{
        override fun map(id: Int, name: String, realm: Realm): BookDb {
            val bookDb = realm.createObject(BookDb::class.java, id)
            bookDb.name = name
            return bookDb
        }

    }
}