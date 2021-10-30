package com.gmail.olegbeltion.firstclean.data

import com.gmail.olegbeltion.firstclean.core.Abstract
import com.gmail.olegbeltion.firstclean.data.cache.BookDataToDbMapper
import com.gmail.olegbeltion.firstclean.data.cache.BookDb
import com.gmail.olegbeltion.firstclean.data.cache.DbWrapper
import com.gmail.olegbeltion.firstclean.domain.BookDomain

class BookData(private val id: Int,
               private val name: String,
               private val testament: String) :
    Abstract.Object<BookDomain,BookDataToDomainMapper>, ToBookDb<BookDb, BookDataToDbMapper> {
    override fun map(mapper: BookDataToDomainMapper) = mapper.map(id, name)
    override fun mapTo(mapper: BookDataToDbMapper, db: DbWrapper) = mapper.mapToDb(id, name, db)

    fun matches(t: TestamentTemp) = t.matches(testament)
    fun saveTestament(t: TestamentTemp) = t.save(testament)
}

interface ToBookDb<T,M: Abstract.Mapper>{
    fun mapTo(mapper: M, db: DbWrapper): T
}

