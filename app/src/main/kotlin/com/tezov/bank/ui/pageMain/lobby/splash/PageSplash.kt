/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 21:30
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 21:13
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.pageMain.lobby.splash

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.lib_core_android_kotlin.ui.component.chunk.WebViewRawResource
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action

object PageSplash : Page<PageSplashState, PageSplashAction> {

    @Composable
    override fun Page<PageSplashState, PageSplashAction>.content(innerPadding: PaddingValues) {
        val accessor = DiAccessorAppUiPage(requester = this).contextSplash()
        val action = accessor.action()
        Surface(modifier = Modifier.padding(innerPadding)) {
            WebViewRawResource(R.raw.html_terms){
                if(it == "onStart"){
                    action.onStart()
                    true
                }
                else{
                    false
                }
            }
        }
    }

}