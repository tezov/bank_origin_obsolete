package com.tezov.bank.ui.page.login

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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.theme.ThemeColors
import com.tezov.bank.ui_composable.Swiper
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.util.ExtensionCompositionLocal

@OptIn(ExperimentalComposeUiApi::class)
object PageLogin : Page<PageLoginState, PageLoginAction> {

    @Composable
    override fun Page<PageLoginState, PageLoginAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextLogin()
        val state = accessor.state()
        val action = accessor.action()
        state.animationState.updateTransition()
        ExtensionCompositionLocal.CompositionLocalProvider(
            parent = arrayOf(
                PageLoginTheme.localColors provides PageLoginTheme.provideColors(),
                PageLoginTheme.localDimensions provides PageLoginTheme.provideDimensions(),
                PageLoginTheme.localShapes provides PageLoginTheme.provideShapes(),
            ),
            child = {
                arrayOf(
                    ThemeWidgetExtended.localSwiperPager provides PageLoginTheme.provideSwiperPagerStyle()
                )
            }
        ) {
            contentLoading(state, action, innerPadding)
            contentLoaded(state, action, innerPadding)
        }
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
                        .size(PageLoginTheme.dimensions.logoSize),
                    painter = painterResource(id = R.drawable.logo_tezov_bank_inverse),
                    contentDescription = "bank logo"
                )
            }

            Image(
                modifier = Modifier
                    .size(PageLoginTheme.dimensions.iconBigSize)
                    .clip(CircleShape)
                    .border(
                        PageLoginTheme.dimensions.strokeIcon,
                        PageLoginTheme.colors.backgroundButtonLight,
                        CircleShape
                    ),
                painter = painterResource(id = R.drawable.img_suitcase_blue),
                contentScale = ContentScale.Crop,
                contentDescription = "suit case"
            )

            Spacer(modifier = Modifier.width(PageLoginTheme.dimensions.paddingStartToIconBig))

            Image(
                modifier = Modifier
                    .size(PageLoginTheme.dimensions.iconMediumSize)
                    .clip(CircleShape)
                    .background(PageLoginTheme.colors.backgroundButtonLight),
                painter = painterResource(id = R.drawable.ic_add_24dp),
                colorFilter = ColorFilter.tint(PageLoginTheme.colors.background),
                contentDescription = "add account"
            )

            Spacer(modifier = Modifier.width(PageLoginTheme.dimensions.paddingStartToIconMedium))

            Image(
                modifier = Modifier
                    .size(PageLoginTheme.dimensions.iconSmallSize)
                    .clip(CircleShape)
                    .background(PageLoginTheme.colors.backgroundButtonDark),
                painter = painterResource(id = R.drawable.ic_3dot_v_24dp),
                colorFilter = ColorFilter.tint(PageLoginTheme.colors.backgroundButtonLight),
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
                        style = MaterialTheme.typographyExtended.textHuge.copy(fontSize = PageLoginTheme.dimensions.textHuge),
                        color = PageLoginTheme.colors.textContent
                    )
                    Spacer(modifier = Modifier.height(PageLoginTheme.dimensions.paddingTopToTextHuge))
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Balayer l'écran vers la gauche\npour afficher votre solde.",
                        style = MaterialTheme.typographyExtended.textNormal.copy(
                            fontSize = PageLoginTheme.dimensions.textNormal,
                            fontWeight = FontWeight.Bold
                        ),
                        color = PageLoginTheme.colors.textContent
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
                            style = MaterialTheme.typographyExtended.textHuge.copy(fontSize = PageLoginTheme.dimensions.textHuge),
                            color = PageLoginTheme.colors.textContent
                        )
                        Spacer(modifier = Modifier.height(PageLoginTheme.dimensions.paddingTopToTextHuge))
                        OutlinedButton(
                            onClick = { },
                            border = BorderStroke(
                                PageLoginTheme.dimensions.strokeButton,
                                PageLoginTheme.colors.textContent
                            ),
                            shape = PageLoginTheme.shapes.buttonOutline,
                            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
                            enabled = true
                        ) {
                            Text(
                                "Activer le solde",
                                style = MaterialTheme.typographyExtended.textButton.copy(fontWeight = FontWeight.Bold),
                                color = PageLoginTheme.colors.textContent,
                                modifier = Modifier
                                    .padding(
                                        horizontal = PageLoginTheme.dimensions.paddingHorizontalButtonOutlined,
                                        vertical = PageLoginTheme.dimensions.paddingVerticalButtonOutlined
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
                shape = PageLoginTheme.shapes.button,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = PageLoginTheme.colors.backgroundButtonDark,
                    disabledBackgroundColor = MaterialTheme.colorsResource.grayLight
                ),
                enabled = true
            ) {
                Text(
                    "Accéder à mes comptes",
                    style = MaterialTheme.typographyExtended.textButton
                        .copy(fontSize = PageLoginTheme.dimensions.textButton),
                    color = PageLoginTheme.colors.textButtonDark,
                    modifier = Modifier
                        .padding(
                            horizontal = PageLoginTheme.dimensions.paddingHorizontalButton,
                            vertical = PageLoginTheme.dimensions.paddingVerticalButton
                        )
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.elementNormal_v)
                    .border(
                        1.dp,
                        ThemeColors.Data.whiteDark,
                        PageLoginTheme.shapes.button
                    ),
                onClick = { },
                shape = PageLoginTheme.shapes.button,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = PageLoginTheme.colors.backgroundButtonLight,
                    disabledBackgroundColor = MaterialTheme.colorsResource.grayLight
                ),
                enabled = true
            ) {
                Text(
                    "Envoyer de l'argent avec paylib",
                    style = MaterialTheme.typographyExtended.textButton.copy(fontSize = PageLoginTheme.dimensions.textButton),
                    color = PageLoginTheme.colors.textButtonLight,
                    modifier = Modifier
                        .padding(
                            horizontal = PageLoginTheme.dimensions.paddingHorizontalButton,
                            vertical = PageLoginTheme.dimensions.paddingVerticalButton
                        )
                )
            }

            Spacer(modifier = Modifier.height(PageLoginTheme.dimensions.paddingTopFromLinkService))

            ClickableText(
                text = AnnotatedString("Aide et Services"),
                style = MaterialTheme.typographyExtended.textLink.copy(
                    fontSize = PageLoginTheme.dimensions.textLink,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorsCommonExtended.onPrimaryLight
                )
            ) {


            }

        }

    }


}