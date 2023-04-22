/*
 *  *********************************************************************************
 *  Created by Tezov on 22/04/2023 14:12
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 22/04/2023 13:48
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.account

import androidx.compose.ui.graphics.Color
import com.tezov.bank.R
import com.tezov.bank.ui.component.block.SectionAccountValueSimpleRow
import com.tezov.bank.ui.component.element.AccountSummaryCard
import com.tezov.bank.ui.component.element.AccountValueSimpleRow
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitStateSemantic
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

class PageAccountState private constructor() : PageState {

    var header: Header?=null
    var accountHistories: List<SectionAccountValueSimpleRow.Data>?=null

    companion object {
        fun create() = PageAccountState()
    }

    data class Header(
        val iconMailbox: Int?=null,
        val iconAccount: Int?=null,
        val headline: String?=null,
        val accountSummary: AccountSummaryCard.Data?=null,
    )

    init {
        this.header = Header(
            iconMailbox = R.drawable.ic_info_24dp,
            iconAccount = R.drawable.ic_info_24dp,
            headline = "Hello !",
            accountSummary = AccountSummaryCard.Data(
                iconInfo = R.drawable.ic_info_24dp,
                iconAction = R.drawable.ic_3dot_h_24dp,
                surtitle = "N°****3475",
                title = "Compte de chèques",
                subTitle = "Aujourd'hui",
                amount = "47 123,98 €",
                actions = listOf(
                    "Informations du compte",
                    "Faire un virement",
                    "Catégoriser des opérations",
                    "Rechercher une opération",
                    "Pointer des opérations",
                    "Afficher le RIB",
                    "Trier par..."
                )
            )
        )

        val semantic = OutfitStateSemantic(
            neutral = Color.Gray,
            info = Color.Blue,
            alert = Color.Black,
            success = Color.Green,
            error = Color.Red,
        )
        this.accountHistories = listOf(
            SectionAccountValueSimpleRow.Data(
                title = "VENDREDI 14 AVRIL",
                rows = listOf(
                    AccountValueSimpleRow.Data(
                        iconInfoId = R.drawable.ic_info_24dp,
                        iconInfoColor = semantic.neutral,
                        title = "Paiements cb amazon du 12/04 a payli2441535 - CLASS",
                        subTitle = "Achats,shopping",
                        amount = "-14.69 €",
                    ),
                    AccountValueSimpleRow.Data(
                        iconInfoId = R.drawable.ic_info_24dp,
                        iconInfoColor = semantic.info,
                        title = "Prelevement bouygues telecom du 13/04 - EMMETEUR",
                        subTitle = "Téléphone",
                        amount = "-9.95 €",
                    ),
                    AccountValueSimpleRow.Data(
                        iconInfoId = R.drawable.ic_info_24dp,
                        iconInfoColor = semantic.info,
                        title = "Paiement cb auchan du 11/04 a Faches-Thumesnil",
                        subTitle = "Alimentation, supermarché",
                        amount = "-41.46 €",
                    ),
                )
            ),
            SectionAccountValueSimpleRow.Data(
                title = "JEUDI 06 AVRIL",
                rows = listOf(
                    AccountValueSimpleRow.Data(
                        iconInfoId = R.drawable.ic_info_24dp,
                        iconInfoColor = semantic.success,
                        title = "Remboursement cb amazon",
                        subTitle = "Remboursement",
                        amount = "26.99 €",
                    ),
                    AccountValueSimpleRow.Data(
                        iconInfoId = R.drawable.ic_info_24dp,
                        iconInfoColor = semantic.alert,
                        title = "Paiements cb otacos ganbetta du 31/03 à paris 15",
                        subTitle = "Restaurants, bars",
                        amount = "-17.20 €",
                    ),
                )
            )
        )
    }

}