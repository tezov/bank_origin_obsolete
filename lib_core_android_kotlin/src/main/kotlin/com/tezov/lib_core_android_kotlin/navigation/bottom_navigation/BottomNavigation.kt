/*
 *  *********************************************************************************
 *  Created by Tezov on 03/03/2023 22:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 03/03/2023 21:58
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.navigation.bottom_navigation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.navigation.bottom_navigation.BottomNavigationState
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitColorsState
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextSketch
import com.tezov.lib_core_android_kotlin.ui.theme.theme.componentsExtended

object BottomNavigation:
    ActivitySub<BottomNavigationState, BottomNavigationAction> {

    open class Style(
        val outfitText: OutfitTextSketch = OutfitTextSketch(),
        val colorBackground: Color = Color.Black,
        val outfitColor: OutfitColorsState = OutfitColorsState(),
    ){
        companion object{

            open class Builder internal constructor(style: Style) {
                var outfitText = style.outfitText
                var colorBackground = style.colorBackground
                var outfitColor = style.outfitColor

                internal fun get() = Style(
                    outfitText = outfitText,
                    colorBackground = colorBackground,
                    outfitColor = outfitColor,
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
            outfitColor = style.outfitColor,
        )
    }

    @Composable
    operator fun invoke(items:Set<BottomNavigationItemData>) {
        content(items)
    }

    @Composable
    private fun content(items:Set<BottomNavigationItemData>) {
        val accessor = AccessorCoreUiActivity().get(this).contextSubMap()
        val action = accessor.with<BottomNavigation,_,_>().action()

        BottomNavigation(
            backgroundColor = MaterialTheme.componentsExtended.bottomNavigation.colorBackground,
        ) {
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = if(action.navigationController.currentRoute() == item.route)
                                item.iconActive else item.iconInactive
                            ),
                            contentDescription = stringResource(id = item.titleResourceId)
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(id = item.titleResourceId),
                            style = MaterialTheme.componentsExtended.bottomNavigation.outfitText.typo,
                        )
                    },
                    selectedContentColor = MaterialTheme.componentsExtended.bottomNavigation.outfitColor.active,
                    unselectedContentColor =MaterialTheme.componentsExtended.bottomNavigation.outfitColor.inactive,
                    alwaysShowLabel = true,
                    selected = action.navigationController.currentRoute() == item.route,
                    onClick = {
                        action.onClickItem(item.route)
                    }
                )
            }
        }
    }
}