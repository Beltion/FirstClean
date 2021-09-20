package com.gmail.olegbeltion.firstclean.core

abstract class  Abstract {

    interface Object<T,M : Mapper> {
        fun map(mapper: M): T
    }

    interface Mapper
}