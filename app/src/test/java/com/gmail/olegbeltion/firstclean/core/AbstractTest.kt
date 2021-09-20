package com.gmail.olegbeltion.firstclean.core

import org.junit.Test
import java.io.IOException

class AbstractTest {

    @Test
    fun test_success() {
        val dataObj = TestDataObject.Success("a", "b")
        val domainObj = dataObj.map(DataToDomainMapper.Base())
        assert(domainObj is DomainObject.Success)
    }

    @Test
    fun test_fail() {
        val dataObj = TestDataObject.Fail(IOException())
        val domainObj = dataObj.map(DataToDomainMapper.Base())
        assert(domainObj is DomainObject.Fail)
    }

    private sealed class TestDataObject : Abstract.Object<DomainObject, DataToDomainMapper> {
        abstract override fun map(mapper: DataToDomainMapper): DomainObject

        class Success(
            private val tOne: String,
            private val tTwo: String
        ) : TestDataObject() {
            override fun map(mapper: DataToDomainMapper): DomainObject = mapper.map(tOne, tTwo)

        }

        class Fail(private val e: Exception) : TestDataObject() {
            override fun map(mapper: DataToDomainMapper): DomainObject = mapper.map(e)
        }
    }

    private interface DataToDomainMapper : Abstract.Mapper {
        fun map(tOne: String, tTwo: String): DomainObject
        fun map(e: Exception): DomainObject

        class Base : DataToDomainMapper {
            override fun map(tOne: String, tTwo: String): DomainObject =
                DomainObject.Success("$tOne $tTwo")

            override fun map(e: Exception): DomainObject = DomainObject.Fail(e)

        }
    }

    private sealed class DomainObject : Abstract.Object<UiObject, DomainToUiMapper> {
        class Success(private val tCombined: String) : DomainObject() {
            override fun map(mapper: DomainToUiMapper): UiObject {
                TODO("Not yet implemented")
            }
        }

        class Fail(private val e: Exception) : DomainObject() {
            override fun map(mapper: DomainToUiMapper): UiObject {
                TODO("Not yet implemented")
            }
        }

    }

    interface DomainToUiMapper : Abstract.Mapper

    sealed class UiObject : Abstract.Object<Unit, Abstract.Mapper.Empty>
}