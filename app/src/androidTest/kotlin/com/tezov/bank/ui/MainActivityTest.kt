/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:51
 *  First project bank / bank.app.androidTest
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.tezov.bank.ui.activity.MainActivity
import com.tezov.test_common.rule.LazyActivityScenarioRule.Companion.lazyActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val rule = lazyActivityScenarioRule<MainActivity>()

    @Test
    fun scenario() {
        fun print(parent: ViewGroup) {
            Log.d(">>:", "parent:" + parent::class.simpleName)
            for (i in 0 until parent.childCount) {
                val child = parent.getChildAt(i)
                if (child is ViewGroup) {
                    print(child)
                } else {
                    Log.d(">>:", "child:" + child::class.simpleName)
                }
            }
        }

        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = Intent(context, MainActivity::class.java)
        rule.launch(intent)
        rule.scenario.moveToState(Lifecycle.State.RESUMED)
        rule.scenario.onActivity { activity ->
            val root = activity.findViewById<ViewGroup>(android.R.id.content)

            Truth.assertThat(root).isNotNull()
            //print(root)
        }
    }


}