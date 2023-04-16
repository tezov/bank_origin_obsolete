/*
 *  *********************************************************************************
 *  Created by Tezov on 16/04/2023 22:13
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 16/04/2023 18:13
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.chunk

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.unit.Dp

object Shadow {

    object Bottom {

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            elevation: Dp,
            ambientColor: Color = DefaultShadowColor,
            spotColor: Color = DefaultShadowColor,
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(elevation)
                    .shadow(elevation, ambientColor = ambientColor, spotColor = spotColor)
            )
        }


    }

}