/*
 *  *********************************************************************************
 *  Created by Tezov on 05/05/2023 20:30
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/05/2023 20:20
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalLevel
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPagesBundle
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalModalsBundle
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalPage
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalPageBundle
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShapeStateColor
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
                ThemeColorsExtended.Dummy.outfitShapeState
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
        val accessor = DiAccessorCoreUiActivity().with(LocalActivity.current).contextSubMap()
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
                    CompositionLocalProvider(
                        LocalLevel provides 1,
                        LocalPageBundle provides LocalPagesBundle.last(),
                    ) {
                        state.sheetContent()
                    }
                }
            },
            content = content
        )
    }

}