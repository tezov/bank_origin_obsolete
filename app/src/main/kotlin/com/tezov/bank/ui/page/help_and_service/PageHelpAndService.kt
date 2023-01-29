package com.tezov.bank.ui.page.help_and_service

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.dialog.login.auth.DialogLoginAuthTheme
import com.tezov.bank.ui.dialog.login.auth.colors
import com.tezov.bank.ui.dialog.login.auth.dimensions
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
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
                IconButton(
                    modifier = Modifier.wrapContentSize(),
                    onClick = { }) {
                    Icon(
                        modifier = Modifier.size(PageHelpAndServiceTheme.dimensions.iconCloseSize),
                        painter = painterResource(id = R.drawable.ic_close_24dp),
                        contentDescription = null,
                        tint = PageHelpAndServiceTheme.colors.onBackgroundLight,
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
//                    .verticalScroll(rememberScrollState())
                ) {

                    contentHelpAndService {

                    }
                    Spacer(modifier = Modifier.height(MaterialTheme.dimensionsSpacingExtended.big_v))
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
        val itemsData = mutableListOf(
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
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_h),
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_v),
            ) {
                val lastOddItem = (itemsData.size % 2).takeIf { it == 1 }?.let {
                    itemsData.removeLast()
                }
                this.items(itemsData) { data ->
                    CardSmall(
                        text = data.first,
                        iconResourceId = data.second
                    )
                }
                lastOddItem?.let { data ->
                    item(
                        span = {
                            GridItemSpan(maxLineSpan)
                        }
                    ) {
                        CardLarge(
                            text = data.first,
                            iconResourceId = data.second
                        )
                    }
                }
            }

        }
    }

    @Composable
    private fun CardSmall(
        text: String,
        iconResourceId: Int
    ) {
        val ID_ICON = "icon"
        val ID_TEXT = "text"
        val constraintSet = ConstraintSet {
            val refIcon = createRefFor(ID_ICON)
            val refText = createRefFor(ID_TEXT)
            constrain(refIcon) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }
            constrain(refText) {
                top.linkTo(refIcon.bottom)
                start.linkTo(parent.start)
                end.linkTo(refIcon.start)
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = PageHelpAndServiceTheme.shapes.card,
            border = PageHelpAndServiceTheme.borders.card
        ) {
            ConstraintLayout(
                constraintSet = constraintSet,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                        horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                    ),
            ) {
                Icon(
                    modifier = Modifier
                        .layoutId(ID_ICON)
                        .size(PageHelpAndServiceTheme.dimensions.iconCardSize),
                    painter = painterResource(id = iconResourceId),
                    tint = PageHelpAndServiceTheme.colors.onBackgroundLight,
                    contentDescription = text,
                )
                Text(
                    modifier = Modifier.layoutId(ID_TEXT),
                    text = text,
                    style = PageHelpAndServiceTheme.typographies.text
                )
            }
        }
    }

    @Composable
    private fun CardLarge(
        text: String,
        iconResourceId: Int
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = PageHelpAndServiceTheme.shapes.card,
            border = PageHelpAndServiceTheme.borders.card
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
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
        val itemsData = mutableListOf(
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
                    .wrapContentHeight()
                    .background(PageHelpAndServiceTheme.colors.backgroundSection)
                    .align(Alignment.Start)
            ) {
                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = "CONTACTER LA HELLO TEAM",
                    style = PageHelpAndServiceTheme.typographies.titleNormal
                )
            }
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                columns = GridCells.Fixed(1),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_h),
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_v),
            ) {
                this.items(itemsData) { data ->
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
        val itemsData = mutableListOf(
            "Mentions légales",
            "Mentions légales Bourse",
            "Politique des cookies",
            "Paramètres des cookies",
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(PageHelpAndServiceTheme.colors.backgroundSection)
                    .align(Alignment.Start)
            ) {
                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = "MENTION LEGALES",
                    style = PageHelpAndServiceTheme.typographies.titleNormal
                )
            }
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                columns = GridCells.Fixed(1),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_h),
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_v),
            ) {
                this.items(itemsData) { data ->
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