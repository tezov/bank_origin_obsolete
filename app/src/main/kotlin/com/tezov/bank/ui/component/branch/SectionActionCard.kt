/*
 *  *********************************************************************************
 *  Created by Tezov on 19/03/2023 22:02
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/03/2023 20:33
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.branch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.component.leaf.ActionCard
import com.tezov.lib_core_android_kotlin.type.primaire.SizeDp
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Text
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionComposable
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionComposable.loopOver
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextSimple
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsSpacingExtended

object SectionActionCard {

    @Immutable
    data class Style(
        val iconStyle: Icon.Simple.Style = Icon.Simple.Style(
            size = SizeDp(24.dp),
            tint = Color.Black
        ),
        val outfitTextHeader: OutfitTextSimple = OutfitTextSimple(),
        val colorBackgroundHeader: Color = Color.Transparent,
        val colorBackgroundBody: Color = Color.Transparent,
        val dimensionPaddingBody_h: Dp = 0.dp,
        val actionCardStyle: ActionCard.Style = ActionCard.Style()
    )

    data class Data(
        val iconResourceId: Int? = null,
        val title: String? = null,
        var template: ActionCard.Template = ActionCard.Template.Undefined,
        val cards: List<ActionCard.Data>
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style:Style,
        data: Data,
        onClick: (Int) -> Unit = {}
    ) {
        if (data.cards.isEmpty()) {
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
                        .background(style.colorBackgroundHeader)
                        .padding(vertical = MaterialTheme.dimensionsPaddingExtended.elementNormal_v),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = modifier.width(MaterialTheme.dimensionsPaddingExtended.elementNormal_h))
                    data.iconResourceId?.let {
                        Icon.Simple(
                            modifier = Modifier
                                .padding(end = MaterialTheme.dimensionsPaddingExtended.elementBig_h),
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(style.colorBackgroundBody)
                    .padding(
                        vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_h,
                        horizontal = style.dimensionPaddingBody_h
                    ),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_v),
            ) {
                data.cards.loopOver {
                    val first = next
                    val second = next
                    // set default section template
                    if(data.template.isDefined){
                        first?.let {
                            if(first.data.template.isUndefined){
                                first.data.template = data.template
                            }
                        }
                        second?.let {
                            if(second.data.template.isUndefined){
                                second.data.template = data.template
                            }
                        }
                    }
                    // compose row
                    if (first != null && second != null) {
                        if (first.data.template.isInlined) {
                            push(second)
                            ContentRowUno(style.actionCardStyle, first, onClick)
                        } else if (second.data.template.isInlined) {
                            push(first)
                            ContentRowUno(style.actionCardStyle, second, onClick)
                        } else {
                            ContentRowDuo(style.actionCardStyle, first, second, onClick)
                        }
                        if (hasReachEnd && isStackEmpty) {
                            done()
                        }
                    }
                    else if (first != null) {
                        ContentRowUno(style.actionCardStyle, first, onClick)
                        done()
                    }
                    else {
                        done()
                    }
                }
            }
        }
    }

    @Composable
    private fun ContentRowUno(
        style: ActionCard.Style,
        first: ExtensionComposable.LoopOver.Entry<ActionCard.Data>,
        onClick: (Int) -> Unit
    ) {
        ActionCard(
            modifier = Modifier
                .fillMaxWidth(),
            style = style,
            data = first.data.apply {
                template = ActionCard.Template.InlineDefault
            },
            onClick = { onClick(first.index) }
        )
    }

    @Composable
    private fun ContentRowDuo(
        style: ActionCard.Style,
        first: ExtensionComposable.LoopOver.Entry<ActionCard.Data>,
        second: ExtensionComposable.LoopOver.Entry<ActionCard.Data>,
        onClick: (Int) -> Unit
    ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Max)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_v),
        ) {
            ActionCard(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                style = style,
                data = first.data,
                onClick = { onClick(first.index) }
            )
            ActionCard(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                style = style,
                data = second.data,
                onClick = { onClick(second.index) }
            )
        }

    }

}