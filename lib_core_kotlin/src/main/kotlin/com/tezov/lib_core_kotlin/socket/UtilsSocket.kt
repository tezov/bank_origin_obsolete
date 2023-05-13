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

package com.tezov.lib_core_kotlin.socket

import com.tezov.lib_core_java.type.unit.UnitByte
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