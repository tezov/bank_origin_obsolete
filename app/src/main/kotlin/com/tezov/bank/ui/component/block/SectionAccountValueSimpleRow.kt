/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 15:29
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 15:20
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
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.modifier.then
import com.tezov.lib_core_android_kotlin.ui.modifier.thenOnNotNull
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object SectionAccountValueSimpleRow {


    class StyleBuilder internal constructor(
        style: Style
    ) {
        var outfitTextTitle = style.outfitTextTitle
        var styleIconInfo = style.styleIconInfo
        var colorBackgroundHeader = style.colorBackgroundHeader
        var colorBackgroundBody = style.colorBackgroundBody
        var colorDivider = style.colorDivider
        var sizeDivider = style.sizeDivider
        var paddingBody = style.paddingBody
        var styleRow = style.styleRow

        fun get() = Style(
            outfitTextTitle = outfitTextTitle,
            styleIconInfo = styleIconInfo,
            colorBackgroundHeader = colorBackgroundHeader,
            colorBackgroundBody = colorBackgroundBody,
            colorDivider = colorDivider,
            sizeDivider = sizeDivider,
            paddingBody = paddingBody,
            styleRow = styleRow,
        )
    }

    class Style(
        val outfitTextTitle: OutfitText.StateColor.Style? = null,
        styleIconInfo: Icon.StateColor.Style? = null,
        val colorBackgroundHeader: Color? = null,
        val colorBackgroundBody: Color? = null,
        val colorDivider: Color? = null,
        val sizeDivider: Dp = 1.dp,
        val paddingBody: Dp = 0.dp,
        styleRow: AccountValueSimpleRow.Style? = null
    ) {

        val styleIconInfo: Icon.StateColor.Style by DelegateNullFallBack.Ref(
            styleIconInfo,
            fallBackValue = {
                Icon.StateColor.Style()
            }
        )

        val styleRow: AccountValueSimpleRow.Style by DelegateNullFallBack.Ref(
            styleRow,
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
            styleIconInfo = style.styleIconInfo,
            colorBackgroundHeader = style.colorBackgroundHeader,
            colorBackgroundBody = style.colorBackgroundBody,
            colorDivider = style.colorDivider,
            sizeDivider = style.sizeDivider,
            paddingBody = style.paddingBody,
            styleRow = style.styleRow,
        )

    }

    data class Data(
        val iconInfoId: Int? = null,
        val title: String? = null,
        val rows: List<AccountValueSimpleRow.Data>
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style: Style,
        data: Data,
        onClickInfo: () -> Unit = {},
        onClickRow: (Int) -> Unit = {}
    ) {
        if (data.rows.isEmpty()) {
            return
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            if(data.title != null || data.iconInfoId != null) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .thenOnNotNull(style.colorBackgroundHeader) {
                            modifier.background(it)
                        }
                        .padding(start = MaterialTheme.dimensionsPaddingExtended.element.small.horizontal),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    data.title?.let { text ->
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
                    data.iconInfoId?.let {
                        Spacer(modifier = Modifier.width(MaterialTheme.dimensionsPaddingExtended.element.small.horizontal))
                        Icon.Clickable(
                            onClick = onClickInfo
                        ){
                            Icon.StateColor(
                                style = style.styleIconInfo,
                                resourceId = it,
                                description = null,
                            )
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .thenOnNotNull(style.colorBackgroundBody) {
                        background(it)
                    }
                    .then(style.colorBackgroundHeader, onNotNull = {
                        padding(top = MaterialTheme.dimensionsPaddingExtended.element.normal.vertical)
                    }, onNull = {
                        padding(top = MaterialTheme.dimensionsPaddingExtended.element.small.vertical)
                    }),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsPaddingExtended.element.normal.vertical),
            ) {
                data.rows.forEachIndexed { index, row ->
                    AccountValueSimpleRow(
                        modifier = Modifier.padding(
                            start = style.paddingBody,
                            end = style.paddingBody,
                            bottom = MaterialTheme.dimensionsPaddingExtended.element.normal.vertical,
                        ),
                        data = row, style = style.styleRow
                    ) {
                        onClickRow(index)
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