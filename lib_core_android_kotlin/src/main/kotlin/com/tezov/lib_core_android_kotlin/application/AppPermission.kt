/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:12
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.application

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import com.tezov.lib_core_android_kotlin.ui.activity.ActivityBase
import com.tezov.lib_core_android_kotlin.ui.activity.ActivityBase.RequestForPermission
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.ActivityAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.ActivityState
import com.tezov.lib_core_kotlin.type.collection.ListEntry

object AppPermission {
    fun isGranted(context: Context, permission: String) = ActivityCompat.checkSelfPermission(
            context,
            permission
        ) == PackageManager.PERMISSION_GRANTED

    class Checker(internal val activity: ActivityBase<ActivityState, ActivityAction<ActivityState>>) {
        private val resultPermissions = ListEntry<String, Boolean>()
        private lateinit var requestForPermission:RequestForPermission

        fun add(permission: String) {
            resultPermissions.add(permission, isGranted(activity.applicationContext, permission))
        }
        fun add(permission: List<String>) {
            permission.forEach { add(it) }
        }

        fun check() = RequestForPermission.Response(resultPermissions)
        suspend fun response(): RequestForPermission.Response{
            val response = check()
            return if(response.isAllGranted()){
                response
            } else{
                requestForPermission = RequestForPermission(activity).apply {
                    add(response.denied())
                }
                requestForPermission.response()
            }
        }

    }
}