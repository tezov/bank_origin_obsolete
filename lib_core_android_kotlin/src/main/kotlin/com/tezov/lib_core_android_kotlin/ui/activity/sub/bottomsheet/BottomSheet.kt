/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 13:14
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 13:13
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShapeStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.background
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import kotlinx.coroutines.flow.filter

object BottomSheet : ActivitySub<BottomSheetState, BottomSheetAction> {

    class StyleBuilder internal constructor(style: Style) {
        var shape = style.outfitShape
        var paddingOuter = style.paddingOuter
        var paddingInner = style.paddingOuter
        var elevation = style.elevation

        internal fun get() = Style(
            elevation = elevation,
            paddingOuter = paddingOuter,
            paddingInner = paddingInner,
            outfitShape = shape,
        )
    }

    class Style(
        outfitShape: OutfitShapeStateColor? = null,
        paddingOuter: PaddingValues? = null,
        paddingInner: PaddingValues? = null,
        val elevation: Dp = 2.dp,
    ) {
        val outfitShape: OutfitShapeStateColor by DelegateNullFallBack.Ref(
            outfitShape,
            fallBackValue = {
                ThemeColorsExtended.Dummy.outfitShapeState
            })
        val paddingOuter: PaddingValues by DelegateNullFallBack.Ref(
            paddingOuter,
            fallBackValue = { PaddingValues(start = 1.dp, end = 1.dp) })
        val paddingInner: PaddingValues by DelegateNullFallBack.Ref(
            paddingInner,
            fallBackValue = { PaddingValues() })

        companion object {

            @Composable
            fun Style.copy(builder: @Composable StyleBuilder.() -> Unit = {}) =
                StyleBuilder(this).also {
                    it.builder()
                }.get()

        }

        constructor(style: Style) : this(
            outfitShape = style.outfitShape,
            paddingOuter = style.paddingOuter,
            paddingInner = style.paddingInner,
            elevation = style.elevation,
        )
    }

    //TODO manage selector

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    operator fun invoke(mainContent: @Composable () -> Unit) {
        val accessor = DiAccessorCoreUiActivity().with(LocalActivity.current).contextSubMap()
        val state = accessor.with<BottomSheet, _, _>().state()
        ModalBottomSheetLayout(
            sheetContentColor = MaterialTheme.colorsResource.transparent,
            sheetBackgroundColor = MaterialTheme.colorsResource.transparent,
            sheetState = state.bottomSheetState,
            sheetShape = RectangleShape,
            sheetElevation = 0.dp,
            sheetContent = {
                //todo MaterialTheme.componentsCommonExtended.bottomSheet.elevation -> TopShaddow rounded
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(MaterialTheme.componentsCommonExtended.bottomSheet.paddingOuter)
                        .background(MaterialTheme.componentsCommonExtended.bottomSheet.outfitShape)
                        .padding(MaterialTheme.componentsCommonExtended.bottomSheet.paddingOuter),
                ) {
                    state.content()
                }
                LaunchedEffect(Unit) {
                    snapshotFlow { state.bottomSheetState.currentValue }
                        .filter { it == ModalBottomSheetValue.Hidden }
                        .collect {
                            state.show(null)
                        }
                }
                LaunchedEffect(state.isVisible) {
                    if (state._isVisible) {
                        state.bottomSheetState.show()
                    } else {
                        state.bottomSheetState.hide()
                    }
                }
            },
            content = mainContent
        )
    }

}