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

package com.tezov.lib_core_android_kotlin.ui.di.accessor

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalApplication
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.component.DaggerComponentCoreUiActivity_EntryPoint
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.wakeUp
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.wakeUpSub

class DiAccessorCoreUiActivity protected constructor() :
    DiAccessor<ComponentCoreUiActivity.EntryPoint>() {

    companion object {
        @Composable
        operator fun invoke() = (LocalApplication.current).accessorCoreUi

        @Composable
        operator fun invoke(requester: Activity<*, *>) = (LocalApplication.current).accessorCoreUi
    }

    @Composable
    override fun create() = DaggerComponentCoreUiActivity_EntryPoint.factory().create()

    @Composable
    fun wakeUp(requester: Activity<*, *>) {
        with(requester).apply {
            exposeCoreCoroutineScope().get()
            exposeCoreScaffoldState().get()
            exposeCoreNavigationController().get()
            contextSubMap().wakeUpSub()
            contextMain().wakeUp()
        }
    }

}