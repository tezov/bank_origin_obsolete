/*
 *  *********************************************************************************
 *  Created by Tezov on 01/04/2023 21:02
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/04/2023 20:46
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
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPalette
import com.tezov.lib_core_android_kotlin.ui.theme.style.asOutfitTextColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeTypographiesExtended

object ThemeTypography {

    @Composable
    fun providesTypographies() = ThemeTypographiesExtended.Common(
        text = OutfitPalette.Variant(
            micro = TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp
            ).asOutfitTextColor,
            small = TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp
            ).asOutfitTextColor,
            normal = TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ).asOutfitTextColor,
            big = TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            ).asOutfitTextColor,
            huge = TextStyle(
                fontFamily = MaterialTheme.fontUbuntu,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            ).asOutfitTextColor,
            supra = TextStyle(
                fontFamily = MaterialTheme.fontUbuntu,
                fontWeight = FontWeight.Bold,
                fontSize = 34.sp
            ).asOutfitTextColor,
        ),
        textTitle = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        ).asOutfitTextColor,
        textSubtitle = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp
        ).asOutfitTextColor,
        textHelper = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp
        ).asOutfitTextColor,
        textFieldValue = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        ).asOutfitTextColor,
        textFieldLabel = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp
        ).asOutfitTextColor,
    )
}