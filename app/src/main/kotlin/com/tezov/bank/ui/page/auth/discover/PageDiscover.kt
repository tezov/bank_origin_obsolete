/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 23:53
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 23:48
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
import androidx.compose.ui.Modifier
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.leaf.CarouselCard
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable
import com.tezov.lib_core_android_kotlin.ui.component.plain.Text
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended

object PageDiscover : Page<PageDiscoverState, PageDiscoverAction> {

    @Composable
    override fun Page<PageDiscoverState, PageDiscoverAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextDiscover()
        val action = accessor.action()
        val state = accessor.state()

        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PageDiscoverTheme provides PageDiscoverTheme.provideColors(),
                PageDiscoverTheme provides PageDiscoverTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    PageDiscoverTheme provides PageDiscoverTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PageDiscoverTheme provides PageDiscoverTheme.provideStyles(),
                )
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(PageDiscoverTheme.colors.background)
                    .verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(PageDiscoverTheme.colors.accent)
                        .height(PageDiscoverTheme.dimensions.header),
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    contentHeader(state.header)
                    state.cardWithButtonData.value?.let {
                        val cards = ArrayList<@Composable () -> Unit>()
                        it.forEach { data ->
                            cards.add {
                                CarouselCard(
                                    modifier = Modifier.fillMaxSize(),
                                    data = data,
                                    style = PageDiscoverTheme.styles.cardButton
                                )
                            }
                        }
                        HorizontalScrollable.Pager(
                            style = PageDiscoverTheme.styles.carousel,
                            pages = cards
                        ) {

                        }
                    }
//                    state.cardWithLinkData.value?.let {
//                        val cards = ArrayList<@Composable () -> Unit>()
//                        it.forEach { data ->
//                            cards.add {
//                                CarouselCard(
//                                    data = data,
//                                    style = PageDiscoverTheme.styles.cardLink
//                                )
//                            }
//                        }
//                        HorizontalScrollable.Pager(
//                            modifier = Modifier
//                                .fillMaxWidth(),
//                            style = PageDiscoverTheme.styles.carousel,
//                            pages = cards
//                        ) {
//
//                        }
//                    }
                    state.offers.value?.let {
                        SectionActionCard(data = it, style = PageDiscoverTheme.styles.sectionCard) {


                        }
                    }
                    Spacer(modifier = Modifier.height(PageDiscoverTheme.dimensions.spacingTopSectionRowToBottomSectionCard))
                    state.tips.value?.let {
                        SectionActionRow(data = it, style = PageDiscoverTheme.styles.sectionRow) {


                        }
                    }
                    Spacer(modifier = Modifier.height(MaterialTheme.dimensionsPaddingExtended.element.huge.vertical))
                }
            }
        }
    }

    @Composable
    private fun contentHeader(
        header: PageDiscoverState.Header
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.dimensionsPaddingExtended.page.normal.vertical,
                    start = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal,
                    end = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal,
                )
        ) {
            header.headline.value?.let {
                Text.StateColor(
                    text = it,
                    style = PageDiscoverTheme.typographies.headline.copy {
                        outfitState = PageDiscoverTheme.colors.background.asStateSimple
                    }
                )
            }
        }
    }

    @Composable
    override fun handleOnBackPressed() = DialogAuthCloseAppController.handleOnBackPressed()

}