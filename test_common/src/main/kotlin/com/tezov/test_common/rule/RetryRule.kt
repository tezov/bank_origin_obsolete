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

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class RetryRule : TestRule {

    private class RepeatStatement(private val statement: Statement, private val repeat: Int) : Statement() {
        @Throws(Throwable::class)
        override fun evaluate() {
            require(repeat>=1)
            for (i in 1..repeat) {
                try {
                    statement.evaluate()
                    return
                }
                catch (e: Throwable){
                    if(i >= repeat){
                        throw e
                    }
                }
            }
        }
    }

    override fun apply(base: Statement, description: Description) = description.getAnnotation(
        RetryTest::class.java)?.let {
        RepeatStatement(base, it.value)
    }?:let {
        base
    }
}