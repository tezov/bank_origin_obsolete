/*
 *  *********************************************************************************
 *  Created by Tezov on 02/03/2023 20:30
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/03/2023 20:30
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
import com.tezov.bank.ui.theme.font.fontRoboto
import com.tezov.bank.ui.theme.font.fontUbuntu
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextSketch
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeTypographiesExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsFontExtended

object ThemeTypography {
    @Composable
    fun providesTypographies() = androidx.compose.material.Typography()

    @Composable
    fun providesTypographiesExtended() = ThemeTypographiesExtended.Sketch(
        textTitle = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = MaterialTheme.dimensionsFontExtended.textTitle
            )
        ),
        textSubtitle = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = MaterialTheme.dimensionsFontExtended.textSubtitle
            )
        ),
        textHelper = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = MaterialTheme.dimensionsFontExtended.textHelper
            )
        ),
        textNormal = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = MaterialTheme.dimensionsFontExtended.textNormal
            )
        ),
        textSupra = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = MaterialTheme.dimensionsFontExtended.textSupra
            )
        ),
        textBig = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = MaterialTheme.dimensionsFontExtended.textBig
            )
        ),
        textHuge = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.dimensionsFontExtended.textHuge
            )
        ),
        textSmall = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = MaterialTheme.dimensionsFontExtended.textSmall
            )
        ),
        textFieldValue = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = MaterialTheme.dimensionsFontExtended.textFieldValue
            )
        ),
        textFieldLabel = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.SemiBold,
                fontSize = MaterialTheme.dimensionsFontExtended.textFieldLabel
            )
        ),
        textLink = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = MaterialTheme.dimensionsFontExtended.textLink,
                textDecoration = TextDecoration.Underline
            )
        ),
        textButton = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = MaterialTheme.dimensionsFontExtended.textButton
            )
        ),
        textButtonOutline = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.dimensionsFontExtended.textButtonOutlined
            )
        ),
        topNavigationTitle = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontUbuntu,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.dimensionsFontExtended.topNavigation
            )
        ),
        bottomNavigationLabel = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontUbuntu,
                fontWeight = FontWeight.SemiBold,
                fontSize = MaterialTheme.dimensionsFontExtended.bottomNavigation
            )
        ),
        snackBarMessage = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontUbuntu,
                fontWeight = FontWeight.Normal,
                fontSize = MaterialTheme.dimensionsFontExtended.snackBarMessage
            )
        ),
        snackBarAction = OutfitTextSketch(
            TextStyle(
                fontFamily = MaterialTheme.fontUbuntu,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.dimensionsFontExtended.snackBarMessage
            )
        ),
    )
}