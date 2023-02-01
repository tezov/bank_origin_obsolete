/*
 *  *********************************************************************************
 *  Created by Tezov on 01/02/2023 22:00
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/02/2023 21:39
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.lobby.help_and_service

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.definition.colorsCommonResource
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsSpacingExtended
import com.tezov.lib_core_android_kotlin.ui.util.ExtensionCompositionLocal

object PageHelpAndService : Page<PageHelpAndServiceState, PageHelpAndServiceAction> {

    @Composable
    override fun Page<PageHelpAndServiceState, PageHelpAndServiceAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextHelpAndService()
        val state = accessor.state()
        val action = accessor.action()
        ExtensionCompositionLocal.CompositionLocalProvider(
            parent = arrayOf(
                PageHelpAndServiceTheme provides PageHelpAndServiceTheme.provideColors(),
                PageHelpAndServiceTheme provides PageHelpAndServiceTheme.provideDimensions(),
            ),
            child = {
                arrayOf(
                    PageHelpAndServiceTheme provides PageHelpAndServiceTheme.provideShapes(),
                    PageHelpAndServiceTheme provides PageHelpAndServiceTheme.provideBorders(),
                    PageHelpAndServiceTheme provides PageHelpAndServiceTheme.provideTypographies(),
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(PageHelpAndServiceTheme.colors.background)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(PageHelpAndServiceTheme.colors.backgroundSection)
                ) {
                    IconButton(
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.TopStart),
                        onClick = { action.close() }) {
                        Icon(
                            modifier = Modifier.size(PageHelpAndServiceTheme.dimensions.iconCloseSize),
                            painter = painterResource(id = R.drawable.ic_close_24dp),
                            contentDescription = stringResource(id = R.string.pg_h_and_s_icon_close),
                            tint = PageHelpAndServiceTheme.colors.onBackgroundLight,
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    contentHelpAndService(state.helpAndServices) { index ->

                    }
                    Spacer(modifier = Modifier.height(MaterialTheme.dimensionsSpacingExtended.normal_v))
                    contentContact(state.contacts) { index ->

                    }
                    contentLegalNotice(state.notices) { index ->

                    }
                }
            }
        }
    }

    @Composable
    private fun contentHelpAndService(
        datas: List<PageHelpAndServiceState.ActionCardData>,
        onClick: (Int) -> Unit
    ) {
        if (datas.isEmpty()) {
            return
        }
        Column(
            modifier = Modifier
                .padding(
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                    horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                )
        ) {
            Text(
                modifier = Modifier.wrapContentSize(),
                text = stringResource(id = R.string.pg_h_and_s_title_help_and_service),
                style = PageHelpAndServiceTheme.typographies.titleBig
            )
            Spacer(modifier = Modifier.height(MaterialTheme.dimensionsSpacingExtended.normal_v))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_h),
            ) {
                val end = (datas.size % 2).takeIf { it == 0 } ?: let { datas.size - 1 }
                for (i in 0 until end step 2) {
                    val startData = datas[i]
                    val endData = datas[i + 1]
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_v),
                    ) {
                        CardSmall(
                            modifier = Modifier
                                .wrapContentHeight()
                                .weight(1f),
                            data = startData,
                            onClick = { onClick(i) }
                        )
                        CardSmall(
                            modifier = Modifier
                                .wrapContentHeight()
                                .weight(1f),
                            data = endData,
                            onClick = { onClick(i + 1) }
                        )
                    }
                }
                if (end != datas.size) {
                    val data = datas.last()
                    CardLarge(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        data = data,
                        onClick = { onClick(datas.lastIndex) }
                    )
                }
            }
        }
    }

    @Composable
    private fun contentContact(
        datas: List<PageHelpAndServiceState.ActionRowRichData>,
        onClick: (Int) -> Unit
    ) {
        if (datas.isEmpty()) {
            return
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                color = PageHelpAndServiceTheme.colors.backgroundSection
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = MaterialTheme.dimensionsPaddingExtended.elementBig_v)
                        .wrapContentSize(),
                    text = stringResource(id = R.string.pg_h_and_s_section_contact),
                    style = PageHelpAndServiceTheme.typographies.titleNormal
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_h),
            ) {
                datas.forEachIndexed { index, data ->
                    RowWithStartIcon(
                        data = data,
                        onClick = { onClick(index) }
                    )
                }
            }
        }
    }

    @Composable
    private fun contentLegalNotice(
        datas: List<PageHelpAndServiceState.ActionRowData>,
        onClick: (Int) -> Unit
    ) {
        if (datas.isEmpty()) {
            return
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                color = PageHelpAndServiceTheme.colors.backgroundSection
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = MaterialTheme.dimensionsPaddingExtended.elementBig_v)
                        .wrapContentSize(),
                    text = stringResource(id = R.string.pg_h_and_s_section_notice),
                    style = PageHelpAndServiceTheme.typographies.titleNormal
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_h),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_h),
            ) {
                datas.forEachIndexed { index, data ->
                    RowSimple(data = data) {
                        onClick(index)
                    }
                    if (index != datas.lastIndex) {
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = MaterialTheme.dimensionsPaddingExtended.blockBig_h),
                            color = PageHelpAndServiceTheme.colors.divider,
                            thickness = PageHelpAndServiceTheme.dimensions.divider,
                        )
                    }
                }
            }
        }
    }




    @Composable
    private fun CardSmall(
        modifier: Modifier,
        data: PageHelpAndServiceState.ActionCardData,
        onClick: () -> Unit
    ) {
        val iconSize = PageHelpAndServiceTheme.dimensions.iconCardSize
        val ID_ICON = "icon"
        val ID_TEXT = "text"
        val constraintSet = ConstraintSet {
            val refIcon = createRefFor(ID_ICON)
            val refText = createRefFor(ID_TEXT)
            constrain(refIcon) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                width = Dimension.value(iconSize)
                height = Dimension.value(iconSize)
            }
            constrain(refText) {
                top.linkTo(refIcon.bottom)
                start.linkTo(parent.start)
                end.linkTo(refIcon.start)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
        }
        Surface(
            modifier = modifier.clickable {
                onClick()
            },
            color = MaterialTheme.colorsCommonResource.transparent,
            shape = PageHelpAndServiceTheme.shapes.card,
            border = PageHelpAndServiceTheme.borders.card,
        ) {
            ConstraintLayout(
                constraintSet = constraintSet,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(
                        vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                        horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                    ),
            ) {
                Icon(
                    modifier = Modifier.layoutId(ID_ICON),
                    painter = painterResource(id = data.iconResourceId),
                    tint = PageHelpAndServiceTheme.colors.onBackgroundLight,
                    contentDescription = data.title,
                )
                Text(
                    modifier = Modifier.layoutId(ID_TEXT),
                    text = data.title,
                    style = PageHelpAndServiceTheme.typographies.textCard,
                    overflow = TextOverflow.Visible
                )
            }
        }
    }

    @Composable
    private fun CardLarge(
        modifier:Modifier,
        data: PageHelpAndServiceState.ActionCardData,
        onClick: () -> Unit
    ) {
        Surface(
            modifier = modifier.clickable { onClick() },
            color = MaterialTheme.colorsCommonResource.transparent,
            shape = PageHelpAndServiceTheme.shapes.card,
            border = PageHelpAndServiceTheme.borders.card
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(
                        vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                        horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                    ),
            ) {
                Text(
                    modifier = Modifier
                        .wrapContentHeight()
                        .weight(1f)
                        .align(Alignment.Bottom),
                    text = data.title,
                    style = PageHelpAndServiceTheme.typographies.textCard
                )
                Icon(
                    modifier = Modifier
                        .size(PageHelpAndServiceTheme.dimensions.iconCardSize),
                    painter = painterResource(id = data.iconResourceId),
                    tint = PageHelpAndServiceTheme.colors.onBackgroundLight,
                    contentDescription = data.title,
                )
            }
        }
    }

    @Composable
    private fun RowWithStartIcon(
        data: PageHelpAndServiceState.ActionRowRichData,
        onClick: () -> Unit
    ) {
        Row(
            modifier = Modifier
                .clickable { onClick() }
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                    horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            data.iconInfoResourceId?.let {
                Icon(
                    modifier = Modifier
                        .size(PageHelpAndServiceTheme.dimensions.iconRowSize),
                    painter = painterResource(id = it),
                    tint = PageHelpAndServiceTheme.colors.onBackgroundLight,
                    contentDescription = data.title,
                )
            }
            Spacer(modifier = Modifier.width(MaterialTheme.dimensionsSpacingExtended.normal_h))
            Text(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f),
                text = data.title,
                style = PageHelpAndServiceTheme.typographies.textRow
            )
            Icon(
                modifier = Modifier
                    .size(PageHelpAndServiceTheme.dimensions.iconChevronSize),
                painter = painterResource(id = data.iconActionResourceId),
                tint = PageHelpAndServiceTheme.colors.onBackgroundLight,
                contentDescription = data.title,
            )
        }
    }

    @Composable
    private fun RowSimple(
        data:PageHelpAndServiceState.ActionRowData,
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
                style = PageHelpAndServiceTheme.typographies.textRow
            )
            Icon(
                modifier = Modifier
                    .size(PageHelpAndServiceTheme.dimensions.iconChevronSize),
                painter = painterResource(id = data.iconActionResourceId),
                tint = PageHelpAndServiceTheme.colors.onBackgroundLight,
                contentDescription = data.title,
            )
        }
    }


}