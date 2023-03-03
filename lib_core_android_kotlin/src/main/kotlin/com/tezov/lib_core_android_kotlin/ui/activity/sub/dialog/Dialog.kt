/*
 *  *********************************************************************************
 *  Created by Tezov on 03/03/2023 22:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 03/03/2023 22:28
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
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrameSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShapeSimple
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

        open class Style(
            val outfitFrame: OutfitFrameSimple = OutfitFrameSimple(),
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

        @Composable
        private fun content(content: @Composable () -> Unit) {
            Surface(
                color = MaterialTheme.componentsExtended.dialogCard.outfitFrame.outfitShape.color,
                shape = MaterialTheme.componentsExtended.dialogCard.outfitFrame.outfitShape.resolveOrDefault(),
                elevation = MaterialTheme.componentsExtended.dialogCard.elevation,
                border = MaterialTheme.componentsExtended.dialogCard.outfitFrame.outfitBorder.resolveOrDefault()
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