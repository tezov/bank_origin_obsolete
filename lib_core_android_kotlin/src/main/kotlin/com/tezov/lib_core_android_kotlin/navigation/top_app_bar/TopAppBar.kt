/*
 *  *********************************************************************************
 *  Created by Tezov on 29/03/2023 22:26
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 29/03/2023 21:20
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
import com.tezov.lib_core_android_kotlin.ui.component.plain.Text
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText
import com.tezov.lib_core_android_kotlin.ui.theme.theme.componentsCommonExtended

object TopAppBar: ActivitySub<TopAppBarState, TopAppBarAction> {


    open class Style(
        val outfitText: OutfitText.StateColor = OutfitText.StateColor(),
        val colorBackground: Color = Color.Black,
        val colorIconLeading: Color = Color.Black,
        val colorIconTrailing: Color = Color.Black,
    ){
        companion object{

            open class Builder internal constructor(style: Style) {
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

            @Composable
            fun Style.copy(builder: @Composable Builder.()->Unit = {}) = Builder(this).also {
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
        val accessor = AccessorCoreUiActivity().get(this).contextSubMap()
        val action = accessor.with<TopAppBar,_,_>().action()

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