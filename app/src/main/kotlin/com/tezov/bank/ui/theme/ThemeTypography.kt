/*
 *  *********************************************************************************
 *  Created by Tezov on 02/04/2023 17:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/04/2023 17:18
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
import com.tezov.bank.ui.theme.font.fontUbuntu
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style.Nucleus.asButtonNucleus
import com.tezov.lib_core_android_kotlin.ui.theme.style.asOutfitText
import com.tezov.lib_core_android_kotlin.ui.theme.style.asOutfitTextPalette
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeTypographiesExtended
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style.Nucleus.Typography as ButtonNucleus
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link.StateColor.Style.Nucleus.Typography as LinkNucleus

object ThemeTypography {

    @Composable
    fun providesCommon() = ThemeTypographiesExtended.Common(
        title = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        ).asOutfitTextPalette,


//        subtitle = TextStyle(
//            fontFamily = MaterialTheme.fontRoboto,
//            fontWeight = FontWeight.Normal,
//            fontSize = 15.sp
//        ).asOutfitTextColor,
//        helper = TextStyle(
//            fontFamily = MaterialTheme.fontRoboto,
//            fontWeight = FontWeight.Normal,
//            fontSize = 13.sp
//        ).asOutfitTextColor,
//        fieldValue = TextStyle(
//            fontFamily = MaterialTheme.fontRoboto,
//            fontWeight = FontWeight.Normal,
//            fontSize = 18.sp
//        ).asOutfitTextColor,
//        fieldLabel = TextStyle(
//            fontFamily = MaterialTheme.fontRoboto,
//            fontWeight = FontWeight.SemiBold,
//            fontSize = 12.sp
//        ).asOutfitTextColor,

    )

    @Composable
    fun providesButtons() = ThemeTypographiesExtended.Button(
        primary = TextStyle(
            fontFamily = MaterialTheme.fontUbuntu,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        ).asButtonNucleus




    )
}