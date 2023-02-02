/*
 *  *********************************************************************************
 *  Created by Tezov on 02/02/2023 20:23
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/02/2023 18:50
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
                BottomNavigationItemData(R.string.nav_btm_account, R.drawable.ic_home_24dp, Route.Account),
                BottomNavigationItemData(R.string.nav_btm_discover, R.drawable.ic_list_24dp, Route.Discover),
                BottomNavigationItemData(R.string.nav_btm_payment, R.drawable.ic_transfert_24dp, Route.Payment),
                BottomNavigationItemData(R.string.nav_btm_help, R.drawable.ic_help_square24dp, Route.Help),
                BottomNavigationItemData(R.string.nav_btm_profile, R.drawable.ic_profile_24dp, Route.Profile),
            )
        }
    }

}