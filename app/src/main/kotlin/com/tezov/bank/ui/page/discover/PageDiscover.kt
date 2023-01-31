/*
 *  *********************************************************************************
 *  Created by Tezov on 31/01/2023 19:15
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 31/01/2023 19:15
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.discover

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.util.ExtensionCompositionLocal

object PageDiscover : Page<PageDiscoverState, PageDiscoverAction> {

    @Composable
    override fun Page<PageDiscoverState, PageDiscoverAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextAccount()
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

            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)) {
            }
        }
    }


}