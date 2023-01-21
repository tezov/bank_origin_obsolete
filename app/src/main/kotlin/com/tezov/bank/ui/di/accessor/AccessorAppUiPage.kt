package com.tezov.bank.ui.di.accessor

import androidx.compose.runtime.Composable
import com.tezov.bank.ui.di.component.ComponentAppUiDialog
import com.tezov.bank.ui.di.component.ComponentAppUiPage
import com.tezov.bank.ui.di.component.DaggerComponentAppUiDialog_EntryPoint
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorBase
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiDialog
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiActivity
import javax.inject.Inject
import kotlin.reflect.KClass

@ScopeAppUiActivity
class AccessorAppUiPage @Inject protected constructor() :
    AccessorBase<ComponentAppUiPage.EntryPoint, KClass<out Dialog<*, *>>, ComponentAppUiDialog.EntryPoint>() {

    companion object{
        @Composable
        operator fun invoke() = AccessorAppUiActivity().get(this).accessorPage()

        @Composable
        operator fun invoke(requester:Any) = AccessorAppUiActivity().get(requester).accessorPage()
    }

    @Composable
    override fun create() = AccessorAppUiActivity().getChild(this)

    @Composable
    override fun onCreated() {
        getChild(this)
    }

    @Composable
    override fun createChild(type: KClass<out Dialog<*, *>>) =
        DaggerComponentAppUiDialog_EntryPoint.factory().create(AccessorCoreUiDialog().get(this), this.get(this))

    @Composable
    override fun getChild(requester:Any, type: KClass<out Dialog<*, *>>) = throw Exception("use getChild(requester:Any) instead")

    @Composable
    fun getChild(requester:Any) = super.getChild(requester, Dialog::class)

}