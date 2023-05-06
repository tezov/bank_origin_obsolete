/*
 *  *********************************************************************************
 *  Created by Tezov on 06/05/2023 22:22
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/05/2023 21:59
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.navigation


class RouteManager {

    abstract class Route(val value: String, parent:Route ?= null ){
        var parent:Route ?= parent
            internal set
    }
    abstract class Routes(value: String, val child:Set<Route>):Route(value){
        init {
            child.forEach { it.parent = this }
        }
    }

    object Back : Route("back")
    object NotImplemented : Route("not_implemented")

    private val _routes:MutableSet<Route> = mutableSetOf(
        Back,
        NotImplemented,
    )
    val routes get():Set<Route> = _routes

    fun add(route: Route) = _routes.add(route)
    fun add(routes: Collection<Route>) = _routes.addAll(routes)

    fun find(route: String?) = find(route, _routes)

    private fun find(route: String?, routes:Set<Route>):Route? {
        val iterator = routes.iterator()
        while (iterator.hasNext()){
            val next = iterator.next()
            if(route == next.value){
                return next
            }
            if(next is Routes){
                find(route, next.child)?.let {
                    return it
                }
            }
        }
        return null

    }
}