package com.ewide.test.core.utils

object Utils {
    fun String.formatSortType(): String {
        return lowercase().replaceFirst(this[0].toString(), this[0].uppercase())
    }
}