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

package com.tezov.test_common.rule

import android.app.Activity
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import org.junit.rules.ExternalResource

class LazyActivityScenarioRule<A : Activity> : ExternalResource {

    companion object {
        inline fun <reified A : Activity> lazyActivityScenarioRule(noinline intentSupplier: () -> Intent): LazyActivityScenarioRule<A> =
            LazyActivityScenarioRule(intentSupplier)

        inline fun <reified A : Activity> lazyActivityScenarioRule(intent: Intent? = null): LazyActivityScenarioRule<A> =
            if (intent == null) {
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

    fun close() {
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

