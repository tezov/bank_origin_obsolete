package com.tezov.lib_core_kotlin.type.primaire

class Pair<F, S>(var first: F, var second: S) {
    override fun equals(o: Any?): Boolean {
        return if (o is Pair<*, *>) {
            var result = equals(first, o.first)
            result = result and equals(
                second,
                o.second
            )
            result
        } else {
            false
        }
    }

    private fun equals(o1: Any?, o2: Any?): Boolean {
        return if (o1 != null) {
            o1 == o2
        } else {
            o2 == null
        }
    }
}