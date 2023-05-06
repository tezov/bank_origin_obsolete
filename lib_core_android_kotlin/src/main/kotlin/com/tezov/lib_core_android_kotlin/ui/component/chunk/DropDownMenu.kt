/*
 *  *********************************************************************************
 *  Created by Tezov on 06/05/2023 16:08
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/05/2023 16:03
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.chunk

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.modifier.thenOnNotNull
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeColorsExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import androidx.compose.ui.graphics.Color as ColorImport

object DropDownMenu {

    object StateColor {

        class StyleBuilder internal constructor(
            style: Style
        ) {
            var iconStyle = style.iconStyle
            var outfitText = style.outfitText
            var colorBackgroundMenu = style.colorBackgroundMenu

            internal fun get() = Style(
                iconStyle = iconStyle,
                outfitText = outfitText,
                colorBackgroundMenu = colorBackgroundMenu,
            )
        }

        class Style(
            iconStyle: Icon.StateColor.Style? = null,
            outfitText: OutfitTextStateColor? = null,
            colorBackgroundMenu: ColorImport? = null,
        ) {
            val iconStyle: Icon.StateColor.Style by DelegateNullFallBack.Ref(
                iconStyle,
                fallBackValue = {
                    Icon.StateColor.Style()
                })
            val outfitText: OutfitTextStateColor by DelegateNullFallBack.Ref(
                outfitText,
                fallBackValue = {
                    ThemeColorsExtended.Dummy.outfitTextState
                })
            val colorBackgroundMenu: ColorImport by DelegateNullFallBack.Ref(
                colorBackgroundMenu,
                fallBackValue = {
                    ThemeColorsExtended.Dummy.pink
                })

            companion object {

                @Composable
                fun Style.copy(
                    builder: @Composable StyleBuilder.() -> Unit = {}
                ) = StyleBuilder(this).also {
                    it.builder()
                }.get()

            }

            constructor(style: Style) : this(
                iconStyle = style.iconStyle,
                outfitText = style.outfitText,
                colorBackgroundMenu = style.colorBackgroundMenu,
            )
        }

        @Composable
        operator fun invoke(
            modifierBox: Modifier = Modifier,
            modifierIcon: Modifier = Modifier,
            modifierMenu: Modifier = Modifier,
            style: Style = Style(),
            painter: Painter,
            description: String? = null,
            items: List<String>,
            offset: DpOffset = DpOffset.Zero,
            contentPadding: PaddingValues = PaddingValues(8.dp, 0.dp),
            enabled: Boolean = true,
            selector: Any? = null,
            onClick: (Int) -> Unit = {},
        ) {
            Box(
                modifier = modifierBox
            ) {
                var expanded by remember { mutableStateOf(false) }
                Icon.Clickable(
                    onClick = {
                        if (enabled) {
                            expanded = true
                        }
                    }
                ){
                    Icon.StateColor(
                        modifier = modifierIcon,
                        style = style.iconStyle,
                        painter = painter,
                        description = description,
                        selector = selector
                    )
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = modifierMenu
                        .thenOnNotNull(style.colorBackgroundMenu) {
                            background(it)
                        },
                    offset = offset
                ) {
                    items.forEachIndexed { index, text ->
                        DropdownMenuItem(
                            onClick = {
                                expanded = false
                                onClick.invoke(index)
                            },
                            contentPadding = contentPadding
                        ) {
                            Text.StateColor(
                                text = text,
                                style = style.outfitText
                            )
                        }
                    }
                }
            }
        }

        @Composable
        operator fun invoke(
            modifierBox: Modifier = Modifier,
            modifierIcon: Modifier = Modifier,
            modifierMenu: Modifier = Modifier,
            style: Style = Style(),
            resourceId: Int,
            description: String? = null,
            items: List<String>,
            offset: DpOffset = DpOffset.Zero,
            contentPadding: PaddingValues = PaddingValues(8.dp, 0.dp),
            enabled: Boolean = true,
            selector: Any? = null,
            onClick: (Int) -> Unit = {},
        ) {
            invoke(
                modifierBox,
                modifierIcon,
                modifierMenu,
                style,
                painterResource(id = resourceId),
                description,
                items,
                offset,
                contentPadding,
                enabled,
                selector,
                onClick
            )
        }

        @Composable
        operator fun invoke(
            modifierBox: Modifier = Modifier,
            modifierIcon: Modifier = Modifier,
            modifierMenu: Modifier = Modifier,
            style: Style = Style(),
            painter: Painter,
            items: List<Int>,
            description: String? = null,
            offset: DpOffset = DpOffset.Zero,
            contentPadding: PaddingValues = PaddingValues(8.dp, 0.dp),
            enabled: Boolean = true,
            selector: Any? = null,
            onClick: (Int) -> Unit = {},
        ) {
            invoke(
                modifierBox,
                modifierIcon,
                modifierMenu,
                style,
                painter,
                description,
                items.map { stringResource(id = it) },
                offset,
                contentPadding,
                enabled,
                selector,
                onClick
            )
        }

        @Composable
        operator fun invoke(
            modifierBox: Modifier = Modifier,
            modifierIcon: Modifier = Modifier,
            modifierMenu: Modifier = Modifier,
            style: Style = Style(),
            resourceId: Int,
            items: List<Int>,
            description: String? = null,
            offset: DpOffset = DpOffset.Zero,
            contentPadding: PaddingValues = PaddingValues(8.dp, 0.dp),
            enabled: Boolean = true,
            selector: Any? = null,
            onClick: (Int) -> Unit = {},
        ) {
            invoke(
                modifierBox,
                modifierIcon,
                modifierMenu,
                style,
                painterResource(id = resourceId),
                description,
                items.map { stringResource(id = it) },
                offset,
                contentPadding,
                enabled,
                selector,
                onClick
            )
        }


        //        *** selector dual shortcut

        @Composable
        operator fun invoke(
            modifierBox: Modifier = Modifier,
            modifierIcon: Modifier = Modifier,
            modifierMenu: Modifier = Modifier,
            style: Style = Style(),
            painter: Painter,
            description: String? = null,
            items: List<String>,
            offset: DpOffset = DpOffset.Zero,
            contentPadding: PaddingValues = PaddingValues(8.dp, 0.dp),
            enabled: Boolean = true,
            onClick: (Int) -> Unit = {},
        ) {
            invoke(
                modifierBox,
                modifierIcon,
                modifierMenu,
                style,
                painter,
                description,
                items,
                offset,
                contentPadding,
                enabled,
                if (enabled) OutfitState.BiStable.Selector.Enabled else OutfitState.BiStable.Selector.Disabled,
                onClick
            )
        }

        @Composable
        operator fun invoke(
            modifierBox: Modifier = Modifier,
            modifierIcon: Modifier = Modifier,
            modifierMenu: Modifier = Modifier,
            style: Style = Style(),
            resourceId: Int,
            description: String? = null,
            items: List<String>,
            offset: DpOffset = DpOffset.Zero,
            contentPadding: PaddingValues = PaddingValues(8.dp, 0.dp),
            enabled: Boolean = true,
            onClick: (Int) -> Unit = {},
        ) {
            invoke(
                modifierBox,
                modifierIcon,
                modifierMenu,
                style,
                painterResource(id = resourceId),
                description,
                items,
                offset,
                contentPadding,
                enabled,
                if (enabled) OutfitState.BiStable.Selector.Enabled else OutfitState.BiStable.Selector.Disabled,
                onClick
            )
        }

        @Composable
        operator fun invoke(
            modifierBox: Modifier = Modifier,
            modifierIcon: Modifier = Modifier,
            modifierMenu: Modifier = Modifier,
            style: Style = Style(),
            painter: Painter,
            items: List<Int>,
            description: String? = null,
            offset: DpOffset = DpOffset.Zero,
            contentPadding: PaddingValues = PaddingValues(8.dp, 0.dp),
            enabled: Boolean = true,
            onClick: (Int) -> Unit = {},
        ) {
            invoke(
                modifierBox,
                modifierIcon,
                modifierMenu,
                style,
                painter,
                description,
                items.map { stringResource(id = it) },
                offset,
                contentPadding,
                enabled,
                if (enabled) OutfitState.BiStable.Selector.Enabled else OutfitState.BiStable.Selector.Disabled,
                onClick
            )
        }

        @Composable
        operator fun invoke(
            modifierBox: Modifier = Modifier,
            modifierIcon: Modifier = Modifier,
            modifierMenu: Modifier = Modifier,
            style: Style = Style(),
            resourceId: Int,
            items: List<Int>,
            description: String? = null,
            offset: DpOffset = DpOffset.Zero,
            contentPadding: PaddingValues = PaddingValues(8.dp, 0.dp),
            enabled: Boolean = true,
            onClick: (Int) -> Unit = {},
        ) {
            invoke(
                modifierBox,
                modifierIcon,
                modifierMenu,
                style,
                painterResource(id = resourceId),
                description,
                items.map { stringResource(id = it) },
                offset,
                contentPadding,
                enabled,
                if (enabled) OutfitState.BiStable.Selector.Enabled else OutfitState.BiStable.Selector.Disabled,
                onClick
            )
        }

    }

}