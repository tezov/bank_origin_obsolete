package com.tezov.bank.ui.navigation.bottom_navigation

import com.tezov.bank.R
import com.tezov.bank.navigation.NavigationController.Companion.Route
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigationItemData

sealed class BottomNavigationItems(titleResourceId: Int, icon: Int, route: Route):
    BottomNavigationItemData(titleResourceId, icon, route) {
    companion object {
        val items: Set<BottomNavigationItemData> by lazy {
            setOf(

            )
        }
    }

}