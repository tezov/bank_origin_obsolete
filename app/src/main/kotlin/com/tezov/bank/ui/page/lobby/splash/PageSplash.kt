/*
 *  *********************************************************************************
 *  Created by Tezov on 09/04/2023 20:20
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 09/04/2023 19:02
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.lobby.splash

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.*
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.page.auth.account.PageAccountAction
import com.tezov.bank.ui.page.auth.account.PageAccountState
import com.tezov.bank.ui.page.lobby.splash.PageSplashAction
import com.tezov.bank.ui.page.lobby.splash.PageSplashState
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