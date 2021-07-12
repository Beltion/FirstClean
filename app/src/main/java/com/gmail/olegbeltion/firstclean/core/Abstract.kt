package com.gmail.olegbeltion.firstclean.core

abstract class Abstract {

    abstract class Object<T,M : Mapper> {
        abstract fun map(mapper: M): T
    }

    // FIXME: 11.07.2021  rename
    interface Mappble<T,M : Mapper> {
        abstract fun map(mapper: M): T
    }

    interface Mapper {
        class Empty : Mapper
    }
}