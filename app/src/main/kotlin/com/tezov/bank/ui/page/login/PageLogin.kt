package com.tezov.bank.ui.page.help_and_service

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.page.login.PageLoginAction
import com.tezov.bank.ui.page.login.PageLoginState
import com.tezov.bank.ui_composable.Swiper
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page

@OptIn(ExperimentalComposeUiApi::class)
object PageLogin : Page<PageLoginState, PageLoginAction> {
    val SIZE_ICON_LOGIN = 32.dp

    @Composable
    override fun Page<PageLoginState, PageLoginAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextLogin()
        val state = accessor.state()
        val action = accessor.action()
        state.animationState.updateTransition()
        contentLoading(state, action, innerPadding)
        contentLoaded(state, action, innerPadding)
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
                .background(MaterialTheme.colors.primary)
                .padding(
                    top = MaterialTheme.dimensionsPaddingExtended.blockBig_v,
                    bottom = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                    start = MaterialTheme.dimensionsPaddingExtended.blockBig_h,
                    end = MaterialTheme.dimensionsPaddingExtended.blockBig_h
                )
        ) {
            ContentHeader(
                Modifier
                    .fillMaxWidth()
            )
            ContentBody(
                Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
            ContentFooter(
                Modifier
                    .fillMaxWidth()
            )
        }
    }

    @Composable
    private fun ContentHeader(
        modifier: Modifier,
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(modifier = Modifier.weight(1f)) {
                Image(
                    modifier = Modifier
                        .size(64.dp),
                    painter = painterResource(id = R.drawable.logo_tezov_bank_inverse),
                    contentDescription = "bank logo"
                )
            }

            Image(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colorsCommonExtended.onPrimaryLight, CircleShape),
                painter = painterResource(id = R.drawable.img_suitcase_blue),
                contentScale = ContentScale.Crop,
                contentDescription = "suit case"
            )

            Spacer(modifier = Modifier.width(12.dp))

            Image(
                modifier = Modifier.size(48.dp),
                painter = painterResource(id = R.drawable.ic_add_round_24dp),
                contentDescription = "add account"
            )

            Spacer(modifier = Modifier.width(6.dp))

            Image(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colors.secondary, CircleShape)
                    .background(MaterialTheme.colors.secondary),
                painter = painterResource(id = R.drawable.ic_3dot_v_24dp),
                contentDescription = "more action"
            )


        }
    }

    @Composable
    private fun ContentBody(
        modifier: Modifier,
    ) {
        Swiper.Pager(
            modifier = modifier,
            pages = arrayListOf({
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "M. ZOLLVER",
                        style = MaterialTheme.typographyExtended.textHuge,
                        color = MaterialTheme.colorsCommonExtended.onPrimaryLight
                    )
                    Spacer(modifier = Modifier.height(22.dp))
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Balayer l'écran vers la gauche\npour afficher votre solde.",
                        style = MaterialTheme.typographyExtended.textNormal.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = MaterialTheme.colorsCommonExtended.onPrimaryLight
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
                            textAlign = TextAlign.Center,
                            text = "Accédez à votre solde\nen un coups d'oeil",
                            style = MaterialTheme.typographyExtended.textHuge,
                            color = MaterialTheme.colorsCommonExtended.onPrimaryLight
                        )
                        Spacer(modifier = Modifier.height(22.dp))
                        OutlinedButton(
                            modifier = Modifier
                                .padding(top = MaterialTheme.dimensionsPaddingExtended.elementNormal_v),
                            onClick = { },
                            border = BorderStroke(
                                2.dp,
                                MaterialTheme.colorsCommonExtended.onPrimaryLight
                            ),
                            shape = MaterialTheme.shapeCommonExtended.buttonBig,
                            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
                            enabled = true
                        ) {
                            Text(
                                "Activer le solde",
                                style = MaterialTheme.typographyExtended.textButton,
                                color = MaterialTheme.colorsCommonExtended.onPrimaryLight,
                                modifier = Modifier
                                    .padding(
                                        horizontal = 32.dp,
                                        vertical = MaterialTheme.dimensionsPaddingExtended.buttonNormal_v
                                    )
                            )
                        }
                    }
                }),
            pageSelected = 0,
            onPageChange = {


            })
    }

    @Composable
    private fun ContentFooter(
        modifier: Modifier,
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.elementBig_v),
                onClick = { },
                shape = MaterialTheme.shapeCommonExtended.buttonBig,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colorsCommonExtended.backgroundButtonConfirm,
                    disabledBackgroundColor = MaterialTheme.colorsResource.grayLight
                ),
                enabled = true
            ) {
                Text(
                    "Accéder à mes comptes",
                    style = MaterialTheme.typographyExtended.textButton,
                    color = MaterialTheme.colorsCommonExtended.onBackgroundButtonConfirm,
                    modifier = Modifier
                        .padding(
                            horizontal = MaterialTheme.dimensionsPaddingExtended.buttonNormal_h,
                            vertical = MaterialTheme.dimensionsPaddingExtended.buttonNormal_v
                        )
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.elementNormal_v),
                onClick = { },
                shape = MaterialTheme.shapeCommonExtended.buttonBig,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colorsCommonExtended.backgroundButtonProceed,
                    disabledBackgroundColor = MaterialTheme.colorsResource.grayLight
                ),
                enabled = true
            ) {
                Text(
                    "Envoyer de l'argent avec paylib",
                    style = MaterialTheme.typographyExtended.textButton,
                    color = MaterialTheme.colorsCommonExtended.onBackgroundButtonProceed,
                    modifier = Modifier
                        .padding(
                            horizontal = MaterialTheme.dimensionsPaddingExtended.buttonNormal_h,
                            vertical = MaterialTheme.dimensionsPaddingExtended.buttonNormal_v
                        )
                )
            }

            Spacer(modifier = Modifier.height(60.dp))

            ClickableText(
                text = AnnotatedString("Aide et Services"),
                style = MaterialTheme.typographyExtended.textLink.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorsCommonExtended.onPrimaryLight
                )
            ) {


            }

        }

    }


}