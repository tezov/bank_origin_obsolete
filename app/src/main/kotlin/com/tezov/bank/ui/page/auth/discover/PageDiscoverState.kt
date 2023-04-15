/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 22:02
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 21:24
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.discover

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.tezov.bank.R
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.leaf.ActionCard
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.bank.ui.component.leaf.CarouselCard
import com.tezov.bank.ui.page.auth.help.PageHelpState
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageDiscoverState private constructor(
    val header: Header,
    val cardWithButtonData: MutableState<List<CarouselCard.Data>?>,
    val cardWithLinkData: MutableState<List<CarouselCard.Data>?>,
    val offers: MutableState<SectionActionCard.Data?>,
    val tips: MutableState<SectionActionRow.Data?>,
) : PageState {

    companion object {
        fun create(
            header: Header = Header.empty(),
            cardWithButtonData: MutableState<List<CarouselCard.Data>?> = mutableStateOf(null),
            cardWithLinkData: MutableState<List<CarouselCard.Data>?> = mutableStateOf(null),
            offers: MutableState<SectionActionCard.Data?> = mutableStateOf(null),
            tips: MutableState<SectionActionRow.Data?> = mutableStateOf(null),
        ) = PageDiscoverState(
            header = header,
            cardWithButtonData = cardWithButtonData,
            cardWithLinkData = cardWithLinkData,
            offers = offers,
            tips = tips,
        )
    }

    data class Header(
        val headline: MutableState<String?>,
    ) {
        companion object {
            fun empty() = Header(
                mutableStateOf(null),
            )
        }
    }

    init {
        header.apply {
            headline.value = "Découvrir"
        }

        cardWithButtonData.value = listOf(
            CarouselCard.Data(
                tag = "100 euros offerts",
                title = "Parrainez un proche...",
                body = "Jusqu'au 9 février, c'est 100€ pour vous et 80€ pour vos filleuls à chaque parrainage validé.",
                action = "Parrainer",
                iconInfoResourceId = R.drawable.ic_call_24dp
            ),
            CarouselCard.Data(
                title = "Roulez vert !",
                body = "Grâce au Prêt Véhicule Vert, financez l'achat de votre véhicule peu polluant.",
                action = "Découvrir",
                iconInfoResourceId = R.drawable.ic_call_24dp
            ),
        )

        cardWithLinkData.value = listOf(
            CarouselCard.Data(
                title = "Envie de vous faire plaisir en vacances ?",
                body = "Avec les 2 cartes Visa Hello Prime et les 2 cartes virtuelles de l'offre Hello Prime Duo, réglez vos hôtel et cocktails !",
                action = "En savoir plus",
                iconInfoResourceId = R.drawable.ic_call_24dp
            ),
            CarouselCard.Data(
                title = "Vous voulez vous lancer en bourse ?",
                body = "Profitez de l'espace complet dédié à la Bourse dans notre appli.",
                action = "En savoir plus",
                iconInfoResourceId = R.drawable.ic_call_24dp
            ),
            CarouselCard.Data(
                title = "Envie de donner du sens à votre épargne ?",
                body = "L'Assurance Vie Hello! permet d'investir de manière responsable dans des fonds ISR.",
                action = "En savoir plus",
                iconInfoResourceId = R.drawable.ic_call_24dp
            ),
        )

        offers.value = SectionActionCard.Data(
            title = "Toute l'offre Tezov bank!",
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