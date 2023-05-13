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
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiPage
import com.tezov.lib_core_android_kotlin.ui.di.component.DaggerComponentCoreUiPage_EntryPoint
import javax.inject.Inject

@ScopeCoreUiActivity
class DiAccessorCoreUiPage @Inject protected constructor() :
    DiAccessor<ComponentCoreUiPage.EntryPoint>() {

    companion object {
        @Composable
        operator fun invoke() =
            DiAccessorCoreUiActivity().with(
                requester = this,
                key = LocalActivity.current
            ).accessorPage()

        @Composable
        operator fun invoke(requester: Page<*, *>) =
            DiAccessorCoreUiActivity().with(
                key = LocalActivity.current
            ).accessorPage().with(
                key = requester
            )
    }

    @Composable
    override fun create() = DaggerComponentCoreUiPage_EntryPoint
        .factory()
        .create(
            DiAccessorCoreUiActivity().with(
                key = LocalActivity.current
            )
        )

}