/*
 *  *********************************************************************************
 *  Created by Tezov on 20/04/2023 20:47
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 20/04/2023 20:28
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.help

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.tezov.bank.ui.component.block.SectionSimpleRow
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended

object PageHelp : Page<PageHelpState, PageHelpAction> {

    @Composable
    override fun Page<PageHelpState, PageHelpAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextHelp()
        val action = accessor.action()
        val state = accessor.state()
        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PageHelpTheme provides PageHelpTheme.provideColors(),
            ),
            parent = {
                arrayOf(
                    PageHelpTheme provides PageHelpTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PageHelpTheme provides PageHelpTheme.provideStyles(),
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(PageHelpTheme.colors.background)
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            ) {
                contentHeader(state.header)
                contentBody(
                    emergencies = state.emergencies,
                    paymentModes = state.paymentModes,
                    configuration = state.configuration,
                    account = state.account,
                    misc = state.misc,
                )
                Spacer(modifier = Modifier.height(MaterialTheme.dimensionsPaddingExtended.element.huge.vertical))
            }
        }
    }

    @Composable
    private fun contentHeader(
        header: PageHelpState.Header
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.dimensionsPaddingExtended.page.normal.vertical,
                    start = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal,
                    end = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal,
                    bottom = MaterialTheme.dimensionsPaddingExtended.block.huge.vertical
                )
        ) {
            header.headline.value?.let {
                Text.StateColor(
                    text = it,
                    style = PageHelpTheme.typographies.headline
                )
            }
            header.title.value?.let {
                Text.StateColor(
                    modifier = Modifier.padding(top = MaterialTheme.dimensionsPaddingExtended.block.huge.vertical),
                    text = it,
                    style = PageHelpTheme.typographies.subHeadline
                )
            }
            header.text.value?.let {
                Text.StateColor(
                    modifier = Modifier.padding(top = MaterialTheme.dimensionsPaddingExtended.block.normal.vertical),
                    text = it,
                    style = PageHelpTheme.typographies.body
                )
            }
        }
    }

    @Composable
    private fun contentBody(
        emergencies: MutableState<SectionSimpleRow.Data?>,
        paymentModes: MutableState<SectionSimpleRow.Data?>,
        configuration: MutableState<SectionSimpleRow.Data?>,
        account: MutableState<SectionSimpleRow.Data?>,
        misc: MutableState<SectionSimpleRow.Data?>,
    ) {
        emergencies.value?.let {
            SectionSimpleRow(data = it, style = PageHelpTheme.styles.sectionRow) {


            }
        }
        paymentModes.value?.let {
            SectionSimpleRow(data = it, style = PageHelpTheme.styles.sectionRow) {


            }
        }
        configuration.value?.let {
            SectionSimpleRow(data = it, style = PageHelpTheme.styles.sectionRow) {


            }
        }
        account.value?.let {
            SectionSimpleRow(data = it, style = PageHelpTheme.styles.sectionRow) {


            }
        }
        misc.value?.let {
            SectionSimpleRow(data = it, style = PageHelpTheme.styles.sectionRow) {


            }
        }

    }

    @Composable
    override fun handleOnBackPressed() = DialogAuthCloseAppController.handleOnBackPressed()

}