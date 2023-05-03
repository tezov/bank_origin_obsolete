/*
 *  *********************************************************************************
 *  Created by Tezov on 03/05/2023 21:39
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 03/05/2023 20:01
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.navigation.bottom_navigation

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubState

class BottomNavigationState private constructor() : ActivitySubState {

    companion object {
        @Composable
        fun create(
        ) = BottomNavigationState()
    }


}