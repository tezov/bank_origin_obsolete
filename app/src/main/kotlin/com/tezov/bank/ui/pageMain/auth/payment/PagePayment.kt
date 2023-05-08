/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 18:25
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 18:14
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.pageMain.auth.payment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.tezov.bank.ui.component.block.SectionSimpleTile
import com.tezov.bank.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Shadow
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.component.layout.ColumnCollapsibleHeader
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.modifier.then
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsCommonExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended

object PagePayment : Page<PagePaymentState, PagePaymentAction> {

    private const val DIVIDER_HEADER_VISIBILITY_START = 0.3f

    @Composable
    override fun Page<PagePaymentState, PagePaymentAction>.content(innerPadding: PaddingValues) {
        val accessor = DiAccessorAppUiPage().with(key = this).contextPayment()
        val action = accessor.action()
        val state = accessor.state()
        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PagePaymentTheme provides PagePaymentTheme.provideColors(),
                PagePaymentTheme provides PagePaymentTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    PagePaymentTheme provides PagePaymentTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PagePaymentTheme provides PagePaymentTheme.provideStyles(),
                )
            }
        ) {
            ColumnCollapsibleHeader(
                modifier = Modifier
                    .background(PagePaymentTheme.colors.background)
                    .padding(innerPadding),
                properties = PagePaymentTheme.dimensions.headerProperties,
                header = { progress, progressDp ->
                    contentHeader(
                        state.header,
                        progress,
                        progressDp
                    )
                },
                body = {
                    contentBody(
                        action = action,
                        cardSmall = state.cardsSmall,
                        cardLarge = state.cardsLarge,
                    )
                    Spacer(modifier = Modifier.height(MaterialTheme.dimensionsPaddingExtended.element.huge.vertical))
                }
            )
        }
    }

    @Composable
    private fun BoxScope.contentHeader(
        header: PagePaymentState.Header?,
        progress: Float,
        progressDp: Dp
    ) {
        if(header == null){
            return
        }
        header.headline?.let {
            Column(
                modifier = Modifier.height(progressDp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text.StateColor(
                    modifier = Modifier
                        .padding(
                            horizontal = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal + (MaterialTheme.dimensionsPaddingExtended.element.huge.horizontal * progress),
                            vertical = MaterialTheme.dimensionsPaddingExtended.page.normal.vertical
                        ),
                    text = it,
                    style = PagePaymentTheme.typographies.headline.copy {
                        typo = typo.copy(
                            fontSize = (PagePaymentTheme.dimensions.headLineMin.value + ((PagePaymentTheme.dimensions.headlineMax.value - PagePaymentTheme.dimensions.headLineMin.value) * progress)).sp
                        )
                    }
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
                    elevation = (MaterialTheme.dimensionsCommonExtended.elevation.normal * (1-progress)),
                )
            }
        }
    }

    @Composable
    private fun ColumnScope.contentBody(
        action: PagePaymentAction,
        cardSmall: SectionSimpleTile.Data?,
        cardLarge: SectionSimpleTile.Data?,
    ){
        cardSmall?.let {
            SectionSimpleTile(
                data = it,
                style = PagePaymentTheme.styles.sectionCard,
                onClick = action::onClickCardsSmall
            )
        }
        Spacer(modifier = Modifier.height(MaterialTheme.dimensionsPaddingExtended.block.huge.vertical))
        cardLarge?.let {
            SectionSimpleTile(
                data = it,
                style = PagePaymentTheme.styles.sectionCard,
                onClick = action::onClickCardsLarge
            )
        }
    }

    @Composable
    override fun handleOnBackPressed() = DialogAuthCloseAppController.handleOnBackPressed()
}