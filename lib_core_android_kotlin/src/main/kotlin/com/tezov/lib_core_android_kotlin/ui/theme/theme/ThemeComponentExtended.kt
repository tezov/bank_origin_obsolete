/*
 *  *********************************************************************************
 *  Created by Tezov on 05/04/2023 23:47
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/04/2023 23:47
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigation
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBar
import com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheet
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar
import com.tezov.lib_core_android_kotlin.ui.component.plain.ButtonStateColor
import com.tezov.lib_core_android_kotlin.ui.component.plain.LinkStateColor
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
        val topAppBar: TopAppBar.Style by DelegateNullFallBack(topAppBar)
        val bottomNavigation: BottomNavigation.Style by DelegateNullFallBack(bottomNavigation)
        val dialogCard: Dialog.Card.Style by DelegateNullFallBack(dialogCard)
        val bottomSheet: BottomSheet.Style by DelegateNullFallBack(bottomSheet)
        val snackBar: Snackbar.Style by DelegateNullFallBack(snackBar)
    }

    internal val localCommons: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

    class Buttons(
        val primary: ButtonStateColor,
        secondary: ButtonStateColor? = null,
        tertiary: ButtonStateColor? = null,
        confirm: ButtonStateColor? = null,
        cancel: ButtonStateColor? = null,
        proceed: ButtonStateColor? = null,
    ) : DelegateNullFallBack.Group<ButtonStateColor> {

        val secondary: ButtonStateColor by DelegateNullFallBack(secondary)
        val tertiary: ButtonStateColor by DelegateNullFallBack(tertiary)
        val confirm: ButtonStateColor by DelegateNullFallBack(confirm)
        val cancel: ButtonStateColor by DelegateNullFallBack(cancel)
        val proceed: ButtonStateColor by DelegateNullFallBack(proceed)

        override fun groupFallBackRefs() =
            listOf(primary, secondary, tertiary, confirm, cancel, proceed)

        init {
            groupLazyFallBackValue = { primary }
        }
    }

    internal val localButtons: ProvidableCompositionLocal<Buttons> = staticCompositionLocalOf {
        error("not provided")
    }

    class Links(
        val primary: LinkStateColor,
        secondary: LinkStateColor? = null,
        tertiary: LinkStateColor? = null,
    ) : DelegateNullFallBack.Group<LinkStateColor> {

        val secondary: LinkStateColor by DelegateNullFallBack(secondary)
        val tertiary: LinkStateColor by DelegateNullFallBack(tertiary)

        override fun groupFallBackRefs() = listOf(secondary, tertiary)

        init {
            groupLazyFallBackValue = { primary }
        }
    }

    internal val localLinks: ProvidableCompositionLocal<Links> = staticCompositionLocalOf {
        error("not provided")
    }

}