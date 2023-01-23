package com.tezov.bank.ui.dialog.login.auth

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.di.accessor.AccessorAppUiDialog
import com.tezov.bank.ui.page.login.PageLoginTheme
import com.tezov.bank.ui.page.login.colors
import com.tezov.bank.ui.page.login.dimensions
import com.tezov.bank.ui.page.login.shapes
import com.tezov.bank.ui.theme.ThemeColors
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*

object DialogLoginAuth : Dialog<DialogLoginAuthState, DialogLoginAuthAction> {

    @Composable
    override fun Dialog<DialogLoginAuthState, DialogLoginAuthAction>.content() {
        val accessor = AccessorAppUiDialog().get(requester = this).contextLoginAuth()
        val action = accessor.action()
        Surface(color = ThemeColors.Data.blackOverlay) {
            Box(
                Modifier
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
                        painter = painterResource(id = com.tezov.bank.R.drawable.ic_close_24dp),
                        contentDescription = null,
                        tint = MaterialTheme.colorsCommonExtended.onPrimaryLight,
                    )
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Saisissez votre code secret pour\naccéder à vos comptes",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typographyExtended.textBig//.copy(fontSize = PageLoginTheme.dimensions.textHuge),
//                        color = PageLoginTheme.colors.textContent
                    )

                    ContentBoxLogin(modifier = Modifier){

                    }

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = MaterialTheme.dimensionsPaddingExtended.elementBig_v),
                        onClick = { },
//                        shape = PageLoginTheme.shapes.button,
                        colors = ButtonDefaults.buttonColors(
//                            backgroundColor = PageLoginTheme.colors.backgroundButtonDark,
                            disabledBackgroundColor = MaterialTheme.colorsResource.grayLight
                        ),
                        enabled = true
                    ) {
                        Text(
                            "Se connecter",
                            style = MaterialTheme.typographyExtended.textButton
//                                .copy(fontSize = PageLoginTheme.dimensions.textButton),
//                            color = PageLoginTheme.colors.textButtonDark,
//                            modifier = Modifier
//                                .padding(
//                                    horizontal = PageLoginTheme.dimensions.paddingHorizontalButton,
//                                    vertical = PageLoginTheme.dimensions.paddingVerticalButton
//                                )
                        )
                    }
                    ContentBoxForgotten(modifier = Modifier) {

                    }
                }
            }
        }

    }

    @Composable
    private fun ContentBoxLogin(
        modifier: Modifier = Modifier,
        onClick: (resourceId: Int) -> Unit
    ) {
        Box(modifier = modifier.fillMaxWidth().height(240.dp).background(Color.Cyan))
    }

    @Composable
    private fun ContentBoxForgotten(
        modifier: Modifier = Modifier,
        onClick: (resourceId: Int) -> Unit
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    horizontal = MaterialTheme.dimensionsPaddingExtended.elementBig_h,
                    vertical = MaterialTheme.dimensionsPaddingExtended.elementBig_v
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ClickableText(
                text = AnnotatedString("Mon n°client ?"),
                style = MaterialTheme.typographyExtended.textLink
            ) {
                onClick(0)
            }
            ClickableText(
                text = AnnotatedString("Code secret oublié ?"),
                style = MaterialTheme.typographyExtended.textLink
            ) {
                onClick(1)
            }
        }
    }

}