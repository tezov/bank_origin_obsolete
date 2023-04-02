/*
 *  *********************************************************************************
 *  Created by Tezov on 02/04/2023 17:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/04/2023 17:18
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

inline val Color.asOutfitColor: OutfitStateSimple<Color> get() = OutfitStateSimple(this)
inline val Color.asOutfitColorActive: OutfitStateDual<Color> get() = OutfitStateDual(active = this)
inline val Color.asOutfitColorInactive: OutfitStateDual<Color> get() = OutfitStateDual(inactive = this)

inline val TextStyle.asOutfitText: OutfitTextStateColor
    get() = OutfitText.StateColor.Style(
        typo = this
    ).also { it.outfitState.nullFallback = { Color.Black } }
inline val TextStyle.asOutfitTextPalette: OutfitPaletteSize<OutfitTextStateColor>
    get() = OutfitPaletteSize(this.asOutfitText)

inline val Int.asOutfitShapeSize: OutfitShape.Size get() = OutfitShape.Size(this)

inline val Int.asOutfitShapeColor: OutfitShapeStateColor
    get() = OutfitShapeStateColor(
        size = this.asOutfitShapeSize
    )
inline val Int.asOutfitBorderColor: OutfitBorderStateColor
    get() = OutfitBorderStateColor(
        size = this.dp
    )
inline val Double.asOutfitBorderColor: OutfitBorderStateColor
    get() = OutfitBorderStateColor(
        size = this.dp
    )



