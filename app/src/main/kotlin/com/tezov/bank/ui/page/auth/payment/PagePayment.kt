/*
 *  *********************************************************************************
 *  Created by Tezov on 12/02/2023 16:03
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 12/02/2023 15:51
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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.provides
import com.tezov.bank.ui.component.leaf.ActionCard
import com.tezov.bank.ui.component.leaf.provides
import com.tezov.lib_core_android_kotlin.ui.component.tree.ColumnCollapsibleHeader
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsSpacingExtended

object PagePayment : Page<PagePaymentState, PagePaymentAction> {

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
                    ActionCard provides PagePaymentTheme.provideActionCardStyle(),
                    SectionActionCard provides PagePaymentTheme.provideSectionCardStyle()
                )
            }
        ) {
            ColumnCollapsibleHeader(
                modifier = Modifier
                    .fillMaxSize()
                    .background(PagePaymentTheme.colors.background)
                    .padding(innerPadding),
                properties = PagePaymentTheme.dimensions.headerHeight,
                header = { progress, progressDp ->
                    contentHeader(
                        state.header,
                        progress,
                        progressDp
                    )
                },
                body = {
                    state.cardSmall.value?.let {
                        SectionActionCard(data = it) {


                        }
                    }
                    state.cardLarge.value?.let {
                        SectionActionCard(data = it) {


                        }
                    }
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
                Text(
                    modifier = Modifier
                        .padding(
                            horizontal = MaterialTheme.dimensionsPaddingExtended.page_h + (MaterialTheme.dimensionsPaddingExtended.elementHuge_h * progress),
                            vertical = MaterialTheme.dimensionsPaddingExtended.textBig_v
                        ),
                    text = it,
                    style = PagePaymentTheme.typographies.title.copy(
                        fontSize = (PagePaymentTheme.dimensions.textTitleMin.value + ((PagePaymentTheme.dimensions.textTitleMax.value - PagePaymentTheme.dimensions.textTitleMin.value) * progress)).sp
                    )
                )
                if (progress < 0.05f) {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth(),
                        color = PagePaymentTheme.colors.headerDivider,
                        thickness = PagePaymentTheme.dimensions.headerDividerSize,
                    )
                }
                Spacer(modifier = Modifier.height((MaterialTheme.dimensionsSpacingExtended.normal_v * (1f - progress))))
            }
        }
    }

    @Composable
    override fun handleOnBackPressed() = DialogAuthCloseAppController.handleOnBackPressed()
}