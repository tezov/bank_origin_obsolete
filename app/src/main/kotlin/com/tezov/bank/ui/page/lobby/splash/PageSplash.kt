/*
 *  *********************************************************************************
 *  Created by Tezov on 03/05/2023 21:39
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 03/05/2023 19:53
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.lobby.splash

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.*
import com.tezov.bank.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.bank.ui.page.lobby.splash.PageSplash.content
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

object PageSplash : Page<PageSplashState, PageSplashAction> {

    @Composable
    override fun Page<PageSplashState, PageSplashAction>.content(innerPadding: PaddingValues) {
        val accessor = DiAccessorAppUiPage(requester = this).contextSplash()
        val action = accessor.action()
        LaunchedEffect(Unit) {
            action.onStart()
        }
    }

    @Composable
    override fun onDispose() {
        DiAccessorAppUiPage(requester = this).contextSplash().dispose()
        super.onDispose()
    }
}