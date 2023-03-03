/*
 *  *********************************************************************************
 *  Created by Tezov on 03/03/2023 22:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 03/03/2023 22:28
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.component.plain.Text
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShapeSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextSimple
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

object Snackbar : ActivitySub<SnackbarState, SnackbarAction> {

    open class Style(
        val outfitTextMessage: OutfitTextSimple = OutfitTextSimple(),
        val outfitTextAction: OutfitTextSimple = OutfitTextSimple(),
        val outfitShape: OutfitShapeSimple = OutfitShapeSimple(),
        val elevation: Dp = 0.dp,
    ){
        companion object{

            open class Builder internal constructor(style: Style) {
                var outfitShape = style.outfitShape
                var elevation = style.elevation

                internal fun get() = Style(
                    elevation = elevation,
                    outfitShape = outfitShape,
                )
            }

            @Composable
            fun Style.copy(builder: @Composable Builder.()->Unit = {}) = Builder(this).also {
                it.builder()
            }.get()

        }

        constructor(style: Style) : this(
            outfitShape = style.outfitShape,
            elevation = style.elevation,
        )
    }

    @Composable
    operator fun invoke() {
        content()
    }

    @Composable
    private fun content() {
        val accessor = AccessorCoreUiActivity().get(this).contextSubMap()
        val state = accessor.with<Snackbar,_,_>().state()

        SnackbarHost(
            hostState = state.hostState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = MaterialTheme.dimensionsPaddingExtended.blockSmall_h,
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockSmall_v
                )
        ) { data ->
            Snackbar(
                backgroundColor = MaterialTheme.componentsExtended.snackbar.outfitShape.color,
                elevation = MaterialTheme.componentsExtended.snackbar.elevation,
                shape = MaterialTheme.componentsExtended.snackbar.outfitShape.resolveOrDefault(),
                content = {
                    Text.Simple(
                        text = data.message,
                        style = MaterialTheme.componentsExtended.snackbar.outfitTextMessage,
                    )
                },
                action = {
                    data.actionLabel?.let { label ->
                        TextButton(
                            onClick = { data.performAction() }) {
                            Text.Simple(
                                text = label,
                                style = MaterialTheme.componentsExtended.snackbar.outfitTextAction,
                            )
                        }
                    }
                }
            )
        }
    }


}