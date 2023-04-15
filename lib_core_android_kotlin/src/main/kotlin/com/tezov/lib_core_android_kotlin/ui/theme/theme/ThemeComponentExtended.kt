/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:52
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigation
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBar
import com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheet
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button as ButtonImport
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link as LinkImport

val MaterialTheme.componentsCommonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeComponentExtended.localCommons.current

infix fun MaterialTheme.provides(value: ThemeComponentExtended.Common) =
    ThemeComponentExtended.localCommons provides value

val MaterialTheme.componentsButtonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeComponentExtended.localButtons.current

infix fun MaterialTheme.provides(value: ThemeComponentExtended.Buttons) =
    ThemeComponentExtended.localButtons provides value

val MaterialTheme.componentsLinkExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeComponentExtended.localLinks.current

infix fun MaterialTheme.provides(value: ThemeComponentExtended.Links) =
    ThemeComponentExtended.localLinks provides value

object ThemeComponentExtended {

    class Common(
        topAppBar: TopAppBar.Style? = null,
        bottomNavigation: BottomNavigation.Style? = null,
        dialogCard: Dialog.Card.Style? = null,
        bottomSheet: BottomSheet.Style? = null,
        snackBar: Snackbar.Style? = null,
    ) {
        val topAppBar: TopAppBar.Style by DelegateNullFallBack.Ref(topAppBar)
        val bottomNavigation: BottomNavigation.Style by DelegateNullFallBack.Ref(bottomNavigation)
        val dialogCard: Dialog.Card.Style by DelegateNullFallBack.Ref(dialogCard)
        val bottomSheet: BottomSheet.Style by DelegateNullFallBack.Ref(bottomSheet)
        val snackBar: Snackbar.Style by DelegateNullFallBack.Ref(snackBar)
    }

    internal val localCommons: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }


    class Buttons(
        val primary: ButtonImport.StateColor.Style,
        secondary: ButtonImport.StateColor.Style? = null,
        tertiary: ButtonImport.StateColor.Style? = null,
        confirm: ButtonImport.StateColor.Style? = null,
        cancel: ButtonImport.StateColor.Style? = null,
        proceed: ButtonImport.StateColor.Style? = null,
    ) {

        private val delegates = DelegateNullFallBack.Group<ButtonImport.StateColor.Style>()
        val secondary: ButtonImport.StateColor.Style by delegates.ref(secondary)
        val tertiary: ButtonImport.StateColor.Style by delegates.ref(tertiary)
        val confirm: ButtonImport.StateColor.Style by delegates.ref(confirm)
        val cancel: ButtonImport.StateColor.Style by delegates.ref(cancel)
        val proceed: ButtonImport.StateColor.Style by delegates.ref(proceed)

        init {
            delegates.fallBackValue = { primary }
        }
    }

    internal val localButtons: ProvidableCompositionLocal<Buttons> = staticCompositionLocalOf {
        error("not provided")
    }

    class Links(
        val primary: LinkImport.StateColor.Style,
        secondary: LinkImport.StateColor.Style? = null,
        tertiary: LinkImport.StateColor.Style? = null,
    ) {

        private val delegates = DelegateNullFallBack.Group<LinkImport.StateColor.Style>()
        val secondary: LinkImport.StateColor.Style by delegates.ref(secondary)
        val tertiary: LinkImport.StateColor.Style by delegates.ref(tertiary)

        init {
            delegates.fallBackValue = { primary }
        }
    }

    internal val localLinks: ProvidableCompositionLocal<Links> = staticCompositionLocalOf {
        error("not provided")
    }
}