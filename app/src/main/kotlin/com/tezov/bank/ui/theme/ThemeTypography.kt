/*
 *  *********************************************************************************
 *  Created by Tezov on 19/03/2023 22:02
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/03/2023 20:59
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
import com.tezov.bank.ui.theme.font.fontUbuntu
import com.tezov.lib_core_android_kotlin.ui.theme.style.outfitTextColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeTypographiesExtended

object ThemeTypography {

    @Composable
    fun providesTypographies() = ThemeTypographiesExtended.Common(
        textTitle = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        ).outfitTextColor,
        textSubtitle = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp
        ).outfitTextColor,
        textHelper = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp
        ).outfitTextColor,
        textSupra = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Bold,
            fontSize = 34.sp
        ).outfitTextColor,
        textHuge = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp
        ).outfitTextColor,
        textBig = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        ).outfitTextColor,
        textNormal = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ).outfitTextColor,
        textSmall = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp
        ).outfitTextColor,
        textMicro = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp
        ).outfitTextColor,
        textFieldValue = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        ).outfitTextColor,
        textFieldLabel = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp
        ).outfitTextColor,
        textLink = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            textDecoration = TextDecoration.Underline
        ).outfitTextColor,
        textButton = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        ).outfitTextColor,
        textButtonOutline = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ).outfitTextColor,
    )
}