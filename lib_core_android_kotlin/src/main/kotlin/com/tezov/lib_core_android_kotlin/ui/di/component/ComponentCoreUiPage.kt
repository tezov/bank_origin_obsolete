/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.di.component

import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiDialog
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeCoreUiPage
import dagger.Component


object ComponentCoreUiPage {

    @ScopeCoreUiPage
    @Component(
        dependencies = [ComponentCoreUiActivity.EntryPoint::class],
        modules = []
    )
    interface EntryPoint {

        @Component.Factory
        interface Factory {
            fun create(componentCoreActivity: ComponentCoreUiActivity.EntryPoint): EntryPoint
        }

        fun accessorDialog(): AccessorCoreUiDialog

    }

}

