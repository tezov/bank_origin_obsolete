/*
 *  *********************************************************************************
 *  Created by Tezov on 02/02/2023 22:16
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/02/2023 22:16
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.branch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*

infix fun SectionActionRow.provides(value: SectionActionRow.Style) = local provides value

object SectionActionRow {

    internal val local: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Style(
        val colorIcon: Color = Color.Transparent,
        val dimensionIcon: Dp = 0.dp,
        val textStyleContent: TextStyle = TextStyle(),
        val colorBackground: Color,
        val colorDivider: Color,
        val dimensionDivider: Dp,
    )

    data class Data(
        val iconResourceId: Int? = null,
        val title: String? = null,
        val rows: List<ActionRow.Data>
    )

    @Composable
    operator fun invoke(
        data: Data,
        onClick: (Int) -> Unit
    ) {
        Content(data, onClick)
    }

    @Composable
    private fun Content(
        data: Data,
        onClick: (Int) -> Unit
    ) {
        if (data.rows.isEmpty()) {
            return
        }
        val style = local.current
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            data.title?.let { text ->
                Row(
                    modifier = Modifier
                        .background(style.colorBackground)
                        .fillMaxWidth()
                        .padding(vertical = MaterialTheme.dimensionsPaddingExtended.elementNormal_v)
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    data.iconResourceId?.let {
                        Icon(
                            modifier = Modifier
                                .padding(start = MaterialTheme.dimensionsPaddingExtended.elementHuge_h)
                                .size(style.dimensionIcon),
                            painter = painterResource(id = it),
                            tint = style.colorIcon,
                            contentDescription = text,
                        )
                    }
                    Text(
                        modifier = Modifier
                            .padding(start = MaterialTheme.dimensionsPaddingExtended.elementBig_h)
                            .wrapContentSize(),
                        text = text,
                        style = style.textStyleContent
                    )
                }
            } ?: run {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = MaterialTheme.dimensionsPaddingExtended.blockBig_h),
                    color = style.colorDivider,
                    thickness = style.dimensionDivider,
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_h),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_h),
            ) {
                data.rows.forEachIndexed { index, row ->
                    ActionRow(data = row){
                        onClick(index)
                    }
                    if (index != data.rows.lastIndex) {
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = MaterialTheme.dimensionsPaddingExtended.blockBig_h),
                            color = style.colorDivider,
                            thickness = style.dimensionDivider,
                        )
                    }
                }
            }
        }
    }

}