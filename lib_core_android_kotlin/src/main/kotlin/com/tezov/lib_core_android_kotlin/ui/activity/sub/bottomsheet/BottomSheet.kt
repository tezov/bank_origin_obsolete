/*
 *  *********************************************************************************
 *  Created by Tezov on 25/04/2023 21:10
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 25/04/2023 20:45
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.DebugLocalLevel
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPages
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalModals
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalPage
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShapeStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object BottomSheet : ActivitySub<BottomSheetState, BottomSheetAction> {

    class StyleBuilder internal constructor(style: Style) {
        var shape = style.outfitShape
        var padding = style.padding
        var elevation = style.elevation

        internal fun get() = Style(
            elevation = elevation,
            padding = padding,
            outfitShape = shape,
        )
    }

    class Style(
        outfitShape: OutfitShapeStateColor? = null,
        padding: PaddingValues? = null,
        val elevation: Dp = 2.dp,
    ) {
        val outfitShape: OutfitShapeStateColor by DelegateNullFallBack.Ref(
            outfitShape,
            fallBackValue = {
                OutfitShapeStateColor(
                    outfitState = Color.Gray.copy(alpha = 0.25f).asStateSimple,
                    size = OutfitShape.Size(topStart = 12.dp, topEnd = 12.dp)
                )
            })
        val padding: PaddingValues by DelegateNullFallBack.Ref(
            padding,
            fallBackValue = { PaddingValues(1.dp, 1.dp) })

        companion object {

            @Composable
            fun Style.copy(builder: @Composable StyleBuilder.() -> Unit = {}) =
                StyleBuilder(this).also {
                    it.builder()
                }.get()

        }

        constructor(style: Style) : this(
            outfitShape = style.outfitShape,
            padding = style.padding,
            elevation = style.elevation,
        )
    }

    //TODO manage selector

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    operator fun invoke(content: @Composable () -> Unit) {
        val accessor = AccessorCoreUiActivity().get(LocalActivity.current).contextSubMap()
        val state = accessor.with<BottomSheet, _, _>().state()
        ModalBottomSheetLayout(
            sheetContentColor = MaterialTheme.colorsResource.transparent,
            sheetBackgroundColor = MaterialTheme.colorsResource.transparent,
            sheetState = state.bottomSheetState,
            sheetShape = RectangleShape,
            sheetElevation = 0.dp,
            sheetContent = {
                Surface(
                    color = MaterialTheme.componentsCommonExtended.bottomSheet.outfitShape.resolveColor()
                        ?: MaterialTheme.colors.surface,
                    modifier = Modifier.padding(MaterialTheme.componentsCommonExtended.bottomSheet.padding),
                    shape = MaterialTheme.componentsCommonExtended.bottomSheet.outfitShape.getShape()
                        ?: RectangleShape,
                    elevation = MaterialTheme.componentsCommonExtended.bottomSheet.elevation,
                ) {
                    val locals = LocalPages.current.last()
                    CompositionLocalProvider(
                        DebugLocalLevel provides 1,
                        LocalPage provides locals.page,
                        LocalModals provides locals.modals
                    ) {
                        state.sheetContent()
                    }
                }
            },
            content = content
        )
    }

}