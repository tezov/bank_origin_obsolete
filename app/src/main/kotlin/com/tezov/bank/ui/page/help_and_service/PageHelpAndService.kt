package com.tezov.bank.ui.page.help_and_service

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.dialog.login.auth.DialogLoginAuthTheme
import com.tezov.bank.ui.dialog.login.auth.colors
import com.tezov.bank.ui.dialog.login.auth.dimensions
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.theme.definition.colorsCommonExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.colorsCommonResource
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsSpacingExtended
import com.tezov.lib_core_android_kotlin.ui.util.ExtensionCompositionLocal

object PageHelpAndService : Page<PageHelpAndServiceState, PageHelpAndServiceAction> {

    @Composable
    override fun Page<PageHelpAndServiceState, PageHelpAndServiceAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextHelpAndService()
        val state = accessor.state()
        val action = accessor.action()
        ExtensionCompositionLocal.CompositionLocalProvider(
            parent = arrayOf(
                PageHelpAndServiceTheme provides PageHelpAndServiceTheme.provideColors(),
                PageHelpAndServiceTheme provides PageHelpAndServiceTheme.provideDimensions(),
            ),
            child = {
                arrayOf(
                    PageHelpAndServiceTheme provides PageHelpAndServiceTheme.provideShapes(),
                    PageHelpAndServiceTheme provides PageHelpAndServiceTheme.provideBorders(),
                    PageHelpAndServiceTheme provides PageHelpAndServiceTheme.provideTypographies(),
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(PageHelpAndServiceTheme.colors.background)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(PageHelpAndServiceTheme.colors.backgroundSection)
                ) {
                    IconButton(
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.TopStart),
                        onClick = { action.close() }) {
                        Icon(
                            modifier = Modifier.size(PageHelpAndServiceTheme.dimensions.iconCloseSize),
                            painter = painterResource(id = R.drawable.ic_close_24dp),
                            contentDescription = null,
                            tint = PageHelpAndServiceTheme.colors.onBackgroundLight,
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    contentHelpAndService {

                    }
                    Spacer(modifier = Modifier.height(MaterialTheme.dimensionsSpacingExtended.normal_v))
                    contentContact {

                    }
                    contentLegalNotice {

                    }
                }
            }
        }
    }

    @Composable
    private fun contentHelpAndService(
        onClick: (Int) -> Unit
    ) {
        val itemsData = listOf(
            Pair("Opposer une carte", com.tezov.bank.R.drawable.ic_crisis_24dp),
            Pair("Contester un prélèvement", com.tezov.bank.R.drawable.ic_argue_24dp),
            Pair("Suivre mon dossier", com.tezov.bank.R.drawable.ic_checklist_24dp),
            Pair("Trouver un distributeur", com.tezov.bank.R.drawable.ic_euro_24dp),
            Pair("Retirer à l'étranger", com.tezov.bank.R.drawable.ic_explore_24dp),
            Pair("Découvrir l'application", com.tezov.bank.R.drawable.ic_search_24dp),
            Pair("Accéder à l'assitance technique", com.tezov.bank.R.drawable.ic_help_24dp),
        )

        Column(
            modifier = Modifier
                .padding(
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                    horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                )
        ) {
            Text(
                modifier = Modifier.wrapContentSize(),
                text = "Aide & services",
                style = PageHelpAndServiceTheme.typographies.titleBig
            )
            Spacer(modifier = Modifier.height(MaterialTheme.dimensionsSpacingExtended.normal_v))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_h),
            ) {
                val end = (itemsData.size % 2).takeIf { it == 0 } ?: let { itemsData.size - 1 }
                for (i in 0 until end step 2) {
                    val startData = itemsData[i]
                    val endData = itemsData[i + 1]
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_v),
                    ) {
                        CardSmall(
                            modifier = Modifier
                                .wrapContentHeight()
                                .weight(1f),
                            text = startData.first,
                            iconResourceId = startData.second
                        )
                        CardSmall(
                            modifier = Modifier
                                .wrapContentHeight()
                                .weight(1f),
                            text = endData.first,
                            iconResourceId = endData.second
                        )
                    }
                }
                if (end != itemsData.size) {
                    val data = itemsData.last()
                    CardLarge(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        text = data.first,
                        iconResourceId = data.second
                    )
                }
            }
        }
    }

    @Composable
    private fun CardSmall(
        modifier: Modifier,
        text: String,
        iconResourceId: Int
    ) {
        val iconSize = PageHelpAndServiceTheme.dimensions.iconCardSize
        val ID_ICON = "icon"
        val ID_TEXT = "text"
        val constraintSet = ConstraintSet {
            val refIcon = createRefFor(ID_ICON)
            val refText = createRefFor(ID_TEXT)
            constrain(refIcon) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                width = Dimension.value(iconSize)
                height = Dimension.value(iconSize)
            }
            constrain(refText) {
                top.linkTo(refIcon.bottom)
                start.linkTo(parent.start)
                end.linkTo(refIcon.start)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
        }
        Surface(
            modifier = modifier,
            color = MaterialTheme.colorsCommonResource.transparent,
            shape = PageHelpAndServiceTheme.shapes.card,
            border = PageHelpAndServiceTheme.borders.card,
        ) {
            ConstraintLayout(
                constraintSet = constraintSet,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(
                        vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                        horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                    ),
            ) {
                Icon(
                    modifier = Modifier.layoutId(ID_ICON),
                    painter = painterResource(id = iconResourceId),
                    tint = PageHelpAndServiceTheme.colors.onBackgroundLight,
                    contentDescription = text,
                )
                Text(
                    modifier = Modifier.layoutId(ID_TEXT),
                    text = text,
                    style = PageHelpAndServiceTheme.typographies.text,
                    overflow = TextOverflow.Visible
                )
            }

        }
    }

    @Composable
    private fun CardLarge(
        modifier: Modifier,
        text: String,
        iconResourceId: Int
    ) {
        Surface(
            modifier = modifier,
            color = MaterialTheme.colorsCommonResource.transparent,
            shape = PageHelpAndServiceTheme.shapes.card,
            border = PageHelpAndServiceTheme.borders.card
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(
                        vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                        horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                    ),
            ) {
                Text(
                    modifier = Modifier
                        .wrapContentHeight()
                        .weight(1f)
                        .align(Alignment.Bottom),
                    text = text,
                    style = PageHelpAndServiceTheme.typographies.text
                )
                Icon(
                    modifier = Modifier
                        .size(PageHelpAndServiceTheme.dimensions.iconCardSize),
                    painter = painterResource(id = iconResourceId),
                    tint = PageHelpAndServiceTheme.colors.onBackgroundLight,
                    contentDescription = text,
                )
            }
        }
    }


    @Composable
    private fun contentContact(
        onClick: (Int) -> Unit
    ) {
        val itemsData = listOf(
            Pair("Appeler", R.drawable.ic_call_24dp),
            Pair("Service sourds et malentendats", R.drawable.ic_hearing_disabled_24dp),
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                color = PageHelpAndServiceTheme.colors.backgroundSection
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = MaterialTheme.dimensionsPaddingExtended.elementNormal_v)
                        .wrapContentSize(),
                    text = "CONTACTER LA HELLO TEAM",
                    style = PageHelpAndServiceTheme.typographies.titleNormal
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_h),
            ) {
                itemsData.forEach { data ->
                    RowWithStartIcon(
                        text = data.first,
                        iconResourceId = data.second
                    )
                }
            }
        }
    }

    @Composable
    private fun RowWithStartIcon(
        text: String,
        iconResourceId: Int
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                    horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(PageHelpAndServiceTheme.dimensions.iconRowSize),
                painter = painterResource(id = iconResourceId),
                tint = PageHelpAndServiceTheme.colors.onBackgroundLight,
                contentDescription = text,
            )
            Spacer(modifier = Modifier.width(MaterialTheme.dimensionsSpacingExtended.normal_h))
            Text(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f),
                text = text,
                style = PageHelpAndServiceTheme.typographies.text
            )
            Icon(
                modifier = Modifier
                    .size(PageHelpAndServiceTheme.dimensions.iconChevronSize),
                painter = painterResource(id = R.drawable.ic_arrow_cut_right_24dp),
                tint = PageHelpAndServiceTheme.colors.onBackgroundLight,
                contentDescription = text,
            )
        }
    }

    @Composable
    private fun contentLegalNotice(
        onClick: (Int) -> Unit
    ) {
        val itemsData = listOf(
            "Mentions légales",
            "Mentions légales Bourse",
            "Politique des cookies",
            "Paramètres des cookies",
            "A propos de l'accessibilité",
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                color = PageHelpAndServiceTheme.colors.backgroundSection
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = MaterialTheme.dimensionsPaddingExtended.elementNormal_v)
                        .wrapContentSize(),
                    text = "MENTION LEGALES",
                    style = PageHelpAndServiceTheme.typographies.titleNormal
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_h),
            ) {
                itemsData.forEach { data ->
                    RowNormal(data)
                }
            }
        }
    }

    @Composable
    private fun RowNormal(
        text: String,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                    horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f),
                text = text,
                style = PageHelpAndServiceTheme.typographies.text
            )
            Icon(
                modifier = Modifier
                    .size(PageHelpAndServiceTheme.dimensions.iconChevronSize),
                painter = painterResource(id = R.drawable.ic_arrow_cut_right_24dp),
                tint = PageHelpAndServiceTheme.colors.onBackgroundLight,
                contentDescription = text,
            )
        }
    }

}