/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

package com.tezov.lib_core_android_kotlin.ui.extension

import androidx.compose.runtime.Composable
import com.tezov.lib_core_kotlin.extension.ExtensionCollection.pop
import com.tezov.lib_core_kotlin.extension.ExtensionCollection.push

object ExtensionComposable {

    @Composable
    fun <T> List<T>.loopOver(action: @Composable LoopOver<T>.Scope.() -> Unit) =
        LoopOver(data = this, action = action).apply { loop() }

    class LoopOver<T>(
        private var index: Int = -1,
        private val data: List<T>,
        private val action: @Composable LoopOver<T>.Scope.() -> Unit
    ) {
        var isDone = false
        val buffer: ArrayDeque<Entry<T>> = ArrayDeque()

        @Composable
        internal fun loop() {
            if (data.isNotEmpty()) {
                while (!isDone) {
                    Scope().action()
                }
            }
        }

        data class Entry<T>(val index: Int, val data: T)

        inner class Scope {
            val isStackEmpty get() = buffer.isEmpty()
            val hasReachEnd get() = index >= data.size
            val next
                get():Entry<T>? = buffer.pop() ?: run {
                    val index = ++index
                    data.getOrNull(index)?.let {
                        Entry(index, it)
                    }
                }

            fun push(p: Entry<T>) = buffer.push(p)
            fun done() {
                isDone = true
            }
        }
    }
}