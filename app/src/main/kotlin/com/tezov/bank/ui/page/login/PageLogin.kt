package com.tezov.bank.ui.page.help_and_service

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
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
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockBig_v,
                    horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
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

            Box(modifier = Modifier.weight(1f)){
                Image(
                    modifier = Modifier
                        .size(64.dp),
                    painter = painterResource(id = R.drawable.logo_tezov_bank),
                    contentDescription = "bank logo"
                )
            }

            Image(
                modifier = Modifier.size(32.dp),
                painter = painterResource(id = R.drawable.ic_add_round_24dp),
                contentDescription = "add account"
            )

            Image(
                modifier = Modifier.size(32.dp),
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

                    Text(text = "M. Zollver")
                    Text(text = "Balayer l'écran vers la gauche pour afficher votre solde.")


                }
            },
                {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Accédez à votre solde en un coups d'oeil")
                    }
                }),
            pageSelected = 0,
            onPageChange = {
                Log.d(">>:", "ContentBody: $it")

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
                modifier = Modifier.fillMaxWidth().padding(top = MaterialTheme.dimensionsPaddingExtended.elementNormal_v),
                onClick = { },
                shape = MaterialTheme.shapeCommonExtended.buttonSmall,
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
                modifier = Modifier.fillMaxWidth().padding(top = MaterialTheme.dimensionsPaddingExtended.elementNormal_v),
                onClick = { },
                shape = MaterialTheme.shapeCommonExtended.buttonSmall,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colorsCommonExtended.backgroundButtonCancel,
                    disabledBackgroundColor = MaterialTheme.colorsResource.grayLight
                ),
                enabled = true
            ) {
                Text(
                    "Envoyer de l'argent avec paylib",
                    style = MaterialTheme.typographyExtended.textButton,
                    color = MaterialTheme.colorsCommonExtended.onBackgroundButtonCancel,
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
                style = MaterialTheme.typographyExtended.textLink
            ) {


            }

        }

    }


}