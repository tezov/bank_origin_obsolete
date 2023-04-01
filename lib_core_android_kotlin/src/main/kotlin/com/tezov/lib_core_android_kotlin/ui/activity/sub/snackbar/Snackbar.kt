/*
 *  *********************************************************************************
 *  Created by Tezov on 01/04/2023 21:02
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/04/2023 20:46
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
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

object Snackbar : ActivitySub<SnackbarState, SnackbarAction> {

    class Style(
        val outfitTextMessage: OutfitText.StateColor = OutfitText.StateColor(),
        val outfitTextAction: OutfitText.StateColor = OutfitText.StateColor(),
        val outfitShape: OutfitShape.StateColor = OutfitShape.StateColor(),
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

    //todo all selector possible
    @Composable
    private fun content() {
        val accessor = AccessorCoreUiActivity().get(this).contextSubMap()
        val state = accessor.with<Snackbar,_,_>().state()

        SnackbarHost(
            hostState = state.hostState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = MaterialTheme.dimensionsPaddingExtended.block.horizontal.small,
                    vertical = MaterialTheme.dimensionsPaddingExtended.block.vertical.small
                )
        ) { data ->
            Snackbar(
                backgroundColor = MaterialTheme.componentsCommonExtended.snackBar.outfitShape.resolveColor() ?: SnackbarDefaults.backgroundColor,
                elevation = MaterialTheme.componentsCommonExtended.snackBar.elevation,
                shape = MaterialTheme.componentsCommonExtended.bottomSheet.outfitShape.getShape() ?: MaterialTheme.shapes.small,
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