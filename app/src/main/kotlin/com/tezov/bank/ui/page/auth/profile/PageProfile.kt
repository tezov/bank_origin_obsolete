/*
 *  *********************************************************************************
 *  Created by Tezov on 05/02/2023 01:03
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/02/2023 23:13
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.profile

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
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal

object PageProfile : Page<PageProfileState, PageProfileAction> {

    @Composable
    override fun Page<PageProfileState, PageProfileAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextProfile()
        val action = accessor.action()
        val state = accessor.state()


        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PageProfileTheme provides PageProfileTheme.provideColors(),
                PageProfileTheme provides PageProfileTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    PageProfileTheme provides PageProfileTheme.provideShapes(),
                    PageProfileTheme provides PageProfileTheme.provideBorders(),
                    PageProfileTheme provides PageProfileTheme.provideTypographies(),
                )
            }
        ) {

            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
                .verticalScroll(rememberScrollState())) {

                contentListRich(state.profils)
                contentList(0, state.documents)
                contentList(0, state.offers)
                contentList(0, state.help)

            }
        }
    }


    @Composable
    private fun contentListRich(
        datas: List<PageProfileState.ActionRowRichData>,
//        onClick: (Int) -> Unit
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
            .height(250.dp)
            .background(Color.Red))

    }

    @Composable
    private fun contentList(
        title: Int,
        datas: List<PageProfileState.ActionRowData>,
//        onClick: (Int) -> Unit
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
            .height(250.dp)
            .background(Color.Red))

    }


}