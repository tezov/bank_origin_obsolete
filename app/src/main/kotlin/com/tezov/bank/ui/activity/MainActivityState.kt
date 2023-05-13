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

import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.ActivityState

class MainActivityState private constructor(
    val coreState: com.tezov.lib_core_android_kotlin.ui.activity.ActivityMainState,
) : ActivityState {

    companion object {
        fun create(coreState: com.tezov.lib_core_android_kotlin.ui.activity.ActivityMainState) =
            MainActivityState(coreState)
    }

}