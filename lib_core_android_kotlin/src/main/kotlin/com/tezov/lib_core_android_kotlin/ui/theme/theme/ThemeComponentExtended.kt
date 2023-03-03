/*
 *  *********************************************************************************
 *  Created by Tezov on 03/03/2023 22:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 03/03/2023 22:28
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

val MaterialTheme.componentsExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeComponentExtended.local.current
infix fun MaterialTheme.provides(value: ThemeComponentExtended.Sketch) = ThemeComponentExtended.local provides value

object ThemeComponentExtended {

    @Immutable
    data class Sketch(
        val topAppBar: TopAppBar.Style,
        val bottomNavigation: BottomNavigation.Style,
        val dialogCard: Dialog.Card.Style,
        val bottomSheet: BottomSheet.Style,
        val snackbar: Snackbar.Style,
    )
    internal val local: ProvidableCompositionLocal<Sketch> = staticCompositionLocalOf {
        error("not provided")
    }

}