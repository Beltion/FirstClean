package com.gmail.olegbeltion.firstclean.data

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.data.cache.BookDataToDbMapper
import com.gmail.olegbeltion.firstclean.data.cache.BookDb
import com.gmail.olegbeltion.firstclean.domain.BookDomain
import io.realm.Realm

class BookData(private val id: Int,
               private val name: String,
               private val testament: String) :
    Abstract.Object<BookDomain,BookDataToDomainMapper>, ToDbMapper<BookDb, BookDataToDbMapper> {
    override fun map(mapper: BookDataToDomainMapper) = mapper.map(id, name)
    override fun mapTo(mapper: BookDataToDbMapper, realm: Realm) = mapper.map(id, name, testament, realm)

    fun compare(t: TestamentTemp) = t.isTheSame(testament)
    fun saveTestament(t: TestamentTemp) = t.save(testament)
}

interface ToDbMapper<T,M: Abstract.Mapper>{
    fun mapTo(mapper: M, realm: Realm): T
}

interface TestamentTemp {
    fun save(t: String)
    fun isTheSame(t: String): Boolean
    fun isEmpty(): Boolean

    class Base: TestamentTemp{
        private var temp = ""
        override fun save(t: String) {
            temp = t
        }

        override fun isTheSame(t: String) = temp == t

        override fun isEmpty() = temp.isEmpty()

    }
}