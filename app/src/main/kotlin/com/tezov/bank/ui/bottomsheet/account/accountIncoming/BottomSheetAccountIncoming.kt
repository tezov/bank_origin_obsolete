/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 16:11
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 16:03
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.bottomsheet.account.accountIncoming

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.DiAccessorAppUiDialog
import com.tezov.bank.ui.pageMain.auth.profile.PageProfileTheme
import com.tezov.bank.ui.pageMain.auth.profile.styles
import com.tezov.lib_core_android_kotlin.type.primaire.size
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.bottomSheet.BottomSheet
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.theme.style.padding
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsCommonExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsIconExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended

object BottomSheetAccountIncoming :
    BottomSheet<BottomSheetAccountIncomingState, BottomSheetAccountIncomingAction> {

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
                    .background(BottomSheetAccountIncomingTheme.colors.background)
                    .fillMaxWidth()
            ) {
                ContentHeader(action = action, title = state.contentData.title)
                Divider(
                    modifier = Modifier.padding(vertical = MaterialTheme.dimensionsPaddingExtended.element.huge.vertical),
                    thickness = MaterialTheme.dimensionsCommonExtended.divider.huge,
                    color = BottomSheetAccountIncomingTheme.colors.fade
                )
                ContentBody(
                    body = state.contentData.body,
                    footer = state.contentData.footer
                )
            }
        }
    }

    @Composable
    private fun ColumnScope.ContentHeader(
        action: BottomSheetAccountIncomingAction,
        title: String
    ) {
        Row(
            modifier = Modifier.padding(horizontal = MaterialTheme.dimensionsPaddingExtended.page.big.horizontal)
        ) {
            Text.StateColor(
                modifier = Modifier.padding(vertical = MaterialTheme.dimensionsPaddingExtended.page.big.vertical),
                text = title,
                style = BottomSheetAccountIncomingTheme.typographies.title
            )
            Spacer(modifier = Modifier.weight(1.0f))
            Icon.Clickable(
                modifier = Modifier.padding(vertical = MaterialTheme.dimensionsPaddingExtended.page.big.horizontal),
                onClick = action::onClickClose
            ) {
                Icon.StateColor(
                    style = BottomSheetAccountIncomingTheme.styles.iconClose,
                    resourceId = R.drawable.ic_close_24dp,
                    description = stringResource(id = R.string.pg_a_bts_icon_close),
                )
            }
        }

    }

    @Composable
    private fun ColumnScope.ContentBody(
        body: String,
        footer: String,
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = MaterialTheme.dimensionsPaddingExtended.page.big.horizontal)
                .padding(bottom = MaterialTheme.dimensionsPaddingExtended.page.big.vertical)
        ){
            Text.StateColor(
                text = body,
                style = BottomSheetAccountIncomingTheme.typographies.body
            )
            Spacer(modifier = Modifier.height(MaterialTheme.dimensionsPaddingExtended.element.normal.vertical))
            Text.StateColor(
                text = footer,
                style = BottomSheetAccountIncomingTheme.typographies.footer
            )
        }
    }


}