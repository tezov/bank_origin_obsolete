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

package com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubState
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page

class DialogState private constructor(
    val stateUpdated: MutableState<Int>,
) : ActivitySubState {

    companion object {
        @Composable
        fun create(
            dialogContentUpdated: MutableState<Int> = mutableStateOf(0)
        ) = DialogState(
            stateUpdated = dialogContentUpdated,
        )
    }

    var isVisible = false
        get() = (stateUpdated.value > 0) && field
        private set

    private var _content: (@Composable () -> Unit) = { }

    @Composable
    internal fun content() = _content()

    internal fun show(content: (@Composable () -> Unit)?) {
        if (content == null) {
            _content = { }
            isVisible = false
        } else {
            _content = {
                CompositionLocalProvider(
                    Activity.LocalLevel provides 1,
                    Page.LocalPageBundle provides Activity.LocalPagesBundle.last(),
                ) {
                    content()
                }
            }
            isVisible = true
        }
        stateUpdated.value++
    }

}