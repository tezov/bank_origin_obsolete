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