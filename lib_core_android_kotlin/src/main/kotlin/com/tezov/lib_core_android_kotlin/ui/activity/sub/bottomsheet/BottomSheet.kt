/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 03:45
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 03:45
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.theme.colorsCommonResource
import com.tezov.lib_core_android_kotlin.ui.theme.theme.shapesExtended

object BottomSheet : ActivitySub<BottomSheetState, BottomSheetAction> {

    @Composable
    operator fun invoke(content: @Composable () -> Unit) {
        content(content)
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    private fun content(content: @Composable () -> Unit) {
        val accessor = AccessorCoreUiActivity().get(this).contextSubMap()
        val state = accessor.with<BottomSheet,_,_>().state()
        ModalBottomSheetLayout(
            sheetContentColor = MaterialTheme.colorsCommonResource.transparent,
            sheetBackgroundColor = MaterialTheme.colorsCommonResource.transparent,
            sheetState = state.bottomSheetState,
            sheetShape = RectangleShape,
            sheetElevation = 0.dp,
            sheetContent = {
                Surface(
                    modifier = Modifier.padding(start = 1.dp, end = 1.dp),
                    shape = MaterialTheme.shapesExtended.bottomSheet,
                    elevation = ModalBottomSheetDefaults.Elevation
                ) {
                    state.sheetContent()
                }
            },
            content = content
        )
    }

}