/*
 *  *********************************************************************************
 *  Created by Tezov on 10/05/2023 22:21
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 10/05/2023 22:21
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.modifier

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity

fun Modifier.requireFullScreen() = composed {
    val size = Activity.LocalActivityBundle.current.size
    requiredSize(size.width, size.height)
}
