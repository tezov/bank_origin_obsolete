/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

package com.tezov.bank.ui.dialog.lobby.login.loginAuth

import androidx.compose.foundation.background
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
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.platform.LocalTextToolbar
import androidx.compose.ui.platform.TextToolbar
import androidx.compose.ui.platform.TextToolbarStatus
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.DiAccessorAppUiDialog
import com.tezov.bank.ui.dialog.lobby.login.loginAuth.DialogLoginAuthState.Companion.LOGIN_LENGTH
import com.tezov.bank.ui.dialog.lobby.login.loginAuth.DialogLoginAuthState.Companion.PASSWORD_LENGTH
import com.tezov.lib_core_android_kotlin.type.primaire.size
import com.tezov.lib_core_android_kotlin.ui.component.block.KeyBoard
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Button
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Link
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivityBundle
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.modifier.requireFullScreen
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.border
import com.tezov.lib_core_android_kotlin.ui.theme.style.padding
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

object DialogLoginAuth : Dialog<DialogLoginAuthState, DialogLoginAuthAction> {

    @Composable
    override fun Dialog<DialogLoginAuthState, DialogLoginAuthAction>.content() {
        val accessor = DiAccessorAppUiDialog().with(key = this).contextLoginAuth()
        val state = accessor.state()
        val action = accessor.action()

        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                DialogLoginAuthTheme provides DialogLoginAuthTheme.provideColors(),
            ),
            parent = {
                arrayOf(
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
                    .requireFullScreen()
                    .background(DialogLoginAuthTheme.colors.background)
            ) {
                Icon.Clickable(
                    onClick = action::onClickClose
                ) {
                    Icon(
                        modifier = Modifier.size(MaterialTheme.dimensionsIconExtended.modal.normal),
                        painter = painterResource(id = R.drawable.ic_close_24dp),
                        contentDescription = stringResource(id = R.string.dlg_login_auth_icon_close),
                        tint = DialogLoginAuthTheme.colors.onBackground,
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(MaterialTheme.dimensionsPaddingExtended.page.big),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    contentHeader()
                    Spacer(modifier = Modifier.height(MaterialTheme.dimensionsPaddingExtended.element.big.vertical))
                    contentBody(state.loginState, state.passwordState)
                    Spacer(modifier = Modifier.height(MaterialTheme.dimensionsPaddingExtended.element.big.vertical))
                    contentFooter(
                        action = action,
                        credentialValidState = state.credentialValidState
                    )
                }
            }
        }
    }

    @Composable
    private fun ColumnScope.contentHeader() {
        Text.StateColor(
            text = R.string.dlg_login_auth_enter_password,
            style = DialogLoginAuthTheme.typographies.title
        )
    }

    //todo modifier lenght control par une validation login / password au niveau du state comme le credential valid
    @Composable
    private fun ColumnScope.contentBody(
        login: MutableState<String>,
        password: MutableState<String>,
    ) {
        val textSelectionDisableColors = TextSelectionColors(
            handleColor = MaterialTheme.colorsResource.transparent,
            backgroundColor = MaterialTheme.colorsResource.transparent
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
                    .border(MaterialTheme.bordersExtended.block.normal.copy {
                        outfitState = DialogLoginAuthTheme.colors.onBackground.asStateSimple
                    }, MaterialTheme.shapesExtended.block.small)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(start = MaterialTheme.dimensionsPaddingExtended.chunk.normal.horizontal)
                            .size(MaterialTheme.dimensionsIconExtended.fieldInfo.normal)
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
                            Text.StateColor(
                                text = R.string.dlg_login_auth_fld_label_login,
                                style = DialogLoginAuthTheme.typographies.label
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
                            backgroundColor = MaterialTheme.colorsResource.transparent
                        ),
                        textStyle = DialogLoginAuthTheme.typographies.input.resolve(),
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
                            Icon.Clickable(onClick = {
                                login.value = ""
                                focusManagement.requestLoginFocus()
                            }) {
                                Icon(
                                    modifier = Modifier
                                        .size(MaterialTheme.dimensionsIconExtended.fieldAction.normal)
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
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(MaterialTheme.dimensionsCommonExtended.divider.normal),
                    color = DialogLoginAuthTheme.colors.fade
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    CompositionLocalProvider(
                        LocalTextInputService provides null
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(start = MaterialTheme.dimensionsPaddingExtended.chunk.normal.horizontal)
                                .size(MaterialTheme.dimensionsIconExtended.fieldInfo.normal)
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
                                Text.StateColor(
                                    text = R.string.dlg_login_auth_fld_label_password,
                                    style = DialogLoginAuthTheme.typographies.label
                                )
                            },
                            onValueChange = {},
                            singleLine = true,
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = MaterialTheme.colorsResource.transparent,
                                cursorColor = MaterialTheme.colorsResource.transparent
                            ),
                            visualTransformation = PasswordVisualTransformation(),
                            textStyle = DialogLoginAuthTheme.typographies.input.resolve(),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.NumberPassword,
                            ),
                            keyboardActions = KeyboardActions(),
                            trailingIcon = {
                                Icon.Clickable(onClick = {
                                    password.takeIf { it.value.isNotEmpty() }?.apply {
                                        value = value.dropLast(1)
                                        focusManagement.requestPasswordFocus()
                                    }
                                }) {
                                    Icon(
                                        modifier = Modifier
                                            .size(MaterialTheme.dimensionsIconExtended.fieldAction.normal)
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
                } else if (password.value.length < PASSWORD_LENGTH) {
                    focusManagement.requestPasswordFocus()
                }
            }
            DisposableEffect(Unit) {
                onDispose {
                    focusManagement.hideKeyBoard()
                }
            }

        }
    }

    @Composable
    private fun ColumnScope.contentFooter(
        action: DialogLoginAuthAction,
        credentialValidState: Boolean,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button.StateColor(
                modifierButton = Modifier
                    .fillMaxWidth(),
                modifierText = Modifier
                    .padding(MaterialTheme.dimensionsPaddingExtended.text.big),
                text = stringResource(id = R.string.dlg_login_auth_btn_connect),
                style = DialogLoginAuthTheme.styles.button,
                enabled = credentialValidState,
                onClick = action::onClickConnect,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.element.supra.vertical),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Link.StateColor(
                    text = stringResource(id = R.string.dlg_login_auth_link_login_forgotten),
                    style = DialogLoginAuthTheme.styles.link,
                    onClick = action::onClickForgetLogin,
                )
                Link.StateColor(
                    text = stringResource(id = R.string.dlg_login_auth_link_password_forgotten),
                    style = DialogLoginAuthTheme.styles.link,
                    onClick = action::onClickForgetPassword,
                )
            }
        }
    }

}