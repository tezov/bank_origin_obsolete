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

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class RepeatRule : TestRule {

    private class RepeatStatement(private val statement: Statement, private val repeat: Int) :
        Statement() {
        @Throws(Throwable::class)
        override fun evaluate() {
            require(repeat >= 1)
            for (i in 1..repeat) {
                statement.evaluate()
            }
        }
    }

    override fun apply(base: Statement, description: Description) = description.getAnnotation(
        RepeatTest::class.java
    )?.let {
        RepeatStatement(base, it.value)
    } ?: let {
        base
    }
}