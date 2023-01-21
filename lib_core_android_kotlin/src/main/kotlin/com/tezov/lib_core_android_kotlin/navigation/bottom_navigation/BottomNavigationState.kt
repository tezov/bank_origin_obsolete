package com.tezov.lib_core_android_kotlin.ui.navigation.bottom_navigation

import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubState

class BottomNavigationState private constructor() : ActivitySubState {

    companion object {
        @Composable
        fun create(
        ) = BottomNavigationState()
    }


}