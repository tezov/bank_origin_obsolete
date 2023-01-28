package com.tezov.bank.ui.dialog.login.auth

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.AccessorAppUiDialog
import com.tezov.bank.ui.page.login.*
import com.tezov.lib_core_android_kotlin.ui.component.widget.KeyBoard
import com.tezov.lib_core_android_kotlin.ui.component.widget.provides
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*
import com.tezov.lib_core_android_kotlin.ui.util.ExtensionCompositionLocal
import kotlinx.coroutines.delay

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
                            contentDescription = null,
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
            text = "Saisissez votre code secret pour\naccéder à vos comptes",
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(DialogLoginAuthTheme.borders.authCard)

        ) {
            val keyboardController = LocalSoftwareKeyboardController.current
            val focusManager = LocalFocusManager.current
            val (focusLogin, focusPassword) = remember{
                FocusRequester.createRefs()
            }
            Row {
                TextField(
                    modifier = Modifier
                        .focusRequester(focusLogin)
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically),
                    value = login.value,
                    label = { Text(text = "label") },
                    onValueChange = {
                        login.value = it
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colorsCommonResource.transparent
                    ),
                    textStyle = DialogLoginAuthTheme.typographies.field,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(onNext = {
                        focusManager.clearFocus(true)
                        keyboardController?.hide()
                    }),
                    trailingIcon = {
                        IconButton(onClick = {
                            login.value = ""
                            focusLogin.requestFocus()
                            keyboardController?.show()
                        }) {
                            Icon(
                                modifier = Modifier
                                    .size(DialogLoginAuthTheme.dimensions.iconFieldSize)
                                    .align(Alignment.CenterVertically),
                                painter = when (login.value.isEmpty()) {
                                    false -> painterResource(id = R.drawable.ic_cancel_round_24dp)
                                    true -> painterResource(id = R.drawable.ic_transparent_24dp)
                                },
                                tint = DialogLoginAuthTheme.colors.onBackground,
                                contentDescription = null
                            )
                        }
                    }
                )
            }

            Row {
                CompositionLocalProvider(
                    LocalTextInputService provides null
                ) {
                    TextField(
                        modifier = Modifier
                            .focusRequester(focusPassword)
                            .fillMaxWidth()
                            .align(Alignment.CenterVertically),
                        value = password.value,
                        label = { Text(text = "label") },
                        onValueChange = {
                            password.value = it
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = MaterialTheme.colorsCommonResource.transparent,
                            cursorColor = MaterialTheme.colorsCommonResource.transparent
                        ),
                        visualTransformation = PasswordVisualTransformation(),
                        textStyle = DialogLoginAuthTheme.typographies.field,
                        trailingIcon = {
                            IconButton(onClick = {
                                password.takeIf{ it.value.isNotEmpty() }?.apply{
                                    focusPassword.requestFocus()
                                    value = value.dropLast(1)
                                }
                            }) {
                                Icon(
                                    modifier = Modifier
                                        .size(DialogLoginAuthTheme.dimensions.iconFieldSize)
                                        .align(Alignment.CenterVertically),
                                    painter = when (password.value.isEmpty()) {
                                        false -> painterResource(id = R.drawable.ic_backspace_24dp)
                                        true -> painterResource(id = R.drawable.ic_transparent_24dp)
                                    },
                                    tint = DialogLoginAuthTheme.colors.onBackground,
                                    contentDescription = null
                                )
                            }
                        }
                    )
                }
            }

            KeyBoard.GridCubeDigitsTwoRowShuffled(modifier = Modifier.padding(6.dp)) {
                focusPassword.requestFocus()
                keyboardController?.hide()
                password.value = password.value + it
            }

            LaunchedEffect(Unit){
                delay(100)
                if(login.value.isEmpty()){
                    focusLogin.requestFocus()
                    keyboardController?.show()
                }
                else{
                    focusPassword.requestFocus()
                    keyboardController?.hide()
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
                    "Se connecter",
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
                    text = AnnotatedString("Mon n°client ?"),
                    style = DialogLoginAuthTheme.typographies.link
                ) {
                    onClickForgotLogin()
                }
                ClickableText(
                    text = AnnotatedString("Code secret oublié ?"),
                    style = DialogLoginAuthTheme.typographies.link
                ) {
                    onClickForgotPassword()
                }
            }
        }
    }

}