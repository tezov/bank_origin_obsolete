/*
 *  *********************************************************************************
 *  Created by Tezov on 01/04/2023 21:02
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/04/2023 20:46
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheet
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPages
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalModals
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalPage
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

@OptIn(ExperimentalComposeUiApi::class)
object Dialog : ActivitySub<DialogState, DialogAction> {

    @Composable
    operator fun invoke() {
        content()
    }

    @Composable
    private fun content() {
        val accessor = AccessorCoreUiActivity().get(this).contextSubMap()
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

    object Card{

        class Style(
            val outfitFrame: OutfitFrame.StateColor = OutfitFrame.StateColor(),
            val elevation: Dp = 0.dp,
        ){
            companion object{

                open class Builder internal constructor(style: Style) {
                    var outfitFrame = style.outfitFrame
                    var elevation = style.elevation

                    internal fun get() = Style(
                        elevation = elevation,
                        outfitFrame = outfitFrame,
                    )
                }

                @Composable
                fun Style.copy(builder: @Composable Builder.()->Unit = {}) = Builder(this).also {
                    it.builder()
                }.get()

            }

            constructor(style: Style) : this(
                outfitFrame = style.outfitFrame,
                elevation = style.elevation,
            )
        }

        @Composable
        operator fun invoke(content: @Composable () -> Unit) {
            content(content)
        }

        //todo all selector possible
        @Composable
        private fun content(content: @Composable () -> Unit) {
            Surface(
                color = MaterialTheme.componentsCommonExtended.dialogCard.outfitFrame.resolveColor() ?: MaterialTheme.colors.surface,
                shape = MaterialTheme.componentsCommonExtended.dialogCard.outfitFrame.getShape() ?: RectangleShape,
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