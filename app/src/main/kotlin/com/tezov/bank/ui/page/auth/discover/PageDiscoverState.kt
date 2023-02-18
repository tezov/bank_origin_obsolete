/*
 *  *********************************************************************************
 *  Created by Tezov on 18/02/2023 14:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 18/02/2023 14:31
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.discover

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.tezov.bank.R
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.leaf.ActionCard
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageDiscoverState private constructor(
    val cardWithButtonData: SnapshotStateList<CardButtonData>,
    val cardWithLinkData: SnapshotStateList<CardLinkData>,
    val offers: MutableState<SectionActionCard.Data?>,
    val tips: MutableState<SectionActionRow.Data?>,
) : PageState {

    companion object {
        fun create(
            cardWithButtonData: SnapshotStateList<CardButtonData> = mutableStateListOf(),
            cardWithLinkData: SnapshotStateList<CardLinkData> = mutableStateListOf(),
            offers: MutableState<SectionActionCard.Data?> = mutableStateOf(null),
            tips: MutableState<SectionActionRow.Data?> = mutableStateOf(null),
        ) = PageDiscoverState(
            cardWithButtonData = cardWithButtonData,
            cardWithLinkData = cardWithLinkData,
            offers = offers,
            tips = tips,
        )
    }

    data class CardButtonData(
        val title:String,
        val text:String,
        val textButton:String,
        val iconResourceId:Int,
    )

    data class CardLinkData(
        val title:String,
        val text:String,
        val textLink:String,
        val iconResourceId:Int,
    )

    init {
        cardWithButtonData.addAll(
            listOf(
                CardButtonData("title", "text", "button", R.drawable.ic_call_24dp),

            )
        )

        cardWithLinkData.addAll(
            listOf(
                CardLinkData("title", "text", "link", R.drawable.ic_call_24dp),

            )
        )

        offers.value = SectionActionCard.Data(
            title = "Toute l'offre Hello bank!",
            template = ActionCard.Template.IconTop,
            cards = listOf(
                ActionCard.Data(
                    title = "Comptes et cartes",
                    iconResourceId = R.drawable.img_account_card
                ),
                ActionCard.Data(
                    title = "Épargne",
                    iconResourceId = R.drawable.img_coin
                ),
                ActionCard.Data(
                    title = "Crédit",
                    iconResourceId = R.drawable.img_credit
                ),
                ActionCard.Data(
                    title = "Assurances",
                    iconResourceId = R.drawable.img_insurance
                ),
                ActionCard.Data(
                    title = "Compte professionnel",
                    iconResourceId = R.drawable.img_account_pro
                ),
                ActionCard.Data(
                    title = "Bourse",
                    iconResourceId = R.drawable.img_market
                ),
                ActionCard.Data(
                    title = "Offre enfants",
                    iconResourceId = R.drawable.img_children
                ),
                ActionCard.Data(
                    title = "Mobilité bancaire",
                    iconResourceId = R.drawable.img_account_mobility
                ),
            )
        )

        tips.value = SectionActionRow.Data(
            title = "Retrouvez nos astuces",
            rows = listOf(
                ActionRow.Data(
                    title = "Valider mes paiements en ligne",
                    iconInfoResourceId = R.drawable.img_payment_confirm
                ),
                ActionRow.Data(
                    title = "Optimiser mes notifications",
                    iconInfoResourceId = R.drawable.img_notification
                ),
                ActionRow.Data(
                    title = "Déposer un chèque en agence",
                    iconInfoResourceId = R.drawable.img_cheque_agency
                ),
            )
        )

    }


}