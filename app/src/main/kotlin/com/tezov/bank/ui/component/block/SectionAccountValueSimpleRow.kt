/*
 *  *********************************************************************************
 *  Created by Tezov on 23/04/2023 12:17
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 23/04/2023 11:04
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.block

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
import com.tezov.bank.ui.component.element.AccountValueSimpleRow
import com.tezov.bank.ui.component.element.SimpleRow
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.modifier.thenOnNotNull
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText
import com.tezov.lib_core_android_kotlin.ui.theme.style.background
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object SectionAccountValueSimpleRow {


    class StyleBuilder internal constructor(
        style: Style
    ) {
        var outfitTextTitle = style.outfitTextTitle
        var colorBackgroundHeader = style.colorBackgroundHeader
        var colorBackgroundBody = style.colorBackgroundBody
        var colorDivider = style.colorDivider
        var sizeDivider = style.sizeDivider
        var paddingBody = style.paddingBody
        var rowStyle = style.rowStyle

        fun get() = Style(
            outfitTextTitle = outfitTextTitle,
            colorBackgroundHeader = colorBackgroundHeader,
            colorBackgroundBody = colorBackgroundBody,
            colorDivider = colorDivider,
            sizeDivider = sizeDivider,
            paddingBody = paddingBody,
            rowStyle = rowStyle,
        )
    }

    class Style(
        val outfitTextTitle: OutfitText.StateColor.Style? = null,
        val colorBackgroundHeader: Color? = null,
        val colorBackgroundBody: Color? = null,
        val colorDivider: Color? = null,
        val sizeDivider: Dp = 1.dp,
        val paddingBody: Dp = 0.dp,
        rowStyle: AccountValueSimpleRow.Style? = null
    ) {

        val rowStyle: AccountValueSimpleRow.Style by DelegateNullFallBack.Ref(
            rowStyle,
            fallBackValue = { AccountValueSimpleRow.Style() }
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
            outfitTextTitle = style.outfitTextTitle,
            colorBackgroundHeader = style.colorBackgroundHeader,
            colorBackgroundBody = style.colorBackgroundBody,
            colorDivider = style.colorDivider,
            sizeDivider = style.sizeDivider,
            paddingBody = style.paddingBody,
            rowStyle = style.rowStyle,
        )

    }

    data class Data(
        val title: String? = null,
        val rows: List<AccountValueSimpleRow.Data>
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
                        }
                        .padding(start = MaterialTheme.dimensionsPaddingExtended.element.small.horizontal),
                ) {
                    Text.StateColor(
                        modifier = Modifier
                            .padding(
                                top = MaterialTheme.dimensionsPaddingExtended.element.small.vertical,
                                bottom = MaterialTheme.dimensionsPaddingExtended.element.small.vertical
                            ),
                        text = text,
                        style = style.outfitTextTitle
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .thenOnNotNull(style.colorBackgroundBody) {
                        background(it)
                    }
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.element.small.vertical),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsPaddingExtended.element.normal.vertical),
            ) {
                data.rows.forEachIndexed { index, row ->
                    AccountValueSimpleRow(
                        modifier = Modifier.padding(
                            start = style.paddingBody,
                            end = style.paddingBody,
                            bottom = MaterialTheme.dimensionsPaddingExtended.element.normal.vertical,
                        ),
                        data = row, style = style.rowStyle
                    ) {
                        onClick(index)
                    }
                    if (style.sizeDivider > 0.dp && style.colorDivider != null && index != data.rows.lastIndex) {
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = style.paddingBody),
                            color = style.colorDivider,
                            thickness = style.sizeDivider,
                        )
                    }
                }
            }
        }
    }

}