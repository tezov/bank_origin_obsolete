package com.tezov.bank.ui.dialog.login.auth

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.AccessorAppUiDialog
import com.tezov.bank.ui.page.login.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*

object DialogLoginAuth : Dialog<DialogLoginAuthState, DialogLoginAuthAction> {

    @Composable
    override fun Dialog<DialogLoginAuthState, DialogLoginAuthAction>.content() {
        val accessor = AccessorAppUiDialog().get(requester = this).contextLoginAuth()
        val action = accessor.action()
        CompositionLocalProvider(
            DialogLoginAuthTheme.localColors provides DialogLoginAuthTheme.provideColors(),
            DialogLoginAuthTheme.localDimensions provides DialogLoginAuthTheme.provideDimensions(),
            DialogLoginAuthTheme.localShapes provides DialogLoginAuthTheme.provideShapes(),
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
                        ContentBody {

                        }
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
            style = MaterialTheme.typographyExtended.textTitle.copy(fontSize = DialogLoginAuthTheme.dimensions.textTitle),
            color = DialogLoginAuthTheme.colors.onBackground
        )

    }

    private val SIZE_ICON_LOGIN = 32.dp

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    private fun ContentBody(
        onClick: (resourceId: Int) -> Unit
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MaterialTheme.dimensionsPaddingExtended.elementBig_v)
                .border(1.dp, DialogLoginAuthTheme.colors.onBackground, RoundedCornerShape(2))

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
                    textStyle = MaterialTheme.typographyExtended.textField,
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
                        .size(SIZE_ICON_LOGIN)
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
                        .size(SIZE_ICON_LOGIN)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(id = R.drawable.ic_lock_24dp),
                    tint = DialogLoginAuthTheme.colors.onBackground,
                    contentDescription = null
                )
            }

            KeyBoardDigital()
        }
    }

    @OptIn(ExperimentalTextApi::class)
    @Composable
    private fun KeyBoardDigital() {
        val color = DialogLoginAuthTheme.colors.onBackground
        val strokeWidth = 2.dp / 1.5f
        val textMeasure = rememberTextMeasurer()

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {
            val canvasWidth = size.width
            val canvasWidthSplit = canvasWidth / 5
            val canvasHeight = size.height

            drawLine(
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = canvasWidth, y = 0f),
                color = color,
                strokeWidth = strokeWidth.toPx()
            )

            drawLine(
                start = Offset(x = 0f, y = canvasHeight / 2),
                end = Offset(x = canvasWidth, y = canvasHeight / 2),
                color = color,
                strokeWidth = strokeWidth.toPx()
            )

            for( i in 1 until 5){
                drawLine(
                    start = Offset(x = canvasWidthSplit * i, y = 0f),
                    end = Offset(x = canvasWidthSplit * i, y = canvasHeight),
                    color = color,
                    strokeWidth = strokeWidth.toPx()
                )
            }

            val numbers = "0123456789".toMutableList().shuffled()
            for( i in 0 until 5){
                drawText(
                    textMeasurer = textMeasure,
                    text = numbers[i*2].toString(),
                    topLeft = Offset(canvasWidthSplit * i + canvasWidthSplit / 2, 0f),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 48.sp,
                        fontStyle = FontStyle.Italic
                    )
                )
                drawText(
                    textMeasurer = textMeasure,
                    text = numbers[(i*2)+1].toString(),
                    topLeft = Offset(canvasWidthSplit * i + canvasWidthSplit / 2, 140f),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 48.sp,
                        fontStyle = FontStyle.Italic
                    )
                )
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
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.elementBig_v),
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
                    style = MaterialTheme.typographyExtended.textButton
                        .copy(fontSize = DialogLoginAuthTheme.dimensions.textButton),
                    color = DialogLoginAuthTheme.colors.textButtonDark,
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
                    .padding(
                        horizontal = MaterialTheme.dimensionsPaddingExtended.elementBig_h,
                        vertical = MaterialTheme.dimensionsPaddingExtended.elementBig_v
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ClickableText(
                    text = AnnotatedString("Mon n°client ?"),
                    style = MaterialTheme.typographyExtended.textLink.copy(
                        fontSize = DialogLoginAuthTheme.dimensions.textLink,
                        color = MaterialTheme.colorsCommonExtended.onPrimaryLight
                    )
                ) {
                    onClick(0)
                }
                ClickableText(
                    text = AnnotatedString("Code secret oublié ?"),
                    style = MaterialTheme.typographyExtended.textLink.copy(
                        fontSize = DialogLoginAuthTheme.dimensions.textLink,
                        color = MaterialTheme.colorsCommonExtended.onPrimaryLight
                    )
                ) {
                    onClick(1)
                }
            }


        }
    }

}