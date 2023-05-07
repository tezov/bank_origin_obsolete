/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 23:36
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 23:24
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.element

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tezov.bank.R
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeColorsExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object MessageRow {

    class StyleBuilder internal constructor(
        style: Style
    ) {
        var colorIconInfo = style.colorIconInfo
        var styleIconAction = style.styleIconAction
        var outfitTextTitle = style.outfitTextTitle
        var outfitTextSubTitle = style.outfitTextSubTitle

        fun get() = Style(
            colorIconInfo = colorIconInfo,
            iconActionStyle = styleIconAction,
            outfitTextTitle = outfitTextTitle,
            outfitTextSubTitle = outfitTextSubTitle,
        )
    }

    class Style(
        val colorIconInfo: Color? = ThemeColorsExtended.Dummy.pink,
        iconActionStyle: Icon.Simple.Style? = null,
        val outfitTextTitle: OutfitTextStateColor? = null,
        val outfitTextSubTitle: OutfitTextStateColor? = null,
    ) {

        val styleIconAction: Icon.Simple.Style by DelegateNullFallBack.Ref(
            iconActionStyle,
            fallBackValue = {
                Icon.Simple.Style()
            }
        )

        companion object {

            @Composable
            fun Style.copy(
                scope: @Composable StyleBuilder.() -> Unit = {}
            ) = StyleBuilder(this).also {
                it.scope()
            }.get()

        }

        constructor(style: Style) : this(
            colorIconInfo = style.colorIconInfo,
            iconActionStyle = style.styleIconAction,
            outfitTextTitle = style.outfitTextTitle,
            outfitTextSubTitle = style.outfitTextSubTitle,
        )

    }

    class Data(
        val title: String,
        val subtitle: String,
        val iconActionId: Int = R.drawable.ic_arrow_cut_right_24dp,
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style: Style,
        data: Data,
        onClick: () -> Unit = {}
    ) {



    }

}