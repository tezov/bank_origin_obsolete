package com.tezov.bank.ui.dialog.login.auth

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.forEachGesture
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
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

            val keyBoardDigits = remember {
                val digits = listOf(
                    KeyBoardDigit.make("0"),
                    KeyBoardDigit.make("1"),
                    KeyBoardDigit.make("2"),
                    KeyBoardDigit.make("3"),
                    KeyBoardDigit.make("4"),
                    KeyBoardDigit.make("5"),
                    KeyBoardDigit.make("6"),
                    KeyBoardDigit.make("7"),
                    KeyBoardDigit.make("8"),
                    KeyBoardDigit.make("9"),
                )
                KeyBoardDigits.make(digits.shuffled()){
                    Log.d(">>:", "ContentBody: ${this.value}")
                }
            }

            KeyBoardDigital(keyBoardDigits)
        }
    }

    interface KeyBoardDigits {

        val value: List<KeyBoardDigit>

        val size get() = value.size

        fun forEachIndexed(action: (Int, KeyBoardDigit) -> Unit) = value.forEachIndexed(action)

        fun onClicked(index:Int){
            kotlin.runCatching { value[index] }.getOrNull()?.onClicked()
        }

        fun KeyBoardDigit.onClicked()

        companion object {
            fun make(value: List<KeyBoardDigit>, onclick: KeyBoardDigit.()->Unit) = object : KeyBoardDigits {
                override val value get() = value
                override fun KeyBoardDigit.onClicked() = onclick()
            }
        }
    }

    interface KeyBoardDigit {

        val value: String

        companion object {
            fun make(value: String) = object : KeyBoardDigit {
                override val value get() = value
            }
        }

    }

    @OptIn(ExperimentalTextApi::class)
    @Composable
    private fun KeyBoardDigital(digits: KeyBoardDigits) {
        val color = DialogLoginAuthTheme.colors.onBackground
        val strokeWidth = 2.dp / 1.5f
        val textMeasure = rememberTextMeasurer()

        val yLength = 2
        val xLength = digits.size / yLength

        Layout(
            measurePolicy = { measurables, constraints ->
                with(constraints) {
                    val digitSize = maxWidth / xLength
                    val maxHeight = digitSize * yLength
                    layout(maxWidth, maxHeight) {}
                }
            },
            content = {},
            modifier = Modifier
                .padding(4.dp)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = { offset ->
                            val xPosition = ((offset.x / size.width) * xLength).toInt()
                            val yPosition = ((offset.y / size.height) * yLength).toInt()
                            val index = xLength * yPosition + xPosition
                            digits.onClicked(index)
                        }
                    )
                }
                .drawBehind {
                    val canvasWidth = size.width
                    val canvasHeight = size.height
                    val digitSize = canvasWidth / xLength
                    val digitSizeHalf = (digitSize / 3.5).toFloat()
                    val fontSize = digitSize * 0.25
                    //vertical line
                    for (i in 0..yLength) {
                        val y = digitSize * i
                        drawLine(
                            start = Offset(x = 0f, y = y),
                            end = Offset(x = canvasWidth, y = y),
                            color = color,
                            strokeWidth = strokeWidth.toPx()
                        )
                    }
                    //horizontal line
                    for (i in 0..(xLength + 1)) {
                        val x = digitSize * i
                        drawLine(
                            start = Offset(x = x, y = 0f),
                            end = Offset(x = x, y = canvasHeight),
                            color = color,
                            strokeWidth = strokeWidth.toPx()
                        )
                    }
                    val overflow = xLength * yLength
                    digits.forEachIndexed { index, keyBoardDigit ->
                        if(index>=overflow){
                            return@forEachIndexed
                        }
                        val x = (index % xLength) * digitSize + digitSizeHalf
                        val y = (index / xLength) * digitSize
                        drawText(
                            textMeasurer = textMeasure,
                            text = keyBoardDigit.value,
                            topLeft = Offset(x, y),
                            style = TextStyle(
                                color = color,
                                fontSize = fontSize.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                }
        )
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