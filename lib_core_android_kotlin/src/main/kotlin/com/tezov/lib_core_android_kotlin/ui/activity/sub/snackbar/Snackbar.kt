package com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.definition.colorsCommonExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.shapeCommonExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.typographyExtended

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
                backgroundColor = MaterialTheme.colorsCommonExtended.snackbarBackground,
                elevation = 0.dp,
                shape = MaterialTheme.shapeCommonExtended.snackbar,
                content = {
                    Text(
                        text = data.message,
                        style = MaterialTheme.typographyExtended.snackBarMessage,
                        color = MaterialTheme.colorsCommonExtended.snackbarMessage,
                    )
                },
                action = {
                    data.actionLabel?.let { label ->
                        TextButton(
                            onClick = { data.performAction() }) {
                            Text(
                                text = label,
                                style = MaterialTheme.typographyExtended.snackBarAction,
                                color = MaterialTheme.colorsCommonExtended.snackbarAction,
                            )
                        }
                    }
                }
            )
        }
    }


}