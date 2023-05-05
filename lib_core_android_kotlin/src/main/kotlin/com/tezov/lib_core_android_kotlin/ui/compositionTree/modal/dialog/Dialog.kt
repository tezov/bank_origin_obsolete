/*
 *  *********************************************************************************
 *  Created by Tezov on 05/05/2023 20:30
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/05/2023 20:14
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog

import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.Modal
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.Modal.Companion.LocalModal
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalModalsBundle

interface Dialog<S : DialogState, A : DialogAction<S>> : Modal<S, A> {
    companion object {
        val LocalDialog @Composable get() = LocalModal.current as Dialog<*,*>
    }

    @Composable
    override fun Modal<S, A>.content() {
        (this as Dialog<S, A>).content()
    }

    @Composable
    fun Dialog<S, A>.content()

}