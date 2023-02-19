/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 20:50
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 20:30
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
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeTypographyExtended
import com.tezov.bank.ui.theme.font.fontRoboto
import com.tezov.bank.ui.theme.font.fontUbuntu
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextSimple
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsFontExtended

object ThemeTypography {
    @Composable
    fun providesTypographies() = androidx.compose.material.Typography()
    
    @Composable
    fun providesTypographiesExtended() = ThemeTypographyExtended.Common(
        textTitle = OutfitTextSimple(
            TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.Normal,
                fontSize = MaterialTheme.dimensionsFontExtended.textTitle
            )
        ),
        textSubtitle = OutfitTextSimple(
            TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textSubtitle
            )
        ),
        textHelper = OutfitTextSimple(
            TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textHelper
            )
        ),
        textNormal = OutfitTextSimple(
            TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textNormal
            )
        ),
        textSupra = OutfitTextSimple(
            TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textSupra
            )
        ),
        textBig = OutfitTextSimple(
            TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textBig
            )
        ),
        textHuge = OutfitTextSimple(
            TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.dimensionsFontExtended.textHuge
            )
        ),
        textSmall = OutfitTextSimple(
            TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textSmall
            )
        ),
        textFieldValue = OutfitTextSimple(
            TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textFieldValue
            )
        ),
        textFieldLabel = OutfitTextSimple(
            TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.SemiBold,
            fontSize = MaterialTheme.dimensionsFontExtended.textFieldLabel
            )
        ),
        textLink = OutfitTextSimple(
            TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textLink,
            textDecoration = TextDecoration.Underline
            )
        ),
        textButton = OutfitTextSimple(
            TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textButton
            )
        ),
        textButtonOutline = OutfitTextSimple(
            TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.dimensionsFontExtended.textButtonOutlined
            )
        ),
        topNavigationTitle = OutfitTextSimple(
            TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.dimensionsFontExtended.topNavigation
            )
        ),
        bottomNavigationLabel = OutfitTextSimple(
            TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.SemiBold,
            fontSize = MaterialTheme.dimensionsFontExtended.bottomNavigation
            )
        ),
        snackBarMessage = OutfitTextSimple(
            TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.snackBarMessage
            )
        ),
        snackBarAction = OutfitTextSimple(
            TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.dimensionsFontExtended.snackBarMessage
            )
        ),
    )
}