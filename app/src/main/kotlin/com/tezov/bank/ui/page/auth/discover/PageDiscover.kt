/*
 *  *********************************************************************************
 *  Created by Tezov on 18/04/2023 19:24
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 18/04/2023 19:24
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
import com.google.accompanist.pager.ExperimentalPagerApi
import com.tezov.bank.ui.component.block.SectionSimpleTile
import com.tezov.bank.ui.component.block.SectionSimpleRow
import com.tezov.bank.ui.component.block.SectionCarouselCard
import com.tezov.bank.ui.component.block.SectionRollerCard
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended

@OptIn(ExperimentalPagerApi::class)
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
                    state.cardsWithButton.value?.let {
                        SectionCarouselCard(data = it, style = PageDiscoverTheme.styles.sectionCarouselCardButton){

                        }
                    }
                    Spacer(modifier = Modifier.height(MaterialTheme.dimensionsPaddingExtended.element.big.vertical))
                    state.cardsWithLink.value?.let {
                        SectionCarouselCard(data = it, style = PageDiscoverTheme.styles.sectionCarouselCardLink){

                        }
                    }
                    Spacer(modifier = Modifier.height(MaterialTheme.dimensionsPaddingExtended.element.big.vertical))
                    state.cashbacks.value?.let {
                        SectionRollerCard(data = it, style = PageDiscoverTheme.styles.sectionRollerCard){

                        }
                    }
                    Spacer(modifier = Modifier.height(MaterialTheme.dimensionsPaddingExtended.element.big.vertical))
                    state.offers.value?.let {
                        SectionSimpleTile(data = it, style = PageDiscoverTheme.styles.sectionActionCard) {


                        }
                    }
                    Spacer(modifier = Modifier.height(PageDiscoverTheme.dimensions.spacingTopSectionRowToBottomSectionCard))
                    state.tips.value?.let {
                        SectionSimpleRow(data = it, style = PageDiscoverTheme.styles.sectionActionRow) {


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