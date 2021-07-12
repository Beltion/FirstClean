package com.gmail.olegbeltion.firstclean.data.cache

import com.gmail.olegbeltion.firstclean.core.Book

interface BooksCacheDataSource {
    suspend fun fetchBooks(): List<BookDb>
    fun saveBooks(books: List<Book>)

    class Base(private val realmProvider: RealmProvider) : BooksCacheDataSource {
        override suspend fun fetchBooks(): List<BookDb> {
            realmProvider.provide().use { realm ->
                val books = realm.where(BookDb::class.java).findAll() ?: emptyList<BookDb>()
                return realm.copyFromRealm(books)
            }
        }

        override fun saveBooks(books: List<Book>) = realmProvider.provide().use { realm ->
            realm.executeTransaction {
                books.forEach { book ->
                    val bookDb = it.createObject(BookDb::class.java, book.id)
                    bookDb.name = book.name
                }

            }
        }
    }
}