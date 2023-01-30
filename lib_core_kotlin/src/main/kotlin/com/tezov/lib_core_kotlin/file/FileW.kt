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

package com.tezov.lib_core_kotlin.file

import com.tezov.lib_core_kotlin.buffer.ByteBuffer
import com.tezov.lib_core_kotlin.file.UtilsFile.extension
import com.tezov.lib_core_kotlin.file.UtilsFile.mimeTypeForFullName
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.nio.channels.GatheringByteChannel
import java.nio.channels.ScatteringByteChannel
import java.util.ArrayList
import kotlin.Throws

class FileW : File {
    constructor(pathname: String) : super(pathname)
    constructor(parent: String, child: String) : this(FileW(parent), child)
    constructor(parent: FileW?, child: String) : super(parent, child)

    override fun getParentFile() = super.getParent()?.let { FileW(it) }

    fun createDirectory() = if (!exists()) {
        mkdirs()
    } else {
        true
    }

    val extension: String?
        get() = name.extension()
    val mineType: String?
        get() = name.mimeTypeForFullName()


    @Throws(IOException::class)
    fun write(byteBuffer: ByteBuffer) = write(arrayOf(byteBuffer))

    @Throws(IOException::class)
    fun write(byteBuffers: Array<ByteBuffer>) {
        var output: GatheringByteChannel? = null
        try {
            output = FileOutputStream(this).channel
            byteBuffers.forEach {
                output.write(it.buffer)
            }
            output.close()
        } catch (e: IOException) {
            output?.close()
            throw e
        }
    }

    @Throws(IOException::class)
    fun read(): ByteBuffer? = read(null, true)?.get(0)

    @Throws(IOException::class)
    fun read(byteBuffers: MutableList<ByteBuffer>?, readAll: Boolean): List<ByteBuffer>? {
        var _byteBuffers = byteBuffers
        var input: ScatteringByteChannel? = null
        try {
            input = FileInputStream(this).channel
            if (_byteBuffers == null) {
                if (!readAll) {
                    input.close()
                    return null
                }
                _byteBuffers = ArrayList()
            }
            val bufferLength = _byteBuffers.map { it.remaining }.sum()
            val fileLength = length().toInt()
            if (readAll && fileLength > bufferLength) {
                _byteBuffers.add(ByteBuffer.obtain(fileLength - bufferLength))
            }
            _byteBuffers.forEach {
                input.read(it.buffer)
                it.rewind
            }
            input.close()
        } catch (e: IOException) {
            input?.close()
            throw e
        }
        return _byteBuffers
    }
}