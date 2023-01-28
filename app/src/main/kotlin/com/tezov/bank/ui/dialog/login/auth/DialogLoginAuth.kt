package com.tezov.bank.ui.dialog.login.auth

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.AccessorAppUiDialog
import com.tezov.bank.ui.page.login.*
import com.tezov.lib_core_android_kotlin.ui.component.widget.KeyBoard
import com.tezov.lib_core_android_kotlin.ui.component.widget.provides
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*
import com.tezov.lib_core_android_kotlin.ui.util.ExtensionCompositionLocal

object DialogLoginAuth : Dialog<DialogLoginAuthState, DialogLoginAuthAction> {

    @Composable
    override fun Dialog<DialogLoginAuthState, DialogLoginAuthAction>.content() {
        val accessor = AccessorAppUiDialog().get(requester = this).contextLoginAuth()
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
        ){
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
                        ContentBody {

                        }
                        Spacer(modifier = Modifier.height(DialogLoginAuthTheme.dimensions.spacingTopFromButton))
                        ContentFooter {

                        }
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
        onClick: (resourceId: Int) -> Unit
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(DialogLoginAuthTheme.borders.authCard)

        ) {

            Row {
                val focusManager = LocalFocusManager.current
                val keyboardController = LocalSoftwareKeyboardController.current
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    value = "login.value",
                    label = { Text(text = "label") },
                    onValueChange = {
//                        login.value = it
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colorsCommonResource.transparent
                    ),
                    textStyle = DialogLoginAuthTheme.typographies.field,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
//                        imeAction = if (password.value.isBlank()) ImeAction.Next else ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(onDone = {
//                        focusManager.clearFocus(true)
//                        keyboardController?.hide()
//                        onImeAction(ImeAction.Done, R.string.screen_login_field_login)
                    }, onNext = {
//                        onImeAction(ImeAction.Next, R.string.screen_login_field_login)
                    })
                )
                Icon(
                    modifier = Modifier
                        .size(DialogLoginAuthTheme.dimensions.iconFieldSize)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(id = R.drawable.ic_person_24dp),
                    tint = DialogLoginAuthTheme.colors.onBackground,
                    contentDescription = null
                )
            }

            Row {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    value = "password.value",
                    label = { Text(text = "label") },
                    onValueChange = {
//                        password.value = it
                    },
                    trailingIcon = {
                        IconButton(onClick = {
//                            passwordVisible.value = !passwordVisible.value
                        }) {
//                            Image(
//                                modifier = Modifier.size(SIZE_ICON_LOGIN),
//                                painter = when (passwordVisible.value) {
//                                    false -> painterResource(id = R.drawable.ic_eye_opened_24dp)
//                                    true -> painterResource(id = R.drawable.ic_eye_closed_24dp)
//                                },
//                                contentDescription = null
//                            )
                        }
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colorsCommonResource.transparent
                    ),
//                    visualTransformation = when (passwordVisible.value) {
//                        false -> PasswordVisualTransformation()
//                        true -> VisualTransformation.None
//                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.NumberPassword,
//                        imeAction = if (login.value.isBlank()) ImeAction.Next else ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(onDone = {
//                        focusManager.clearFocus(true)
//                        keyboardController?.hide()
//                        onImeAction(ImeAction.Done, R.string.screen_login_field_password)
                    }, onNext = {
//                        onImeAction(ImeAction.Next, R.string.screen_login_field_password)
                    }),
                    textStyle = MaterialTheme.typographyExtended.textField
                )
                Icon(
                    modifier = Modifier
                        .size(DialogLoginAuthTheme.dimensions.iconFieldSize)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(id = R.drawable.ic_lock_24dp),
                    tint = DialogLoginAuthTheme.colors.onBackground,
                    contentDescription = null
                )
            }

            KeyBoard.GridCubeDigitsTwoRowShuffled(modifier = Modifier.padding(6.dp)){
                Log.d(">>:", "ContentBody: $it")

            }
        }
    }

    @Composable
    private fun ContentFooter(
        onClick: (resourceId: Int) -> Unit
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = { },
                shape = DialogLoginAuthTheme.shapes.button,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = DialogLoginAuthTheme.colors.backgroundButtonDark,
                    disabledBackgroundColor = MaterialTheme.colorsCommonResource.grayLight
                ),
                enabled = true
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
                    onClick(0)
                }
                ClickableText(
                    text = AnnotatedString("Code secret oublié ?"),
                    style = DialogLoginAuthTheme.typographies.link
                ) {
                    onClick(1)
                }
            }


        }
    }

}