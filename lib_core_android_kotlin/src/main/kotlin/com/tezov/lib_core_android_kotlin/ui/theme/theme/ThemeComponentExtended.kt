/*
 *  *********************************************************************************
 *  Created by Tezov on 02/04/2023 14:12
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/04/2023 14:12
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
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button as ButtonImport
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link as LinkImport

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
    class Button(
        val primary: ButtonImport.StateColor.Style,
        secondary: ButtonImport.StateColor.Style? = null,
        tertiary: ButtonImport.StateColor.Style? = null,
        confirm: ButtonImport.StateColor.Style? = null,
        cancel: ButtonImport.StateColor.Style? = null,
        proceed: ButtonImport.StateColor.Style? = null,
    ) : DelegateNullFallBack.Setter<ButtonImport.StateColor.Style>{

        val secondary: ButtonImport.StateColor.Style by DelegateNullFallBack(secondary)
        val tertiary: ButtonImport.StateColor.Style by DelegateNullFallBack(tertiary)
        val confirm: ButtonImport.StateColor.Style by DelegateNullFallBack(confirm)
        val cancel: ButtonImport.StateColor.Style by DelegateNullFallBack(cancel)
        val proceed: ButtonImport.StateColor.Style by DelegateNullFallBack(proceed)

        override fun refs() = listOf(secondary, tertiary, confirm, cancel, proceed)

        init {
            nullFallback = { primary }
        }
    }

    internal val localButtons: ProvidableCompositionLocal<Button> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Link(
        val primary: LinkImport.StateColor.Style,
        val secondary: LinkImport.StateColor.Style,
        val tertiary: LinkImport.StateColor.Style,
    )

    internal val localLinks: ProvidableCompositionLocal<Link> = staticCompositionLocalOf {
        error("not provided")
    }

}