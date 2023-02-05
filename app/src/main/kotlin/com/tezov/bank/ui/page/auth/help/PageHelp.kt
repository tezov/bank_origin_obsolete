/*
 *  *********************************************************************************
 *  Created by Tezov on 05/02/2023 18:22
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/02/2023 18:16
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
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.bank.ui.component.leaf.provides
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.branch.provides
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsSpacingExtended
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsPaddingExtended

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
                    ActionRow provides PageHelpTheme.provideActionRowStyle(),
                    SectionActionRow provides PageHelpTheme.provideSectionRowStyle(),
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(PageHelpTheme.colors.background)
                    .verticalScroll(rememberScrollState())
            ) {
                contentHeader(state.header)
                state.emergencies.value?.let {
                    SectionActionRow(data = it){


                    }
                }
                state.paymentModes.value?.let {
                    SectionActionRow(data = it){


                    }
                }
                state.configuration.value?.let {
                    SectionActionRow(data = it){


                    }
                }
                state.account.value?.let {
                    SectionActionRow(data = it){


                    }
                }
                state.misc.value?.let {
                    SectionActionRow(data = it){


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
                .padding(horizontal = MaterialTheme.dimensionsPaddingExtended.page_h)
        ) {
            header.headline.value?.let {
                Text(
                    text = it,
                    style = PageHelpTheme.typographies.titleHuge
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(MaterialTheme.dimensionsSpacingExtended.huge_v)
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
                        .height(MaterialTheme.dimensionsSpacingExtended.normal_v)
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
                        .height(MaterialTheme.dimensionsSpacingExtended.huge_v)
                )
            }
        }
    }

}