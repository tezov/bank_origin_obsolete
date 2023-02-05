/*
 *  *********************************************************************************
 *  Created by Tezov on 05/02/2023 01:03
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/02/2023 01:02
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.payment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.provides
import com.tezov.bank.ui.component.leaf.ActionCard
import com.tezov.bank.ui.component.leaf.provides
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsSpacingExtended
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal

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
                    PagePaymentTheme provides PagePaymentTheme.provideShapes(),
                    PagePaymentTheme provides PagePaymentTheme.provideBorders(),
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(PagePaymentTheme.colors.background)
                    .verticalScroll(rememberScrollState())
            ) {
                contentHeader(state.header)
                state.cardSmall.value?.let {
                    SectionActionCard(data = it){


                    }
                }
                state.cardLarge.value?.let {
                    SectionActionCard(data = it){


                    }
                }
            }
        }
    }

    @Composable
    private fun contentHeader(
        header: PagePaymentState.Header
    ) {
        header.headline.value?.let{
            Text(
                modifier = Modifier.wrapContentSize(),
                text = it,
                style = PagePaymentTheme.typographies.title
            )
            Spacer(modifier = Modifier.height(MaterialTheme.dimensionsSpacingExtended.normal_v))
        }
    }

}