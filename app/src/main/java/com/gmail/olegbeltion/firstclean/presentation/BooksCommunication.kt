package com.gmail.olegbeltion.firstclean.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.gmail.olegbeltion.firstclean.core.Abstract

interface BooksCommunication : Abstract.Mapper{
    fun map(books: List<BookUi>)
    fun observe(owner: LifecycleOwner, observer: Observer<List<BookUi>>)

    class Base: BooksCommunication {
        private val bookListLiveData = MutableLiveData<List<BookUi>>()

        override fun map(books: List<BookUi>) {
            bookListLiveData.value = books
        }


        override fun observe(owner: LifecycleOwner, observer: Observer<List<BookUi>>) {
            bookListLiveData.observe(owner,observer)
        }
    }
}