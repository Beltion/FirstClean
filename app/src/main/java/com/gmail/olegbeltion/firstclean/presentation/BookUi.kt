package com.gmail.olegbeltion.firstclean.presentation

import com.gmail.olegbeltion.firstclean.core.Abstract

sealed class BookUi : Abstract.Object<Unit, BookUi.StringMapper> {

    object Progress : BookUi() {
        override fun map(mapper: StringMapper) = Unit
    }

    class Base(
        private val id: Int,
        private val name: String
    ) : BookUi() {
        override fun map(mapper: StringMapper) = mapper.map(name)
    }

    class Fail(
        private val msg: String
    ) : BookUi() {
        override fun map(mapper: StringMapper) = mapper.map(msg)
    }

//    TODO Improve later

    interface StringMapper : Abstract.Mapper {
        fun map(t: String)
    }
}
