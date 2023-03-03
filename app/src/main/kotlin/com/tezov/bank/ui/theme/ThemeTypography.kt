/*
 *  *********************************************************************************
 *  Created by Tezov on 03/03/2023 22:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 03/03/2023 22:28
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.tezov.bank.ui.theme.font.fontRoboto
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextSketch
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeTypographiesExtended

object ThemeTypography {
    @Composable
    fun providesTypographies() = androidx.compose.material.Typography()

    @Composable
    fun providesTypographiesExtended() = ThemeTypographiesExtended.Sketch(
        textTitle = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
        ),
        textSubtitle = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp
            )
        ),
        textHelper = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp
            )
        ),
        textSupra = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = 34.sp
            )
        ),
        textHuge = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            )
        ),
        textBig = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
        ),
        textNormal = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        ),
        textSmall = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp
            )
        ),
        textMicro = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp
            )
        ),
        textFieldValue = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp
            )
        ),
        textFieldLabel = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            )
        ),
        textLink = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                textDecoration = TextDecoration.Underline
            )
        ),
        textButton = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp
            )
        ),
        textButtonOutline = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        ),
    )
}