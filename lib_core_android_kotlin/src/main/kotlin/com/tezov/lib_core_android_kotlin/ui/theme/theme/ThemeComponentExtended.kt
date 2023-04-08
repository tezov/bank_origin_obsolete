/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 14:32
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 13:44
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

}