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
    override fun map(mapper: BookDataToDomainMapper) = mapper.map(id, name, testament)
    override fun mapTo(mapper: BookDataToDbMapper, realm: Realm) = mapper.map(id, name, testament, realm)

    fun compare(t: String) = testament == t
    fun getTestament() = testament
}

interface ToDbMapper<T,M: Abstract.Mapper>{
    fun mapTo(mapper: M, realm: Realm): T
}