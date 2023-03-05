/*
 *  *********************************************************************************
 *  Created by Tezov on 05/03/2023 17:17
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/03/2023 17:17
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

//alias
typealias OutfitStateDual<T> = OutfitState.Dual.Style<T>

typealias OutfitColorsSemantic = OutfitColor.Semantic.Style
typealias OutfitColorsPalette = OutfitColor.Palette.Style

typealias OutfitTextSketch = OutfitText.Sketch.Style
typealias OutfitTextSimple = OutfitText.Simple.Style
typealias OutfitTextState<T, OT> = OutfitText.State.Style<T,OT>
typealias OutfitTextStateColorDual = OutfitTextState<Color, OutfitStateDual<Color>>

typealias OutfitShapeSketch = OutfitShape.Sketch.Style
typealias OutfitShapeSimple = OutfitShape.Simple.Style
typealias OutfitShapeState<T, OT> = OutfitShape.State.Style<T,OT>
typealias OutfitShapeStateColorDual = OutfitShapeState<Color, OutfitStateDual<Color>>

typealias OutfitBorderSketch = OutfitBorder.Sketch.Style
typealias OutfitBorderSimple = OutfitBorder.Simple.Style
typealias OutfitBorderState<T, OT> = OutfitBorder.State.Style<T, OT>
typealias OutfitBorderStateColorDual = OutfitBorderState<Color, OutfitStateDual<Color>>

typealias OutfitFrameSimple = OutfitFrame.Simple.Style
typealias OutfitFrameState<T, OT> = OutfitFrame.State.Style<T, OT>
typealias OutfitFrameStateColorDual = OutfitFrameState<Color, OutfitStateDual<Color>>

//type
inline val Color.outfitColorActive: OutfitStateDual<Color> get() = OutfitStateDual(active = this)
inline val Color.outfitColorInactive: OutfitStateDual<Color> get() = OutfitStateDual(inactive = this)

inline val TextStyle.outfitTextSketch: OutfitTextSketch get() = OutfitTextSketch(typo = this)
inline val TextStyle.outfitTextSimple: OutfitTextSimple get() = OutfitTextSimple(sketch = this.outfitTextSketch)
inline val TextStyle.outfitTextStateDualColor: OutfitTextStateColorDual get() = OutfitTextStateColorDual(sketch = this.outfitTextSketch)

inline val Int.outfitShapeSize: OutfitShape.Size get() = OutfitShape.Size(this)
inline val Int.outfitShapeSketch: OutfitShapeSketch get() = OutfitShapeSketch(size = this.outfitShapeSize)
inline val Int.outfitShapeSimple: OutfitShapeSimple get() = OutfitShapeSimple(sketch = this.outfitShapeSketch)
inline val Int.outfitShapeStateDualColor: OutfitShapeStateColorDual get() = OutfitShapeStateColorDual(sketch = this.outfitShapeSketch)

inline val Int.outfitBorderSketch: OutfitBorderSketch get() = OutfitBorderSketch(size = this.dp)
inline val Int.outfitBorderSimple: OutfitBorderSimple get() =OutfitBorderSimple(sketch = this.outfitBorderSketch)
inline val Int.outfitBorderStateDualColor: OutfitBorderStateColorDual get() = OutfitBorderStateColorDual(sketch = this.outfitBorderSketch)

inline val Double.outfitBorderSketch: OutfitBorderSketch get() = OutfitBorderSketch(size = this.dp)
inline val Double.outfitBorderSimple: OutfitBorderSimple get() = OutfitBorderSimple(sketch = this.outfitBorderSketch)
inline val Double.outfitBorderStateDualColor: OutfitBorderStateColorDual get() = OutfitBorderStateColorDual(sketch = this.outfitBorderSketch)

