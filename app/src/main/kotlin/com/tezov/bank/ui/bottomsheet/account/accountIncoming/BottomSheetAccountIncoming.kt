/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 14:37
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 14:24
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.bottomsheet.account.accountIncoming

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.DiAccessorAppUiDialog
import com.tezov.lib_core_android_kotlin.type.primaire.size
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.bottomSheet.BottomSheet
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.modifier.fillMaxHeight
import com.tezov.lib_core_android_kotlin.ui.theme.style.padding
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

object BottomSheetAccountIncoming : BottomSheet<BottomSheetAccountIncomingState, BottomSheetAccountIncomingAction> {

    @Composable
    override fun BottomSheet<BottomSheetAccountIncomingState, BottomSheetAccountIncomingAction>.content() {
        val accessor = DiAccessorAppUiDialog().with(key = this).contextAccountIncoming()
        val state = accessor.state()
        val action = accessor.action()

        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                BottomSheetAccountIncomingTheme provides BottomSheetAccountIncomingTheme.provideColors(),
            ),
            parent = {
                arrayOf(
                    BottomSheetAccountIncomingTheme provides BottomSheetAccountIncomingTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    BottomSheetAccountIncomingTheme provides BottomSheetAccountIncomingTheme.provideStyles(),
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            ) {
                Icon.Clickable(
                    modifier = Modifier.align(Alignment.End),
                    onClick = action::onClickClose
                ) {
                    Icon(
                        modifier = Modifier.size(MaterialTheme.dimensionsIconExtended.modal.normal),
                        painter = painterResource(id = R.drawable.ic_close_24dp),
                        contentDescription = stringResource(id = R.string.dlg_login_auth_icon_close),
                        tint = BottomSheetAccountIncomingTheme.colors.onBackground,
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(MaterialTheme.dimensionsPaddingExtended.page.big),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ContentBody()
                }
            }
        }
    }

    @Composable
    private fun ColumnScope.ContentBody() {



    }


}