/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 19:53
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 19:38
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigation
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBar
import com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheet
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
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
        val primary: ButtonImport.StateColor.Style,
        secondary: ButtonImport.StateColor.Style? = null,
        tertiary: ButtonImport.StateColor.Style? = null,
        confirm: ButtonImport.StateColor.Style? = null,
        cancel: ButtonImport.StateColor.Style? = null,
        proceed: ButtonImport.StateColor.Style? = null,
    ) : DelegateNullFallBack.Group<ButtonImport.StateColor.Style> {

        val secondary: ButtonImport.StateColor.Style by DelegateNullFallBack(secondary)
        val tertiary: ButtonImport.StateColor.Style by DelegateNullFallBack(tertiary)
        val confirm: ButtonImport.StateColor.Style by DelegateNullFallBack(confirm)
        val cancel: ButtonImport.StateColor.Style by DelegateNullFallBack(cancel)
        val proceed: ButtonImport.StateColor.Style by DelegateNullFallBack(proceed)

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
        val primary: LinkImport.StateColor.Style,
        secondary: LinkImport.StateColor.Style? = null,
        tertiary: LinkImport.StateColor.Style? = null,
    ) : DelegateNullFallBack.Group<LinkImport.StateColor.Style> {

        val secondary: LinkImport.StateColor.Style by DelegateNullFallBack(secondary)
        val tertiary: LinkImport.StateColor.Style by DelegateNullFallBack(tertiary)

        override fun groupFallBackRefs() = listOf(secondary, tertiary)

        init {
            groupLazyFallBackValue = { primary }
        }
    }

    internal val localLinks: ProvidableCompositionLocal<Links> = staticCompositionLocalOf {
        error("not provided")
    }
}