/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

package com.tezov.bank.navigation.bottom_navigation

import com.tezov.bank.R
import com.tezov.bank.navigation.NavigationController
import com.tezov.bank.navigation.NavigationController.*
import com.tezov.lib_core_android_kotlin.navigation.RouteManager
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigationItemData

sealed class BottomNavigationItems(
    titleResourceId: Int,
    iconActive: Int,
    iconInactive: Int,
    route: RouteManager.Route
) :
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