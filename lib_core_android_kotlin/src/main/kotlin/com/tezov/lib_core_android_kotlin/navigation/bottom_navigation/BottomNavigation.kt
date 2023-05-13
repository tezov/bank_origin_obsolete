/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

package com.tezov.lib_core_android_kotlin.navigation.bottom_navigation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.BiStable.Style.Companion.asStateBiStable
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitStateBiStable
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeColorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.componentsCommonExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object BottomNavigation :
    ActivitySub<BottomNavigationState, BottomNavigationAction> {

    class StyleBuilder internal constructor(style: Style) {
        var elevation = style.elevation
        var outfitText = style.outfitText
        var colorBackground = style.colorBackground
        var outfitColor = style.outfitColor

        internal fun get() = Style(
            elevation = elevation,
            outfitText = outfitText,
            colorBackground = colorBackground,
            outfitColor = outfitColor,
        )
    }

    class Style(
        val elevation: Dp = 2.dp,
        outfitText: OutfitTextStateColor? = null,
        colorBackground: Color? = null,
        outfitColor: OutfitStateBiStable<Color>? = null,
    ) {

        val outfitText: OutfitTextStateColor by DelegateNullFallBack.Ref(
            outfitText,
            fallBackValue = {
                OutfitTextStateColor()
            })

        val colorBackground: Color by DelegateNullFallBack.Ref(
            colorBackground,
            fallBackValue = {
                ThemeColorsExtended.Dummy.pink
            })

        val outfitColor: OutfitStateBiStable<Color> by DelegateNullFallBack.Ref(
            outfitColor,
            fallBackValue = {
                ThemeColorsExtended.Dummy.green.asStateBiStable
            })

        companion object {

            @Composable
            fun Style.copy(builder: @Composable StyleBuilder.() -> Unit = {}) =
                StyleBuilder(this).also {
                    it.builder()
                }.get()

        }

        constructor(style: Style) : this(
            elevation = style.elevation,
            outfitText = style.outfitText,
            colorBackground = style.colorBackground,
            outfitColor = style.outfitColor,
        )
    }

    @Composable
    operator fun invoke(items: Set<BottomNavigationItemData>) {
        content(items)
    }

    @Composable
    private fun content(items: Set<BottomNavigationItemData>) {
        val accessor = DiAccessorCoreUiActivity().with(LocalActivity.current).contextSubMap()
        val action = accessor.with<BottomNavigation, _, _>().action()
        val style = MaterialTheme.componentsCommonExtended.bottomNavigation
        BottomNavigation(
            elevation = style.elevation,
            backgroundColor = style.colorBackground,
        ) {
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(
                                id = if (action.navigationController.currentRoute() == item.route)
                                    item.iconActive else item.iconInactive
                            ),
                            contentDescription = stringResource(id = item.titleResourceId)
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(id = item.titleResourceId),
                            style =style.outfitText.typo,
                        )
                    },
                    selectedContentColor = style.outfitColor.resolve(
                        OutfitState.BiStable.Selector.Active
                    ) ?: LocalContentColor.current,
                    unselectedContentColor = style.outfitColor.resolve(
                        OutfitState.BiStable.Selector.Inactive
                    ) ?: LocalContentColor.current.copy(alpha = ContentAlpha.medium),
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