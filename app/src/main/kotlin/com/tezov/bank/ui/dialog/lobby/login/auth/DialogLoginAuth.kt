/*
 *  *********************************************************************************
 *  Created by Tezov on 19/03/2023 16:08
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/03/2023 16:08
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.dialog.lobby.login.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.AccessorAppUiDialog
import com.tezov.bank.ui.dialog.lobby.login.auth.DialogLoginAuthState.Companion.LOGIN_LENGTH
import com.tezov.bank.ui.dialog.lobby.login.auth.DialogLoginAuthState.Companion.PASSWORD_LENGTH
import com.tezov.lib_core_android_kotlin.ui.component.branch.KeyBoard
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal

object DialogLoginAuth : Dialog<DialogLoginAuthState, DialogLoginAuthAction> {

    @Composable
    override fun Dialog<DialogLoginAuthState, DialogLoginAuthAction>.content() {
        val accessor = AccessorAppUiDialog().get(requester = this).contextLoginAuth()
        val state = accessor.state()
        val action = accessor.action()

        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                DialogLoginAuthTheme provides DialogLoginAuthTheme.provideColors(),
                DialogLoginAuthTheme provides DialogLoginAuthTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    DialogLoginAuthTheme provides DialogLoginAuthTheme.provideShapes(),
                    DialogLoginAuthTheme provides DialogLoginAuthTheme.provideBorders(),
                    DialogLoginAuthTheme provides DialogLoginAuthTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    DialogLoginAuthTheme provides DialogLoginAuthTheme.provideStyles(),
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DialogLoginAuthTheme.colors.background)
            ) {
                IconButton(
                    onClick = { action.hide() }) {
                    Icon(
                        modifier = Modifier.size(DialogLoginAuthTheme.dimensions.iconCloseSize),
                        painter = painterResource(id = R.drawable.ic_close_24dp),
                        contentDescription = stringResource(id = R.string.dlg_login_auth_icon_close),
                        tint = DialogLoginAuthTheme.colors.onBackground,
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h,
                            vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                        ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ContentHeader()
                    Spacer(modifier = Modifier.height(DialogLoginAuthTheme.dimensions.spacingTopToTitle))
                    ContentBody(state.loginState, state.passwordState)
                    Spacer(modifier = Modifier.height(DialogLoginAuthTheme.dimensions.spacingTopFromButton))
                    ContentFooter(
                        credentialValidState = state.credentialValidState,
                        onClickConnect = {
                            action.connect()
                        },
                        onClickForgotLogin = {

                        },
                        onClickForgotPassword = {

                        }
                    )
                }
            }
        }
    }

    @Composable
    private fun ContentHeader() {
        Text(
            text = stringResource(id = R.string.dlg_login_auth_enter_password),
            textAlign = TextAlign.Center,
            style = DialogLoginAuthTheme.typographies.title
        )
    }

    //todo modifier lenght control par une validation login / password au niveau du state comme le credential valid
    @Composable
    private fun ContentBody(
        login: MutableState<String>,
        password: MutableState<String>,
    ) {
        val textSelectionDisableColors = TextSelectionColors(
            handleColor = MaterialTheme.colorsCommonResource.transparent,
            backgroundColor = MaterialTheme.colorsCommonResource.transparent
        )
        val textSelectionDisableToolbar = object : TextToolbar {
            override val status: TextToolbarStatus = TextToolbarStatus.Hidden

            override fun hide() {}

            override fun showMenu(
                rect: Rect,
                onCopyRequested: (() -> Unit)?,
                onPasteRequested: (() -> Unit)?,
                onCutRequested: (() -> Unit)?,
                onSelectAllRequested: (() -> Unit)?,
            ) {
            }
        }

        CompositionLocalProvider(
            LocalTextSelectionColors provides textSelectionDisableColors,
            LocalTextToolbar provides textSelectionDisableToolbar
        ) {
            val focusManagement = remember {
                DialogLoginAuthFocusManager(login, password)
            }
            focusManagement.compose()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(DialogLoginAuthTheme.borders.authCard)

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = MaterialTheme.dimensionsPaddingExtended.elementNormal_v)
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(MaterialTheme.dimensionsPaddingExtended.elementMicro_h)
                            .size(DialogLoginAuthTheme.dimensions.iconFieldInfoSize)
                            .align(Alignment.CenterVertically),
                        painter = painterResource(id = R.drawable.ic_person_24dp),
                        tint = DialogLoginAuthTheme.colors.onBackground,
                        contentDescription = stringResource(id = R.string.dlg_login_auth_icon_login_clear)
                    )
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterVertically)
                            .focusRequester(focusManagement.focusLogin)
                            .onFocusChanged {
                                if (it.isFocused) {
                                    focusManagement.onLoginFocus()
                                }
                            },
                        value = login.value,
                        label = {
                            Text(
                                text = stringResource(id = R.string.dlg_login_auth_fld_label_login),
                                style = DialogLoginAuthTheme.typographies.fieldLabel
                            )
                        },
                        onValueChange = {
                            if (it.length <= LOGIN_LENGTH) {
                                login.value = it
                            }
                            focusManagement.onLoginChange()
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = MaterialTheme.colorsCommonResource.transparent
                        ),
                        textStyle = DialogLoginAuthTheme.typographies.fieldValue,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.NumberPassword,
                            imeAction = if (password.value.length < PASSWORD_LENGTH) ImeAction.Next else ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                focusManagement.requestClearFocus()
                            },
                            onNext = {
                                focusManagement.requestPasswordFocus()
                            }
                        ),
                        trailingIcon = {
                            IconButton(onClick = {
                                login.value = ""
                                focusManagement.requestLoginFocus()
                            }) {
                                Icon(
                                    modifier = Modifier
                                        .size(DialogLoginAuthTheme.dimensions.iconFieldActionSize)
                                        .align(Alignment.CenterVertically),
                                    painter = when (login.value.isEmpty()) {
                                        false -> painterResource(id = R.drawable.ic_cancel_round_24dp)
                                        true -> painterResource(id = R.drawable.ic_transparent_24dp)
                                    },
                                    tint = DialogLoginAuthTheme.colors.onBackground,
                                    contentDescription = stringResource(id = R.string.dlg_login_auth_icon_login_clear)
                                )
                            }
                        }
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = MaterialTheme.dimensionsPaddingExtended.elementNormal_v)
                ) {
                    CompositionLocalProvider(
                        LocalTextInputService provides null
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(MaterialTheme.dimensionsPaddingExtended.elementMicro_h)
                                .size(DialogLoginAuthTheme.dimensions.iconFieldInfoSize)
                                .align(Alignment.CenterVertically),
                            painter = painterResource(id = R.drawable.ic_lock_24dp),
                            tint = DialogLoginAuthTheme.colors.onBackground,
                            contentDescription = stringResource(id = R.string.dlg_login_auth_icon_password_info)
                        )

                        TextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterVertically)
                                .focusRequester(focusManagement.focusPassword)
                                .onFocusChanged {
                                    if (it.isFocused) {
                                        focusManagement.onPasswordFocus()
                                    }
                                },
                            value = password.value,
                            label = {
                                Text(
                                    text = stringResource(id = R.string.dlg_login_auth_fld_label_password),
                                    style = DialogLoginAuthTheme.typographies.fieldLabel
                                )
                            },
                            onValueChange = {},
                            singleLine = true,
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = MaterialTheme.colorsCommonResource.transparent,
                                cursorColor = MaterialTheme.colorsCommonResource.transparent
                            ),
                            visualTransformation = PasswordVisualTransformation(),
                            textStyle = DialogLoginAuthTheme.typographies.fieldValue,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.NumberPassword,
                            ),
                            keyboardActions = KeyboardActions(),
                            trailingIcon = {
                                IconButton(onClick = {
                                    password.takeIf { it.value.isNotEmpty() }?.apply {
                                        value = value.dropLast(1)
                                        focusManagement.requestPasswordFocus()
                                    }
                                }) {
                                    Icon(
                                        modifier = Modifier
                                            .size(DialogLoginAuthTheme.dimensions.iconFieldActionSize)
                                            .align(Alignment.CenterVertically),
                                        painter = when (password.value.isEmpty()) {
                                            false -> painterResource(id = R.drawable.ic_backspace_24dp)
                                            true -> painterResource(id = R.drawable.ic_transparent_24dp)
                                        },
                                        tint = DialogLoginAuthTheme.colors.onBackground,
                                        contentDescription = stringResource(id = R.string.dlg_login_auth_icon_password_delete)
                                    )
                                }
                            }
                        )
                    }
                }

                KeyBoard.GridCubeDigitsTwoRowShuffled(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(MaterialTheme.dimensionsPaddingExtended.elementNormal_v)
                        .alpha(
                            when (focusManagement.isPasswordHasFocus()) {
                                true -> 1.0f
                                false -> 0.35f
                            }
                        ),
                    style = DialogLoginAuthTheme.styles.keyBoardGridCube
                ) {
                    if (password.value.length < PASSWORD_LENGTH) {
                        password.value = password.value + it
                    }
                    focusManagement.onPasswordChange()
                }
            }

            LaunchedEffect(Unit) {
                if (login.value.length < LOGIN_LENGTH) {
                    focusManagement.requestLoginFocus()
                } else if(password.value.length < PASSWORD_LENGTH){
                    focusManagement.requestPasswordFocus()
                }
            }
            DisposableEffect(Unit){
                onDispose {
                    focusManagement.hideKeyBoard()
                }
            }

        }
    }

    @Composable
    private fun ContentFooter(
        credentialValidState: Boolean,
        onClickConnect: () -> Unit,
        onClickForgotLogin: () -> Unit,
        onClickForgotPassword: () -> Unit,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Button.TextFilled(
                modifierButton = Modifier
                    .fillMaxWidth(),
                modifierText = Modifier
                    .padding(
                        horizontal = DialogLoginAuthTheme.dimensions.paddingButton_h,
                        vertical = DialogLoginAuthTheme.dimensions.paddingButton_v
                    ),
                text = stringResource(id = R.string.dlg_login_auth_btn_connect),
                style = DialogLoginAuthTheme.styles.button,
                enabled = credentialValidState,
                onClick = onClickConnect,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = DialogLoginAuthTheme.dimensions.paddingTopFromLink),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Link.StateColor(
                    text = stringResource(id = R.string.dlg_login_auth_link_login_forgotten),
                    style = DialogLoginAuthTheme.styles.link,
                    onClick = onClickForgotLogin,
                )
                Link.StateColor(
                    text = stringResource(id = R.string.dlg_login_auth_link_password_forgotten),
                    style = DialogLoginAuthTheme.styles.link,
                    onClick = onClickForgotPassword,
                )
            }
        }
    }

}