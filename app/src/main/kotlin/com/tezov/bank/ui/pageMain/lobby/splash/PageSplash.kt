/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 16:14
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 16:14
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.pageMain.lobby.splash

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.*
import com.tezov.bank.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action

object PageSplash : Page<PageSplashState, PageSplashAction> {

    @Composable
    override fun Page<PageSplashState, PageSplashAction>.content(innerPadding: PaddingValues) {
        val accessor = DiAccessorAppUiPage(requester = this).contextSplash()
        val action = accessor.action()
        LaunchedEffect(Unit) {
            action.onStart()
        }
    }

}