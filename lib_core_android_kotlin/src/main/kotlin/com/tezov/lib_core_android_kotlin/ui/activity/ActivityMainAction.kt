/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.activity

import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.ActivityAction
import kotlinx.coroutines.CoroutineScope

class ActivityMainAction private constructor(
    val coroutineScope: CoroutineScope,
    val navigationController: NavigationController,
) : ActivityAction<ActivityMainState> {

    companion object {
        fun create(
            coroutineScope: CoroutineScope,
            navigationController: NavigationController,
        ) = ActivityMainAction(
            coroutineScope = coroutineScope,
            navigationController = navigationController,
        )
    }



}