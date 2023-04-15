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

package com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tezov.lib_core_android_kotlin.ui.component.plain.Text
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.Size.Companion.asShapeSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShapeStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.padding
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
                OutfitTextStateColor(
                    outfitState = Color.Black.asStateSimple,
                    typo = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp
                    )
                )
            })
        val outfitTextAction: OutfitTextStateColor by DelegateNullFallBack.Ref(
            outfitTextAction,
            fallBackValue = {
                OutfitTextStateColor(
                    outfitState = Color.Black.asStateSimple,
                    typo = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                )
            })
        val outfitShape: OutfitShapeStateColor by DelegateNullFallBack.Ref(
            outfitShape,
            fallBackValue = {
                OutfitShapeStateColor(
                    outfitState = Color.Gray.copy(alpha = 0.75f).asStateSimple,
                    size = 12.dp.asShapeSize
                )
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

    @Composable
    operator fun invoke() {
        content()
    }

    //todo all selector possible
    @Composable
    private fun content() {
        val accessor = AccessorCoreUiActivity().get(this).contextSubMap()
        val state = accessor.with<Snackbar, _, _>().state()

        SnackbarHost(
            hostState = state.hostState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.dimensionsPaddingExtended.block.small)
        ) { data ->
            Snackbar(
                backgroundColor = MaterialTheme.componentsCommonExtended.snackBar.outfitShape.resolveColor()
                    ?: SnackbarDefaults.backgroundColor,
                elevation = MaterialTheme.componentsCommonExtended.snackBar.elevation,
                shape = MaterialTheme.componentsCommonExtended.snackBar.outfitShape.getShape()
                    ?: MaterialTheme.shapes.small,
                content = {
                    Text.StateColor(
                        text = data.message,
                        style = MaterialTheme.componentsCommonExtended.snackBar.outfitTextMessage
                    )
                },
                action = {
                    data.actionLabel?.let { label ->
                        TextButton(
                            onClick = { data.performAction() }) {
                            Text.StateColor(
                                text = label,
                                style = MaterialTheme.componentsCommonExtended.snackBar.outfitTextAction
                            )
                        }
                    }
                }
            )
        }
    }


}