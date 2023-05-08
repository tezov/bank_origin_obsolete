/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 15:29
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 14:49
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.dialog.auth.closeAppConfirmation

import androidx.compose.runtime.Composable
import com.tezov.bank.ui.component.element.AccountSummaryCard
import com.tezov.bank.ui.pageMain.auth.account.PageAccountState
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.DialogState

class DialogAuthCloseAppConfirmationState private constructor( ) : DialogState {
    var contentData: ContentData

    companion object {

        @Composable
        fun create() = DialogAuthCloseAppConfirmationState()
    }

    data class ContentData(
        val title: String,
        val body: String,
        val cancel: String,
        val confirm: String,
    )

    init {
        contentData = ContentData(
            title = "Déconnection",
            body = "Etes-vous certain de vouloir vous déconnecter ?",
            cancel = "Non",
            confirm = "Oui",
        )
    }

}