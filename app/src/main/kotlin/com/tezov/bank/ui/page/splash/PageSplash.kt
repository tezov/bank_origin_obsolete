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