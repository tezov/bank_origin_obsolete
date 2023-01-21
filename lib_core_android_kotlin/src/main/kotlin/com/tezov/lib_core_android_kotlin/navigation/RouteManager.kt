package com.tezov.lib_core_android_kotlin.navigation


class RouteManager {

    abstract class Route(val value:String)

    object Back: Route("back")
    object NotImplemented: Route("not_implemented")

    private val _items = mutableSetOf(
        Back,
        NotImplemented,
    )
    val items get():Set<Route> = _items

    fun add(route:Route) = _items.add(route)
    fun add(routes:Collection<Route>) = _items.addAll(routes)
    fun find(route:String?) = _items.find { it.value == route }
}