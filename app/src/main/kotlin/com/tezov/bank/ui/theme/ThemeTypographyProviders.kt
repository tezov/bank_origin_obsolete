/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 15:32
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 14:40
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tezov.bank.ui.theme.font.fontRoboto
import com.tezov.bank.ui.theme.font.fontUbuntu
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.asPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.asTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeTypographiesExtended

object ThemeTypographyProviders {

    @Composable
    fun common() = ThemeTypographiesExtended.Common(
        title = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp
        ).asTextStateColor.asPaletteSize,
        body = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ).asTextStateColor.asPaletteSize,
        subtitle = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ).asTextStateColor.asPaletteSize,
        helper = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp
        ).asTextStateColor.asPaletteSize,
        button = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        ).asTextStateColor.asPaletteSize,
        link = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ).asTextStateColor.asPaletteSize,
        input = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        ).asTextStateColor.asPaletteSize,
        label = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp
        ).asTextStateColor.asPaletteSize,
        caption = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        ).asTextStateColor.asPaletteSize,
    )

}