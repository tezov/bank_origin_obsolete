/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme.font

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.tezov.bank.R

val MaterialTheme.fontUbuntu: FontFamily
    @Composable
    @ReadOnlyComposable
    get() = FontUbuntu.local.current.value

object FontUbuntu{
    val local = compositionLocalOf {
        lazy {
            FontFamily(
                Font(R.font.ubuntu_light, FontWeight.Light),
                Font(R.font.ubuntu_medium, FontWeight.Medium),
                Font(R.font.ubuntu_bold, FontWeight.Bold),
                Font(R.font.ubuntu_regular, FontWeight.Normal),
            )
        }
    }
}
