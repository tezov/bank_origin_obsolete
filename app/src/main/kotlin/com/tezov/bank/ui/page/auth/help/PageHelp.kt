/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 19:53
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 19:49
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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsCommonExtended
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
                    SectionActionRow(data = it, style = PageHelpTheme.styles.sectionRow){


                    }
                }
                state.paymentModes.value?.let {
                    SectionActionRow(data = it, style = PageHelpTheme.styles.sectionRow){


                    }
                }
                state.configuration.value?.let {
                    SectionActionRow(data = it, style = PageHelpTheme.styles.sectionRow){


                    }
                }
                state.account.value?.let {
                    SectionActionRow(data = it, style = PageHelpTheme.styles.sectionRow){


                    }
                }
                state.misc.value?.let {
                    SectionActionRow(data = it, style = PageHelpTheme.styles.sectionRow){


                    }
                }
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
//                .padding(horizontal = MaterialTheme.dimensionsPaddingExtended.page_h)
        ) {
            header.headline.value?.let {
                Text(
                    text = it,
                    style = PageHelpTheme.typographies.titleHuge
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
//                        .height(MaterialTheme.dimensionsCommonExtended.huge_v)
                )
            }
            header.title.value?.let {
                Text(
                    text = it,
                    style = PageHelpTheme.typographies.titleBig
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
//                        .height(MaterialTheme.dimensionsCommonExtended.normal_v)
                )
            }
            header.text.value?.let {
                Text(
                    text = it,
                    style = PageHelpTheme.typographies.normal
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
//                        .height(MaterialTheme.dimensionsCommonExtended.huge_v)
                )
            }
        }
    }

    @Composable
    override fun handleOnBackPressed() = DialogAuthCloseAppController.handleOnBackPressed()

}