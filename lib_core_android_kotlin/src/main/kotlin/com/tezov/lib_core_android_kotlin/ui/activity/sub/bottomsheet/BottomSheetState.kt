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

package com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalLevel
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPagesBundle
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubState
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalPageBundle

@OptIn(ExperimentalMaterialApi::class)
class BottomSheetState private constructor(
    val bottomSheetState: ModalBottomSheetState,
    private val stateUpdated: MutableState<Int>
) : ActivitySubState {

    companion object {
        @OptIn(ExperimentalMaterialApi::class)
        @Composable
        fun create(
            bottomSheetState: ModalBottomSheetState = ModalBottomSheetState(
                initialValue = ModalBottomSheetValue.Hidden,
                animationSpec = SwipeableDefaults.AnimationSpec,
                isSkipHalfExpanded = false,
                confirmValueChange = { true }
            ),
            sheetContentUpdated: MutableState<Int> = mutableStateOf(0)
        ) = BottomSheetState(
            bottomSheetState = bottomSheetState,
            stateUpdated = sheetContentUpdated,
        )
    }

    internal var _isVisible = false

    val isVisible get() = (stateUpdated.value > 0) && _isVisible

    private var _content: (@Composable () -> Unit) = { }

    @Composable
    internal fun content() = _content()

    internal fun show(content: (@Composable () -> Unit)?) {
        if (content == null) {
            _content = { }
            _isVisible = false
        } else {
            _content = {
                CompositionLocalProvider(
                    LocalLevel provides 1,
                    LocalPageBundle provides LocalPagesBundle.last(),
                ) {
                    content()
                }
            }
            _isVisible = true
        }
        stateUpdated.value++
    }

}