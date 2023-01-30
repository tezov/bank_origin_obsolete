/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.ProvidedValue

object ExtensionCompositionLocal {

    @Composable
    fun CompositionLocalProvider(
        parent: Array<ProvidedValue<*>>,
        child: @Composable () -> Array<ProvidedValue<*>>,
        content: @Composable () -> Unit
    ) {
        androidx.compose.runtime.CompositionLocalProvider(values = *parent) {
            androidx.compose.runtime.CompositionLocalProvider(values = *child(), content = content)
        }
    }
}