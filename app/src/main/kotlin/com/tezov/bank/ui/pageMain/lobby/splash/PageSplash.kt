/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
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