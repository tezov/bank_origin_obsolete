/*
 *  *********************************************************************************
 *  Created by Tezov on 04/04/2023 21:22
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/04/2023 21:22
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
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style.Nucleus.asButtonNucleus
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link.StateColor.Style.Nucleus.asLinkNucleus
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.asTextPaletteSizeStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.asTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeTypographiesExtended

object ThemeTypographyProviders {

    @Composable
    fun common() = ThemeTypographiesExtended.Texts(
        title = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        ).asTextPaletteSizeStateColor,
        subtitle = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp
        ).asTextPaletteSizeStateColor,
        helper = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp
        ).asTextPaletteSizeStateColor,
        fieldValue = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        ).asTextStateColor,
        fieldLabel = TextStyle(
            fontFamily = MaterialTheme.fontRoboto,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp
        ).asTextStateColor,
    )

    @Composable
    fun buttons() = ThemeTypographiesExtended.Buttons(
        primary = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        ).asButtonNucleus
    )

    @Composable
    fun links() = ThemeTypographiesExtended.Links(
        primary = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        ).asLinkNucleus
    )
}