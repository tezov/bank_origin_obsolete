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

package com.tezov.lib_core_kotlin.socket

import com.tezov.lib_core_java.type.unit.UnitByte
import kotlin.Throws
import com.tezov.lib_core_kotlin.util.UtilsBytes
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

object UtilsSocket {
    val DEFAULT_BUFFER_SIZE = UnitByte.o.convert(20, UnitByte.Mo).toInt()

    //public static int randomPortDynamic(){
    //todo
    //    return AppRandomNumber.nextInt(ValidatorPortDynamic.MIN, ValidatorPortDynamic.MAX);
    //}
    //public static int randomPortUser(){
    //    return AppRandomNumber.nextInt(ValidatorPortUser.MIN, ValidatorPortUser.MAX);
    //}
    //public static InetAddress randomMulticastAddress(){
    //    try{
    //        return InetAddress.getByName(AppRandomNumber.nextInt(224, 239) + "." + AppRandomNumber.nextInt(0, 255) + "." + AppRandomNumber.nextInt(0, 255) + "." + AppRandomNumber.nextInt(0, 255));
    //    } catch(Throwable e){
    //
    //        return null;
    //    }
    //}

    @Throws(IOException::class)
    fun receive(
        source: InputStream,
        destination: OutputStream,
        available: Int,
        bufferSize: Int = DEFAULT_BUFFER_SIZE
    ) {
        var _available = available
        var length: Int
        val buffer: ByteArray = UtilsBytes.obtain(bufferSize).asByteArray()
        while (source.read(buffer, 0, Math.min(_available, bufferSize)).also { length = it } > 0) {
            destination.write(buffer, 0, length)
            _available -= length
        }
        destination.flush()
        if (_available != 0) {
            throw IOException("Did not receive all bytes")
        }
    }
}