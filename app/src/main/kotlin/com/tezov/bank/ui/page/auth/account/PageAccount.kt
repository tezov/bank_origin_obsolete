/*
 *  *********************************************************************************
 *  Created by Tezov on 21/04/2023 23:20
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 21/04/2023 23:19
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.component.block.SectionAccountValueSimpleRow
import com.tezov.bank.ui.component.element.AccountSummaryCard
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Shadow
import com.tezov.lib_core_android_kotlin.ui.component.layout.ColumnCollapsibleHeader
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.modifier.then
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsCommonExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended

object PageAccount : Page<PageAccountState, PageAccountAction> {

    private const val DIVIDER_HEADER_VISIBILITY_START = 0.3f

    @Composable
    override fun Page<PageAccountState, PageAccountAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextAccount()
        val action = accessor.action()
        val state = accessor.state()
        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PageAccountTheme provides PageAccountTheme.provideColors(),
                PageAccountTheme provides PageAccountTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    PageAccountTheme provides PageAccountTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PageAccountTheme provides PageAccountTheme.provideStyles(),
                )
            }
        ) {
            ColumnCollapsibleHeader(
                modifier = Modifier
                    .fillMaxSize()
                    .background(PageAccountTheme.colors.background)
                    .padding(innerPadding),
                properties = PageAccountTheme.dimensions.headerProperties,
                header = { progress, progressDp ->
                    contentHeader(
                        state.header,
                        progress,
                        progressDp
                    )
                },
                body = {
                    contentBody(state.accountHistories)
                }
            )
        }
    }


    @Composable
    private fun contentHeader(
        header: PageAccountState.Header,
        progress: Float,
        progressDp: Dp,
    ) {
        header.accountSummary.value?.let {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(progressDp)
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {

                AccountSummaryCard(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth(0.6f),
                    style = PageAccountTheme.styles.accountSummary,
                    data = it
                )
                Shadow.Bottom(
                    modifier = Modifier
                        .then(progress < DIVIDER_HEADER_VISIBILITY_START,
                            onTrue = {
                                alpha((DIVIDER_HEADER_VISIBILITY_START - progress) / DIVIDER_HEADER_VISIBILITY_START)
                            },
                            onFalse = {
                                alpha(0f)
                            }
                        ),
                    elevation = (MaterialTheme.dimensionsCommonExtended.elevation.normal * (1 - progress)),
                )
            }
        }
    }

    @Composable
    private fun contentBody(
        accountHistories: MutableState<List<SectionAccountValueSimpleRow.Data>?>
    ) {
        accountHistories.value?.let { list ->
            list.forEach { data ->
                SectionAccountValueSimpleRow(
                    data = data,
                    style = PageAccountTheme.styles.sectionAccountValue
                ) {

                }
            }
        }
        accountHistories.value?.let { list ->
            list.forEach { data ->
                SectionAccountValueSimpleRow(
                    data = data,
                    style = PageAccountTheme.styles.sectionAccountValue
                ) {

                }
            }
        }
        accountHistories.value?.let { list ->
            list.forEach { data ->
                SectionAccountValueSimpleRow(
                    data = data,
                    style = PageAccountTheme.styles.sectionAccountValue
                ) {

                }
            }
        }
        accountHistories.value?.let { list ->
            list.forEach { data ->
                SectionAccountValueSimpleRow(
                    data = data,
                    style = PageAccountTheme.styles.sectionAccountValue
                ) {

                }
            }
        }
        Spacer(modifier = Modifier.height(MaterialTheme.dimensionsPaddingExtended.element.big.vertical))
    }

    @Composable
    override fun handleOnBackPressed() = DialogAuthCloseAppController.handleOnBackPressed()

}