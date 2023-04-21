/*
 *  *********************************************************************************
 *  Created by Tezov on 21/04/2023 23:20
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 21/04/2023 23:18
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.element

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.*
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.component.layout.ShrinkableBox
import com.tezov.lib_core_android_kotlin.ui.modifier.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.asStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import java.util.*

object AccountSummaryCard {

    private const val MIN_SHRINK_FACTOR = 0.80f

    class StyleBuilder internal constructor(
        style: Style
    ) {
        var outfitFrame = style.outfitFrame
        var outfitTextTitle = style.outfitTextTitle
        var outfitTextSubTitle = style.outfitTextSubTitle
        var outfitTextAmount = style.outfitTextAmount

        internal fun get() = Style(
            outfitFrame = outfitFrame,
            outfitTextTitle = outfitTextTitle,
            outfitTextSubTitle = outfitTextSubTitle,
            outfitTextAmount = outfitTextAmount,
        )
    }

    class Style(
        outfitFrame: OutfitFrameStateColor? = null,
        val outfitTextTitle: OutfitTextStateColor? = null,
        val outfitTextSubTitle: OutfitTextStateColor? = null,
        val outfitTextAmount: OutfitTextStateColor? = null,
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
            outfitTextTitle = style?.outfitTextTitle,
            outfitTextSubTitle = style?.outfitTextSubTitle,
            outfitTextAmount = style?.outfitTextAmount,
        )

    }

    data class Data(
        val title: String,
        val subTitle: String,
        val amount: String,
    )

    private enum class MotionLayoutItem {
        TITLE,
        SUBTITLE,
        AMOUNT;
    }

    @Composable
    private fun constraintSetStart() = remember {
        ConstraintSet {
            val title = createRefFor(MotionLayoutItem.TITLE.name)
            val subtitle = createRefFor(MotionLayoutItem.SUBTITLE.name)
            val amount = createRefFor(MotionLayoutItem.AMOUNT.name)
            constrain(title) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }
            constrain(subtitle) {
                top.linkTo(title.bottom)
                start.linkTo(parent.start)
            }
            constrain(amount) {
                top.linkTo(subtitle.bottom)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            }
        }
    }

    @Composable
    private fun constraintSetEnd() = remember {
        ConstraintSet {
            val title = createRefFor(MotionLayoutItem.TITLE.name)
            val subtitle = createRefFor(MotionLayoutItem.SUBTITLE.name)
            val amount = createRefFor(MotionLayoutItem.AMOUNT.name)
            constrain(title) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)

            }
            constrain(subtitle) {
                width = Dimension.fillToConstraints
                top.linkTo(title.bottom)
                start.linkTo(parent.start)
                end.linkTo(amount.start)
                bottom.linkTo(parent.bottom)
            }
            constrain(amount) {
                width = Dimension.wrapContent
                top.linkTo(title.bottom)
                start.linkTo(subtitle.end)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        }
    }

    @Composable
    private fun constraintTransition() = Transition(
        """{
            pathMotionArc: 'startHorizontal',
            easing: 'easeInOut',
            KeyFrames: {
                KeyAttributes: [
                    {
                        target: ['AMOUNT'],
                        frames: [0, 10, 35, 50, 60, 100],
                        translationY: [0, -10, -15, -25, 10, 0],
                        rotationZ: [0, 5, -5, -10, -15, 0],
                        pathRotate: [1.00, 1.05, 1.10, 1.15, 1.00]
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
        onClick: (() -> Unit)? = null
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
                .padding(MaterialTheme.dimensionsPaddingExtended.block.normal)
                .thenOnNotNull(onClick) {
                    clickable { it() }
                },
            start = constraintSetEnd(),
            end = constraintSetStart(),
            transition = constraintTransition(),
            progress = progress,
//            debug = EnumSet.of(MotionLayoutDebugFlags.SHOW_ALL)
        ) {

            Text.StateColor(
                modifier = Modifier
                    .layoutId(MotionLayoutItem.TITLE.name)
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.element.small.vertical),
                text = data.title,
                style = style.outfitTextTitle
            )
            Text.StateColor(
                modifier = Modifier
                    .layoutId(MotionLayoutItem.SUBTITLE.name)
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.element.small.vertical),
                text = data.subTitle,
                style = style.outfitTextSubTitle
            )
            Text.StateColor(
                modifier = Modifier
                    .layoutId(MotionLayoutItem.AMOUNT.name)
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.element.small.vertical),
                text = data.amount,
                style = style.outfitTextAmount
            )

        }

    }


}




