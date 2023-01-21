package com.tezov.bank.ui.di.accessor

import androidx.compose.runtime.Composable
import com.tezov.bank.ui.di.component.ComponentAppUiDialog
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorBase
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiPage
import javax.inject.Inject

@ScopeAppUiPage
class AccessorAppUiDialog @Inject protected constructor():
    AccessorBase<ComponentAppUiDialog.EntryPoint, Nothing, Nothing>() {

    companion object{
        @Composable
        operator fun invoke() = AccessorAppUiPage().get(this).accessorDialog()

        @Composable
        operator fun invoke(requester:Any) = AccessorAppUiPage().get(requester).accessorDialog()
    }

    @Composable
    override fun create() = AccessorAppUiPage().getChild(this)

    @Composable
    override fun createChild(type: Nothing) = throw Exception("can't have child")

}