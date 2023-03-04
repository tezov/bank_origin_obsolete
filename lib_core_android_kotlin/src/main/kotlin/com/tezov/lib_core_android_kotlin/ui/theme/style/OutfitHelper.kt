/*
 *  *********************************************************************************
 *  Created by Tezov on 04/03/2023 14:12
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/03/2023 13:55
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
typealias OutfitColorsState = OutfitColors.State.Style

typealias OutfitTextSketch = OutfitText.Sketch.Style
typealias OutfitTextSimple = OutfitText.Simple.Style
typealias OutfitTextState = OutfitText.State.Style

typealias OutfitShapeSketch = OutfitShape.Sketch.Style
typealias OutfitShapeSimple = OutfitShape.Simple.Style
typealias OutfitShapeState = OutfitShape.State.Style

typealias OutfitBorderSketch = OutfitBorder.Sketch.Style
typealias OutfitBorderSimple = OutfitBorder.Simple.Style
typealias OutfitBorderState = OutfitBorder.State.Style

typealias OutfitFrameSimple = OutfitFrame.Simple.Style
typealias OutfitFrameState = OutfitFrame.State.Style

//type

inline val Color.outfitColorsActive: OutfitColors.State.Style get() = OutfitColors.State.Style(active = this)
inline val Color.outfitColorsInactive: OutfitColors.State.Style get() = OutfitColors.State.Style(inactive = this)

inline val TextStyle.outfitTextSketch: OutfitText.Sketch.Style get() = OutfitText.Sketch.Style(typo = this)
inline val TextStyle.outfitTextSimple: OutfitText.Simple.Style get() = OutfitText.Simple.Style(sketch = this.outfitTextSketch)
inline val TextStyle.outfitTextState: OutfitText.State.Style get() = OutfitText.State.Style(sketch = this.outfitTextSketch)

inline val Int.outfitShapeSize: OutfitShape.Size get() = OutfitShape.Size(this)
inline val Int.outfitShapeSketch: OutfitShape.Sketch.Style get() = OutfitShape.Sketch.Style(size = this.outfitShapeSize)
inline val Int.outfitShapeSimple: OutfitShape.Simple.Style get() = OutfitShape.Simple.Style(sketch = this.outfitShapeSketch)
inline val Int.outfitShapeState: OutfitShape.State.Style get() = OutfitShape.State.Style(sketch = this.outfitShapeSketch)


inline val Int.outfitBorderSketch: OutfitBorder.Sketch.Style get() = OutfitBorder.Sketch.Style(size = this.dp)
inline val Int.outfitBorderSimple: OutfitBorder.Simple.Style get() = OutfitBorder.Simple.Style(sketch = this.outfitBorderSketch)
inline val Int.outfitBorderState: OutfitBorder.State.Style get() = OutfitBorder.State.Style(sketch = this.outfitBorderSketch)
inline val Double.outfitBorderSketch: OutfitBorder.Sketch.Style get() = OutfitBorder.Sketch.Style(size = this.dp)
inline val Double.outfitBorderSimple: OutfitBorder.Simple.Style get() = OutfitBorder.Simple.Style(sketch = this.outfitBorderSketch)
inline val Double.outfitBorderState: OutfitBorder.State.Style get() = OutfitBorder.State.Style(sketch = this.outfitBorderSketch)

