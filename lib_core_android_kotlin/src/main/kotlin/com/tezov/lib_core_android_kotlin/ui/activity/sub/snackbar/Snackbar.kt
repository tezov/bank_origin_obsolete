/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 17:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 17:15
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShapeStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object Snackbar : ActivitySub<SnackbarState, SnackbarAction> {

    class StyleBuilder internal constructor(style: Style) {
        var outfitTextMessage = style.outfitTextMessage
        var outfitTextAction = style.outfitTextAction
        var outfitShape = style.outfitShape
        var elevation = style.elevation

        internal fun get() = Style(
            outfitTextMessage = outfitTextMessage,
            outfitTextAction = outfitTextAction,
            outfitShape = outfitShape,
            elevation = elevation,
        )
    }

    class Style(
        outfitTextMessage: OutfitTextStateColor? = null,
        outfitTextAction: OutfitTextStateColor? = null,
        outfitShape: OutfitShapeStateColor? = null,
        val elevation: Dp = 2.dp,
    ) {
        val outfitTextMessage: OutfitTextStateColor by DelegateNullFallBack.Ref(
            outfitTextMessage,
            fallBackValue = {
                OutfitTextStateColor()
            })
        val outfitTextAction: OutfitTextStateColor by DelegateNullFallBack.Ref(
            outfitTextAction,
            fallBackValue = {
                OutfitTextStateColor()
            })
        val outfitShape: OutfitShapeStateColor by DelegateNullFallBack.Ref(
            outfitShape,
            fallBackValue = {
                ThemeColorsExtended.Dummy.outfitShapeState
            })

        companion object {

            @Composable
            fun Style.copy(builder: @Composable StyleBuilder.() -> Unit = {}) =
                StyleBuilder(this).also {
                    it.builder()
                }.get()

        }

        constructor(style: Style) : this(
            outfitTextMessage = style.outfitTextMessage,
            outfitTextAction = style.outfitTextAction,
            outfitShape = style.outfitShape,
            elevation = style.elevation,
        )
    }

    //TODO manage selector

    @Composable
    operator fun invoke(modifier: Modifier = Modifier) {
        val accessor = DiAccessorCoreUiActivity().with(LocalActivity.current).contextSubMap()
        val state = accessor.with<Snackbar, _, _>().state()
        SnackbarHost(
            hostState = state.hostState,
            modifier = modifier
        ) { data ->
            val style = MaterialTheme.componentsCommonExtended.snackBar
            Snackbar(
                backgroundColor = style.outfitShape.resolveColor()
                    ?: SnackbarDefaults.backgroundColor,
                elevation = style.elevation,
                shape = style.outfitShape.getShape()
                    ?: MaterialTheme.shapes.small,
                content = {
                    Text.StateColor(
                        text = data.message,
                        style = style.outfitTextMessage,

                        )
                },
                action = {
                    data.actionLabel?.let { label ->
                        Text.Button(
                            onClick = { data.performAction() }) {
                            Text.StateColor(
                                text = label,
                                style = style.outfitTextAction,

                                )
                        }
                    }
                }
            )
        }
    }


}