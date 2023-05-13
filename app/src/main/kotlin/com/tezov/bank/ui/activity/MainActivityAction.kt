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

package com.tezov.bank.ui.activity

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.tezov.bank.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.ActivityAction

class MainActivityAction private constructor(
    val coreAction: com.tezov.lib_core_android_kotlin.ui.activity.ActivityMainAction,
    val navigationController: NavigationController,
) : ActivityAction<MainActivityState> {

    companion object {
        @Composable
        fun create(
            coreAction: com.tezov.lib_core_android_kotlin.ui.activity.ActivityMainAction,
        ): MainActivityAction {
            val executionState = remember {
                mutableStateOf(0)
            }
            return MainActivityAction(
                coreAction = coreAction,
                navigationController = NavigationController(coreAction.navigationController),
            )
        }
    }

}