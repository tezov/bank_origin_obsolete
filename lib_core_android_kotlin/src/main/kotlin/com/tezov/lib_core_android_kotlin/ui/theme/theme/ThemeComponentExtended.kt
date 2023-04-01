/*
 *  *********************************************************************************
 *  Created by Tezov on 01/04/2023 21:02
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/04/2023 20:46
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigation
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBar
import com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheet
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText

val MaterialTheme.componentsCommonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeComponentExtended.localCommons.current
infix fun MaterialTheme.provides(value: ThemeComponentExtended.Common) = ThemeComponentExtended.localCommons provides value

val MaterialTheme.componentsButtonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeComponentExtended.localButtons.current
infix fun MaterialTheme.provides(value: ThemeComponentExtended.Button) = ThemeComponentExtended.localButtons provides value

val MaterialTheme.componentsLinkExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeComponentExtended.localLinks.current
infix fun MaterialTheme.provides(value: ThemeComponentExtended.Link) = ThemeComponentExtended.localLinks provides value

object ThemeComponentExtended {

    @Immutable
    data class Common(
        val topAppBar: TopAppBar.Style,
        val bottomNavigation: BottomNavigation.Style,
        val dialogCard: Dialog.Card.Style,
        val bottomSheet: BottomSheet.Style,
        val snackBar: Snackbar.Style,
    )
    internal val localCommons: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Button(
        val confirm: com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style,
        val cancel: com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style,
        val proceed: com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style,
        val primary: com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style,
        val secondary: com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style,
        val tertiary: com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style,
    )

    internal val localButtons: ProvidableCompositionLocal<Button> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Link(
        val primary: com.tezov.lib_core_android_kotlin.ui.component.plain.Link.StateColor.Style,
        val secondary: com.tezov.lib_core_android_kotlin.ui.component.plain.Link.StateColor.Style,
        val tertiary: com.tezov.lib_core_android_kotlin.ui.component.plain.Link.StateColor.Style,
    )

    internal val localLinks: ProvidableCompositionLocal<Link> = staticCompositionLocalOf {
        error("not provided")
    }

}