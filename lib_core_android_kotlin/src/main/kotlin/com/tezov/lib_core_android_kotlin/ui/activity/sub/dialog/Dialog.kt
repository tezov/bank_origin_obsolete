/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPages
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalModals
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalPage
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.definition.colorsCommonExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsElevationExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.bordersExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.shapesExtended

@OptIn(ExperimentalComposeUiApi::class)
object Dialog : ActivitySub<DialogState, DialogAction> {

    @Composable
    operator fun invoke() {
        content()
    }

    @Composable
    fun content() {
        val accessor = AccessorCoreUiActivity().get(this).contextSubMap()
        val state = accessor.with<Dialog, _, _>().state()
        if (state.isVisible()) {
            Dialog(
                onDismissRequest = { state.show(false) },
                properties = DialogProperties(
                    usePlatformDefaultWidth = false
                )
            ) {
                val locals = LocalPages.current.last()
                CompositionLocalProvider(
                    Activity.DebugLocalLevel provides 1,
                    LocalPage provides locals.page,
                    LocalModals provides locals.modals
                ) {
                    state.dialogContent()
                }
            }
        }
    }

    @Composable
    fun Card(content: @Composable () -> Unit) {
        Card(
            shape = MaterialTheme.shapesExtended.dialog,
            elevation = MaterialTheme.dimensionsElevationExtended.elevationNormal,
            border = MaterialTheme.bordersExtended.dialog
        ) {
            Surface(color = MaterialTheme.colorsCommonExtended.backgroundModal) {
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