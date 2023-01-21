package com.tezov.lib_core_kotlin.util


object ExtensionBoolean {
    inline fun <T> Boolean.onTrue(run: () -> T) = takeIf { it }?.let { run() }
    inline fun <T> Boolean.onFalse(run: () -> T) = takeIf { !it }?.let { run() }
}