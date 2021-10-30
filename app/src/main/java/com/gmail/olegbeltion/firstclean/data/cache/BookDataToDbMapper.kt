package com.gmail.olegbeltion.firstclean.data.cache

import com.gmail.olegbeltion.firstclean.core.Abstract

interface BookDataToDbMapper: Abstract.Mapper {
    fun mapToDb(id: Int, name: String, db: DbWrapper): BookDb

    class Base: BookDataToDbMapper {
        override fun mapToDb(id: Int, name: String,db: DbWrapper): BookDb {
            val bookDb = db.createObject(id)
            bookDb.name = name
            return bookDb
        }

    }
}