package com.tezov.bank.ui.page.help_and_service

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.page.login.PageLoginAction
import com.tezov.bank.ui.page.login.PageLoginState
import com.tezov.bank.ui_composable.Swiper
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page

@OptIn(ExperimentalComposeUiApi::class)
object PageLogin : Page<PageLoginState, PageLoginAction> {
    val SIZE_ICON_LOGIN = 32.dp

    @Composable
    override fun Page<PageLoginState, PageLoginAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextLogin()
        val state = accessor.state()
        val action = accessor.action()
        state.animationState.updateTransition()
        contentLoading(state, action, innerPadding)
        contentLoaded(state, action, innerPadding)
        LaunchedEffect(Unit) {
            if (state.animationState.isNotDone) {
                state.animationState.startTransition()
            }
        }
    }

    @Composable
    private fun contentLoading(
        state: PageLoginState,
        action: PageLoginAction,
        innerPadding: PaddingValues
    ) {

    }

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    private fun contentLoaded(
        state: PageLoginState,
        action: PageLoginAction,
        innerPadding: PaddingValues
    ) {
        Column {
            ContentHeader(
                Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            )
            ContentBody(
                Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
            ContentFooter(
                Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
        }
    }

    @Composable
    private fun ContentHeader(
        modifier: Modifier,
    ) {
        Box(
            modifier = modifier
                .background(Color.Blue)
        )
    }

    @Composable
    private fun ContentBody(
        modifier: Modifier,
    ) {
        Swiper.Pager(
            modifier = modifier.background(Color.Cyan),
            pages = arrayListOf({
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                }
            },
                {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {

                    }
                }),
            pageSelected = 0,
            onPageChange = {
                Log.d(">>:", "ContentBody: $it")

            })
    }

    @Composable
    private fun ContentFooter(
        modifier: Modifier,
    ) {
        Box(
            modifier = modifier
                .background(Color.Blue)
        )

    }




}