package com.tezov.bank.ui.activity

import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.ActivityState

class MainActivityState private constructor(
    val coreState: com.tezov.lib_core_android_kotlin.ui.activity.ActivityMainState,
) : ActivityState {

    companion object {
        fun create(coreState: com.tezov.lib_core_android_kotlin.ui.activity.ActivityMainState) = MainActivityState(coreState)
    }

}