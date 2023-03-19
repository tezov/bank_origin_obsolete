/*
 *  *********************************************************************************
 *  Created by Tezov on 19/03/2023 16:08
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/03/2023 14:46
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

//type
inline val Color.outfitColorActive: OutfitStateDual<Color> get() = OutfitStateDual(active = this)
inline val Color.outfitColorInactive: OutfitStateDual<Color> get() = OutfitStateDual(inactive = this)

inline val Int.outfitShapeSize: OutfitShape.Size get() = OutfitShape.Size(this)

inline val Int.outfitShapeColor: OutfitShape.StateColor get() = OutfitShape.StateColor(size = this.outfitShapeSize)
inline val Int.outfitBorderColor: OutfitBorder.StateColor get() = OutfitBorder.StateColor(size = this.dp)
inline val Double.outfitBorderColor: OutfitBorder.StateColor get() = OutfitBorder.StateColor(size = this.dp)
inline val TextStyle.outfitTextColor: OutfitText.StateColor get() = OutfitText.StateColor(typo = this)

