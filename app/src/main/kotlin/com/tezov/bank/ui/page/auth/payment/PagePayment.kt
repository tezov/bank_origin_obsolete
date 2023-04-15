/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:51
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.payment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController
import com.tezov.lib_core_android_kotlin.ui.component.plain.Text
import com.tezov.lib_core_android_kotlin.ui.component.tree.ColumnCollapsibleHeader
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended

object PagePayment : Page<PagePaymentState, PagePaymentAction> {

    private const val DIVIDER_HEADER_VISIBILITY_START = 0.3f

    @Composable
    override fun Page<PagePaymentState, PagePaymentAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextPayment()
        val action = accessor.action()
        val state = accessor.state()
        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PagePaymentTheme provides PagePaymentTheme.provideColors(),
                PagePaymentTheme provides PagePaymentTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    PagePaymentTheme provides PagePaymentTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PagePaymentTheme provides PagePaymentTheme.provideStyles(),
                )
            }
        ) {
            ColumnCollapsibleHeader(
                modifier = Modifier
                    .fillMaxSize()
                    .background(PagePaymentTheme.colors.background)
                    .padding(innerPadding),
                properties = PagePaymentTheme.dimensions.heightHeader,
                header = { progress, progressDp ->
                    contentHeader(
                        state.header,
                        progress,
                        progressDp
                    )
                },
                body = {
                    state.cardSmall.value?.let {
                        SectionActionCard(
                            data = it,
                            style = PagePaymentTheme.styles.sectionCard
                        ) {


                        }
                    }
                    Spacer(modifier = Modifier.height(MaterialTheme.dimensionsPaddingExtended.block.huge.vertical))
                    state.cardLarge.value?.let {
                        SectionActionCard(
                            data = it,
                            style = PagePaymentTheme.styles.sectionCard
                        ) {


                        }
                    }
                    Spacer(modifier = Modifier.height(MaterialTheme.dimensionsPaddingExtended.element.huge.vertical))
                }
            )
        }
    }

    @Composable
    private fun contentHeader(
        header: PagePaymentState.Header,
        progress: Float,
        progressDp: Dp
    ) {
        header.headline.value?.let {
            Column(
                modifier = Modifier.height(progressDp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text.StateColor(
                    modifier = Modifier
                        .padding(
                            horizontal = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal + (MaterialTheme.dimensionsPaddingExtended.element.huge.horizontal * progress),
                            vertical = MaterialTheme.dimensionsPaddingExtended.page.normal.vertical
                        ),
                    text = it,
                    style = PagePaymentTheme.typographies.headline.copy {
                        typo = typo.copy(
                            fontSize = (PagePaymentTheme.dimensions.sizeHeadLineMin.value + ((PagePaymentTheme.dimensions.sizeHeadlineMax.value - PagePaymentTheme.dimensions.sizeHeadLineMin.value) * progress)).sp
                        )
                    }
                )
                if (progress < DIVIDER_HEADER_VISIBILITY_START) {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .alpha((DIVIDER_HEADER_VISIBILITY_START - progress) / DIVIDER_HEADER_VISIBILITY_START),
                        color = PagePaymentTheme.colors.fade,
                        thickness = PagePaymentTheme.dimensions.heightHeaderDivider,
                    )
                }
                Spacer(modifier = Modifier.height((MaterialTheme.dimensionsPaddingExtended.element.normal.vertical * (1f - progress))))
            }
        }
    }

    @Composable
    override fun handleOnBackPressed() = DialogAuthCloseAppController.handleOnBackPressed()
}