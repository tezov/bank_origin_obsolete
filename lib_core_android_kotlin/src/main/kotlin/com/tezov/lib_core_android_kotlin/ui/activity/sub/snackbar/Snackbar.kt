/*
 *  *********************************************************************************
 *  Created by Tezov on 02/03/2023 21:57
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/03/2023 21:57
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
import com.tezov.lib_core_android_kotlin.ui.component.plain.Text
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.Simple.Style.Companion.copyToSimpleStyle
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

object Snackbar : ActivitySub<SnackbarState, SnackbarAction> {

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
                backgroundColor = MaterialTheme.shapesSketchExtended.snackbar.color,
                elevation = MaterialTheme.dimensionsElevationExtended.snackbar,
                shape = MaterialTheme.shapesSketchExtended.snackbar.resolveOrDefault(),
                content = {
                    Text.Simple(
                        text = data.message,
                        style = MaterialTheme.typographiesSketchExtended.snackBarMessage,
                    )
                },
                action = {
                    data.actionLabel?.let { label ->


                        TextButton(
                            onClick = { data.performAction() }) {
                            Text.Simple(
                                text = label,
                                style = MaterialTheme.typographiesSketchExtended.snackBarAction,
                            )
                        }


                    }
                }
            )
        }
    }


}