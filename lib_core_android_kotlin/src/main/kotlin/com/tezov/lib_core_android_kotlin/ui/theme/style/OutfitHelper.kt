/*
 *  *********************************************************************************
 *  Created by Tezov on 13/03/2023 21:48
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 13/03/2023 21:48
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
typealias OutfitStateDualSelector = OutfitState.Dual.Selector

typealias OutfitStateSemantic<T> = OutfitState.Semantic.Style<T>
typealias OutfitStateSemanticSelector = OutfitState.Semantic.Selector

typealias OutfitPaletteColor = OutfitPalette.Color

typealias OutfitTextSketch = OutfitText.Sketch.Style
typealias OutfitTextSimple = OutfitText.Simple.Style
typealias OutfitTextState<T, S, OT> = OutfitText.State.Style<T, S, OT>
typealias OutfitTextStateColor = OutfitTextState<Color, out OutfitState.Selector, out OutfitState.Style<Color, out OutfitState.Selector>>
typealias OutfitTextStateDualColor = OutfitTextState<Color, OutfitStateDualSelector, OutfitStateDual<Color>>
typealias OutfitTextStateSemanticColor = OutfitTextState<Color, OutfitStateSemanticSelector, OutfitStateSemantic<Color>>

typealias OutfitShapeSketch = OutfitShape.Sketch.Style
typealias OutfitShapeSimple = OutfitShape.Simple.Style
typealias OutfitShapeState<T, S, OT> = OutfitShape.State.Style<T, S, OT>
typealias OutfitShapeStateColor = OutfitShapeState<Color, out OutfitState.Selector, out OutfitState.Style<Color, out OutfitState.Selector>>
typealias OutfitShapeStateDualColor = OutfitShapeState<Color, OutfitStateDualSelector, OutfitStateDual<Color>>
typealias OutfitShapeStateSemanticColor = OutfitShapeState<Color, OutfitStateSemanticSelector, OutfitStateSemantic<Color>>

typealias OutfitBorderSketch = OutfitBorder.Sketch.Style
typealias OutfitBorderSimple = OutfitBorder.Simple.Style
typealias OutfitBorderState<T, S, OT> = OutfitBorder.State.Style<T, S, OT>
typealias OutfitBorderStateColor = OutfitBorderState<Color, out OutfitState.Selector, out OutfitState.Style<Color, out OutfitState.Selector>>
typealias OutfitBorderStateDualColor = OutfitBorderState<Color, OutfitStateDualSelector, OutfitStateDual<Color>>
typealias OutfitBorderStateSemanticColor = OutfitBorderState<Color, OutfitStateSemanticSelector, OutfitStateSemantic<Color>>

typealias OutfitFrameSimple = OutfitFrame.Simple.Style
typealias OutfitFrameState<T, S, OT> = OutfitFrame.State.Style<T, S, OT>
typealias OutfitFrameStateColor = OutfitFrameState<Color, out OutfitState.Selector, out OutfitState.Style<Color, out OutfitState.Selector>>
typealias OutfitFrameStateDualColor = OutfitFrameState<Color, OutfitStateDualSelector, OutfitStateDual<Color>>
typealias OutfitFrameStateSemanticColor = OutfitFrameState<Color, OutfitStateSemanticSelector, OutfitStateSemantic<Color>>

//type
inline val Color.outfitColorActive: OutfitStateDual<Color> get() = OutfitStateDual(active = this)
inline val Color.outfitColorInactive: OutfitStateDual<Color> get() = OutfitStateDual(inactive = this)

inline val TextStyle.outfitTextSketch: OutfitTextSketch get() = OutfitTextSketch(typo = this)
inline val TextStyle.outfitTextSimple: OutfitTextSimple get() = OutfitTextSimple(sketch = this.outfitTextSketch)

inline val Int.outfitShapeSize: OutfitShape.Size get() = OutfitShape.Size(this)
inline val Int.outfitShapeSketch: OutfitShapeSketch get() = OutfitShapeSketch(size = this.outfitShapeSize)
inline val Int.outfitShapeSimple: OutfitShapeSimple get() = OutfitShapeSimple(sketch = this.outfitShapeSketch)

inline val Int.outfitBorderSketch: OutfitBorderSketch get() = OutfitBorderSketch(size = this.dp)
inline val Int.outfitBorderSimple: OutfitBorderSimple get() =OutfitBorderSimple(sketch = this.outfitBorderSketch)
inline val Double.outfitBorderSketch: OutfitBorderSketch get() = OutfitBorderSketch(size = this.dp)
inline val Double.outfitBorderSimple: OutfitBorderSimple get() = OutfitBorderSimple(sketch = this.outfitBorderSketch)

