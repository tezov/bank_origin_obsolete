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