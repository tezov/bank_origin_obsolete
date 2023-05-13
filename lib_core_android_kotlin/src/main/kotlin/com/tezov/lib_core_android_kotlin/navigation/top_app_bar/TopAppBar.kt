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

package com.tezov.lib_core_android_kotlin.navigation.top_app_bar

import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Shadow
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.modifier.then
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeColorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.componentsCommonExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsCommonExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object TopAppBar : ActivitySub<TopAppBarState, TopAppBarAction> {

    class StyleBuilder internal constructor(style: Style) {
        var elevation = style.elevation
        var outfitText = style.outfitText
        var colorBackground = style.colorBackground
        var colorIconLeading = style.colorIconLeading
        var colorIconTrailing = style.colorIconTrailing

        internal fun get() = Style(
            elevation = elevation,
            outfitText = outfitText,
            colorBackground = colorBackground,
            colorIconLeading = colorIconLeading,
            colorIconTrailing = colorIconTrailing,
        )
    }

    class Style(
        val elevation: Dp = 2.dp,
        outfitText: OutfitTextStateColor? = null,
        colorBackground: Color? = ThemeColorsExtended.Dummy.pink,
        colorIconLeading: Color? = ThemeColorsExtended.Dummy.green,
        colorIconTrailing: Color? = ThemeColorsExtended.Dummy.green,
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
        val colorIconLeading: Color by DelegateNullFallBack.Ref(
            colorIconLeading,
            fallBackValue = {
                ThemeColorsExtended.Dummy.green
            })
        val colorIconTrailing: Color by DelegateNullFallBack.Ref(
            colorIconTrailing,
            fallBackValue = {
                ThemeColorsExtended.Dummy.green
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
        Box {
            val style = MaterialTheme.componentsCommonExtended.topAppBar
            TopAppBar(
                elevation = 0.dp,
                title = {
                    Text.StateColor(
                        text = stringResource(id = titleResourceId),
                        style = style.outfitText,
                    )
                },
                backgroundColor = style.colorBackground,
                navigationIcon = {
                    leadingItem?.let {
                        Icon.Clickable(onClick = {
                            action.onClickIconButton(it.route)
                        }) {
                            Icon(
                                painterResource(id = it.icon),
                                null,
                                tint = style.colorIconLeading
                            )
                        }
                    }
                },
                actions = {
                    trailingItem?.let {
                        Icon.Clickable(onClick = {
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
            if(style.elevation > 0.dp){
                Shadow.Bottom(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    elevation = style.elevation,
                )
            }
        }

    }

}