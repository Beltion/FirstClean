package com.gmail.olegbeltion.firstclean.data

interface TestamentTemp {
    fun save(t: String)
    fun matches(t: String): Boolean
    fun isEmpty(): Boolean

    class Base: TestamentTemp{
        private var temp = ""
        override fun save(t: String) {
            temp = t
        }

        override fun matches(t: String) = temp == t

        override fun isEmpty() = temp.isEmpty()

    }
}