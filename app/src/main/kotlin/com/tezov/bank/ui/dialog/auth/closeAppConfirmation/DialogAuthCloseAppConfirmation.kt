/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 16:14
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 16:13
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.dialog.auth.closeAppConfirmation

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tezov.bank.ui.di.accessor.DiAccessorAppUiDialog
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Link
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.theme.style.padding
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended

object DialogAuthCloseAppConfirmation :
    Dialog<DialogAuthCloseAppConfirmationState, DialogAuthCloseAppConfirmationAction> {

    @Composable
    override fun Dialog<DialogAuthCloseAppConfirmationState, DialogAuthCloseAppConfirmationAction>.content() {
        val accessor = DiAccessorAppUiDialog().with(key = this).contextAuthCloseAppConfirmation()
        val state = accessor.state()
        val action = accessor.action()

        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                DialogAuthCloseAppConfirmationTheme provides DialogAuthCloseAppConfirmationTheme.provideColors(),
            ),
            parent = {
                arrayOf(
                    DialogAuthCloseAppConfirmationTheme provides DialogAuthCloseAppConfirmationTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    DialogAuthCloseAppConfirmationTheme provides DialogAuthCloseAppConfirmationTheme.provideStyles()
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(MaterialTheme.dimensionsPaddingExtended.page.normal)
            ) {
                Text.StateColor(
                    text = state.contentData.title,
                    style = DialogAuthCloseAppConfirmationTheme.typographies.title
                )
                Spacer(modifier = Modifier.height(MaterialTheme.dimensionsPaddingExtended.element.normal.vertical))
                Text.StateColor(
                    text = state.contentData.body,
                    style = DialogAuthCloseAppConfirmationTheme.typographies.body
                )
                Spacer(modifier = Modifier.height(MaterialTheme.dimensionsPaddingExtended.element.huge.vertical))
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    Link.StateColor(
                        text = state.contentData.cancel,
                        style = DialogAuthCloseAppConfirmationTheme.styles.linkCancel,
                        onClick = action::onClickCancel
                    )
                    Spacer(modifier = Modifier.width(MaterialTheme.dimensionsPaddingExtended.element.huge.horizontal))
                    Link.StateColor(
                        text = state.contentData.confirm,
                        style = DialogAuthCloseAppConfirmationTheme.styles.linkConfirm,
                        onClick = action::onClickConfirm
                    )
                }
            }
        }
    }
}
