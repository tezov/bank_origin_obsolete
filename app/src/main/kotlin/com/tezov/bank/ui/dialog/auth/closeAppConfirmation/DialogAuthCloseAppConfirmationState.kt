/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
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