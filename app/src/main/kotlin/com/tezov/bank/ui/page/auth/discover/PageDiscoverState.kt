/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 03:45
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 02:41
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
import com.tezov.bank.ui.component.leaf.CarouselCard
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageDiscoverState private constructor(
    val cardWithButtonData: MutableState<List<CarouselCard.Data>?>,
    val cardWithLinkData: MutableState<List<CarouselCard.Data>?>,
    val offers: MutableState<SectionActionCard.Data?>,
    val tips: MutableState<SectionActionRow.Data?>,
) : PageState {

    companion object {
        fun create(
            cardWithButtonData: MutableState<List<CarouselCard.Data>?> = mutableStateOf(null),
            cardWithLinkData: MutableState<List<CarouselCard.Data>?> = mutableStateOf(null),
            offers: MutableState<SectionActionCard.Data?> = mutableStateOf(null),
            tips: MutableState<SectionActionRow.Data?> = mutableStateOf(null),
        ) = PageDiscoverState(
            cardWithButtonData = cardWithButtonData,
            cardWithLinkData = cardWithLinkData,
            offers = offers,
            tips = tips,
        )
    }

    init {
        cardWithButtonData.value =  listOf(
            CarouselCard.Data(
                tag = "100 euros offerts",
                title = "Parrainez un proche...",
                text = "Jusqu'au 9 février, c'est 100€ pour vous et 80€ pour vos filleuls à chaque parrainage validé.",
                button = "Parrainer",
                iconInfoResourceId = R.drawable.ic_call_24dp
            ),
            CarouselCard.Data(
                title = "Roulez vert !",
                text = "Grâce au Prêt Véhicule Vert, financez l'achat de votre véhicule peu polluant.",
                button = "Découvrir",
                iconInfoResourceId = R.drawable.ic_call_24dp
            ),
        )

        cardWithLinkData.value = listOf(
            CarouselCard.Data(
                template = CarouselCard.Template.Link,
                title = "Envie de vous faire plaisir en vacances ?",
                text = "Avec les 2 cartes Visa Hello Prime et les 2 cartes virtuelles de l'offre Hello Prime Duo, réglez vos hôtel et cocktails !",
                button = "En savoir plus",
                iconInfoResourceId = R.drawable.ic_call_24dp
            ),
            CarouselCard.Data(
                template = CarouselCard.Template.Link,
                title = "Vous voulez vous lancer en bourse ?",
                text = "Profitez de l'espace complet dédié à la Bourse dans notre appli.",
                button = "En savoir plus",
                iconInfoResourceId = R.drawable.ic_call_24dp
            ),
            CarouselCard.Data(
                template = CarouselCard.Template.Link,
                title = "Envie de donner du sens à votre épargne ?",
                text = "L'Assurance Vie Hello! permet d'investir de manière responsable dans des fonds ISR.",
                button = "En savoir plus",
                iconInfoResourceId = R.drawable.ic_call_24dp
            ),
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