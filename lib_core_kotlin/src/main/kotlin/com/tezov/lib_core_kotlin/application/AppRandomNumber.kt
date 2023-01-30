/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.lib_core_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.application

import com.tezov.lib_core_kotlin.cipher.SecureProvider.randomGenerator
import com.tezov.lib_core_kotlin.application.AppRandomNumber
import com.tezov.lib_core_kotlin.cipher.SecureProvider
import java.security.SecureRandom
import kotlin.properties.Delegates

object AppRandomNumber {
    private var rand by Delegates.notNull<SecureRandom>()

    init {
        try {
            rand = randomGenerator()
        } catch (e: Throwable) {
        }
    }

    @Synchronized
    fun nextLong(): Long {
        return rand.nextLong()
    }

    @Synchronized
    fun nextLong(bound: Long): Long {
        require(bound > 0) { "bound must be positive" }
        if ((bound and -bound) == bound) {
            return (bound * rand.nextLong() shr 63).toInt().toLong()
        }
        var bits: Long
        var `val`: Long
        do {
            bits = rand.nextLong() shl 1 ushr 1
            `val` = bits % bound
        } while (bits - `val` + (bound - 1) < 0L)
        return `val`
    }

    @Synchronized
    fun nextLong(min: Long, max: Long): Long {
        val bound = max - min
        require(!(max <= 0 || bound < 0)) { "max must positive and diff must be positive" }
        return nextLong(bound) + min
    }

    @Synchronized
    fun nextInt(): Int {
        return rand.nextInt()
    }

    @Synchronized
    fun nextInt(bound: Int): Int {
        require(bound > 0) { "bound must be positive" }
        return rand.nextInt(bound)
    }

    @Synchronized
    fun nextInt(min: Int, max: Int): Int {
        val bound = max - min
        require(!(max <= 0 || bound < 0)) { "max must positive and diff must be positive" }
        return rand.nextInt(bound) + min
    }

    @Synchronized
    fun nextFlip(dividend: Int): Boolean {
        return nextInt(dividend) == 0
    }

    @Synchronized
    fun nextFlip(): Boolean {
        return nextInt(2) == 0
    }


}