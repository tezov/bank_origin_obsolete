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

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubAction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class BottomSheetAction constructor(
    val state: BottomSheetState
) : ActivitySubAction<BottomSheetState> {

    companion object {
        @Composable
        fun create(
            bottomSheetState: BottomSheetState
        ) = BottomSheetAction(
            state = bottomSheetState,
        )
    }

    fun show(content: @Composable () -> Unit) {
        state.show(content)
    }

    fun close() {
        state.show(null)
    }

    fun showOnSheetWithOverlay(content: @Composable () -> Unit) {
        show { BottomSheet.Sheet(content) }
    }

}