/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 19:53
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 19:53
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.dialog.auth.closeAppConfirmation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import com.tezov.bank.ui.di.accessor.AccessorAppUiDialog
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsCommonExtended

object DialogAuthCloseAppConfirmation :
    Dialog<DialogAuthCloseAppConfirmationState, DialogAuthCloseAppConfirmationAction> {

    @Composable
    override fun Dialog<DialogAuthCloseAppConfirmationState, DialogAuthCloseAppConfirmationAction>.content() {
        val accessor = AccessorAppUiDialog().get(requester = this).contextAuthCloseAppConfirmation()
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
            }
        ) {
            Column(
                modifier = Modifier
                    .background(DialogAuthCloseAppConfirmationTheme.colors.background)
                    .fillMaxWidth(0.7f)
//                    .padding(
//                        vertical = MaterialTheme.dimensionsPaddingExtended.blockBig_v,
//                        horizontal = MaterialTheme.dimensionsPaddingExtended.blockBig_h
//                    )
            ) {
                Text(
                    text = "Déconnexion",
                    style = DialogAuthCloseAppConfirmationTheme.typographies.title
                )
//                Spacer(modifier = Modifier.height(MaterialTheme.dimensionsCommonExtended.normal_v))
                Text(
                    text = "Etes-vous sûr de vouloir vous déconnecter ?",
                    style = DialogAuthCloseAppConfirmationTheme.typographies.text
                )
//                Spacer(modifier = Modifier.height(MaterialTheme.dimensionsCommonExtended.huge_v))
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    ClickableText(
                        text = AnnotatedString("NON"),
                        style = DialogAuthCloseAppConfirmationTheme.typographies.button
                    ) {

                    }
//                    Spacer(modifier = Modifier.width(MaterialTheme.dimensionsCommonExtended.big_h))
                    ClickableText(
                        text = AnnotatedString("OUI"),
                        style = DialogAuthCloseAppConfirmationTheme.typographies.button
                    ) {

                    }

                }
            }
        }
    }

}