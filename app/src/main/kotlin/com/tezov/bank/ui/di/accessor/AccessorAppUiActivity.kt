package com.tezov.bank.ui.di.accessor

import androidx.compose.runtime.Composable
import com.tezov.bank.application.Application
import com.tezov.bank.ui.di.component.ComponentAppUiActivity
import com.tezov.bank.ui.di.component.ComponentAppUiPage
import com.tezov.bank.ui.di.component.DaggerComponentAppUiActivity_EntryPoint
import com.tezov.bank.ui.di.component.DaggerComponentAppUiPage_EntryPoint
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorBase
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiPage
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.wakeUp
import kotlin.reflect.KClass

class AccessorAppUiActivity protected constructor():
    AccessorBase<ComponentAppUiActivity.EntryPoint, KClass<out Page<*, *>>, ComponentAppUiPage.EntryPoint>() {

    companion object{
        @Composable
        operator fun invoke() = (Activity.LocalApplication.current as Application).accessorAppUi

        @Composable
        operator fun invoke(requester:Any) = (Activity.LocalApplication.current as Application).accessorAppUi
    }

    @Composable
    override fun create() =
        DaggerComponentAppUiActivity_EntryPoint.factory().create(AccessorCoreUiActivity().get(this))

    @Composable
    override fun onCreated() {
        getChild(this)
    }

    @Composable
    override fun createChild(type: KClass<out Page<*, *>>) =
        DaggerComponentAppUiPage_EntryPoint.factory().create(AccessorCoreUiPage().get(this), this.get(this))


    @Composable
    override fun getChild(requester:Any, type: KClass<out Page<*, *>>) = throw Exception("use getChild(requester:Any) instead")

    @Composable
    fun getChild(requester:Any) = super.getChild(requester, Page::class)

    @Composable
    fun wakeUp(requester:Activity<*, *>){
        AccessorCoreUiActivity().wakeUp(LocalActivity.current)
        get(LocalActivity.current).contextMain().wakeUp()
    }

}