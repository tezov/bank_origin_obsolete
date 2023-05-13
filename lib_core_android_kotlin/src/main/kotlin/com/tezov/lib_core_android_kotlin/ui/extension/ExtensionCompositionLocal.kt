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