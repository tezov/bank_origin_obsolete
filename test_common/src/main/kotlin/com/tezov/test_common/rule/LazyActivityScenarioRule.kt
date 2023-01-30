/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.test_common.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.test_common.rule

import android.app.Activity
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import org.junit.rules.ExternalResource

class LazyActivityScenarioRule<A : Activity> : ExternalResource {

    companion object{
        inline fun <reified A : Activity> lazyActivityScenarioRule(noinline intentSupplier: () -> Intent): LazyActivityScenarioRule<A> =
            LazyActivityScenarioRule(intentSupplier)

        inline fun <reified A : Activity> lazyActivityScenarioRule(intent: Intent? = null): LazyActivityScenarioRule<A> = if (intent == null) {
            LazyActivityScenarioRule(A::class.java)
        } else {
            LazyActivityScenarioRule(intent)
        }
    }

    constructor(startActivityIntentSupplier: () -> Intent) {
        scenarioSupplier = { ActivityScenario.launch(startActivityIntentSupplier()) }
    }

    constructor(startActivityIntent: Intent) {
        scenarioSupplier = { ActivityScenario.launch(startActivityIntent) }
    }

    constructor(startActivityClass: Class<A>) {
        scenarioSupplier = { ActivityScenario.launch(startActivityClass) }
    }

    private var scenarioSupplier: () -> ActivityScenario<A>

    private var _scenario: ActivityScenario<A>? = null

    private var scenarioLaunched: Boolean = false

    fun close(){
        _scenario?.close()
        _scenario = null
        scenarioLaunched = false
    }

    fun launch(newIntent: Intent? = null) {
        if (scenarioLaunched) throw IllegalStateException("Scenario has already been launched!")
        newIntent?.let { scenarioSupplier = { ActivityScenario.launch(it) } }
        _scenario = scenarioSupplier()
        scenarioLaunched = true
    }

    val scenario get() = checkNotNull(_scenario)
}

