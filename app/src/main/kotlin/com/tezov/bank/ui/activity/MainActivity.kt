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

package com.tezov.bank.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.lifecycleScope
import com.tezov.bank.navigation.NavigationGraph
import com.tezov.bank.navigation.bottom_navigation.BottomNavigationItems
import com.tezov.bank.ui.di.accessor.DiAccessorAppUiActivity
import com.tezov.bank.ui.theme.ThemeApplication
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigation
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBar
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBarItemData
import com.tezov.lib_core_android_kotlin.ui.activity.ActivityBase
import com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheet
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.style.padding
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ActivityBase<MainActivityState, MainActivityAction>() {

    @Composable
    override fun Activity<MainActivityState, MainActivityAction>.content() {
        ThemeApplication.BankDefault {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                DiAccessorAppUiActivity().wakeUp(requester = this)
                NavigationGraph()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //todo find a better hack to fix white screen at start on Xiaomi
        //know bug https://issuetracker.google.com/issues/227926002
        //and my phone is a xiaomi xD
        lifecycleScope.launch {
            delay(50)
            window.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }

    @Composable
    fun withTopAppBarAndBottomNavigationBar(
        topAppBarTitleResourceId: Int,
        topAppBarLeadingItem: TopAppBarItemData? = null,
        topAppBarTrailingItem: TopAppBarItemData? = null,
        content: @Composable (PaddingValues) -> Unit
    ) {
        val accessor = DiAccessorAppUiActivity().with(key = this)
        val mainState = accessor.contextMain().state()
        BottomSheet {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = mainState.coreState.scaffoldState,
                bottomBar = {
                    BottomNavigation(BottomNavigationItems.items)
                },
                topBar = {
                    TopAppBar(
                        topAppBarTitleResourceId,
                        topAppBarLeadingItem,
                        topAppBarTrailingItem
                    )
                },
                snackbarHost = {
                    com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar(
                        modifier = Modifier.padding(MaterialTheme.dimensionsPaddingExtended.block.normal)
                    )
                },
                content = content
            )
        }
        Dialog()
    }

    @Composable
    fun withTopAppBar(
        topAppBarTitleResourceId: Int,
        topAppBarLeadingItem: TopAppBarItemData? = null,
        topAppBarTrailingItem: TopAppBarItemData? = null,
        content: @Composable (PaddingValues) -> Unit
    ) {
        val accessor = DiAccessorAppUiActivity().with(key = this)
        val mainState = accessor.contextMain().state()
        BottomSheet {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = mainState.coreState.scaffoldState,
                topBar = {
                    TopAppBar(
                        topAppBarTitleResourceId,
                        topAppBarLeadingItem,
                        topAppBarTrailingItem
                    )
                },
                snackbarHost = {
                    com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar(
                        modifier = Modifier.padding(MaterialTheme.dimensionsPaddingExtended.block.normal)
                    )
                },
                content = content
            )
        }
        Dialog()
    }

    @Composable
    fun withBottomNavigationBar(
        content: @Composable (PaddingValues) -> Unit
    ) {
        val accessor = DiAccessorAppUiActivity().with(key = this)
        val mainState = accessor.contextMain().state()
        BottomSheet {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = mainState.coreState.scaffoldState,
                bottomBar = {
                    BottomNavigation(BottomNavigationItems.items)
                },
                topBar = { },
                snackbarHost = {
                    com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar(
                        modifier = Modifier.padding(MaterialTheme.dimensionsPaddingExtended.block.normal)
                    )
                },
                content = content
            )
        }
        Dialog()
    }

    @Composable
    fun empty(
        content: @Composable (PaddingValues) -> Unit
    ) {
        val accessor = DiAccessorAppUiActivity().with(key = this)
        val mainState = accessor.contextMain().state()
        BottomSheet {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = mainState.coreState.scaffoldState,
                snackbarHost = {
                    com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar(
                        modifier = Modifier.padding(MaterialTheme.dimensionsPaddingExtended.block.normal)
                    )
                },
                content = content
            )
        }
        Dialog()
    }
}

