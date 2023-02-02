/*
 *  *********************************************************************************
 *  Created by Tezov on 02/02/2023 20:23
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/02/2023 20:22
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.help

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsSpacingExtended
import com.tezov.lib_core_android_kotlin.ui.util.ExtensionCompositionLocal

object PageHelp : Page<PageHelpState, PageHelpAction> {

    @Composable
    override fun Page<PageHelpState, PageHelpAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextHelp()
        val action = accessor.action()
        val state = accessor.state()


        ExtensionCompositionLocal.CompositionLocalProvider(
            parent = arrayOf(
                PageHelpTheme provides PageHelpTheme.provideColors(),
                PageHelpTheme provides PageHelpTheme.provideDimensions(),
            ),
            child = {
                arrayOf(
                    PageHelpTheme provides PageHelpTheme.provideShapes(),
                    PageHelpTheme provides PageHelpTheme.provideTypographies(),
                )
            }
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(PageHelpTheme.colors.background)
                    .verticalScroll(rememberScrollState())
            ) {

                contentHeader(state.header)
                contentList(state.emergencies) {

                }
                contentList(state.paymentModes) {

                }
                contentList(state.configuration) {

                }
                contentList(state.account) {

                }
                contentList(state.misc) {

                }

            }
        }
    }

    @Composable
    private fun contentHeader(
        header: PageHelpState.Header
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            header.headline.value?.let {
                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = it,
                    style = PageHelpTheme.typographies.titleHuge
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(MaterialTheme.dimensionsSpacingExtended.huge_v)
                )
            }
            header.title.value?.let {
                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = it,
                    style = PageHelpTheme.typographies.titleBig
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(MaterialTheme.dimensionsSpacingExtended.normal_v)
                )
            }
            header.text.value?.let {
                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = it,
                    style = PageHelpTheme.typographies.normal
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(MaterialTheme.dimensionsSpacingExtended.huge_v)
                )
            }
        }
    }

    @Composable
    private fun contentList(
        section: PageHelpState.Section<PageHelpState.ActionRowData>,
        onClick: (Int) -> Unit
    ) {
        if (section.datas.isEmpty()) {
            return
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            section.title.value?.let { text ->
                Row(
                    modifier = Modifier
                        .background(PageHelpTheme.colors.backgroundSection)
                        .fillMaxWidth()
                        .padding(vertical = MaterialTheme.dimensionsPaddingExtended.elementNormal_v)
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    section.iconResourceId.value?.let {
                        Icon(
                            modifier = Modifier
                                .padding(start = MaterialTheme.dimensionsPaddingExtended.elementHuge_h)
                                .size(PageHelpTheme.dimensions.iconSize),
                            painter = painterResource(id = it),
                            tint = PageHelpTheme.colors.iconSection,
                            contentDescription = text,
                        )
                    }
                    Text(
                        modifier = Modifier
                            .padding(start = MaterialTheme.dimensionsPaddingExtended.elementBig_h)
                            .wrapContentSize(),
                        text = text,
                        style = PageHelpTheme.typographies.titleNormal
                    )
                }
            }
            section.datas.takeIf { it.isNotEmpty() }?.let {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_h),
                    verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_h),
                ) {
                    it.forEachIndexed { index, data ->
                        RowSimple(data = data) {
                            onClick(index)
                        }
                        if (index != it.lastIndex) {
                            Divider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = MaterialTheme.dimensionsPaddingExtended.blockBig_h),
                                color = PageHelpTheme.colors.divider,
                                thickness = PageHelpTheme.dimensions.divider,
                            )
                        }
                    }
                }
            }
        }
    }


    @Composable
    private fun RowSimple(
        data: PageHelpState.ActionRowData,
        onClick: () -> Unit
    ) {
        Row(
            modifier = Modifier
                .clickable {
                    onClick
                }
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_h,
                    horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f),
                text = data.title,
                style = PageHelpTheme.typographies.row
            )
            Icon(
                modifier = Modifier
                    .size(PageHelpTheme.dimensions.iconChevronSize),
                painter = painterResource(id = data.iconActionResourceId),
                tint = PageHelpTheme.colors.iconSection,
                contentDescription = data.title,
            )
        }
    }

}