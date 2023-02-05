/*
 *  *********************************************************************************
 *  Created by Tezov on 05/02/2023 18:22
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/02/2023 17:37
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.branch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.component.leaf.ActionCard
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionComposable
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionComposable.loopOver
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsSpacingExtended

infix fun SectionActionCard.provides(value: SectionActionCard.Style) = local provides value

object SectionActionCard {

    internal val local: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        Style()
    }

    @Immutable
    data class Style(
        val colorIcon: Color = Color.Black,
        val dimensionIcon: Dp = 24.dp,
        val typographyHeader: TextStyle = TextStyle(),
        val colorBackgroundHeader: Color = Color.Transparent,
        val colorBackgroundBody: Color = Color.Transparent,
        val dimensionPaddingBody_h: Dp = 0.dp,
    )

    data class Data(
        val iconResourceId: Int? = null,
        val title: String? = null,
        val cards: List<ActionCard.Data>
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        data: Data,
        onClick: (Int) -> Unit
    ) {
        Content(modifier, data, onClick)
    }

    @Composable
    private fun Content(
        modifier: Modifier,
        data: Data,
        onClick: (Int) -> Unit
    ) {
        if (data.cards.isEmpty()) {
            return
        }
        val style = local.current
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
                        Icon(
                            modifier = Modifier
                                .padding(end = MaterialTheme.dimensionsPaddingExtended.elementBig_h)
                                .size(style.dimensionIcon),
                            painter = painterResource(id = it),
                            tint = style.colorIcon,
                            contentDescription = text,
                        )
                    }
                    Text(
                        text = text,
                        style = style.typographyHeader
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
                    if (first != null && second != null) {
                        if (first.data.template == ActionCard.Template.IconEnd) {
                            push(second)
                            ContentRowUno(first, onClick)
                        } else if (second.data.template == ActionCard.Template.IconEnd) {
                            push(first)
                            ContentRowUno(second, onClick)
                        } else {
                            ContentRowDuo(first, second, onClick)
                        }
                        if (hasReachEnd && isStackEmpty) {
                            done()
                        }
                    } else if (first != null) {
                        ContentRowUno(first) {

                        }
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
        first: ExtensionComposable.LoopOver.Entry<ActionCard.Data>,
        onClick: (Int) -> Unit
    ) {
        ActionCard(
            modifier = Modifier
                .fillMaxWidth(),
            data = first.data.apply {
                template = ActionCard.Template.IconEnd
            },
            onClick = { onClick(first.index) }
        )
    }

    @Composable
    private fun ContentRowDuo(
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
                data = first.data.apply {
                    template = ActionCard.Template.IconTopEnd
                },
                onClick = { onClick(first.index) }
            )
            ActionCard(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                data = second.data.apply {
                    template = ActionCard.Template.IconTopEnd
                },
                onClick = { onClick(second.index) }
            )
        }

    }

}