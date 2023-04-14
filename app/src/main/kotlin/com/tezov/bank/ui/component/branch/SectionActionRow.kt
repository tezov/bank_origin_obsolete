/*
 *  *********************************************************************************
 *  Created by Tezov on 14/04/2023 22:46
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 14/04/2023 20:28
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
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object SectionActionRow {


    class StyleBuilder internal constructor(
        style: Style
    ) {
        var iconStyle = style.iconStyle
        var outfitTextHeader = style.outfitTextHeader
        var colorBackgroundHeader = style.colorBackgroundHeader
        var colorBackgroundBody = style.colorBackgroundBody
        var colorDivider = style.colorDivider
        var dimensionDivider = style.dimensionDivider
        var dimensionPaddingBody = style.dimensionPaddingBody
        var actionRowStyle = style.actionRowStyle

        fun get() = Style(
            iconStyle = iconStyle,
            outfitTextHeader = outfitTextHeader,
            colorBackgroundHeader = colorBackgroundHeader,
            colorBackgroundBody = colorBackgroundBody,
            colorDivider = colorDivider,
            dimensionDivider = dimensionDivider,
            dimensionPaddingBody = dimensionPaddingBody,
            actionRowStyle = actionRowStyle,
        )
    }

    class Style(
        iconStyle: Icon.Simple.Style? = null,
        val outfitTextHeader: OutfitText.StateColor.Style? = null,
        val colorBackgroundHeader: Color? = null,
        val colorBackgroundBody: Color? = null,
        val colorDivider: Color? = null,
        val dimensionDivider: Dp = 1.dp,
        val dimensionPaddingBody: Dp = 0.dp,
        actionRowStyle: ActionRow.Style? = null
    ) {

        val iconStyle: Icon.Simple.Style by DelegateNullFallBack.Ref(
            iconStyle,
            fallBackValue = {
                Icon.Simple.Style(
                    tint = Color.Black,
                    size = DpSize(24.dp)
                )
            }
        )
        val actionRowStyle: ActionRow.Style by DelegateNullFallBack.Ref(
            actionRowStyle,
            fallBackValue = { ActionRow.Style() }
        )

        companion object {

            @Composable
            fun Style.copy(
                scope: @Composable StyleBuilder.() -> Unit = {}
            ) = StyleBuilder(this).also {
                it.scope()
            }.get()

        }

        constructor(style: Style) : this(
            iconStyle = style.iconStyle,
            outfitTextHeader = style.outfitTextHeader,
            colorBackgroundHeader = style.colorBackgroundHeader,
            colorBackgroundBody = style.colorBackgroundBody,
            colorDivider = style.colorDivider,
            dimensionDivider = style.dimensionDivider,
            dimensionPaddingBody = style.dimensionPaddingBody,
            actionRowStyle = style.actionRowStyle,
        )

    }

    data class Data(
        val iconResourceId: Int? = null,
        val title: String? = null,
        val rows: List<ActionRow.Data>
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style: Style,
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
                        .thenOnNotNull(style.colorBackgroundHeader) {
                            modifier.background(it)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = modifier.width(MaterialTheme.dimensionsPaddingExtended.element.small.horizontal))
                    data.iconResourceId?.let {
                        Icon.Simple(
                            modifier = Modifier
                                .padding(end = MaterialTheme.dimensionsPaddingExtended.element.small.horizontal),
                            style = style.iconStyle,
                            resourceId = it,
                            description = text,
                        )
                    }
                    Text.StateColor(
                        modifier = Modifier.padding(vertical = MaterialTheme.dimensionsPaddingExtended.element.big.vertical),
                        text = text,
                        style = style.outfitTextHeader
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .thenOnNotNull(style.colorBackgroundBody) {
                        background(it)
                    },
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsPaddingExtended.element.normal.vertical),
            ) {
                data.rows.forEachIndexed { index, row ->
                    ActionRow(
                        modifier = Modifier
                            .padding(
                                horizontal = style.dimensionPaddingBody
                            ),
                        data = row, style = style.actionRowStyle
                    ) {
                        onClick(index)
                    }
                    if (style.dimensionDivider > 0.dp && style.colorDivider != null && index != data.rows.lastIndex) {
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = style.dimensionPaddingBody + MaterialTheme.dimensionsPaddingExtended.element.big.horizontal),
                            color = style.colorDivider,
                            thickness = style.dimensionDivider,
                        )
                    }
                }
            }
        }
    }

}