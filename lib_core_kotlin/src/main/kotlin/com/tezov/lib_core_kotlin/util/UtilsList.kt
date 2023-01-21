package com.tezov.lib_core_kotlin.util

object UtilsList {
    const val NULL_INDEX = -1
    fun Int.isNullIndex() = this == NULL_INDEX
    fun Int.isNotNullIndex() = this != NULL_INDEX

}