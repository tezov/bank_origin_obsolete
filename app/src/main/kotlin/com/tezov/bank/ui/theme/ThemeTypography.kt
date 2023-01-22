package com.tezov.bank.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import com.tezov.bank.ui.theme.ThemeDimensions.dimensionsFontExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.ThemeTypographyExtended
import com.tezov.bank.ui.theme.font.FontRoboto
import com.tezov.bank.ui.theme.font.FontUbuntu

object ThemeTypography {
    val typography = androidx.compose.material.Typography()
    val typographyExtended = ThemeTypographyExtended.Data(
        textTitle = TextStyle(
            fontFamily = FontRoboto.fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = dimensionsFontExtended.textTitle
        ),
        textSubtitle = TextStyle(
            fontFamily = FontRoboto.fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = dimensionsFontExtended.textSubtitle
        ),
        textHelper = TextStyle(
            fontFamily = FontRoboto.fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = dimensionsFontExtended.textHelper
        ),
        textNormal = TextStyle(
            fontFamily = FontRoboto.fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = dimensionsFontExtended.textNormal
        ),
        textBig = TextStyle(
            fontFamily = FontRoboto.fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = dimensionsFontExtended.textBig
        ),
        textHuge = TextStyle(
            fontFamily = FontRoboto.fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = dimensionsFontExtended.textHuge
        ),
        textSmall = TextStyle(
            fontFamily = FontRoboto.fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = dimensionsFontExtended.textSmall
        ),
        textField = TextStyle(
            fontFamily = FontRoboto.fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = dimensionsFontExtended.textField
        ),
        textLink = TextStyle(
            fontFamily = FontRoboto.fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = dimensionsFontExtended.textLink,
            textDecoration = TextDecoration.Underline
        ),
        textButton = TextStyle(
            fontFamily = FontRoboto.fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = dimensionsFontExtended.textButton
        ),
        textButtonIcon = TextStyle(
            fontFamily = FontRoboto.fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = dimensionsFontExtended.textButton_icon
        ),
        topNavigationTitle = TextStyle(
            fontFamily = FontUbuntu.fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = dimensionsFontExtended.topNavigation
        ),
        bottomNavigationLabel = TextStyle(
            fontFamily = FontUbuntu.fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = dimensionsFontExtended.bottomNavigation
        ),
        snackBarMessage = TextStyle(
            fontFamily = FontUbuntu.fontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = dimensionsFontExtended.snackBarMessage
        ),
        snackBarAction = TextStyle(
            fontFamily = FontUbuntu.fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = dimensionsFontExtended.snackBarMessage
        ),
    )
}