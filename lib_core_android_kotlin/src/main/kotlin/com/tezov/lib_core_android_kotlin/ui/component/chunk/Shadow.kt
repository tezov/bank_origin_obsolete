/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
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