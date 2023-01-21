package com.tezov.lib_core_kotlin.util

class Event<T>(content: T) {
    private val content: T
    private var hasBeenHandled = false

    init {
        this.content = content
    }

    val contentIfNotHandled: T?
        get() = if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }

    fun hasBeenHandled(): Boolean {
        return hasBeenHandled
    }


}