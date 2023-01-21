package com.tezov.bank.ui.page.help_and_service

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.page.help_and_service.PageSplash.content
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page

object PageHelpAndService : Page<PageHelpAndServiceState, PageHelpAndServiceAction> {

    @Composable
    override fun Page<PageHelpAndServiceState, PageHelpAndServiceAction>.content(innerPadding: PaddingValues) {
//        val accessor = AccessorAppUiPage().get(requester = this).contextHelpAndService()

    }

}