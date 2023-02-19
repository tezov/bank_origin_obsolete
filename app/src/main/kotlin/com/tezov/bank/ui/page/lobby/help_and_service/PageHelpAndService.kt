/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 03:45
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 03:45
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.lobby.help_and_service

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.tezov.bank.R
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.SectionActionRow

import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsSpacingExtended
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended

object PageHelpAndService : Page<PageHelpAndServiceState, PageHelpAndServiceAction> {

    @Composable
    override fun Page<PageHelpAndServiceState, PageHelpAndServiceAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextHelpAndService()
        val state = accessor.state()
        val action = accessor.action()
        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PageHelpAndServiceTheme provides PageHelpAndServiceTheme.provideColors(),
                PageHelpAndServiceTheme provides PageHelpAndServiceTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    PageHelpAndServiceTheme provides PageHelpAndServiceTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PageHelpAndServiceTheme provides PageHelpAndServiceTheme.provideStyles(),
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(PageHelpAndServiceTheme.colors.background)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(PageHelpAndServiceTheme.colors.backgroundElevated)
                ) {
                    IconButton(
                        modifier = Modifier
                            .align(Alignment.TopStart),
                        onClick = { action.close() }) {
                        Icon(
                            modifier = Modifier.size(PageHelpAndServiceTheme.dimensions.iconCloseSize),
                            painter = painterResource(id = R.drawable.ic_close_24dp),
                            contentDescription = stringResource(id = R.string.pg_h_and_s_icon_close),
                            tint = PageHelpAndServiceTheme.colors.iconClose,
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    contentHeader(state.header)
                    state.helpAndServices.value?.let {
                        SectionActionCard(data = it, style = PageHelpAndServiceTheme.styles.sectionCard){


                        }
                    }
                    Spacer(modifier = Modifier.height(MaterialTheme.dimensionsSpacingExtended.normal_v))
                    state.contacts.value?.let {
                        SectionActionRow(data = it, style = PageHelpAndServiceTheme.styles.sectionRow){


                        }
                    }
                    state.notices.value?.let {
                        SectionActionRow(data = it, style = PageHelpAndServiceTheme.styles.sectionRow){


                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun contentHeader(
        header: PageHelpAndServiceState.Header
    ) {
        header.headline.value?.let{
            Text(
                modifier = Modifier.padding(
                    horizontal = MaterialTheme.dimensionsPaddingExtended.page_h
                ),
                text = it,
                style = PageHelpAndServiceTheme.typographies.titleBig
            )
            Spacer(modifier = Modifier.height(MaterialTheme.dimensionsSpacingExtended.normal_v))
        }
    }




}