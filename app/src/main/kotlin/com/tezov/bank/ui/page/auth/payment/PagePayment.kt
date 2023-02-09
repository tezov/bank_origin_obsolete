/*
 *  *********************************************************************************
 *  Created by Tezov on 09/02/2023 20:45
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 09/02/2023 20:44
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.payment

import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.provides
import com.tezov.bank.ui.component.leaf.ActionCard
import com.tezov.bank.ui.component.leaf.provides
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionDensity.toPx
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
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(PagePaymentTheme.colors.background)
                    .padding(innerPadding)
                    .verticalScroll(scrollState)
            ) {
                contentHeader(state.header, scrollState)
                state.cardSmall.value?.let {
                    SectionActionCard(data = it) {


                    }
                }
                state.cardLarge.value?.let {
                    SectionActionCard(data = it) {


                    }
                }

                for (i in 0..5) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .background(Color.Red)
                            .height(50.dp)
                    )
                }
            }
        }
    }

    @Composable
    private fun contentHeader(
        header: PagePaymentState.Header,
        scrollState: ScrollState
    ) {
        val progress = 1f - minOf(scrollState.value / 80.dp.toPx, 1f)
        val textSize = maxOf(PagePaymentTheme.dimensions.textTitleMin.value, PagePaymentTheme.dimensions.textTitleMax.value * progress)
        header.headline.value?.let {
            Column(
                modifier = Modifier.height(150.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    modifier = Modifier
                        .padding(
                            horizontal = MaterialTheme.dimensionsPaddingExtended.page_h,
                            vertical = MaterialTheme.dimensionsPaddingExtended.textBig_v
                        ),
                    text = it,
                    style = PagePaymentTheme.typographies.title.copy(
                        fontSize = textSize.sp
                    )
                )
                if (progress <= 0.05) {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth(),
                        color = PagePaymentTheme.colors.headerDivider,
                        thickness = PagePaymentTheme.dimensions.headerDivider,
                    )
                }
                Spacer(modifier = Modifier.height(MaterialTheme.dimensionsSpacingExtended.normal_v))
            }

        }
    }

    @Composable
    override fun handleOnBackPressed() = DialogAuthCloseAppController.handleOnBackPressed()
}