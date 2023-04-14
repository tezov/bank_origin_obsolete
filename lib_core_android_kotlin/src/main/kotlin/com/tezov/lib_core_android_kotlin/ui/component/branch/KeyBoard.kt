/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 11:25
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 11:20
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.branch

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.*
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorderStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrameStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import kotlin.properties.Delegates

object KeyBoard {

    object GridCubeDigitsTwoRowShuffled {

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: GridCube.Style,
            onclick: (value: String) -> Unit
        ) {
            val keyBoardDigits = remember {
                val digits = List(10) {
                    GridCube.Common.CubeChar(it.toString()[0])
                }
                GridCube.Common.CubesChar(2, digits.shuffled()) {
                    onclick(_char)
                }
            }
            GridCube(modifier = modifier, style, keyBoardDigits)
        }
    }

    object GridCube {

        class StyleBuilder internal constructor(style: Style) {
            var colorBackground = style.colorBackground
            var colorOnBackground = style.colorOnBackground
            var outfitFrameOuter = style.outfitFrameOuter
            var outfitBorderInner = style.outfitBorderInner

            internal fun get() = Style(
                colorBackground = colorBackground,
                colorOnBackground = colorOnBackground,
                outfitFrameOuter = outfitFrameOuter,
                outfitBorderInner = outfitBorderInner,
            )
        }

        class Style(
            val colorBackground: Color = Color.Transparent,
            val colorOnBackground: Color = Color.Black,
            outfitFrameOuter: OutfitFrameStateColor? = null,
            outfitBorderInner: OutfitBorderStateColor? = null,
        ) {
            val outfitFrameOuter: OutfitFrameStateColor by DelegateNullFallBack.Ref(
                outfitFrameOuter,
                fallBackValue = {
                    OutfitFrameStateColor(
                        outfitBorder = OutfitBorderStateColor(
                            size = 2.dp,
                            outfitState = Color.Black.asStateSimple
                        )
                    )
                })
            val outfitBorderInner: OutfitBorderStateColor by DelegateNullFallBack.Ref(
                outfitBorderInner,
                fallBackValue = {
                    OutfitBorderStateColor(
                        size = 1.dp,
                        outfitState = Color.Black.asStateSimple
                    )
                })

            companion object {

                @Composable
                fun Style.copy(builder: @Composable StyleBuilder.() -> Unit) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()

            }

            constructor(style: Style) : this(
                colorBackground = style.colorBackground,
                colorOnBackground = style.colorOnBackground,
                outfitFrameOuter = style.outfitFrameOuter,
                outfitBorderInner = style.outfitBorderInner,
            )
        }

        interface Cube
        interface Cubes<C : Cube> {

            val rowCount: Int

            val columnCount: Int get() = size / rowCount

            val values: List<C>

            val size get() = values.size

            fun forEach(action: (C) -> Unit) = values.forEach(action)

            fun forEachIndexed(action: (Int, C) -> Unit) = values.forEachIndexed(action)

            fun onClicked(index: Int) = runCatching { values[index] }.getOrNull()?.onClicked()

            fun C.onClicked()

            @Composable
            fun beforeDraw(style: Style)

            fun beforeDraw(cubeSize: Size, style: Style)

            fun onDraw(cube: C, scope: DrawScope, style: Style)
        }

        @Composable
        operator fun <P : Cubes<C>, C : Cube> invoke(
            modifier: Modifier = Modifier,
            style: Style,
            cubes: P,
        ) {
            Layout(
                measurePolicy = { measurables, constraints ->
                    with(constraints) {
                        val digitSize = maxWidth / cubes.columnCount
                        val maxHeight = digitSize * cubes.rowCount
                        layout(maxWidth, maxHeight) {}
                    }
                },
                content = {},
                modifier = modifier
                    .onTouched(cubes)
                    .onDraw(style, cubes)
            )
        }

        @Composable
        private fun <P : Cubes<C>, C : Cube> Modifier.onTouched(cubes: P): Modifier {
            return pointerInput(Unit) {
                detectTapGestures(
                    onTap = { offset ->
                        val xPosition = ((offset.x / size.width) * cubes.columnCount).toInt()
                        val yPosition = ((offset.y / size.height) * cubes.rowCount).toInt()
                        val index = cubes.columnCount * yPosition + xPosition
                        cubes.onClicked(index)
                    }
                )
            }
        }

        @Composable
        private fun <P : Cubes<C>, C : Cube> Modifier.onDraw(style: Style, cubes: P): Modifier {
            cubes.beforeDraw(style = style)
            val density = LocalDensity.current
            return drawBehind {
                val cubeSize = size.width / cubes.columnCount
                //background
                if (style.colorBackground.alpha > 0f) {
                    drawRect(
                        color = style.colorBackground,
                        topLeft = Offset(0f, 0f),
                        size = Size(size.width, size.height),
                        style = Fill,
                    )
                }
                // border outer
                style.outfitFrameOuter.resolveBorder()?.let { border ->
                    style.outfitFrameOuter.outfitShape.size?.let { cornerSize ->
                        val size = Size(size.width, size.height)
                        val path = Path().apply {
                            addRoundRect(
                                RoundRect(
                                    rect = Rect(
                                        offset = Offset.Zero,
                                        size = size,
                                    ),
                                    topLeft = cornerSize.topStart?.let {
                                        val px = it.toPx(size, density)
                                        CornerRadius(px,px)
                                    } ?: CornerRadius.Zero,
                                    topRight = cornerSize.topEnd?.let {
                                        val px = it.toPx(size, density)
                                        CornerRadius(px,px)
                                    } ?: CornerRadius.Zero,
                                    bottomLeft = cornerSize.bottomStart?.let {
                                        val px = it.toPx(size, density)
                                        CornerRadius(px,px)
                                    } ?: CornerRadius.Zero,
                                    bottomRight = cornerSize.bottomEnd?.let {
                                        val px = it.toPx(size, density)
                                        CornerRadius(px,px)
                                    } ?: CornerRadius.Zero
                                )
                            )
                        }
                        drawPath(path, color = Color.Red)
                    } ?: run{
                        drawRect(
                            brush = border.brush,
                            topLeft = Offset(0f, 0f),
                            size = Size(size.width, size.height),
                            style = Stroke(width = border.width.toPx()),
                        )
                    }
                }
                style.outfitBorderInner.resolve()?.let {
                    //vertical line
                    for (i in 1 until cubes.rowCount) {
                        val y = cubeSize * i
                        drawLine(
                            start = Offset(x = 0f, y = y),
                            end = Offset(x = size.width, y = y),
                            brush = it.brush,
                            strokeWidth = it.width.toPx()
                        )
                    }
                    //horizontal line
                    for (i in 1..cubes.columnCount) {
                        val x = cubeSize * i
                        drawLine(
                            start = Offset(x = x, y = 0f),
                            end = Offset(x = x, y = size.height),
                            brush = it.brush,
                            strokeWidth = it.width.toPx()
                        )
                    }
                }

                val overflow = cubes.columnCount * cubes.rowCount
                //cubes
                val drawContextSizeSave = drawContext.size
                drawContext.size = Size(cubeSize, cubeSize)
                cubes.beforeDraw(drawContext.size, style = style)
                cubes.forEachIndexed { index, cube ->
                    if (index >= overflow) {
                        return@forEachIndexed
                    }
                    val x = (index % cubes.columnCount) * cubeSize
                    val y = (index / cubes.columnCount) * cubeSize
                    translate(x, y) {
                        clipRect(0f, 0f, cubeSize, cubeSize) {
                            cubes.onDraw(cube, this, style)
                        }
                    }
                }
                drawContext.size = drawContextSizeSave
            }
        }

        object Common {

            class CubeChar(char: Char) : Cube {
                internal val _char = char.toString()
            }

            @OptIn(ExperimentalTextApi::class)
            class CubesChar(
                override val rowCount: Int,
                override val values: List<CubeChar>,
                val onclick: CubeChar.() -> Unit
            ) : Cubes<CubeChar> {

                private lateinit var textMeasurer: TextMeasurer
                private lateinit var textStyle: TextStyle
                private var textOffset by Delegates.notNull<Offset>()

                override fun CubeChar.onClicked() = onclick()

                @Composable
                override fun beforeDraw(style: Style) {
                    textMeasurer = rememberTextMeasurer()
                }

                override fun beforeDraw(cubeSize: Size, style: Style) {
                    textStyle = TextStyle(
                        fontSize = (cubeSize.width * 0.25).toFloat().sp,
                        fontWeight = FontWeight.SemiBold,
                        color = style.colorOnBackground
                    )
                    textOffset = Offset((cubeSize.width / 3.5).toFloat(), 0f)
                }

                override fun onDraw(cube: CubeChar, scope: DrawScope, style: Style) {
                    val measuredText = textMeasurer.measure(
                        text = AnnotatedString(cube._char),
                        style = textStyle
                    )
                    scope.drawText(
                        textLayoutResult = measuredText,
                        topLeft = textOffset,
                    )
                }

            }

        }

    }

}