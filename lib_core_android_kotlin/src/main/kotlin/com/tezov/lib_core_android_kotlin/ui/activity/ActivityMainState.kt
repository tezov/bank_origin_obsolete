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

package com.tezov.lib_core_android_kotlin.ui.activity

import androidx.compose.material.ScaffoldState
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.ActivityState

class ActivityMainState private constructor(
    val scaffoldState: ScaffoldState,
) : ActivityState {

    companion object {
        fun create(scaffoldState: ScaffoldState) = ActivityMainState(scaffoldState)
    }

}