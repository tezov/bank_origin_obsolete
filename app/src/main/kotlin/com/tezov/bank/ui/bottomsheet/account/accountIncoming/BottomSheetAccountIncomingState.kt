/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 16:11
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 15:34
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.bottomsheet.account.accountIncoming

import androidx.compose.runtime.Composable
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppConfirmationState
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.bottomSheet.BottomSheetState

class BottomSheetAccountIncomingState private constructor(

) : BottomSheetState {

    var contentData: ContentData

    companion object {

        @Composable
        fun create() = BottomSheetAccountIncomingState()
    }

    data class ContentData(
        val title: String,
        val body: String,
        val footer: String,
    )

    init {
        contentData = ContentData(
            title = "Opérations\nenregistrées",
            body = "Les opérations enregistrées sont des opérations réalisées mais qui n'ont pas encore été confirmées par le commerçant ou qui sont encours de traitements par la banque.",
            footer = "Elles sont incluses, à titre indicatif , dans le solde affiché aujourd'hui",
        )
    }

}