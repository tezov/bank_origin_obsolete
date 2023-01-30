package com.tezov.bank.ui.page.help_and_service

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.tezov.bank.R
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
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
                            contentDescription = stringResource(id = R.string.pg_h_and_s_icon_close),
                            tint = PageHelpAndServiceTheme.colors.onBackgroundLight,
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    contentHelpAndService(state.helpAndServices) { index ->

                    }
                    Spacer(modifier = Modifier.height(MaterialTheme.dimensionsSpacingExtended.normal_v))
                    contentContact(state.contacts) { index ->

                    }
                    contentLegalNotice(state.notices) { index ->

                    }
                }
            }
        }
    }

    @Composable
    private fun contentHelpAndService(
        datas: List<Pair<String, Int>>,
        onClick: (Int) -> Unit
    ) {
        if(datas.isEmpty()){
            return
        }
        Column(
            modifier = Modifier
                .padding(
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                    horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                )
        ) {
            Text(
                modifier = Modifier.wrapContentSize(),
                text = stringResource(id = R.string.pg_h_and_s_title_help_and_service),
                style = PageHelpAndServiceTheme.typographies.titleBig
            )
            Spacer(modifier = Modifier.height(MaterialTheme.dimensionsSpacingExtended.normal_v))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_h),
            ) {
                val end = (datas.size % 2).takeIf { it == 0 } ?: let { datas.size - 1 }
                for (i in 0 until end step 2) {
                    val startData = datas[i]
                    val endData = datas[i + 1]
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
                            iconResourceId = startData.second,
                            onClick = { onClick(i) }
                        )
                        CardSmall(
                            modifier = Modifier
                                .wrapContentHeight()
                                .weight(1f),
                            text = endData.first,
                            iconResourceId = endData.second,
                            onClick = { onClick(i+1) }
                        )
                    }
                }
                if (end != datas.size) {
                    val data = datas.last()
                    CardLarge(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        text = data.first,
                        iconResourceId = data.second,
                        onClick = { onClick(datas.size-1) }
                    )
                }
            }
        }
    }

    @Composable
    private fun CardSmall(
        modifier: Modifier,
        text: String,
        iconResourceId: Int,
        onClick: () -> Unit
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
            modifier = modifier.clickable {
                onClick()
            },
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
        iconResourceId: Int,
        onClick: () -> Unit
    ) {
        Surface(
            modifier = modifier.clickable { onClick() },
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
        datas: List<Pair<String, Int>>,
        onClick: (Int) -> Unit
    ) {
        if(datas.isEmpty()){
            return
        }
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
                    text = stringResource(id = R.string.pg_h_and_s_section_contact),
                    style = PageHelpAndServiceTheme.typographies.titleNormal
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_h),
            ) {
                datas.forEachIndexed { index, data ->
                    RowWithStartIcon(
                        text = data.first,
                        iconResourceId = data.second,
                        onClick = { onClick(index) }
                    )
                }
            }
        }
    }

    @Composable
    private fun RowWithStartIcon(
        text: String,
        iconResourceId: Int,
        onClick: () -> Unit
    ) {
        Row(
            modifier = Modifier
                .clickable { onClick() }
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
        datas: List<String>,
        onClick: (Int) -> Unit
    ) {
        if(datas.isEmpty()){
            return
        }
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
                    text = stringResource(id = R.string.pg_h_and_s_section_notice),
                    style = PageHelpAndServiceTheme.typographies.titleNormal
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_h),
            ) {
                datas.forEachIndexed{ index, data ->
                    RowNormal(data){
                        onClick(index)
                    }
                }
            }
        }
    }

    @Composable
    private fun RowNormal(
        text: String,
        onClick: () -> Unit
    ) {
        Row(
            modifier = Modifier
                .clickable {
                    onClick
                }
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