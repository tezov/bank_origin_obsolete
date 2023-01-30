package com.tezov.bank.ui.page.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.google.accompanist.pager.*
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.lib_core_android_kotlin.ui.component.widget.Swiper
import com.tezov.lib_core_android_kotlin.ui.component.widget.provides
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.util.ExtensionCompositionLocal

object PageLogin : Page<PageLoginState, PageLoginAction> {

    @Composable
    override fun Page<PageLoginState, PageLoginAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextLogin()
        val state = accessor.state()
        val action = accessor.action()

        state.animationState.updateTransition()
        ExtensionCompositionLocal.CompositionLocalProvider(
            parent = arrayOf(
                PageLoginTheme provides PageLoginTheme.provideColors(),
                PageLoginTheme provides PageLoginTheme.provideDimensions(),
            ),
            child = {
                arrayOf(
                    PageLoginTheme provides PageLoginTheme.provideShapes(),
                    PageLoginTheme provides PageLoginTheme.provideBorders(),
                    PageLoginTheme provides PageLoginTheme.provideTypographies(),
                    Swiper.Pager provides PageLoginTheme.provideSwiperPagerStyle()
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

    @OptIn(ExperimentalComposeUiApi::class)
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
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                onClickAdd = {

                },
                onClickDropDownMenu = { index ->

                }
            )
            ContentBody(
                Modifier
                    .fillMaxWidth()
                    .weight(1f),
                nameState = state.nameState
            )
            ContentFooter(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
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
        modifier: Modifier,
        onClickAdd: () -> Unit,
        onClickDropDownMenu: (id: Int) -> Unit
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(modifier = Modifier
                .wrapContentHeight()
                .weight(1f)) {
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
                painter = painterResource(id = R.drawable.img_suitcase_blue),
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
                        .background(PageLoginTheme.colors.backgroundDropDownMenu)
                        .wrapContentSize(),
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
                                modifier = Modifier
                                    .wrapContentSize(),
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
    private fun ContentBody(
        modifier: Modifier,
        nameState: State<String>
    ) {
        Swiper.Pager(
            modifier = modifier,
            pageSelected = 0,
            pages = arrayListOf(
                {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            modifier = Modifier
                                .wrapContentSize(),
                            text = nameState.value,
                            style = PageLoginTheme.typographies.supra
                        )
                        Spacer(modifier = Modifier.height(PageLoginTheme.dimensions.spacingTopToTitle))
                        Text(
                            modifier = Modifier
                                .wrapContentSize(),
                            textAlign = TextAlign.Center,
                            text = stringResource(id = R.string.pg_login_pager_0),
                            style = PageLoginTheme.typographies.body
                        )

                    }
                },
                {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier
                                .wrapContentSize(),
                            textAlign = TextAlign.Center,
                            text = stringResource(id = R.string.pg_login_pager_1),
                            style = PageLoginTheme.typographies.huge
                        )
                        Spacer(modifier = Modifier.height(PageLoginTheme.dimensions.spacingTopToTitle))
                        OutlinedButton(
                            modifier = Modifier .wrapContentSize(),
                            onClick = { },
                            border = PageLoginTheme.borders.buttonOutline,
                            shape = PageLoginTheme.shapes.buttonOutline,
                            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
                            enabled = true
                        ) {
                            Text(
                                text = stringResource(id = R.string.pg_login_btn_activate_balance),
                                style = PageLoginTheme.typographies.buttonOutlined,
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(
                                        horizontal = PageLoginTheme.dimensions.paddingHorizontalButtonOutlined,
                                        vertical = PageLoginTheme.dimensions.paddingVerticalButtonOutlined
                                    )
                            )
                        }
                    }
                }),
            onPageChange = {


            })
    }

    @Composable
    private fun ContentFooter(
        modifier: Modifier,
        onClickConnect: () -> Unit,
        onClickSendMoney: () -> Unit,
        onClickHelpAndService: () -> Unit,
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.elementBig_v),
                onClick = onClickConnect,
                shape = PageLoginTheme.shapes.button,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = PageLoginTheme.colors.backgroundButtonDark
                ),
                enabled = true
            ) {
                Text(
                    stringResource(id = R.string.pg_login_btn_connect),
                    style = PageLoginTheme.typographies.button,
                    color = PageLoginTheme.colors.textButtonDark,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(
                            horizontal = PageLoginTheme.dimensions.paddingHorizontalButton,
                            vertical = PageLoginTheme.dimensions.paddingVerticalButton
                        )
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.elementNormal_v)
                    .border(
                        PageLoginTheme.borders.buttonDark,
                        PageLoginTheme.shapes.button
                    ),
                onClick = onClickSendMoney,
                shape = PageLoginTheme.shapes.button,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = PageLoginTheme.colors.backgroundButtonLight
                ),
                enabled = true
            ) {
                Text(
                    stringResource(id = R.string.pg_login_btn_send_money),
                    style = PageLoginTheme.typographies.button,
                    color = PageLoginTheme.colors.textButtonLight,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(
                            horizontal = PageLoginTheme.dimensions.paddingHorizontalButton,
                            vertical = PageLoginTheme.dimensions.paddingVerticalButton
                        )
                )
            }

            Spacer(modifier = Modifier.height(PageLoginTheme.dimensions.spacingTopFromLinkService))

            ClickableText(
                modifier = Modifier.wrapContentSize(),
                text = AnnotatedString(stringResource(id = R.string.pg_login_link_help_and_service)),
                style = PageLoginTheme.typographies.link
            ) {
                onClickHelpAndService()
            }

        }

    }


}