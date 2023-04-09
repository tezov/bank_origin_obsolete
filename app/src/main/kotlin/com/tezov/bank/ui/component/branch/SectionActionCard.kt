/*
 *  *********************************************************************************
 *  Created by Tezov on 09/04/2023 21:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 09/04/2023 20:55
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.component.leaf.ActionCard
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Text
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionComposable
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionComposable.loopOver
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object SectionActionCard {

    class Style(
        iconStyle: Icon.Simple.Style? = null,
        val outfitTextHeader: OutfitText.StateColor.Style? = null,
        val colorBackgroundHeader: Color? = null,
        val colorBackgroundBody: Color? = null,
        val dimensionPaddingBody: Dp = 0.dp,
        actionCardStyle: ActionCard.Style? = null
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
        val actionCardStyle: ActionCard.Style by DelegateNullFallBack.Ref(
            actionCardStyle,
            fallBackValue = { ActionCard.Style() }
        )

    }

    data class Data(
        val iconResourceId: Int? = null,
        val title: String? = null,
        var template: ActionCard.Template = ActionCard.Template.Undefined,
        val cards: List<ActionCard.Data>
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style: Style,
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
                        .also { modifier ->
                            style.colorBackgroundHeader?.let {
                                modifier.background(it)
                            }
                        }
                        .padding(vertical = MaterialTheme.dimensionsPaddingExtended.chunk.normal.vertical),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = modifier.width(MaterialTheme.dimensionsPaddingExtended.chunk.normal.horizontal))
                    data.iconResourceId?.let {
                        Icon.Simple(
                            modifier = Modifier
                                .padding(end = MaterialTheme.dimensionsPaddingExtended.chunk.big.vertical),
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
                        horizontal = style.dimensionPaddingBody
                    ),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsPaddingExtended.chunk.normal.vertical),
            ) {
                data.cards.loopOver {
                    val first = next
                    val second = next
                    // set default section template
                    if (data.template.isDefined) {
                        first?.let {
                            if (first.data.template.isUndefined) {
                                first.data.template = data.template
                            }
                        }
                        second?.let {
                            if (second.data.template.isUndefined) {
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
                    } else if (first != null) {
                        ContentRowUno(style.actionCardStyle, first, onClick)
                        done()
                    } else {
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
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsPaddingExtended.chunk.normal.vertical),
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