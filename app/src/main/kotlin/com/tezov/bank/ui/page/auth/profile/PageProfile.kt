/*
 *  *********************************************************************************
 *  Created by Tezov on 08/02/2023 21:11
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/02/2023 21:10
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.profile

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tezov.bank.R
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.branch.provides
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.bank.ui.component.leaf.provides
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsSpacingExtended

object PageProfile : Page<PageProfileState, PageProfileAction> {

    @Composable
    override fun Page<PageProfileState, PageProfileAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextProfile()
        val action = accessor.action()
        val state = accessor.state()


        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PageProfileTheme provides PageProfileTheme.provideColors(),
                PageProfileTheme provides PageProfileTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    PageProfileTheme provides PageProfileTheme.provideShapes(),
                    PageProfileTheme provides PageProfileTheme.provideBorders(),
                    PageProfileTheme provides PageProfileTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    ActionRow provides PageProfileTheme.provideActionRowStyle(),
                    SectionActionRow provides PageProfileTheme.provideSectionRowStyle(),
                )
            }
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(PageProfileTheme.colors.background)
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            ) {
                contentHeader(state.header)
                Spacer(modifier = Modifier.height(MaterialTheme.dimensionsSpacingExtended.normal_v))
                state.profils.value?.let {
                    SectionActionRow(data = it) {


                    }
                }
                state.documents.value?.let {
                    SectionActionRow(data = it) {


                    }
                }
                state.offers.value?.let {
                    SectionActionRow(data = it) {


                    }
                }
                state.helps.value?.let {
                    SectionActionRow(data = it) {


                    }
                }
            }
        }
    }

    @Composable
    private fun contentHeader(
        header: PageProfileState.Header
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            IconButton(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.End),
                onClick = {

                }) {
                Icon(
                    modifier = Modifier.size(48.dp),
                    painter = painterResource(id = R.drawable.ic_close_24dp),
                    contentDescription = null,
                    tint = Color.Blue,
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.width(MaterialTheme.dimensionsSpacingExtended.normal_v))
                Image(
                    modifier = Modifier
                        .size(84.dp)
                        .clip(CircleShape)
                        .border(
                            BorderStroke(3.dp, SolidColor(Color.Blue)),
                            CircleShape
                        ),
                    painter = painterResource(id = R.drawable.img_suitcase_blue),
                    contentScale = ContentScale.Crop,
                    contentDescription = stringResource(id = R.string.pg_login_img_suit_case)
                )
                header.name.value?.let {
                    Spacer(modifier = Modifier.width(MaterialTheme.dimensionsSpacingExtended.big_h))
                    Text(
                        modifier = Modifier
                            .align(Alignment.Top),
                        text = it,
                        style = PageProfileTheme.typographies.title
                    )
                }
            }

        }


    }

    @Composable
    override fun handleOnBackPressed() = DialogAuthCloseAppController.handleOnBackPressed()

}