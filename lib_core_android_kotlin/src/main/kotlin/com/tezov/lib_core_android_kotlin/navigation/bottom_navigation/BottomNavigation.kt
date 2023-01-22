package com.tezov.lib_core_android_kotlin.navigation.bottom_navigation

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
import com.tezov.lib_core_android_kotlin.ui.navigation.bottom_navigation.BottomNavigationState

object BottomNavigation:
    ActivitySub<BottomNavigationState, BottomNavigationAction> {

    @Composable
    operator fun invoke(items:Set<BottomNavigationItemData>) {
        content(items)
    }

    @Composable
    private fun content(items:Set<BottomNavigationItemData>) {
        val accessor = AccessorCoreUiActivity().get(this).contextSubMap()
        val action = accessor.with<BottomNavigation,_,_>().action()

        BottomNavigation(
            backgroundColor = MaterialTheme.colorsCommonExtended.bottomNavigationBackground,
        ) {
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = stringResource(id = item.titleResourceId)
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(id = item.titleResourceId),
                            style = MaterialTheme.typographyExtended.bottomNavigationLabel,
                        )
                    },
                    selectedContentColor = MaterialTheme.colorsCommonExtended.bottomNavigationActive,
                    unselectedContentColor = MaterialTheme.colorsCommonExtended.bottomNavigationInactive,
                    alwaysShowLabel = true,
                    selected = action.navigationController.currentRoute() == item.route,
                    onClick = {
                        action.onClickItem(item.route)
                    }
                )
            }
        }
    }
}