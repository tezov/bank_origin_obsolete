/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 22:29
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 22:28
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.navigation.bottom_navigation

import com.tezov.bank.R
import com.tezov.bank.navigation.NavigationController.Companion.Route
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigationItemData

sealed class BottomNavigationItems(titleResourceId: Int, icon: Int, route: Route):
    BottomNavigationItemData(titleResourceId, icon, route) {
    companion object {
        val items: Set<BottomNavigationItemData> by lazy {
            setOf(
                BottomNavigationItemData(R.string.nav_btm_A, R.drawable.ic_cancel_round_24dp, Route.Account),
                BottomNavigationItemData(R.string.nav_btm_B, R.drawable.ic_cancel_round_24dp, Route.Help),
                BottomNavigationItemData(R.string.nav_btm_C, R.drawable.ic_cancel_round_24dp, Route.Discover),
                BottomNavigationItemData(R.string.nav_btm_D, R.drawable.ic_cancel_round_24dp, Route.Payment),
                BottomNavigationItemData(R.string.nav_btm_E, R.drawable.ic_cancel_round_24dp, Route.Profile),
            )
        }
    }

}