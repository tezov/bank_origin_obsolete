package com.tezov.lib_core_kotlin.type.primitive.string

abstract class StringTransformer {
    abstract fun alter(s: String?): String?
    abstract fun restore(s: String?): String?
}