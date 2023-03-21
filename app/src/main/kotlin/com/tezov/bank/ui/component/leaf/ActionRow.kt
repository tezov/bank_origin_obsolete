/*
 *  *********************************************************************************
 *  Created by Tezov on 21/03/2023 20:53
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 21/03/2023 20:53
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.leaf

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.unit.dp
import com.tezov.bank.R
import com.tezov.lib_core_android_kotlin.type.primaire.SizeDp
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Text
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsSpacingExtended

object ActionRow {

    @Immutable
    data class Style(
        val iconInfoStyle: Icon.Simple.Style = Icon.Simple.Style(
            tint = Color.Black,
            size = SizeDp(24.dp)
        ),
        val iconActionStyle: Icon.Simple.Style = Icon.Simple.Style(
            tint = Color.Black,
            size = SizeDp(24.dp)
        ),
        val outfitText: OutfitText.StateColor = OutfitText.StateColor(),
        val background: Color? = null,
    )

    data class Data(
        val iconInfoResourceId: Int? = null,
        val title: String,
        val iconActionResourceId: Int = R.drawable.ic_arrow_cut_right_24dp,
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style: Style,
        data: Data,
        onClick: () -> Unit = {}
    ) {
        style.background?.let {
            modifier.background(it)
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable { onClick() }
                .padding(
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            data.iconInfoResourceId?.let {
                Icon.Simple(
                    style = style.iconInfoStyle,
                    resourceId = it,
                    description = null,
                )
                Spacer(modifier = Modifier.width(MaterialTheme.dimensionsSpacingExtended.normal_h))
            }
            Text.StateColor(
                modifier = Modifier
                    .weight(1f),
                text = data.title,
                style = style.outfitText
            )
            Icon.Simple(
                style = style.iconActionStyle,
                resourceId = data.iconActionResourceId,
                description = data.title,
            )
        }
    }

}