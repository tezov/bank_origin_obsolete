/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:51
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.tezov.bank.R

val MaterialTheme.fontIbm: FontFamily
    @Composable
    @ReadOnlyComposable
    get() = FontIbm.local.current.value

object FontIbm {
    val local = compositionLocalOf {
        lazy {
            FontFamily(
                Font(R.font.ibm_thin, weight = FontWeight.Light, style = FontStyle.Normal),
                Font(R.font.ibm_thin_italic, weight = FontWeight.Light, style = FontStyle.Italic),
                Font(R.font.ibm_light, weight = FontWeight.Normal, style = FontStyle.Normal),
                Font(R.font.ibm_light_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
                Font(R.font.ibm_regular, weight = FontWeight.SemiBold, style = FontStyle.Normal),
                Font(R.font.ibm_italic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
                Font(R.font.ibm_semibold, weight = FontWeight.Bold, style = FontStyle.Normal),
                Font(
                    R.font.ibm_semibold_italic,
                    weight = FontWeight.Bold,
                    style = FontStyle.Italic
                ),
            )
        }
    }
}
