/*
 *  *********************************************************************************
 *  Created by Tezov on 26/02/2023 18:09
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/02/2023 18:09
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
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Text
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextSimple
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsSpacingExtended

object SectionActionRow {

    @Immutable
    data class Style(
        val iconStyle: Icon.Simple.Style = Icon.Simple.Style(
            size = 24.dp,
            tint = Color.Black
        ),
        val outfitTextHeader: OutfitTextSimple = OutfitTextSimple(),
        val colorBackgroundHeader: Color = Color.Unspecified,
        val colorBackgroundBody: Color = Color.Unspecified,
        val colorDivider: Color = Color.Unspecified,
        val dimensionDivider: Dp = 1.dp,
        val dimensionPaddingBody_h: Dp = 0.dp,
        val actionRowStyle:ActionRow.Style = ActionRow.Style()
    )

    data class Data(
        val iconResourceId: Int? = null,
        val title: String? = null,
        val rows: List<ActionRow.Data>
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style:Style,
        data: Data,
        onClick: (Int) -> Unit = {}
    ) {
        if (data.rows.isEmpty()) {
            return
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            data.title?.let { text ->
                val modifierheader = Modifier
                if(style.colorBackgroundHeader.isSpecified){
                    modifierheader.background(style.colorBackgroundHeader)
                }
                Row(
                    modifier = modifierheader
                        .fillMaxWidth()
                        .padding(vertical = MaterialTheme.dimensionsPaddingExtended.elementBig_h),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = modifier.width(MaterialTheme.dimensionsPaddingExtended.elementBig_h))
                    data.iconResourceId?.let {
                        Icon.Simple(
                            modifier = Modifier
                                .padding(end = MaterialTheme.dimensionsPaddingExtended.elementNormal_h),
                            style = style.iconStyle,
                            resourceId = it,
                            description = text,
                        )
                    }
                    Text.Simple(
                        text = text,
                        style = style.outfitTextHeader
                    )
                }
            }
            val modifierBody = Modifier
            if(style.colorBackgroundBody.isSpecified){
                modifierBody.background(style.colorBackgroundBody)
            }
            Column(
                modifier = modifierBody
                    .fillMaxWidth()
                    .padding(
                        vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                        horizontal = style.dimensionPaddingBody_h
                    ),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_v),
            ) {
                data.rows.forEachIndexed { index, row ->
                    ActionRow(data = row, style = style.actionRowStyle) {
                        onClick(index)
                    }
                    if (style.dimensionDivider > 0.dp && style.colorDivider.isSpecified && index != data.rows.lastIndex) {
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