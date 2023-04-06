/*
 *  *********************************************************************************
 *  Created by Tezov on 06/04/2023 23:14
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/04/2023 23:14
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.tezov.bank.R
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsCommonExtended

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
                    PageProfileTheme provides PageProfileTheme.provideBorders(),
                    PageProfileTheme provides PageProfileTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PageProfileTheme provides PageProfileTheme.provideStyles(),
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
                Spacer(modifier = Modifier.height(MaterialTheme.dimensionsCommonExtended.normal_v))
                state.profils.value?.let {
                    SectionActionRow(data = it, style = PageProfileTheme.styles.sectionRow) {


                    }
                }
                state.documents.value?.let {
                    SectionActionRow(data = it, style = PageProfileTheme.styles.sectionRow) {


                    }
                }
                state.offers.value?.let {
                    SectionActionRow(data = it, style = PageProfileTheme.styles.sectionRow) {


                    }
                }
                state.helps.value?.let {
                    SectionActionRow(data = it, style = PageProfileTheme.styles.sectionRow) {


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
                    modifier = Modifier.size(PageProfileTheme.dimensions.iconCloseSize),
                    painter = painterResource(id = R.drawable.ic_logout_24dp),
                    contentDescription = stringResource(id = R.string.pg_profile_icon_close),
                    tint = PageProfileTheme.colors.iconLogout
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                header.imageResourceId.value?.let {
                    Spacer(modifier = Modifier.width(MaterialTheme.dimensionsCommonExtended.normal_v))
                    Image(
                        modifier = Modifier
                            .size(PageProfileTheme.dimensions.iconUserSize)
                            .clip(CircleShape)
                            .border(
                                PageProfileTheme.borders.iconUser,
                                CircleShape
                            ),
                        painter = painterResource(id = it),
                        contentScale = ContentScale.Crop,
                        contentDescription = stringResource(id = R.string.pg_profile_icon_use)
                    )
                }
                header.name.value?.let {
                    Spacer(modifier = Modifier.width(MaterialTheme.dimensionsCommonExtended.big_h))
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