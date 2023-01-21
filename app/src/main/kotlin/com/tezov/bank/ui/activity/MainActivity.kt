package com.tezov.bank.ui.activity

import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.tezov.lib_core_android_kotlin.ui.activity.ActivityBase
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigation
import com.tezov.bank.ui.di.accessor.AccessorAppUiActivity
import com.tezov.bank.ui.navigation.NavigationGraph
import com.tezov.bank.ui.navigation.bottom_navigation.BottomNavigationItems
import com.tezov.bank.ui.theme.ThemeApplication
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBarItemData
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBar
import com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheet
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.empty_card.Dialog
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity

import kotlinx.coroutines.*


class MainActivity : ActivityBase<MainActivityState, MainActivityAction>() {

    @Composable
    override fun Activity<MainActivityState, MainActivityAction>.content() {
        ThemeApplication.BankDefault {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                AccessorAppUiActivity().wakeUp(requester = this)
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
        val accessor = AccessorAppUiActivity().get(requester = this)
        val mainState = accessor.contextMain().state()
        BottomSheet {
            Dialog()
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
                    com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar()
                },
                content = content
            )
        }
    }

    @Composable
    fun withTopAppBar(
        topAppBarTitleResourceId: Int,
        topAppBarLeadingItem: TopAppBarItemData? = null,
        topAppBarTrailingItem: TopAppBarItemData? = null,
        content: @Composable (PaddingValues) -> Unit
    ) {
        val accessor = AccessorAppUiActivity().get(requester = this)
        val mainState = accessor.contextMain().state()
        BottomSheet {
            Dialog()
            Scaffold(
                modifier = Modifier
                    .fillMaxSize(),
                scaffoldState = mainState.coreState.scaffoldState,
                topBar = {
                    TopAppBar(
                        topAppBarTitleResourceId,
                        topAppBarLeadingItem,
                        topAppBarTrailingItem
                    )
                },
                snackbarHost = {
                    com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar()
                },
                content = content
            )
        }
    }

    @Composable
    fun withBottomNavigationBar(
        content: @Composable (PaddingValues) -> Unit
    ) {
        val accessor = AccessorAppUiActivity().get(requester = this)
        val mainState = accessor.contextMain().state()
        BottomSheet {
            Dialog()
            Scaffold(
                modifier = Modifier
                    .fillMaxSize(),
                scaffoldState = mainState.coreState.scaffoldState,
                bottomBar = {
                    BottomNavigation(BottomNavigationItems.items)
                },
                topBar = { },
                snackbarHost = {
                    com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar()
                },
                content = content
            )
        }
    }

    @Composable
    fun empty(
        content: @Composable (PaddingValues) -> Unit
    ) {
        val accessor = AccessorAppUiActivity().get(requester = this)
        val mainState = accessor.contextMain().state()
        BottomSheet() {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = mainState.coreState.scaffoldState,
                snackbarHost = {
                    com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar()
                },
                content = content
            )
        }
    }


}

