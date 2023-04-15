/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:52
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.navigation


class RouteManager {

    abstract class Route(val value: String)

    object Back : Route("back")
    object NotImplemented : Route("not_implemented")

    private val _items = mutableSetOf(
        Back,
        NotImplemented,
    )
    val items get():Set<Route> = _items

    fun add(route: Route) = _items.add(route)
    fun add(routes: Collection<Route>) = _items.addAll(routes)
    fun find(route: String?) = _items.find { it.value == route }
}