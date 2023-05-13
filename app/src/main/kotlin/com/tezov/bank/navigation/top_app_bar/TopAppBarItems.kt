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

package com.tezov.bank.ui.navigation.top_app_bar

import com.tezov.bank.R
import com.tezov.lib_core_android_kotlin.navigation.RouteManager
import com.tezov.lib_core_android_kotlin.navigation.RouteManager.Route
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBarItemData

sealed class TopAppBarItems(icon: Int, route: Route) : TopAppBarItemData(icon, route) {
    companion object {
        val items: Set<TopAppBarItemData> by lazy {
            setOf(
                Back,
            )
        }
    }

    object Back : TopAppBarItemData(R.drawable.ic_arrow_left_24dp, RouteManager.Back)


}