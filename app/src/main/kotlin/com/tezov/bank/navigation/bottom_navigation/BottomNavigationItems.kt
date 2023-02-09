/*
 *  *********************************************************************************
 *  Created by Tezov on 09/02/2023 19:39
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 09/02/2023 19:39
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.navigation.bottom_navigation

import com.tezov.bank.R
import com.tezov.bank.navigation.NavigationController.Companion.Route
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigationItemData

sealed class BottomNavigationItems(titleResourceId: Int, iconActive: Int, iconInactive: Int, route: Route) :
    BottomNavigationItemData(titleResourceId, iconActive, iconInactive, route) {
    companion object {
        val items: Set<BottomNavigationItemData> by lazy {
            setOf(
                BottomNavigationItemData(
                    R.string.nav_btm_account,
                    R.drawable.ic_home_24dp,
                    R.drawable.ic_home_line_24dp,
                    Route.Account
                ),
                BottomNavigationItemData(
                    R.string.nav_btm_discover,
                    R.drawable.ic_list_square_24dp,
                    R.drawable.ic_list_24dp,
                    Route.Discover
                ),
                BottomNavigationItemData(
                    R.string.nav_btm_payment,
                    R.drawable.ic_transfert_24dp,
                    R.drawable.ic_transfert_round_24dp,
                    Route.Payment
                ),
                BottomNavigationItemData(
                    R.string.nav_btm_help,
                    R.drawable.ic_help_square_24dp,
                    R.drawable.ic_help_square_line_24dp,
                    Route.Help
                ),
                BottomNavigationItemData(
                    R.string.nav_btm_profile,
                    R.drawable.ic_profile_24dp,
                    R.drawable.ic_profile_line_24dp,
                    Route.Profile
                ),
            )
        }
    }

}