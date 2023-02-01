/*
 *  *********************************************************************************
 *  Created by Tezov on 01/02/2023 21:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/02/2023 20:41
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
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.util.ExtensionCompositionLocal

object PageDiscover : Page<PageDiscoverState, PageDiscoverAction> {

    @Composable
    override fun Page<PageDiscoverState, PageDiscoverAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextDiscover()
        val action = accessor.action()
        val state = accessor.state()


        ExtensionCompositionLocal.CompositionLocalProvider(
            parent = arrayOf(
                PageDiscoverTheme provides PageDiscoverTheme.provideColors(),
                PageDiscoverTheme provides PageDiscoverTheme.provideDimensions(),
            ),
            child = {
                arrayOf(
                    PageDiscoverTheme provides PageDiscoverTheme.provideShapes(),
                    PageDiscoverTheme provides PageDiscoverTheme.provideBorders(),
                    PageDiscoverTheme provides PageDiscoverTheme.provideTypographies(),
                )
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Column {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        color = Color.Blue
                    ) {}
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(5f),
                        color = Color.White
                    ) {}
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {

                        contentSwiperWithButton()
                        contentSwiperWithLink()
                        contentProduct()
                        contentTips()

                }
            }
        }
    }

    @Composable
    private fun contentSwiperWithButton(
//        datas: List<PageDiscoverState.CardButtonData>,
//        onClick: (Int) -> Unit
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
            .height(250.dp)
            .background(Color.Cyan))

    }

    @Composable
    private fun contentSwiperWithLink(
//        datas: List<PageDiscoverState.CardLinkData>,
//        onClick: (Int) -> Unit
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
            .height(250.dp)
            .background(Color.Red))

    }

    @Composable
    private fun contentProduct(
//        datas: List<PageDiscoverState.ActionCardData>,
//        onClick: (Int) -> Unit
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
            .height(400.dp)
            .background(Color.Green))

    }

    @Composable
    private fun contentTips(
//        datas: List<PageDiscoverState.ActionRowData>,
//        onClick: (Int) -> Unit
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
            .height(200.dp)
            .background(Color.Gray))

    }


}