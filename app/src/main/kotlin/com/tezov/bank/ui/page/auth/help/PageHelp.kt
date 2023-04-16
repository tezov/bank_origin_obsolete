/*
 *  *********************************************************************************
 *  Created by Tezov on 16/04/2023 22:13
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 16/04/2023 18:13
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
import androidx.compose.ui.Modifier
import com.tezov.bank.ui.component.block.SectionActionRow
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
                state.emergencies.value?.let {
                    SectionActionRow(data = it, style = PageHelpTheme.styles.sectionRow) {


                    }
                }
                state.paymentModes.value?.let {
                    SectionActionRow(data = it, style = PageHelpTheme.styles.sectionRow) {


                    }
                }
                state.configuration.value?.let {
                    SectionActionRow(data = it, style = PageHelpTheme.styles.sectionRow) {


                    }
                }
                state.account.value?.let {
                    SectionActionRow(data = it, style = PageHelpTheme.styles.sectionRow) {


                    }
                }
                state.misc.value?.let {
                    SectionActionRow(data = it, style = PageHelpTheme.styles.sectionRow) {


                    }
                }
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
    override fun handleOnBackPressed() = DialogAuthCloseAppController.handleOnBackPressed()

}