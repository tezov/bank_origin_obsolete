/*
 *  *********************************************************************************
 *  Created by Tezov on 26/04/2023 21:07
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/04/2023 20:03
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.navigation.top_app_bar

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.componentsCommonExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object TopAppBar : ActivitySub<TopAppBarState, TopAppBarAction> {

    class StyleBuilder internal constructor(style: Style) {
        var outfitText = style.outfitText
        var colorBackground = style.colorBackground
        var colorIconLeading = style.colorIconLeading
        var colorIconTrailing = style.colorIconTrailing

        internal fun get() = Style(
            outfitText = outfitText,
            colorBackground = colorBackground,
            colorIconLeading = colorIconLeading,
            colorIconTrailing = colorIconTrailing,
        )
    }

    class Style(
        outfitText: OutfitTextStateColor? = null,
        val colorBackground: Color = Color.Gray.copy(alpha = 0.25f),
        val colorIconLeading: Color = Color.Black,
        val colorIconTrailing: Color = Color.Black,
    ) {
        val outfitText: OutfitTextStateColor by DelegateNullFallBack.Ref(
            outfitText,
            fallBackValue = {
                OutfitTextStateColor(
                    outfitState = Color.Black.asStateSimple,
                    typo = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp
                    )
                )
            })

        companion object {

            @Composable
            fun Style.copy(builder: @Composable StyleBuilder.() -> Unit = {}) =
                StyleBuilder(this).also {
                    it.builder()
                }.get()

        }

        constructor(style: Style) : this(
            outfitText = style.outfitText,
            colorBackground = style.colorBackground,
            colorIconLeading = style.colorIconLeading,
            colorIconTrailing = style.colorIconTrailing,
        )
    }

    @Composable
    operator fun invoke(
        titleResourceId: Int,
        leadingItem: TopAppBarItemData? = null,
        trailingItem: TopAppBarItemData? = null
    ) {
        content(titleResourceId, leadingItem, trailingItem)
    }

    @Composable
    private fun content(
        titleResourceId: Int,
        leadingItem: TopAppBarItemData? = null,
        trailingItem: TopAppBarItemData? = null
    ) {
        val accessor = DiAccessorCoreUiActivity().with(LocalActivity.current).contextSubMap()
        val action = accessor.with<TopAppBar, _, _>().action()

        TopAppBar(
            title = {
                Text.StateColor(
                    text = stringResource(id = titleResourceId),
                    style = MaterialTheme.componentsCommonExtended.topAppBar.outfitText,
                )
            },
            backgroundColor = MaterialTheme.componentsCommonExtended.topAppBar.colorBackground,
            navigationIcon = {
                leadingItem?.let {
                    IconButton(onClick = {
                        action.onClickIconButton(it.route)
                    }) {
                        Icon(
                            painterResource(id = it.icon),
                            null,
                            tint = MaterialTheme.componentsCommonExtended.topAppBar.colorIconLeading
                        )
                    }
                }
            },
            actions = {
                trailingItem?.let {
                    IconButton(onClick = {
                        action.onClickIconButton(it.route)

                    }) {
                        Icon(
                            painterResource(id = it.icon),
                            null,
                            tint = MaterialTheme.componentsCommonExtended.topAppBar.colorIconTrailing
                        )
                    }
                }
            }
        )
    }

}