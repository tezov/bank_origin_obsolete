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
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPagesBundle
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeCoreUiPage
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiDialog
import com.tezov.lib_core_android_kotlin.ui.di.component.DaggerComponentCoreUiDialog_EntryPoint
import javax.inject.Inject

@ScopeCoreUiPage
class DiAccessorCoreUiDialog @Inject protected constructor() :
    DiAccessor<ComponentCoreUiDialog.EntryPoint>() {

    companion object {
        @Composable
        operator fun invoke() =
            DiAccessorCoreUiPage().with(
                requester = this,
                key = LocalPagesBundle.last().current
            ).accessorDialog()

        @Composable
        operator fun invoke(requester: Dialog<*, *>) =
            DiAccessorCoreUiPage().with(
                key = LocalPagesBundle.last().current,
            ).accessorDialog().with(
                key = requester
            )
    }

    @Composable
    override fun create() = DaggerComponentCoreUiDialog_EntryPoint
        .factory()
        .create(
            DiAccessorCoreUiPage().with(
                key = LocalPagesBundle.last().current
            )
        )

}