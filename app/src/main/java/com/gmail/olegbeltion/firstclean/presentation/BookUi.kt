package com.gmail.olegbeltion.firstclean.presentation

import com.gmail.olegbeltion.firstclean.core.Abstract

sealed class BookUi : Abstract.Object<Unit, BookUi.StringMapper> {

    object Progress : BookUi() {
        override fun map(mapper: StringMapper) = Unit
    }

    abstract class Info(
        private val id: Int,
        private val name: String
    ) : BookUi() {
        override fun map(mapper: StringMapper) = mapper.map(name)
    }

    open class Base(
        id: Int,
        name: String
    ) : Info(id, name)

    class Testament(
        id: Int,
        name: String
    ) : Info(id, name)

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
