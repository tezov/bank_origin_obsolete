package com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog

import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPages
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalModals
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalPage
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.definition.colorsCommonExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsElevationExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.shapeBorderExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.shapeCommonExtended

@OptIn(ExperimentalComposeUiApi::class)
object Dialog : ActivitySub<DialogState, DialogAction> {

    @Composable
    operator fun invoke() {
        content()
    }

    @Composable
    fun content() {
        val accessor = AccessorCoreUiActivity().get(this).contextSubMap()
        val state = accessor.with<Dialog, _, _>().state()
        if (state.isVisible()) {
            Dialog(
                onDismissRequest = { state.show(false) },
                properties = DialogProperties(
                    usePlatformDefaultWidth = false
                )
            ) {
                val locals = LocalPages.current.last()
                CompositionLocalProvider(
                    Activity.DebugLocalLevel provides 1,
                    LocalPage provides locals.page,
                    LocalModals provides locals.modals
                ) {
                    state.dialogContent()
                }
            }
        }
    }

    @Composable
    fun Card(content: @Composable () -> Unit) {
        Card(
            shape = MaterialTheme.shapeCommonExtended.dialog,
            elevation = MaterialTheme.dimensionsElevationExtended.elevationNormal,
            border = MaterialTheme.shapeBorderExtended.dialog
        ) {
            Surface(color = MaterialTheme.colorsCommonExtended.backgroundModal) {
                val locals = LocalPages.current.last()
                CompositionLocalProvider(
                    Activity.DebugLocalLevel provides 1,
                    LocalPage provides locals.page,
                    LocalModals provides locals.modals
                ) {
                    content()
                }
            }
        }
    }


}