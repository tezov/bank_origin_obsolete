/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 03:45
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 03:45
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

open class ShapeStyle(
    val shape: Shape? = Default.shape,
    val border: Dp? = Default.border,
    val color: Color? = Default.color,
) {

    companion object{
        internal val Default = ShapeStyle(
            shape = null,
            border = null,
            color = null,
        )

        fun ShapeStyle.copy(
            shape: Shape? = null,
            border: Dp? = null,
            color: Color? = null,
        ) = ShapeStyle(
            shape = shape ?: this.shape,
            border = border ?: this.border,
            color = color ?: this.color,
        )
    }

    constructor(style: ShapeStyle) : this(
        shape = style.shape,
        border = style.border,
        color = style.color,
    )

}