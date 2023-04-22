/*
 *  *********************************************************************************
 *  Created by Tezov on 22/04/2023 22:06
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 22/04/2023 21:58
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.element

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.*
import com.tezov.bank.ui.page.lobby.login.*
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.modifier.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.asStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import java.util.*

object AccountSummaryCard {

    private const val MIN_SHRINK_FACTOR = 0.60f

    class StyleBuilder internal constructor(
        style: Style
    ) {
        var outfitFrame = style.outfitFrame
        var iconInfoStyle = style.iconInfoStyle
        var iconActionStyle = style.iconActionStyle
        var backgroundAction = style.backgroundAction
        var outfitTextSurtitle = style.outfitTextSurtitle
        var outfitTextTitle = style.outfitTextTitle
        var outfitTextSubtitle = style.outfitTextSubtitle
        var outfitTextAmount = style.outfitTextAmount
        var outfitTextAction = style.outfitTextAction

        internal fun get() = Style(
            outfitFrame = outfitFrame,
            iconInfoStyle = iconInfoStyle,
            iconActionStyle = iconActionStyle,
            backgroundAction = backgroundAction,
            outfitTextSurtitle = outfitTextSurtitle,
            outfitTextTitle = outfitTextTitle,
            outfitTextSubtitle = outfitTextSubtitle,
            outfitTextAmount = outfitTextAmount,
            outfitTextAction = outfitTextAction,
        )
    }

    class Style(
        outfitFrame: OutfitFrameStateColor? = null,
        iconInfoStyle: Icon.Simple.Style? = null,
        iconActionStyle: Icon.Simple.Style? = null,
        backgroundAction: Color? = null,
        val outfitTextSurtitle: OutfitTextStateColor? = null,
        val outfitTextTitle: OutfitTextStateColor? = null,
        val outfitTextSubtitle: OutfitTextStateColor? = null,
        val outfitTextAmount: OutfitTextStateColor? = null,
        val outfitTextAction: OutfitTextStateColor? = null,
    ) {
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
        val iconActionStyle: Icon.Simple.Style by DelegateNullFallBack.Ref(
            iconActionStyle,
            fallBackValue = {
                Icon.Simple.Style(
                    tint = Color.Black,
                    size = DpSize(24.dp)
                )
            }
        )
        val backgroundAction: Color by DelegateNullFallBack.Ref(
            backgroundAction,
            fallBackValue = {
                Color.LightGray
            }
        )

        companion object {

            @Composable
            fun Style.copy(
                builder: @Composable StyleBuilder.() -> Unit = {}
            ) = StyleBuilder(this).also {
                it.builder()
            }.get()

        }

        constructor(style: Style?) : this(
            outfitFrame = style?.outfitFrame,
            iconInfoStyle = style?.iconInfoStyle,
            iconActionStyle = style?.iconActionStyle,
            backgroundAction = style?.backgroundAction,
            outfitTextSurtitle = style?.outfitTextSurtitle,
            outfitTextTitle = style?.outfitTextTitle,
            outfitTextSubtitle = style?.outfitTextSubtitle,
            outfitTextAmount = style?.outfitTextAmount,
            outfitTextAction = style?.outfitTextAction,
        )

    }

    data class Data(
        val iconInfo: Int,
        val iconAction: Int,
        val surtitle: String,
        val title: String,
        val subTitle: String,
        val amount: String,
        val actions: List<String>,
    )

    private enum class MotionLayoutItem {
        ICON_INFO,
        ICON_ACTION,
        SURTITLE,
        TITLE,
        SUBTITLE,
        AMOUNT
    }

    @Composable
    private fun constraintSetStart() = remember {
        ConstraintSet {
            val iconInfo = createRefFor(MotionLayoutItem.ICON_INFO.name)
            val iconAction = createRefFor(MotionLayoutItem.ICON_ACTION.name)
            val surtitle = createRefFor(MotionLayoutItem.SURTITLE.name)
            val title = createRefFor(MotionLayoutItem.TITLE.name)
            val subtitle = createRefFor(MotionLayoutItem.SUBTITLE.name)
            val amount = createRefFor(MotionLayoutItem.AMOUNT.name)
            constrain(iconAction) {
                width = Dimension.wrapContent
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }
            constrain(iconInfo) {
                width = Dimension.wrapContent
                top.linkTo(parent.top)
                end.linkTo(iconAction.start)
            }
            constrain(surtitle) {
                width = Dimension.fillToConstraints
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(iconInfo.start)
            }
            constrain(title) {
                top.linkTo(surtitle.bottom)
                start.linkTo(parent.start)
            }
            constrain(subtitle) {
                top.linkTo(title.bottom)
                start.linkTo(parent.start)
            }
            constrain(amount) {
                top.linkTo(subtitle.bottom)
                start.linkTo(parent.start)
            }
        }
    }

    @Composable
    private fun constraintSetEnd() = remember {
        ConstraintSet {
            val iconInfo = createRefFor(MotionLayoutItem.ICON_INFO.name)
            val iconAction = createRefFor(MotionLayoutItem.ICON_ACTION.name)
            val surtitle = createRefFor(MotionLayoutItem.SURTITLE.name)
            val title = createRefFor(MotionLayoutItem.TITLE.name)
            val subtitle = createRefFor(MotionLayoutItem.SUBTITLE.name)
            val amount = createRefFor(MotionLayoutItem.AMOUNT.name)
            constrain(iconAction) {
                width = Dimension.wrapContent
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }
            constrain(iconInfo) {
                width = Dimension.wrapContent
                top.linkTo(parent.top)
                end.linkTo(iconAction.start)
            }
            constrain(surtitle) {
                width = Dimension.fillToConstraints
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(iconInfo.start)
            }
            constrain(title) {
                width = Dimension.fillToConstraints
                top.linkTo(surtitle.bottom)
                start.linkTo(parent.start)
                end.linkTo(amount.start)
            }
            constrain(subtitle) {
                visibility = Visibility.Invisible
                scaleX = 0.0f
                scaleY = 0.0f
                translationY = (-20).dp
                top.linkTo(title.bottom)
                start.linkTo(parent.start)
            }
            constrain(amount) {
                width = Dimension.wrapContent
                top.linkTo(title.top)
                start.linkTo(title.end)
                end.linkTo(parent.end)
                bottom.linkTo(title.bottom)
            }
        }
    }

    @Composable
    private fun constraintTransition() = Transition(
        """{
            pathMotionArc: 'startVertical',
            easing: 'easeInOut',
            KeyFrames: {
                KeyAttributes: [
                    {
                        target: ['AMOUNT'],
                        frames: [0, 50, 100],
                        translationY: [+25, -70, 0],
                        translationX: [-30, 0, 0],
                        scaleY: [0.75, 0.65, 1.0],
                        scaleX: [0.75, 0.5, 1.0],
                        alpha: [1.0, 0.5, 1.0],
                    }
                ]
            }
    }""".trimIndent()
    )

    @OptIn(ExperimentalMotionApi::class)
    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style: Style,
        data: Data,
        progress: Float = 1.0f,
        onClick: ((Int) -> Unit)? = null
    ) {
        val heightState = remember {
            mutableStateOf(Dp.Unspecified)
        }
        MotionLayout(
            modifier = modifier
                .fillMaxWidth()
                .updateToMaxHeight(heightState, heightState.value == Dp.Unspecified)
                .thenOnTrue(heightState.value != Dp.Unspecified) {
                    height(heightState.value * (progress).coerceAtLeast(MIN_SHRINK_FACTOR))
                }
                .background(style.outfitFrame)
                .padding(MaterialTheme.dimensionsPaddingExtended.block.huge),
            start = constraintSetEnd(),
            end = constraintSetStart(),
            transition = constraintTransition(),
            progress = progress,
//            debug = EnumSet.of(MotionLayoutDebugFlags.SHOW_ALL)
        ) {
            Icon.Simple(
                modifier = Modifier
                    .padding(horizontal = MaterialTheme.dimensionsPaddingExtended.element.small.horizontal)
                    .layoutId(MotionLayoutItem.ICON_INFO.name),
                style = style.iconInfoStyle,
                resourceId = data.iconInfo,
                description = data.title
            )
            Box(
                modifier = Modifier
                    .layoutId(MotionLayoutItem.ICON_ACTION.name),
            ) {
                var expanded by remember { mutableStateOf(false) }
                val items = data.actions
                Icon.Simple(
                    modifier = Modifier.clickable { expanded = true },
                    style = style.iconActionStyle,
                    resourceId = data.iconAction,
                    description = data.surtitle
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .background(style.backgroundAction),
                    offset = DpOffset.Zero
                ) {
                    items.forEachIndexed { index, text ->
                        DropdownMenuItem(
                            onClick = {
                                expanded = false
                                onClick?.invoke(index)
                            },
                            contentPadding = PaddingValues(8.dp, 0.dp)
                        ) {
                            Text.StateColor(
                                text = text,
                                style = style.outfitTextAction
                            )
                        }
                    }
                }
            }

            Text.StateColor(
                modifier = Modifier
                    .layoutId(MotionLayoutItem.SURTITLE.name),
                text = data.surtitle,
                style = style.outfitTextSurtitle
            )
            Text.StateColor(
                modifier = Modifier
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.element.normal.vertical)
                    .layoutId(MotionLayoutItem.TITLE.name),
                text = data.title,
                style = style.outfitTextTitle,
                maxLines = 1
            )
            Text.StateColor(
                modifier = Modifier
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.element.normal.vertical)
                    .layoutId(MotionLayoutItem.SUBTITLE.name),
                text = data.subTitle,
                style = style.outfitTextSubtitle
            )
            Text.StateColor(
                modifier = Modifier
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.element.normal.vertical)
                    .layoutId(MotionLayoutItem.AMOUNT.name),
                text = data.amount,
                style = style.outfitTextAmount
            )

        }

    }


}




