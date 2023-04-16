/*
 *  *********************************************************************************
 *  Created by Tezov on 16/04/2023 22:13
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 16/04/2023 21:51
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
import com.tezov.bank.ui.component.block.SectionActionCard
import com.tezov.bank.ui.component.block.SectionActionRow
import com.tezov.bank.ui.component.block.SectionCarouselCard
import com.tezov.bank.ui.component.block.SectionRollerCard
import com.tezov.bank.ui.component.element.ActionCard
import com.tezov.bank.ui.component.element.ActionRow
import com.tezov.bank.ui.component.element.CarouselCard
import com.tezov.bank.ui.component.element.RollerCard
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageDiscoverState private constructor(
    val header: Header,
    val cardsWithButton: MutableState<SectionCarouselCard.Data?>,
    val cardsWithLink: MutableState<SectionCarouselCard.Data?>,
    val cashbacks: MutableState<SectionRollerCard.Data?>,
    val offers: MutableState<SectionActionCard.Data?>,
    val tips: MutableState<SectionActionRow.Data?>,
) : PageState {

    companion object {
        fun create(
            header: Header = Header.empty(),
            cardsWithButton: MutableState<SectionCarouselCard.Data?> = mutableStateOf(null),
            cardsWithLink: MutableState<SectionCarouselCard.Data?> = mutableStateOf(null),
            cashbacks: MutableState<SectionRollerCard.Data?> = mutableStateOf(null),
            offers: MutableState<SectionActionCard.Data?> = mutableStateOf(null),
            tips: MutableState<SectionActionRow.Data?> = mutableStateOf(null),
        ) = PageDiscoverState(
            header = header,
            cardsWithButton = cardsWithButton,
            cardsWithLink = cardsWithLink,
            cashbacks = cashbacks,
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

        cardsWithButton.value = SectionCarouselCard.Data(
            cards = listOf(
                CarouselCard.Data(
                    tag = "100 euros offerts",
                    title = "Parrainez un proche...",
                    body = "Jusqu'au 9 février, c'est 100€ pour vous et 80€ pour vos filleuls à chaque parrainage validé.",
                    action = "Parrainer",
                    iconInfo = R.drawable.ic_call_24dp
                ),
                CarouselCard.Data(
                    title = "Roulez vert !",
                    body = "Grâce au Prêt Véhicule Vert, financez l'achat de votre véhicule peu polluant.",
                    action = "Découvrir",
                    iconInfo = R.drawable.ic_call_24dp
                ),
            )

        )

        cardsWithLink.value = SectionCarouselCard.Data(
            title = "Nos offres pour vos besoins",
            cards =listOf(
                CarouselCard.Data(
                    title = "Envie de vous faire plaisir en vacances ?",
                    body = "Avec les 2 cartes Visa Hello Prime et les 2 cartes virtuelles de l'offre Hello Prime Duo, réglez vos hôtel et cocktails !",
                    action = "En savoir plus",
                    iconInfo = R.drawable.ic_call_24dp
                ),
                CarouselCard.Data(
                    title = "Vous voulez vous lancer en bourse ?",
                    body = "Profitez de l'espace complet dédié à la Bourse dans notre appli.",
                    action = "En savoir plus",
                    iconInfo = R.drawable.ic_call_24dp
                ),
                CarouselCard.Data(
                    title = "Envie de donner du sens à votre épargne ?",
                    body = "L'Assurance Vie Hello! permet d'investir de manière responsable dans des fonds ISR.",
                    action = "En savoir plus",
                    iconInfo = R.drawable.ic_call_24dp
                ),
            )
        )

        cashbacks.value = SectionRollerCard.Data(
            title = "Cashback Hello Extra",
            subTitle = "En ce moment",
            action = "Découvrir Hello Extra",
            cards =listOf(
                RollerCard.Data(
                    title = "BUT",
                    image = R.drawable.cashback_but
                ),
                RollerCard.Data(
                    title = "Carré Blanc",
                    image = R.drawable.cashback_carre_blanc
                ),
                RollerCard.Data(
                    title = "Carrefour",
                    image = R.drawable.cashback_carrefour
                ),
                RollerCard.Data(
                    title = "Doot",
                    image = R.drawable.cashback_dott
                ),
                RollerCard.Data(
                    title = "Franprix",
                    image = R.drawable.cashback_franprix
                ),
                RollerCard.Data(
                    title = "Franprix Appli",
                    image = R.drawable.cashback_franprix_appli
                ),
                RollerCard.Data(
                    title = "Getir",
                    image = R.drawable.cashback_getir
                ),

                RollerCard.Data(
                    title = "Kaporal",
                    image = R.drawable.cashback_kaporal
                ),

                RollerCard.Data(
                    title = "Kombo",
                    image = R.drawable.cashback_kombo
                ),
                RollerCard.Data(
                    title = "Cityscoot",
                    image = R.drawable.cashback_cityscoot
                ),
                RollerCard.Data(
                    title = "Club Leader\nPrice",
                    image = R.drawable.cashback_leader_price
                ),
                RollerCard.Data(
                    title = "Cojean",
                    image = R.drawable.cashback_cojean
                ),
                RollerCard.Data(
                    title = "Marionnaud",
                    image = R.drawable.cashback_marionnaud
                ),

                RollerCard.Data(
                    title = "Molotov",
                    image = R.drawable.cashback_molotov
                ),

                RollerCard.Data(
                    title = "My Vitibox",
                    image = R.drawable.cashback_my_vitibox
                ),
                RollerCard.Data(
                    title = "leCab",
                    image = R.drawable.cashback_lecab
                ),
                RollerCard.Data(
                    title = "Le Slip\nFrançais",
                    image = R.drawable.cashback_le_slip_francais
                ),
                RollerCard.Data(
                    title = "L'Exception",
                    image = R.drawable.cashback_exception
                ),
            )
        )

        offers.value = SectionActionCard.Data(
            title = "Toute l'offre Tezov bank!",
            template = ActionCard.Template.IconTop,
            cards = listOf(
                ActionCard.Data(
                    title = "Comptes et cartes",
                    iconInfo = R.drawable.img_account_card
                ),
                ActionCard.Data(
                    title = "Épargne",
                    iconInfo = R.drawable.img_coin
                ),
                ActionCard.Data(
                    title = "Crédit",
                    iconInfo = R.drawable.img_credit
                ),
                ActionCard.Data(
                    title = "Assurances",
                    iconInfo = R.drawable.img_insurance
                ),
                ActionCard.Data(
                    title = "Compte professionnel",
                    iconInfo = R.drawable.img_account_pro
                ),
                ActionCard.Data(
                    title = "Bourse",
                    iconInfo = R.drawable.img_market
                ),
                ActionCard.Data(
                    title = "Offre enfants",
                    iconInfo = R.drawable.img_children
                ),
                ActionCard.Data(
                    title = "Mobilité bancaire",
                    iconInfo = R.drawable.img_account_mobility
                ),
            )
        )

        tips.value = SectionActionRow.Data(
            title = "Retrouvez nos astuces",
            rows = listOf(
                ActionRow.Data(
                    title = "Valider mes paiements en ligne",
                    iconInfo = R.drawable.img_payment_confirm
                ),
                ActionRow.Data(
                    title = "Optimiser mes notifications",
                    iconInfo = R.drawable.img_notification
                ),
                ActionRow.Data(
                    title = "Déposer un chèque en agence",
                    iconInfo = R.drawable.img_cheque_agency
                ),
            )
        )

    }


}