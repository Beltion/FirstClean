package com.gmail.olegbeltion.firstclean.presentation

import android.content.Context
import androidx.annotation.StringRes

interface ResourcesProvider {
    fun getString(@StringRes id: Int): String

    class Base(private val ctx: Context) : ResourcesProvider {
        override fun getString(id: Int) = ctx.getString(id)

    }
}