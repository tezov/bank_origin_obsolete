/*
 *  *********************************************************************************
 *  Created by Tezov on 05/02/2023 13:38
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/02/2023 13:33
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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.branch.provides
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.bank.ui.component.leaf.provides
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.page.auth.help.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
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
                    .verticalScroll(rememberScrollState())
            ) {
                contentHeader(state.header)
                state.profils.value?.let {
                    SectionActionRow(data = it){


                    }
                }
                state.documents.value?.let {
                    SectionActionRow(data = it){


                    }
                }
                state.offers.value?.let {
                    SectionActionRow(data = it){


                    }
                }
                state.helps.value?.let {
                    SectionActionRow(data = it){


                    }
                }
            }
        }
    }

    @Composable
    private fun contentHeader(
        header: PageProfileState.Header
    ) {

    }


}