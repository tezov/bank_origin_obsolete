/*
 *  *********************************************************************************
 *  Created by Tezov on 02/03/2023 21:08
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/03/2023 20:54
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.lobby.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link
import com.tezov.lib_core_android_kotlin.ui.component.plain.Text
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended

object PageLogin : Page<PageLoginState, PageLoginAction> {

    @Composable
    override fun Page<PageLoginState, PageLoginAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextLogin()
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
                .padding(
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockBig_v,
                    horizontal = MaterialTheme.dimensionsPaddingExtended.blockBig_v
                )
        ) {
            ContentHeader(
                iconState = state.iconState,
                onClickAdd = {

                },
                onClickDropDownMenu = { index ->

                }
            )
            ContentBody(
                nameState = state.nameState
            )
            ContentFooter(
                onClickConnect = {
                    action.onClickConnect()
                },
                onClickSendMoney = {

                },
                onClickHelpAndService = {
                    action.onClickHelpAndService()
                },
            )
        }
    }

    @Composable
    private fun ContentHeader(
        iconState: State<Int>,
        onClickAdd: () -> Unit,
        onClickDropDownMenu: (id: Int) -> Unit
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                Image(
                    modifier = Modifier
                        .size(PageLoginTheme.dimensions.logoSize),
                    painter = painterResource(id = R.drawable.logo_tezov_bank_inverse),
                    contentDescription = stringResource(id = R.string.pg_login_img_logo)
                )
            }
            Image(
                modifier = Modifier
                    .size(PageLoginTheme.dimensions.iconBigSize)
                    .clip(CircleShape)
                    .border(
                        PageLoginTheme.borders.iconBig,
                        CircleShape
                    ),
                painter = painterResource(id = iconState.value),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(id = R.string.pg_login_img_suit_case)
            )
            Spacer(modifier = Modifier.width(PageLoginTheme.dimensions.paddingStartToIconBig))
            IconButton(onClick = {
                onClickAdd()
            }) {
                Icon(
                    modifier = Modifier
                        .size(PageLoginTheme.dimensions.iconMediumSize)
                        .clip(CircleShape)
                        .background(PageLoginTheme.colors.backgroundButtonLight),
                    painter = painterResource(id = R.drawable.ic_add_24dp),
                    tint = PageLoginTheme.colors.background,
                    contentDescription = stringResource(id = R.string.pg_login_icon_add_account)
                )
            }
            Spacer(modifier = Modifier.width(PageLoginTheme.dimensions.paddingStartToIconMedium))
            Box {
                var expanded by remember { mutableStateOf(false) }
                val items = stringArrayResource(id = R.array.pg_login_drop_down_menu)
                IconButton(onClick = {
                    expanded = true
                }) {
                    Icon(
                        modifier = Modifier
                            .size(PageLoginTheme.dimensions.iconSmallSize)
                            .clip(CircleShape)
                            .background(PageLoginTheme.colors.backgroundButtonDark),
                        painter = painterResource(id = R.drawable.ic_3dot_v_24dp),
                        tint = PageLoginTheme.colors.backgroundButtonLight,
                        contentDescription = stringResource(id = R.string.pg_login_icon_more_action)
                    )
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .background(PageLoginTheme.colors.backgroundDropDownMenu),
                    offset = DpOffset(
                        PageLoginTheme.dimensions.iconSmallSize / 2,
                        -PageLoginTheme.dimensions.iconSmallSize / 5
                    )
                ) {
                    items.forEachIndexed { index, text ->
                        DropdownMenuItem(
                            onClick = {
                                expanded = false
                                onClickDropDownMenu(index)
                            },
                            contentPadding = PaddingValues(8.dp, 0.dp)
                        ) {
                            Text(
                                text = text,
                                style = PageLoginTheme.typographies.dropDownMenu
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun ColumnScope.ContentBody(
        nameState: State<String>
    ) {
        HorizontalScrollable.Pager(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            style = PageLoginTheme.styles.pager,
            pageSelected = 0,
            pages = arrayListOf(
                {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text.Simple(
                            text = nameState.value,
                            style = PageLoginTheme.typographies.supra
                        )
                        Spacer(modifier = Modifier.height(PageLoginTheme.dimensions.spacingTopToTitle))
                        Text.Simple(
                            text = stringResource(id = R.string.pg_login_pager_0),
                            style = PageLoginTheme.typographies.body.copy {
                                typo = typo.copy(textAlign = TextAlign.Center)
                            }
                        )
                    }
                },
                {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text.Simple(
                            text = stringResource(id = R.string.pg_login_pager_1),
                            style = PageLoginTheme.typographies.huge.copy {
                                typo = typo.copy(textAlign = TextAlign.Center)
                            }
                        )
                        Spacer(modifier = Modifier.height(PageLoginTheme.dimensions.spacingTopToTitle))
                        Button.TextOutlined(
                            modifierButton = Modifier
                                .padding(top = MaterialTheme.dimensionsPaddingExtended.elementBig_v),
                            modifierText = Modifier
                                .padding(
                                    horizontal = PageLoginTheme.dimensions.paddingButtonOutlined_h,
                                    vertical = PageLoginTheme.dimensions.paddingButtonOutlined_v
                                ),
                            onClick = { },
                            text = stringResource(id = R.string.pg_login_btn_activate_balance),
                            style = PageLoginTheme.styles.buttonOutlined
                        )
                    }
                }),
            onPageChange = {


            })
    }

    @Composable
    private fun ContentFooter(
        onClickConnect: () -> Unit,
        onClickSendMoney: () -> Unit,
        onClickHelpAndService: () -> Unit,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button.TextFilled(
                modifierButton = Modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.elementBig_v),
                modifierText = Modifier
                    .padding(
                        horizontal = PageLoginTheme.dimensions.paddingButton_h,
                        vertical = PageLoginTheme.dimensions.paddingButton_v
                    ),
                text = stringResource(id = R.string.pg_login_btn_connect),
                style = PageLoginTheme.styles.buttonDark,
                onClick = onClickConnect,
            )
            Button.TextFilled(
                modifierButton = Modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.elementBig_v),
                modifierText = Modifier
                    .padding(
                        horizontal = PageLoginTheme.dimensions.paddingButton_h,
                        vertical = PageLoginTheme.dimensions.paddingButton_v
                    ),
                text = stringResource(id = R.string.pg_login_btn_send_money),
                style = PageLoginTheme.styles.buttonLight,
                onClick = onClickSendMoney,
            )
            Spacer(modifier = Modifier.height(PageLoginTheme.dimensions.spacingTopFromLinkService))
            Link.Underlined(
                text = stringResource(id = R.string.pg_login_link_help_and_service),
                style = PageLoginTheme.styles.link,
                onClick = onClickHelpAndService,
            )
        }
    }

}