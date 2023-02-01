/*
 *  *********************************************************************************
 *  Created by Tezov on 01/02/2023 22:00
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/02/2023 21:49
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.util.ExtensionCompositionLocal

object PageHelp : Page<PageHelpState, PageHelpAction> {

    @Composable
    override fun Page<PageHelpState, PageHelpAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextHelp()
        val action = accessor.action()
        val state = accessor.state()


        ExtensionCompositionLocal.CompositionLocalProvider(
            parent = arrayOf(
                PageHelpTheme provides PageHelpTheme.provideColors(),
                PageHelpTheme provides PageHelpTheme.provideDimensions(),
            ),
            child = {
                arrayOf(
                    PageHelpTheme provides PageHelpTheme.provideShapes(),
                    PageHelpTheme provides PageHelpTheme.provideBorders(),
                    PageHelpTheme provides PageHelpTheme.provideTypographies(),
                )
            }
        ) {

            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color.Green)
                .verticalScroll(rememberScrollState())) {

                contentHeader()
                contentList(0, state.emergencies)
                contentList(0, state.paymentModes)
                contentList(0, state.configuration)
                contentList(0, state.account)
                contentList(0, state.misc)

            }
        }
    }

    @Composable
    private fun contentHeader(){
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
            .height(100.dp)
            .background(Color.Blue))
    }

    @Composable
    private fun contentList(
        title: Int,
        datas: List<PageHelpState.ActionRowData>,
//        onClick: (Int) -> Unit
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
            .height(250.dp)
            .background(Color.Red))

    }




}