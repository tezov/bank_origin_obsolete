/*
 *  *********************************************************************************
 *  Created by Tezov on 12/02/2023 22:23
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 12/02/2023 22:11
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.discover

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tezov.bank.R
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.branch.provides
import com.tezov.bank.ui.component.leaf.ActionCard
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.bank.ui.component.leaf.CardButton
import com.tezov.bank.ui.component.leaf.provides
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController
import com.tezov.bank.ui.theme.ThemeComponent
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable
import com.tezov.lib_core_android_kotlin.ui.component.branch.provides
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsSpacingExtended

object PageDiscover : Page<PageDiscoverState, PageDiscoverAction> {

    @Composable
    override fun Page<PageDiscoverState, PageDiscoverAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextDiscover()
        val action = accessor.action()
        val state = accessor.state()

        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PageDiscoverTheme provides PageDiscoverTheme.provideColors(),
            ),
            parent = {
                arrayOf(


                )
            },
            child = {
                arrayOf(
                    ActionRow provides PageDiscoverTheme.provideActionRowStyle(),
                    SectionActionRow provides PageDiscoverTheme.provideSectionRowStyle(),
                    ActionCard provides PageDiscoverTheme.provideActionCardStyle(),
                    SectionActionCard provides PageDiscoverTheme.provideSectionCardStyle(),
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(PageDiscoverTheme.colors.background)
                    .verticalScroll(rememberScrollState())
            ) {

                CompositionLocalProvider(
                    HorizontalScrollable.Pager provides ThemeComponent.provideCarouselStyle(),
                    CardButton provides CardButton.Style()
                ) {
                    val data = CardButton.Data(
                        template = CardButton.Template.Button,
                        iconInfoResourceId = R.drawable.ic_info_24dp,
                        tag = "tag",
                        title = "title",
                        text = "text",
                        button = "button"
                    )
                    HorizontalScrollable.Pager(
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp)
                            .fillMaxWidth(),
                        pages = listOf(
                            {
                                CardButton(
                                    modifier = Modifier.fillMaxWidth(),
                                    data = data
                                )
                            },
                            {
                                CardButton(
                                    modifier = Modifier.fillMaxWidth(),
                                    data = data
                                )
                            },
                            {
                                CardButton(
                                    modifier = Modifier.fillMaxWidth(),
                                    data = data
                                )
                            },
                            {
                                CardButton(
                                    modifier = Modifier.fillMaxWidth(),
                                    data = data
                                )
                            },
                            {
                                CardButton(
                                    modifier = Modifier.fillMaxWidth(),
                                    data = data
                                )
                            }
                        )
                    )
                }

                CompositionLocalProvider(
                    HorizontalScrollable.Pager provides ThemeComponent.provideCarouselStyle(),
                    CardButton provides CardButton.Style()
                ) {
                    val data = CardButton.Data(
                        template = CardButton.Template.Link,
                        iconInfoResourceId = R.drawable.ic_info_24dp,
                        tag = "tag",
                        title = "title",
                        text = "text",
                        button = "link"
                    )
                    HorizontalScrollable.Pager(
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp)
                            .fillMaxWidth(),
                        pages = listOf(
                            {
                                CardButton(
                                    modifier = Modifier.fillMaxWidth(),
                                    data = data
                                )
                            },
                            {
                                CardButton(
                                    modifier = Modifier.fillMaxWidth(),
                                    data = data
                                )
                            },
                            {
                                CardButton(
                                    modifier = Modifier.fillMaxWidth(),
                                    data = data
                                )
                            },
                            {
                                CardButton(
                                    modifier = Modifier.fillMaxWidth(),
                                    data = data
                                )
                            },
                            {
                                CardButton(
                                    modifier = Modifier.fillMaxWidth(),
                                    data = data
                                )
                            }
                        )
                    )
                }

                state.offers.value?.let {
                    SectionActionCard(data = it) {


                    }
                }
                Spacer(modifier = Modifier.height(MaterialTheme.dimensionsSpacingExtended.big_v))
                state.tips.value?.let {
                    SectionActionRow(data = it) {


                    }
                }
            }
        }
    }

    @Composable
    override fun handleOnBackPressed() = DialogAuthCloseAppController.handleOnBackPressed()

}