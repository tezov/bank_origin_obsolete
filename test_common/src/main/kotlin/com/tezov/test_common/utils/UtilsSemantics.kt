package com.tezov.test_common.utils

import android.util.Log
import androidx.compose.ui.test.SemanticsNodeInteraction

object UtilsSemantics {

    fun SemanticsNodeInteraction.toDebugLog() {
        val config =  this.fetchSemanticsNode().config
        for ((key, value) in config) {
            Log.d(">>:", "$key : ${key.name} = $value")
        }
    }

}