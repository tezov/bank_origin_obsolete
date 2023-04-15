/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:51
 *  First project bank / bank.test_common.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
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