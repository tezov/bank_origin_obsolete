/*
 *  *********************************************************************************
 *  Created by Tezov on 26/04/2023 21:07
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/04/2023 20:03
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPages
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalModals
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalPage
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorderStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrameStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.Size.Companion.asShapeSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShapeStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

@OptIn(ExperimentalComposeUiApi::class)
object Dialog : ActivitySub<DialogState, DialogAction> {

    @Composable
    operator fun invoke() {
        content()
    }

    @Composable
    private fun content() {
        val accessor = DiAccessorCoreUiActivity().with(LocalActivity.current).contextSubMap()
        val state = accessor.with<Dialog, _, _>().state()
        if (state.isVisible()) {
            Dialog(
                onDismissRequest = { state.show(false) },
                properties = DialogProperties(
                    usePlatformDefaultWidth = false
                )
            ) {
                state.dialogContent()
            }
        }
    }

    object Card {

        class StyleBuilder internal constructor(style: Style) {
            var outfitFrame = style.outfitFrame
            var elevation = style.elevation

            internal fun get() = Style(
                elevation = elevation,
                outfitFrame = outfitFrame,
            )
        }

        class Style(
            outfitFrame: OutfitFrameStateColor? = null,
            val elevation: Dp = 2.dp,
        ) {

            val outfitFrame: OutfitFrameStateColor by DelegateNullFallBack.Ref(
                outfitFrame,
                fallBackValue = {
                    OutfitFrameStateColor(
                        outfitBorder = OutfitBorderStateColor(
                            outfitState = Color.Black.asStateSimple,
                            size = 1.dp
                        ),
                        outfitShape = OutfitShapeStateColor(
                            outfitState = Color.Gray.copy(alpha = 0.25f).asStateSimple,
                            size = 12.dp.asShapeSize
                        )
                    )
                })

            companion object {

                @Composable
                fun Style.copy(builder: @Composable StyleBuilder.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()

            }

            constructor(style: Style) : this(
                outfitFrame = style.outfitFrame,
                elevation = style.elevation,
            )
        }

        //TODO manage selector

        @Composable
        operator fun invoke(content: @Composable () -> Unit) {
            Surface(
                color = MaterialTheme.componentsCommonExtended.dialogCard.outfitFrame.resolveColorShape()
                    ?: MaterialTheme.colors.surface,
                shape = MaterialTheme.componentsCommonExtended.dialogCard.outfitFrame.getShape()
                    ?: MaterialTheme.shapes.small,
                elevation = MaterialTheme.componentsCommonExtended.dialogCard.elevation,
                border = MaterialTheme.componentsCommonExtended.dialogCard.outfitFrame.resolveBorder()
            ) {
                val locals = LocalPages.current.last()
                CompositionLocalProvider(
                    Activity.DebugLocalLevel provides 1,
                    LocalPage provides locals.page,
                    LocalModals provides locals.modals
                ) {
                    content()
                }
            }
        }

    }


}