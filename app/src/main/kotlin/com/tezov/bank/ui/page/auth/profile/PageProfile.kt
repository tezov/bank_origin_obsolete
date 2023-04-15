/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:51
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.tezov.bank.R
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Image
import com.tezov.lib_core_android_kotlin.ui.component.plain.Text
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.theme.style.padding
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended

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
                Spacer(modifier = Modifier.height(MaterialTheme.dimensionsPaddingExtended.element.huge.vertical))
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
                .padding(MaterialTheme.dimensionsPaddingExtended.page.big)
        ) {
            IconButton(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.End),
                onClick = {

                }) {
                Icon.StateColor(
                    style = PageProfileTheme.styles.iconLogOut,
                    resourceId = R.drawable.ic_logout_24dp,
                    description = stringResource(id = R.string.pg_profile_icon_close),
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                header.imageResourceId.value?.let {
                    Image.StateColor(
                        style = PageProfileTheme.styles.iconUser,
                        resourceId = it,
                        description = stringResource(id = R.string.pg_profile_icon_use)
                    )
                }
                header.name.value?.let {
                    Text.StateColor(
                        modifier = Modifier
                            .align(Alignment.Top)
                            .padding(start = MaterialTheme.dimensionsPaddingExtended.element.huge.horizontal),
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