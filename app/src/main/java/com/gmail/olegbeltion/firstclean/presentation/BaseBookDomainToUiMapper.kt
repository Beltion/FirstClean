package com.gmail.olegbeltion.firstclean.presentation

import com.gmail.olegbeltion.firstclean.R
import com.gmail.olegbeltion.firstclean.domain.BookDomainToUiMapper
import com.gmail.olegbeltion.firstclean.domain.TestamentType

class BaseBookDomainToUiMapper(private val resourcesProvider: ResourcesProvider) :
    BookDomainToUiMapper {
    override fun map(id: Int, name: String) = when {
        TestamentType.OLD.matches(id) ->
            BookUi.Testament(
                id, resourcesProvider.getString(R.string.old_testament)
            )
        TestamentType.NEW.matches(id) ->
            BookUi.Testament(
                id, resourcesProvider.getString(R.string.new_testament)
            )
        else -> BookUi.Base(id, name)
    }
}