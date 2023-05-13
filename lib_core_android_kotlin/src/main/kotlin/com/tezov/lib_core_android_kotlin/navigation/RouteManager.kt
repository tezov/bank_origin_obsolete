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