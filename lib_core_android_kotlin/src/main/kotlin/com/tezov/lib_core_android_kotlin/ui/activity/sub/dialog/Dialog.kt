/*
 *  *********************************************************************************
 *  Created by Tezov on 10/05/2023 22:21
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 10/05/2023 22:18
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalLevel
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPagesBundle
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalPageBundle
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrameStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object Dialog : ActivitySub<DialogState, DialogAction> {


    @Composable
    operator fun invoke() {
        val accessor = DiAccessorCoreUiActivity().with(LocalActivity.current).contextSubMap()
        val state = accessor.with<Dialog, _, _>().state()
        if (state.isVisible) {
            Dialog(
                onDismissRequest = { state.show(null) },
                properties = DialogProperties(
                    usePlatformDefaultWidth = false,
                    decorFitsSystemWindows = false,
                )
            ) {
                CompositionLocalProvider(
                    LocalLevel provides 1,
                    LocalPageBundle provides LocalPagesBundle.last(),
                ) {
                    state.content()
                }
            }
        }
    }

    object Card {

        class StyleBuilder internal constructor(style: Style) {
            var elevation = style.elevation
            var outfitFrame = style.outfitFrame

            internal fun get() = Style(
                elevation = elevation,
                outfitFrame = outfitFrame,
            )
        }

        class Style(
            val elevation: Dp = 2.dp,
            outfitFrame: OutfitFrameStateColor? = null,
        ) {

            val outfitFrame: OutfitFrameStateColor by DelegateNullFallBack.Ref(
                outfitFrame,
                fallBackValue = {
                    ThemeColorsExtended.Dummy.outfitFrameState
                })

            companion object {

                @Composable
                fun Style.copy(builder: @Composable StyleBuilder.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()

            }

            constructor(style: Style) : this(
                elevation = style.elevation,
                outfitFrame = style.outfitFrame,
            )
        }

        //TODO manage selector

        @Composable
        operator fun invoke(content: @Composable () -> Unit) {
            val style = MaterialTheme.componentsCommonExtended.dialogCard
            Surface(
                color = style.outfitFrame.resolveColorShape()
                    ?: MaterialTheme.colors.surface,
                shape = style.outfitFrame.getShape()
                    ?: MaterialTheme.shapes.small,
                elevation = style.elevation,
                border = style.outfitFrame.resolveBorder()
            ) {
                content()
            }
        }

    }

}