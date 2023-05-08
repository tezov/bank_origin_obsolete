/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 16:14
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 16:12
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.pageMain.lobby.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.lib_core_android_kotlin.ui.component.block.HorizontalPager
import com.tezov.lib_core_android_kotlin.ui.component.chunk.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.padding
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended

object PageLogin : Page<PageLoginState, PageLoginAction> {

    @Composable
    override fun Page<PageLoginState, PageLoginAction>.content(innerPadding: PaddingValues) {
        val accessor = DiAccessorAppUiPage().with(key = this).contextLogin()
        val state = accessor.state()
        val action = accessor.action()

        state.animationState.updateTransition()
        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PageLoginTheme provides PageLoginTheme.provideColors(),
                PageLoginTheme provides PageLoginTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    PageLoginTheme provides PageLoginTheme.provideShapes(),
                    PageLoginTheme provides PageLoginTheme.provideBorders(),
                    PageLoginTheme provides PageLoginTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PageLoginTheme provides PageLoginTheme.provideStyles()
                )
            }
        ) {
            contentLoading(state, action, innerPadding)
            contentLoaded(state, action, innerPadding)
        }
        LaunchedEffect(Unit) {
            if (state.animationState.isNotDone) {
                state.animationState.startTransition()
            }
        }
    }

    @Composable
    private fun contentLoading(
        state: PageLoginState,
        action: PageLoginAction,
        innerPadding: PaddingValues
    ) {

    }

    @Composable
    private fun contentLoaded(
        state: PageLoginState,
        action: PageLoginAction,
        innerPadding: PaddingValues
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PageLoginTheme.colors.background)
                .padding(innerPadding)
                .padding(vertical = MaterialTheme.dimensionsPaddingExtended.page.huge.vertical)
        ) {
            ContentHeader(
                action = action,
                iconState = state.iconState,
            )
            ContentBody(
                nameState = state.nameState
            )
            ContentFooter(
                action = action,
            )
        }
    }

    @Composable
    private fun ContentHeader(
        action: PageLoginAction,
        iconState: State<Int>,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.dimensionsPaddingExtended.page.huge.horizontal),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.weight(1f)
            ) {
                Image.Simple(
                    style = PageLoginTheme.styles.logo,
                    resourceId = R.drawable.logo_tezov_bank_inverse,
                    description = stringResource(id = R.string.pg_login_img_logo)
                )
            }
            Image.StateColor(
                style = PageLoginTheme.styles.iconBig,
                resourceId = iconState.value,
                description = stringResource(id = R.string.pg_login_img_suit_case)
            )
            Spacer(modifier = Modifier.width(PageLoginTheme.dimensions.paddingStartToIconBig))
            Icon.Clickable(onClick = action::onClickAdd) {
                Icon.StateColor(
                    resourceId = R.drawable.ic_add_24dp,
                    style = PageLoginTheme.styles.iconMedium,
                    description = stringResource(id = R.string.pg_login_icon_add_account)
                )
            }
            Spacer(modifier = Modifier.width(PageLoginTheme.dimensions.paddingStartToIconMedium))
            DropDownMenu.StateColor(
                style = PageLoginTheme.styles.dropDownMenu,
                resourceId = R.drawable.ic_3dot_v_24dp,
                description = stringResource(id = R.string.pg_login_icon_more_action),
                items = stringArrayResource(id = R.array.pg_login_drop_down_menu).toList(),
                offset = DpOffset(
                    PageLoginTheme.dimensions.iconSmall.width / 2,
                    -PageLoginTheme.dimensions.iconSmall.height / 5
                ),
                onClick = action::onClickMenu
            )
        }
    }

    @Composable
    private fun ColumnScope.ContentBody(
        nameState: State<String>
    ) {
        HorizontalPager.WithIndicator(
            modifier = Modifier
                .weight(1f),
            style = PageLoginTheme.styles.pager,
            itemSelected = 0,
            items = arrayListOf(
                {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text.StateColor(
                            text = nameState.value,
                            style = PageLoginTheme.typographies.supra
                        )
                        Spacer(modifier = Modifier.height(PageLoginTheme.dimensions.spacingTopToTitle))
                        Text.StateColor(
                            text = stringResource(id = R.string.pg_login_pager_0),
                            style = PageLoginTheme.typographies.body.copy {
                                typo = typo.copy(textAlign = TextAlign.Center)
                            }
                        )
                    }
                },
                {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text.StateColor(
                            text = stringResource(id = R.string.pg_login_pager_1),
                            style = PageLoginTheme.typographies.huge.copy {
                                typo = typo.copy(textAlign = TextAlign.Center)
                            }
                        )
                        Spacer(modifier = Modifier.height(PageLoginTheme.dimensions.spacingTopToTitle))
                        Button.StateColor(
                            modifierText = Modifier
                                .padding(MaterialTheme.dimensionsPaddingExtended.text.big),
                            onClick = { },
                            text = stringResource(id = R.string.pg_login_btn_activate_balance),
                            style = PageLoginTheme.styles.buttonOutlined
                        )
                    }
                })
        )
    }

    @Composable
    private fun ContentFooter(
        action: PageLoginAction,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.dimensionsPaddingExtended.page.huge.horizontal),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button.StateColor(
                modifierButton = Modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.block.normal.vertical),
                modifierText = Modifier
                    .padding(MaterialTheme.dimensionsPaddingExtended.text.big),
                text = stringResource(id = R.string.pg_login_btn_connect),
                style = PageLoginTheme.styles.buttonDark,
                onClick = action::onClickConnect,
            )
            Button.StateColor(
                modifierButton = Modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.element.normal.vertical),
                modifierText = Modifier
                    .padding(MaterialTheme.dimensionsPaddingExtended.text.big),
                text = stringResource(id = R.string.pg_login_btn_send_money),
                style = PageLoginTheme.styles.buttonLight,
                onClick = action::onClickSendMoney,
            )
            Spacer(modifier = Modifier.height(PageLoginTheme.dimensions.spacingTopFromLinkService))
            Link.StateColor(
                text = stringResource(id = R.string.pg_login_link_help_and_service),
                style = PageLoginTheme.styles.link,
                onClick = action::onClickHelpAndService,
            )
        }
    }
}