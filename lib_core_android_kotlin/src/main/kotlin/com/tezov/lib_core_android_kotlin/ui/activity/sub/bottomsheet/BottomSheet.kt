package com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPages
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalModals
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalPage
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.definition.colorsResource
import com.tezov.lib_core_android_kotlin.ui.theme.definition.shapeCommonExtended

object BottomSheet : ActivitySub<BottomSheetState, BottomSheetAction> {

    @Composable
    operator fun invoke(content: @Composable () -> Unit) {
        content(content)
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    private fun content(content: @Composable () -> Unit) {
        val accessor = AccessorCoreUiActivity().get(this).contextSubMap()
        val state = accessor.with<BottomSheet,_,_>().state()

        ModalBottomSheetLayout(
            sheetContentColor = MaterialTheme.colorsResource.transparent,
            sheetBackgroundColor = MaterialTheme.colorsResource.transparent,
            sheetState = state.bottomSheetState,
            sheetShape = RectangleShape,
            sheetElevation = 0.dp,
            sheetContent = {
                Card(
                    modifier = Modifier.padding(start = 1.dp, end = 1.dp),
                    shape = MaterialTheme.shapeCommonExtended.bottomSheet,
                    elevation = ModalBottomSheetDefaults.Elevation
                ) {
                    val locals = LocalPages.current.last()
                    CompositionLocalProvider(
                        Activity.DebugLocalLevel provides 1,
                        LocalPage provides locals.page,
                        LocalModals provides locals.modals
                    ) {
                        state.sheetContent()
                    }
                }
            },
            content = content
        )
    }


}