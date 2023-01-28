package com.tezov.bank.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import com.tezov.lib_core_android_kotlin.ui.theme.definition.ThemeTypographyExtended
import com.tezov.bank.ui.theme.font.fontRoboto
import com.tezov.bank.ui.theme.font.fontUbuntu
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsFontExtended

object ThemeTypography {
    @Composable
    fun providesTypographies() = androidx.compose.material.Typography()
    
    @Composable
    fun providesTypographiesExtended() = ThemeTypographyExtended.Common(
        textTitle = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textTitle
        ),
        textSubtitle = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textSubtitle
        ),
        textHelper = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textHelper
        ),
        textNormal = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textNormal
        ),
        textSupra = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textSupra
        ),
        textBig = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textBig
        ),
        textHuge = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.dimensionsFontExtended.textHuge
        ),
        textSmall = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textSmall
        ),
        textFieldValue = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textFieldValue
        ),
        textFieldLabel = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.SemiBold,
            fontSize = MaterialTheme.dimensionsFontExtended.textFieldLabel
        ),
        textLink = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textLink,
            textDecoration = TextDecoration.Underline
        ),
        textButton = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.textButton
        ),
        textButtonOutline = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.dimensionsFontExtended.textButtonOutlined
        ),
        topNavigationTitle = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.dimensionsFontExtended.topNavigation
        ),
        bottomNavigationLabel = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.bottomNavigation
        ),
        snackBarMessage = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.dimensionsFontExtended.snackBarMessage
        ),
        snackBarAction = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.dimensionsFontExtended.snackBarMessage
        ),
    )
}