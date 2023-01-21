package com.tezov.lib_core_android_kotlin.ui.di.accessor

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.tezov.lib_core_kotlin.type.collection.ListEntry
import java.util.*
import kotlin.reflect.KClass

abstract class AccessorBase<COMPONENT:Any, TYPE_CHILD:Any, COMPONENT_CHILD:Any> {
    private lateinit var component:COMPONENT
    private val componentChildren: ListEntry<KClass<out TYPE_CHILD>, COMPONENT_CHILD> = ListEntry()

    init {
//        Log.d(">>", "construct ${this::class.simpleName}")
    }
    protected fun finalize() {
//        Log.d(">>", "destroy ${this::class.simpleName}")
    }

    @Composable
    private fun createLog():COMPONENT{
//        Log.d(">>", "create ${this::class.simpleName}")
        return create()
    }

    @Composable
    protected abstract fun create():COMPONENT

    @Composable
    protected open fun onCreated(){}

    @Composable
    open fun get(requester: Any):COMPONENT {
//        Log.d(">>", "get ${this::class.qualifiedName}")
        if(!this::component.isInitialized){
            component = createLog()
            onCreated()
        }
        return component
    }

    @Composable
    private fun createChildLog(type: TYPE_CHILD):COMPONENT_CHILD{
//        Log.d(">>", "createChild ${this::class.simpleName}")
        return createChild(type)
    }

    @Composable
    protected abstract fun createChild(type: TYPE_CHILD):COMPONENT_CHILD

    @Composable
    open fun getChild(requester: Any, type: TYPE_CHILD): COMPONENT_CHILD{
//        Log.d(">>", "getChild ${this::class.qualifiedName}")
        return componentChildren.getValue(type::class)?: createChildLog(type).also {
            componentChildren.add(type::class, it)
        }
    }

}