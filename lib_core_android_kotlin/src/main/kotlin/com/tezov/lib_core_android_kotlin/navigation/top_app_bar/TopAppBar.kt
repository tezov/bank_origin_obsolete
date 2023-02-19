/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 03:45
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 03:45
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.navigation.top_app_bar

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.tezov.lib_core_android_kotlin.ui.theme.theme.colorsCommonExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.typographyExtended
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