/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:52
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
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