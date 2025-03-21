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

package com.tezov.lib_core_android_kotlin.ui.compositionTree.activity

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.application.Application
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.ui.activity.ActivityBase
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessor
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action

interface Activity<S : ActivityState, A : ActivityAction<S>> : Composition<S, A>, DiAccessor.Key {

    override val diAccessorKeyId: Int
        get() = Activity.hashCode()

    companion object {
        val LocalLevel: ProvidableCompositionLocal<Int> = staticCompositionLocalOf {
            -1
        }
        val LocalApplication: ProvidableCompositionLocal<Application> = staticCompositionLocalOf {
            error("not provided")
        }
        val LocalActivityBundle: ProvidableCompositionLocal<Bundle> = staticCompositionLocalOf {
            error("not provided")
        }
        val LocalActivity @Composable get() = LocalActivityBundle.current
        val LocalPagesBundle @Composable get() = LocalActivityBundle.current.pages

        data class Bundle(
            val current: Activity<*, *>,
            val size: DpSize = DpSize((-1).dp, (-1).dp)
        ) {
            val pages by lazy { ArrayDeque<Page.Companion.Bundle>() }
        }
    }

    @Composable
    fun invokeContent() {
        val bundle = Bundle(this)
        Layout(
            content = {
                CompositionLocalProvider(
                    LocalLevel provides 0,
                    LocalApplication provides LocalContext.current.applicationContext as Application,
                    LocalActivityBundle provides bundle,
                ) {
                    content()
                }
            }
        ) { measurables, constraints ->
            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }
            bundle.size.apply {
                width = constraints.maxWidth.toDp()
                height = constraints.maxHeight.toDp()
            }
            layout(constraints.maxWidth, constraints.maxHeight) {
                placeables.forEach { placeable ->
                    placeable.placeRelative(x = 0, y = 0)
                }
            }
        }
    }

    @Composable
    fun Activity<S, A>.content()

    @Composable
    fun onBackPressedDispatch(): Boolean {
        if (!this.handleOnBackPressed()) {
            val accessor = DiAccessorCoreUiActivity().with(key = this)
            val mainAction = accessor.contextMain().action()
            if (!mainAction.navigationController.onBackPressedDispatch()) {
                (LocalActivity.current as? ActivityBase)?.finishAffinity()
            }
        }
        return true
    }

    @Composable
    fun handleOnBackPressed() = false
}