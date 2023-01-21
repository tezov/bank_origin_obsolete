package com.tezov.lib_core_android_kotlin.ui.di.accessor

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiDialog
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeCoreUiPage
import javax.inject.Inject

@ScopeCoreUiPage
class AccessorCoreUiDialog @Inject protected constructor() :
    AccessorBase<ComponentCoreUiDialog.EntryPoint, Nothing, Nothing>() {

    companion object {
        @Composable
        operator fun invoke() = AccessorCoreUiPage().get(this).accessorDialog()
        @Composable
        operator fun invoke(requester: Any) = AccessorCoreUiPage().get(requester).accessorDialog()
    }

    @Composable
    override fun create() = AccessorCoreUiPage().getChild(this)

    @Composable
    override fun createChild(type: Nothing) = throw Exception("can't have child")
}