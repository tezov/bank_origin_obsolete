/*
 *  *********************************************************************************
 *  Created by Tezov on 12/02/2023 13:31
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 12/02/2023 13:31
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.payment

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionDensity.toPx
import kotlin.math.abs
import kotlin.math.sign

object PagePayment : Page<PagePaymentState, PagePaymentAction> {


    @Composable
    override fun Page<PagePaymentState, PagePaymentAction>.content(innerPadding: PaddingValues) {

        content(150.dp, 300.dp)


    }


    @Composable
    fun rememberVerticalScrollConnection(
        maxPxToConsume: Int,
        progress: MutableState<Float> = remember { mutableStateOf(1f) },
        scrollState: ScrollState = rememberScrollState(),
    ) = remember {
        VerticalScrollConnectionState(maxPxToConsume, progress, scrollState)
    }

    class VerticalScrollConnectionState(
        private val maxPxToConsume: Int,
        val progress: MutableState<Float>,
        val scrollState: ScrollState
    ) : NestedScrollConnection {

        private var pxConsumed: Float = maxPxToConsume * (1f - progress.value)

        private fun isDirectionPositive(value:Float) = value.sign < 0f

        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            if(isDirectionPositive(available.y)){
                if(progress.value <= 0f){
                    return Offset.Zero
                }
                val allowedToBeConsumed = maxPxToConsume - pxConsumed
                val notConsumed = (abs(available.y) - allowedToBeConsumed)
                if(notConsumed <= 0f){
                    pxConsumed -= available.y
                    progress.value = (1f - pxConsumed / maxPxToConsume)
                    return available
                }
                pxConsumed = maxPxToConsume.toFloat()
                progress.value = 0f
                return Offset(0f, -allowedToBeConsumed)
            }
            else{
                if(progress.value >= 1f){
                    return Offset.Zero
                }
                val availableToBeConsumed = available.y - scrollState.value
                if(availableToBeConsumed <= 0f){
                    return Offset.Zero
                }
                val allowedToBeConsumed = pxConsumed
                val notConsumed = availableToBeConsumed - allowedToBeConsumed
                if(notConsumed <= 0){
                    pxConsumed -= availableToBeConsumed
                    progress.value = (1f - pxConsumed / maxPxToConsume)
                    return available
                }
                pxConsumed = 0f
                progress.value = 1f
                return Offset(0f, allowedToBeConsumed)
            }
        }
    }


    @Composable
    fun header(
        height: Dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .background(Color.Red)
        ) {

        }
    }

    @Composable
    fun content(
        minHeight: Dp,
        maxHeight: Dp,
    ) {
        val nestedScrollConnection = rememberVerticalScrollConnection((maxHeight - minHeight).toPx.toInt())

        Column(Modifier.nestedScroll(nestedScrollConnection)) {
            header(minHeight + ((maxHeight - minHeight) * nestedScrollConnection.progress.value))
            Column(
                modifier = Modifier
                    .verticalScroll(nestedScrollConnection.scrollState)
                    .fillMaxSize()
            ) {
                for (i in 0..20) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .background(Color.Red)
                            .height(50.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .height(maxHeight - minHeight)
                        .fillMaxWidth()
                        .background(Color.Gray)
                )
            }
        }

    }


//    @Composable
//    override fun Page<PagePaymentState, PagePaymentAction>.content(innerPadding: PaddingValues) {
//        val accessor = AccessorAppUiPage().get(requester = this).contextPayment()
//        val action = accessor.action()
//        val state = accessor.state()
//
//        ExtensionCompositionLocal.CompositionLocalProvider(
//            ancestor = arrayOf(
//                PagePaymentTheme provides PagePaymentTheme.provideColors(),
//                PagePaymentTheme provides PagePaymentTheme.provideDimensions(),
//            ),
//            parent = {
//                arrayOf(
//                    PagePaymentTheme provides PagePaymentTheme.provideTypographies(),
//                )
//            },
//            child = {
//                arrayOf(
//                    ActionCard provides PagePaymentTheme.provideActionCardStyle(),
//                    SectionActionCard provides PagePaymentTheme.provideSectionCardStyle()
//                )
//            }
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(PagePaymentTheme.colors.background)
//                    .padding(innerPadding)
//                    .verticalScroll(rememberScrollState())
//            ) {
//                contentHeader(state.header)
//                state.cardSmall.value?.let {
//                    SectionActionCard(data = it) {
//
//
//                    }
//                }
//                state.cardLarge.value?.let {
//                    SectionActionCard(data = it) {
//
//
//                    }
//                }
//            }
//        }
//    }
//
//    @Composable
//    private fun contentHeader(
//        header: PagePaymentState.Header
//    ) {
//        header.headline.value?.let {
//            Column(
//                verticalArrangement = Arrangement.Bottom
//            ) {
//                Text(
//                    modifier = Modifier
//                        .padding(
//                            horizontal = MaterialTheme.dimensionsPaddingExtended.page_h,
//                            vertical = MaterialTheme.dimensionsPaddingExtended.textBig_v
//                        ),
//                    text = it,
//                    style = PagePaymentTheme.typographies.title.copy(
//                        fontSize = PagePaymentTheme.dimensions.textTitleMin
//                    )
//                )
//                Divider(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    color = PagePaymentTheme.colors.headerDivider,
//                    thickness = PagePaymentTheme.dimensions.headerDivider,
//                )
//                Spacer(modifier = Modifier.height(MaterialTheme.dimensionsSpacingExtended.normal_v))
//            }
//
//        }
//    }
//
//    @Composable
//    override fun handleOnBackPressed() = DialogAuthCloseAppController.handleOnBackPressed()
}