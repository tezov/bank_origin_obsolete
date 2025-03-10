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

package com.tezov.bank.ui.theme

import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.asStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeShapesExtended

object ThemeShapeProviders {

    fun common() = ThemeShapesExtended.Common(
        block = OutfitPaletteSize(
            normal = 10.dp.asStateColor,
            small = 6.dp.asStateColor,
            big = 14.dp.asStateColor,
        ),
        element = OutfitPaletteSize(
            normal = 12.dp.asStateColor,
            small = 5.dp.asStateColor,
            big = 18.dp.asStateColor,
        ),
        button = OutfitPaletteSize(
            normal = 24.dp.asStateColor,
            small = 12.dp.asStateColor,
        ),
        icon = OutfitPaletteSize(
            normal = 50.asStateColor
        )
    )


}