/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.help_and_service

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.*
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.page.splash.PageSplashAction
import com.tezov.bank.ui.page.splash.PageSplashState
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page

object PageSplash : Page<PageSplashState, PageSplashAction> {

    @Composable
    override fun Page<PageSplashState, PageSplashAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextSplash()
        val action = accessor.action()
        LaunchedEffect(Unit){
            action.onStart()
        }
    }




}