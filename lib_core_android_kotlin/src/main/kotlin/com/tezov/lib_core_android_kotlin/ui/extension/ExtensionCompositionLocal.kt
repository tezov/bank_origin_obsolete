/*
 *  *********************************************************************************
 *  Created by Tezov on 06/05/2023 16:08
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/05/2023 16:02
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue

object ExtensionCompositionLocal {

    @Composable
    fun CompositionLocalProvider(
        ancestor: Array<ProvidedValue<*>>,
        parent: @Composable () -> Array<ProvidedValue<*>> = { emptyArray() },
        child: @Composable () -> Array<ProvidedValue<*>> = { emptyArray() },
        content: @Composable () -> Unit
    ) {
        androidx.compose.runtime.CompositionLocalProvider(values = ancestor) {
            androidx.compose.runtime.CompositionLocalProvider(values = parent()) {
                androidx.compose.runtime.CompositionLocalProvider(
                    values = child(),
                    content = content
                )
            }
        }
    }
}