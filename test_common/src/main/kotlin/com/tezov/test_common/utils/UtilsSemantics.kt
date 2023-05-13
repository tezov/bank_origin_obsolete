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

package com.tezov.test_common.utils

import android.util.Log
import androidx.compose.ui.test.SemanticsNodeInteraction

object UtilsSemantics {

    fun SemanticsNodeInteraction.toDebugLog() {
        val config = this.fetchSemanticsNode().config
        for ((key, value) in config) {
            Log.d(">>:", "$key : ${key.name} = $value")
        }
    }

}