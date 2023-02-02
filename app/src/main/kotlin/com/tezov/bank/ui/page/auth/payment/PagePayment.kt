/*
 *  *********************************************************************************
 *  Created by Tezov on 02/02/2023 22:16
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/02/2023 22:13
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.util.ExtensionCompositionLocal

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
            }
        ) {

            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow)
                .verticalScroll(rememberScrollState())) {
                contentCardSmall()
                contentCardLarge()
            }
        }
    }

    @Composable
    private fun contentCardSmall(
//        datas: List<PagePaymentState.ActionCardData>,
//        onClick: (Int) -> Unit
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
            .height(250.dp)
            .background(Color.Cyan))

    }

    @Composable
    private fun contentCardLarge(
//        datas: List<PagePaymentState.ActionCardRichData>,
//        onClick: (Int) -> Unit
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
            .height(250.dp)
            .background(Color.Cyan))

    }


}