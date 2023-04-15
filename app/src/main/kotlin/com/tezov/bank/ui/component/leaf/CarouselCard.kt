/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 23:53
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 23:52
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.leaf

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Text
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.asStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsCommonExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button as ButtonImport
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link as LinkImport


object CarouselCard {

    object Style {

        open class Base(
            margin: PaddingValues? = null,
            outfitFrame: OutfitFrameStateColor? = null,
            iconInfoStyle: Icon.Simple.Style? = null,
            val outfitTextTag: OutfitTextStateColor? = null,
            val outfitTextTitle: OutfitTextStateColor? = null,
            val outfitTextBody: OutfitTextStateColor? = null,
            outfitFrameTag: OutfitFrameStateColor? = null,
        ) {
            val margin: PaddingValues by DelegateNullFallBack.Ref(
                margin,
                fallBackValue = {
                    PaddingValues(horizontal = 4.dp)
                }
            )
            val outfitFrame: OutfitFrameStateColor by DelegateNullFallBack.Ref(
                outfitFrame,
                fallBackValue = {
                    OutfitFrameStateColor(
                        outfitShape = 8.asStateColor,
                        outfitBorder = OutfitBorderStateColor(
                            size = 1.dp,
                            outfitState = Color.Black.asStateSimple,
                        )
                    )
                }
            )
            val iconInfoStyle: Icon.Simple.Style by DelegateNullFallBack.Ref(
                iconInfoStyle,
                fallBackValue = {
                    Icon.Simple.Style(
                        tint = Color.Black,
                        size = DpSize(24.dp)
                    )
                }
            )
            val outfitFrameTag: OutfitFrameStateColor by DelegateNullFallBack.Ref(
                outfitFrameTag,
                fallBackValue = {
                    OutfitFrameStateColor(
                        outfitShape = 4.asStateColor,
                        outfitBorder = OutfitBorderStateColor(
                            size = 2.dp,
                            outfitState = Color.Black.asStateSimple,
                        )
                    )
                }
            )

            companion object {

                open class Builder internal constructor(
                    style: Base
                ) {
                    var margin = style.margin
                    var outfitFrame = style.outfitFrame
                    var iconInfoStyle = style.iconInfoStyle
                    var outfitTextTag = style.outfitTextTag
                    var outfitTextTitle = style.outfitTextTitle
                    var outfitTextBody = style.outfitTextBody
                    var outfitFrameTag = style.outfitFrameTag


                    internal open fun get() = Base(
                        margin = margin,
                        outfitFrame = outfitFrame,
                        iconInfoStyle = iconInfoStyle,
                        outfitTextTag = outfitTextTag,
                        outfitTextTitle = outfitTextTitle,
                        outfitTextBody = outfitTextBody,
                        outfitFrameTag = outfitFrameTag,
                    )
                }

                @Composable
                fun Base.copy(
                    builder: @Composable Builder.() -> Unit = {}
                ) = Builder(this).also {
                    it.builder()
                }.get()

            }

            constructor(style: Base?) : this(
                margin = style?.margin,
                outfitFrame = style?.outfitFrame,
                iconInfoStyle = style?.iconInfoStyle,
                outfitTextTag = style?.outfitTextTag,
                outfitTextTitle = style?.outfitTextTitle,
                outfitTextBody = style?.outfitTextBody,
                outfitFrameTag = style?.outfitFrameTag,
            )

        }

        class Button(
            baseStyle: Base? = null,
            action: ButtonImport.StateColor.Style? = null,
        ) : Base(baseStyle) {

            val action: ButtonImport.StateColor.Style by DelegateNullFallBack.Ref(
                action,
                fallBackValue = { ButtonImport.StateColor.Style() }
            )

            companion object {

                class Builder internal constructor(
                    style: Button
                ) : Base.Companion.Builder(style) {
                    var action = style.action

                    override fun get() = Button(
                        baseStyle = super.get(),
                        action = action,
                    )
                }

                @Composable
                fun Button.copy(
                    builder: @Composable Builder.() -> Unit = {}
                ) = Builder(this).also {
                    it.builder()
                }.get()

                @Composable
                fun Base.copyToButtonStyle(scope: @Composable Builder.() -> Unit) =
                    Builder(
                        Button(this)
                    ).also { it.scope() }.get()

            }

            constructor(style: Button) : this(
                baseStyle = style,
                action = style.action,
            )

        }

        class Link(
            baseStyle: Base? = null,
            action: LinkImport.StateColor.Style? = null,
        ) : Base(baseStyle) {

            val action: LinkImport.StateColor.Style by DelegateNullFallBack.Ref(
                action,
                fallBackValue = { LinkImport.StateColor.Style() }
            )

            companion object {

                class Builder internal constructor(
                    style: Link
                ) : Base.Companion.Builder(style) {
                    var action = style.action

                    override fun get() = Link(
                        baseStyle = super.get(),
                        action = action,
                    )
                }

                @Composable
                fun Link.copy(
                    builder: @Composable Builder.() -> Unit = {}
                ) = Builder(this).also {
                    it.builder()
                }.get()

                @Composable
                fun Base.copyToLinkStyle(scope: @Composable Builder.() -> Unit) =
                    Builder(
                        Link(this)
                    ).also { it.scope() }.get()

            }

            constructor(style: Link) : this(
                baseStyle = style,
                action = style.action,
            )

        }

    }

    data class Data(
        val iconInfoResourceId: Int? = null,
        val tag: String? = null,
        val title: String,
        val body: String,
        val action: String,
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style: Style.Base,
        data: Data,
        onClick: () -> Unit = {}
    ) {

        when (style) {
            is Style.Button -> {
                ContentButton(style, modifier, data, onClick)
            }
            is Style.Link -> {
                ContentLink(style, modifier, data, onClick)
            }
        }

    }

    @Composable
    private fun ContentButton(
        style: Style.Button,
        modifier: Modifier,
        data: Data,
        onClick: () -> Unit
    ) {
        Surface(
            color = style.outfitFrame.resolveColorShape() ?: MaterialTheme.colors.surface,
            shape = style.outfitFrame.getShape() ?: MaterialTheme.shapes.small,
            border = style.outfitFrame.resolveBorder()
        ) {
            Row {
                Column(
                    modifier = modifier
                        .padding(
                            top = MaterialTheme.dimensionsPaddingExtended.block.big.vertical,
                            start = MaterialTheme.dimensionsPaddingExtended.block.big.horizontal,
                            end = MaterialTheme.dimensionsPaddingExtended.block.big.horizontal,
                            bottom = MaterialTheme.dimensionsPaddingExtended.block.normal.vertical,
                        )
                        .weight(1f)
                ) {
                    data.tag?.let {
                        Column(
                            modifier = Modifier
                                .padding(bottom = MaterialTheme.dimensionsPaddingExtended.element.normal.vertical)
                                .border(style.outfitFrameTag)
                                .background(style.outfitFrameTag)
                        ) {
                            Text.StateColor(
                                modifier = Modifier.padding(
                                    vertical = MaterialTheme.dimensionsPaddingExtended.element.small.vertical,
                                    horizontal = MaterialTheme.dimensionsPaddingExtended.element.big.horizontal
                                ),
                                text = it,
                                style = style.outfitTextTag,
                            )
                        }
                    }
                    Text.StateColor(
                        modifier = Modifier.padding(bottom = MaterialTheme.dimensionsPaddingExtended.element.big.vertical),
                        text = data.title,
                        style = style.outfitTextTitle,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text.StateColor(
                        modifier = Modifier.padding(bottom = MaterialTheme.dimensionsPaddingExtended.element.normal.vertical),
                        text = data.body,
                        style = style.outfitTextBody,
                    )
                    ButtonImport.StateColor(
                        text = data.action,
                        style = style.action,
                        onClick = onClick,
                    )
                }
                data.iconInfoResourceId?.let {
                    Icon.Simple(
                        modifier = Modifier.align(Alignment.Top),
                        resourceId = it,
                        description = null,
                        style = style.iconInfoStyle
                    )
                }
            }
        }
    }

    @Composable
    private fun ContentLink(
        style: Style.Link,
        modifier: Modifier,
        data: Data,
        onClick: () -> Unit
    ) {
        Surface(
            color = style.outfitFrame.resolveColorShape() ?: MaterialTheme.colors.surface,
            shape = style.outfitFrame.getShape() ?: MaterialTheme.shapes.small,
            border = style.outfitFrame.resolveBorder()
        ) {
            Column(
                modifier = modifier
                    .padding(MaterialTheme.dimensionsPaddingExtended.block.big)
            ) {
                data.tag?.let {
                    Column(
                        modifier = Modifier
                            .padding(bottom = MaterialTheme.dimensionsPaddingExtended.element.normal.vertical)
                            .border(style.outfitFrameTag)
                            .background(style.outfitFrameTag)
                    ) {
                        Text.StateColor(
                            modifier = Modifier.padding(
                                vertical = MaterialTheme.dimensionsPaddingExtended.element.small.vertical,
                                horizontal = MaterialTheme.dimensionsPaddingExtended.element.big.horizontal
                            ),
                            text = it,
                            style = style.outfitTextTag,
                        )
                    }
                }
                Row {
                    data.iconInfoResourceId?.let {
                        Icon.Simple(
                            modifier = Modifier.padding(end = MaterialTheme.dimensionsPaddingExtended.element.normal.horizontal),
                            resourceId = it,
                            description = null,
                            style = style.iconInfoStyle
                        )
                    }
                    Text.StateColor(
                        modifier = Modifier.padding(bottom = MaterialTheme.dimensionsPaddingExtended.element.big.vertical),
                        text = data.title,
                        style = style.outfitTextTitle,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Text.StateColor(
                    modifier = Modifier.padding(bottom = MaterialTheme.dimensionsPaddingExtended.element.big.vertical),
                    text = data.body,
                    style = style.outfitTextBody,
                )
                LinkImport.StateColor(
                    text = data.action,
                    style = style.action,
                    onClick = onClick
                )

            }
        }
    }

}




