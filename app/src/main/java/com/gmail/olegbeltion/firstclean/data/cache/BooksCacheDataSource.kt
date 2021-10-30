package com.gmail.olegbeltion.firstclean.data.cache

import com.gmail.olegbeltion.firstclean.data.BookData


interface BooksCacheDataSource {
    suspend fun fetchBooks(): List<BookDb>
    fun saveBooks(books: List<BookData>)

    class Base(
        private val realmProvider: RealmProvider,
        private val mapper: BookDataToDbMapper
    ) : BooksCacheDataSource {
        override suspend fun fetchBooks(): List<BookDb> {
            realmProvider.provide().use { realm ->
                val books = realm.where(BookDb::class.java).findAll() ?: emptyList<BookDb>()
                return realm.copyFromRealm(books)
            }
        }

        override fun saveBooks(books: List<BookData>) = realmProvider.provide().use { realm ->
            realm.executeTransaction {
                books.forEach { book ->
                    book.mapTo(mapper, DbWrapper.Base(it))
                }

            }
        }
    }
}