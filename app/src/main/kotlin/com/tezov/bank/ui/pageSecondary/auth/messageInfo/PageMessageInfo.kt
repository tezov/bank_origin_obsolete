/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 23:15
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 23:14
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.pageSecondary.auth.messageInfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tezov.bank.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.lib_core_android_kotlin.ui.component.block.HorizontalPager
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_kotlin.type.collection.ListEntry

object PageMessageInfo : Page<PageMessageInfoState, PageMessageInfoAction> {

    @Composable
    override fun Page<PageMessageInfoState, PageMessageInfoAction>.content(innerPadding: PaddingValues) {
        val accessor = DiAccessorAppUiPage().with(key = this).contextMessageInfo()
        val action = accessor.action()
        val state = accessor.state()
        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PageMessageInfoTheme provides PageMessageInfoTheme.provideColors(),
                PageMessageInfoTheme provides PageMessageInfoTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    PageMessageInfoTheme provides PageMessageInfoTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PageMessageInfoTheme provides PageMessageInfoTheme.provideStyles(),
                )
            }
        ) {
            val tabTitles = ListEntry<HorizontalPager.WithTabRow.Tab, @Composable () -> Unit>().apply{
                add(HorizontalPager.WithTabRow.Tab("tab_1")) {
                    TabNotification()
                }
                add(HorizontalPager.WithTabRow.Tab("tab_2")) {
                    TabMessageBox()
                }
            }
            HorizontalPager.WithTabRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(PageMessageInfoTheme.colors.background)
                    .padding(innerPadding),
                style = HorizontalPager.WithTabRow.Style(

                ),
                items = tabTitles
            )
        }
    }

    @Composable
    private fun TabNotification() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)
        )
    }

    @Composable
    private fun TabMessageBox() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green)
        )
    }
}