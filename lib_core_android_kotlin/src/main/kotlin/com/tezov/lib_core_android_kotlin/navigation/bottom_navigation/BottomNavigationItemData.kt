/*
 *  *********************************************************************************
 *  Created by Tezov on 09/02/2023 19:39
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 09/02/2023 19:13
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.navigation.bottom_navigation

import com.tezov.lib_core_android_kotlin.navigation.RouteManager.Route


open class BottomNavigationItemData(
    val titleResourceId: Int,
    val iconActive: Int,
    val iconInactive: Int,
    val route: Route
)