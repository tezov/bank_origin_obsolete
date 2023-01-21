package com.tezov.lib_core_android_kotlin.navigation.top_app_bar

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.tezov.lib_core_android_kotlin.ui.theme.definition.colorsCommonExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.typographyExtended
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySub
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.with

object TopAppBar: ActivitySub<TopAppBarState, TopAppBarAction> {

    @Composable
    operator fun invoke(
        titleResourceId: Int,
        leadingItem: TopAppBarItemData? = null,
        trailingItem: TopAppBarItemData? = null
    ) {
        content(titleResourceId, leadingItem, trailingItem)
    }

    @Composable
    private fun content(
        titleResourceId: Int,
        leadingItem: TopAppBarItemData? = null,
        trailingItem: TopAppBarItemData? = null
    ) {
        val accessor = AccessorCoreUiActivity().get(this).contextSubMap()
        val action = accessor.with<TopAppBar,_,_>().action()

        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = titleResourceId),
                    style = MaterialTheme.typographyExtended.topNavigationTitle,
                    color = MaterialTheme.colorsCommonExtended.topAppBarContentText,
                )
            },
            backgroundColor = MaterialTheme.colorsCommonExtended.topAppBarBackground,
            navigationIcon = {
                leadingItem?.let {
                    IconButton(onClick = {
                        action.onClickIconButton(it.route)
                    }) {
                        Icon(
                            painterResource(id = it.icon),
                            null,
                            tint = MaterialTheme.colorsCommonExtended.topAppBarContentIcon
                        )
                    }
                }
            },
            actions = {
                trailingItem?.let {
                    IconButton(onClick = {
                        action.onClickIconButton(it.route)

                    }) {
                        Icon(
                            painterResource(id = it.icon),
                            null,
                            tint = MaterialTheme.colorsCommonExtended.topAppBarContentIcon
                        )
                    }
                }
            }
        )
    }

}