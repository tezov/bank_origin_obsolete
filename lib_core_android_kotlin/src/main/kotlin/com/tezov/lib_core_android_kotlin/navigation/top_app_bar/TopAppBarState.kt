package com.tezov.lib_core_android_kotlin.navigation.top_app_bar

import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubState

class TopAppBarState private constructor() : ActivitySubState {

    companion object {
        @Composable
        fun create() = TopAppBarState()
    }


}