package com.gmail.olegbeltion.firstclean.data

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.data.cache.BookDataToDbMapper
import com.gmail.olegbeltion.firstclean.data.cache.BookDb
import com.gmail.olegbeltion.firstclean.domain.BookDomain
import io.realm.Realm

class BookData(private val id: Int,
               private val name: String) :
    Abstract.Object<BookDomain,BookDataToDomainMapper>, ToDbMapper<BookDb, BookDataToDbMapper> {
    override fun map(mapper: BookDataToDomainMapper) = mapper.map(id, name)
    override fun mapTo(mapper: BookDataToDbMapper, realm: Realm) = mapper.map(id, name, realm)

}

interface ToDbMapper<T,M: Abstract.Mapper>{
    fun mapTo(mapper: M, realm: Realm): T
}