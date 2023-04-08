/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 22:36
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 22:35
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Text
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionModifier.thenOnNotNull
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsCommonExtended

object SectionActionRow {

    @Immutable
    data class Style(
        val iconStyle: Icon.Simple.Style = Icon.Simple.Style(
            size = DpSize(24.dp),
            tint = Color.Black
        ),
        val outfitTextHeader: OutfitText.StateColor.Style = OutfitText.StateColor.Style(),
        val colorBackgroundHeader: Color? = null,
        val colorBackgroundBody: Color? = null,
        val colorDivider: Color? = null,
        val dimensionDivider: Dp = 1.dp,
        val dimensionPaddingBody_h: Dp = 0.dp,
        val actionRowStyle: ActionRow.Style = ActionRow.Style()
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .thenOnNotNull(style.colorBackgroundBody){
                            modifier.background(it)
                        }
                        .padding(vertical = MaterialTheme.dimensionsPaddingExtended.chunk.big.vertical),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = modifier.width(MaterialTheme.dimensionsPaddingExtended.chunk.big.horizontal))
                    data.iconResourceId?.let {
                        Icon.Simple(
                            modifier = Modifier
                                .padding(end = MaterialTheme.dimensionsPaddingExtended.chunk.normal.horizontal),
                            style = style.iconStyle,
                            resourceId = it,
                            description = text,
                        )
                    }
                    Text.StateColor(
                        text = text,
                        style = style.outfitTextHeader
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .also { modifier ->
                        style.colorBackgroundBody?.let {
                            modifier.background(it)
                        }
                    }
                    .padding(
                        vertical = MaterialTheme.dimensionsPaddingExtended.block.normal.vertical,
                        horizontal = style.dimensionPaddingBody_h
                    ),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsPaddingExtended.chunk.normal.vertical),
            ) {
                data.rows.forEachIndexed { index, row ->
                    ActionRow(data = row, style = style.actionRowStyle) {
                        onClick(index)
                    }
                    if (style.dimensionDivider > 0.dp && style.colorDivider != null && index != data.rows.lastIndex) {
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = MaterialTheme.dimensionsPaddingExtended.chunk.big.horizontal),
                            color = style.colorDivider,
                            thickness = style.dimensionDivider,
                        )
                    }
                }
            }
        }
    }

}