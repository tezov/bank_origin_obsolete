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

package com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar

import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubState

class SnackbarState private constructor(
    val hostState: SnackbarHostState
) : ActivitySubState {
    companion object {
        @Composable
        fun create(
            snackbarHostState: SnackbarHostState,
        ) = SnackbarState(
            hostState = snackbarHostState
        )
    }
}