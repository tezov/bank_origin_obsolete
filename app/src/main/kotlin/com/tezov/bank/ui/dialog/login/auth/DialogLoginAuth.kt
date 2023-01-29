package com.tezov.bank.ui.dialog.login.auth

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.AccessorAppUiDialog
import com.tezov.bank.ui.dialog.login.auth.DialogLoginAuthState.Companion.LOGIN_LENGTH
import com.tezov.bank.ui.dialog.login.auth.DialogLoginAuthState.Companion.PASSWORD_LENGTH
import com.tezov.bank.ui.page.login.*
import com.tezov.lib_core_android_kotlin.ui.component.widget.KeyBoard
import com.tezov.lib_core_android_kotlin.ui.component.widget.provides
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*
import com.tezov.lib_core_android_kotlin.ui.util.ExtensionCompositionLocal
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object DialogLoginAuth : Dialog<DialogLoginAuthState, DialogLoginAuthAction> {

    @Composable
    override fun Dialog<DialogLoginAuthState, DialogLoginAuthAction>.content() {
        val accessor = AccessorAppUiDialog().get(requester = this).contextLoginAuth()
        val state = accessor.state()
        val action = accessor.action()

        ExtensionCompositionLocal.CompositionLocalProvider(
            parent = arrayOf(
                DialogLoginAuthTheme provides DialogLoginAuthTheme.provideColors(),
                DialogLoginAuthTheme provides DialogLoginAuthTheme.provideDimensions(),
            ),
            child = {
                arrayOf(
                    DialogLoginAuthTheme provides DialogLoginAuthTheme.provideShapes(),
                    DialogLoginAuthTheme provides DialogLoginAuthTheme.provideBorders(),
                    DialogLoginAuthTheme provides DialogLoginAuthTheme.provideTypographies(),
                    KeyBoard.GridCube provides DialogLoginAuthTheme.provideKeyBoardGridCubeStyle()
                )
            }
        ) {
            Surface(color = DialogLoginAuthTheme.colors.background) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h,
                            vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                        )
                ) {
                    IconButton(
                        modifier = Modifier.align(Alignment.TopStart),
                        onClick = { action.hide() }) {
                        Icon(
                            modifier = Modifier.size(DialogLoginAuthTheme.dimensions.iconCloseSize),
                            painter = painterResource(id = R.drawable.ic_close_24dp),
                            contentDescription = stringResource(id = R.string.dlg_login_auth_icon_close),
                            tint = DialogLoginAuthTheme.colors.onBackground,
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
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
    }

    @Composable
    private fun ContentHeader() {
        Text(
            text = stringResource(id = R.string.dlg_login_auth_enter_password),
            textAlign = TextAlign.Center,
            style = DialogLoginAuthTheme.typographies.title
        )
    }

    @OptIn(ExperimentalComposeUiApi::class)
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

            override fun hide() {  }

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
            val coroutine = rememberCoroutineScope()
            val keyboardController = LocalSoftwareKeyboardController.current
            val focusManager = LocalFocusManager.current
            val focusLogin = remember {
                FocusRequester()
            }
            val focusPassword = remember {
                FocusRequester()
            }
            val focusOwner = remember {
                mutableStateOf<FocusRequester?>(null)
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(DialogLoginAuthTheme.borders.authCard)

            ) {
                Row(modifier = Modifier.padding(bottom = MaterialTheme.dimensionsPaddingExtended.elementNormal_v)) {
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
                            .focusRequester(focusLogin)
                            .onFocusChanged {
                                if (it.isFocused) {
                                    focusOwner.value = focusLogin
                                    coroutine.launch {
                                        delay(100)
                                        keyboardController?.show()
                                    }
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
                            if (it.length >= LOGIN_LENGTH) {
                                if (password.value.length < PASSWORD_LENGTH) {
                                    focusPassword.requestFocus()
                                } else {
                                    keyboardController?.hide()
                                    focusManager.clearFocus(true)
                                }
                            }
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
                                keyboardController?.hide()
                                focusManager.clearFocus(true)
                            },
                            onNext = {
                                focusPassword.requestFocus()
                            }
                        ),
                        trailingIcon = {
                            IconButton(onClick = {
                                login.value = ""
                                focusLogin.requestFocus()
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

                Row(modifier = Modifier.padding(bottom = MaterialTheme.dimensionsPaddingExtended.elementNormal_v)) {
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
                                .focusRequester(focusPassword)
                                .onFocusChanged {
                                    if (it.isFocused) {
                                        focusOwner.value = focusPassword
                                        coroutine.launch {
                                            delay(100)
                                            keyboardController?.hide()
                                        }
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
                                        if (focusOwner.value != focusPassword) {
                                            focusPassword.requestFocus()
                                        }
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
                        .padding(MaterialTheme.dimensionsPaddingExtended.elementNormal_v)
                        .alpha(
                            when (focusOwner.value == focusPassword) {
                                true -> 1.0f
                                false -> 0.35f
                            }
                        )
                ) {
                    if (password.value.length < PASSWORD_LENGTH) {
                        password.value = password.value + it
                        if (focusOwner.value != focusPassword) {
                            focusPassword.requestFocus()
                        }
                    } else if (login.value.length < LOGIN_LENGTH) {
                        if (focusOwner.value != focusLogin) {
                            focusLogin.requestFocus()
                        }
                    } else {
                        keyboardController?.hide()
                        focusManager.clearFocus(true)
                    }
                }
            }

            LaunchedEffect(Unit) {
                if (login.value.isEmpty()) {
                    focusLogin.requestFocus()
                } else {
                    focusPassword.requestFocus()
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
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = onClickConnect,
                shape = DialogLoginAuthTheme.shapes.button,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = DialogLoginAuthTheme.colors.backgroundButtonDark,
                    disabledBackgroundColor = DialogLoginAuthTheme.colors.backgroundButtonInactive
                ),
                enabled = credentialValidState
            ) {
                Text(
                    stringResource(id = R.string.dlg_login_auth_btn_connect),
                    style = DialogLoginAuthTheme.typographies.button,
                    modifier = Modifier
                        .padding(
                            horizontal = DialogLoginAuthTheme.dimensions.paddingHorizontalButton,
                            vertical = DialogLoginAuthTheme.dimensions.paddingVerticalButton
                        )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = DialogLoginAuthTheme.dimensions.paddingTopFromLink),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ClickableText(
                    text = AnnotatedString(stringResource(id = R.string.dlg_login_auth_link_login_forgotten)),
                    style = DialogLoginAuthTheme.typographies.link
                ) {
                    onClickForgotLogin()
                }
                ClickableText(
                    text = AnnotatedString(stringResource(id = R.string.dlg_login_auth_link_password_forgotten)),
                    style = DialogLoginAuthTheme.typographies.link
                ) {
                    onClickForgotPassword()
                }
            }
        }
    }

}