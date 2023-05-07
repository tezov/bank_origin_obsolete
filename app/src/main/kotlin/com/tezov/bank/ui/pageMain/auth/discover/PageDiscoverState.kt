/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 17:59
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 17:55
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.pageMain.auth.discover

import com.tezov.bank.R
import com.tezov.bank.ui.component.block.SectionCarouselCard
import com.tezov.bank.ui.component.block.SectionRollerCard
import com.tezov.bank.ui.component.block.SectionSimpleRow
import com.tezov.bank.ui.component.block.SectionSimpleTile
import com.tezov.bank.ui.component.element.CarouselCard
import com.tezov.bank.ui.component.element.RollerCard
import com.tezov.bank.ui.component.element.SimpleRow
import com.tezov.bank.ui.component.element.SimpleTile
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageDiscoverState private constructor() : PageState {

    var header: Header? = null
    var cardsWithButton: SectionCarouselCard.Data? = null
    var cardsWithLink: SectionCarouselCard.Data? = null
    var cashbacks: SectionRollerCard.Data? = null
    var offers: SectionSimpleTile.Data? = null
    var tips: SectionSimpleRow.Data? = null

    companion object {
        fun create() = PageDiscoverState()
    }

    data class Header(
        val headline: String? = null,
    )

    init {
        header = Header(
            headline = "Découvrir"
        )

        cardsWithButton = SectionCarouselCard.Data(
            cards = listOf(
                CarouselCard.Data(
                    tag = "100 euros offerts",
                    title = "Parrainez un proche...",
                    body = "Jusqu'au 9 février, c'est 100€ pour vous et 80€ pour vos filleuls à chaque parrainage validé.",
                    action = "Parrainer",
                    iconId = R.drawable.ic_call_24dp
                ),
                CarouselCard.Data(
                    title = "Roulez vert !",
                    body = "Grâce au Prêt Véhicule Vert, financez l'achat de votre véhicule peu polluant.",
                    action = "Découvrir",
                    iconId = R.drawable.ic_call_24dp
                ),
            )

        )

        cardsWithLink = SectionCarouselCard.Data(
            title = "Nos offres pour vos besoins",
            cards = listOf(
                CarouselCard.Data(
                    title = "Envie de vous faire plaisir en vacances ?",
                    body = "Avec les 2 cartes Visa Hello Prime et les 2 cartes virtuelles de l'offre Hello Prime Duo, réglez vos hôtel et cocktails !",
                    action = "En savoir plus",
                    iconId = R.drawable.ic_call_24dp
                ),
                CarouselCard.Data(
                    title = "Vous voulez vous lancer en bourse ?",
                    body = "Profitez de l'espace complet dédié à la Bourse dans notre appli.",
                    action = "En savoir plus",
                    iconId = R.drawable.ic_call_24dp
                ),
                CarouselCard.Data(
                    title = "Envie de donner du sens à votre épargne ?",
                    body = "L'Assurance Vie Hello! permet d'investir de manière responsable dans des fonds ISR.",
                    action = "En savoir plus",
                    iconId = R.drawable.ic_call_24dp
                ),
            )
        )

        cashbacks = SectionRollerCard.Data(
            title = "Cashback Hello Extra",
            subTitle = "En ce moment",
            action = "Découvrir Hello Extra",
            cards = listOf(
                RollerCard.Data(
                    title = "BUT",
                    imageId = R.drawable.cashback_but
                ),
                RollerCard.Data(
                    title = "Carré Blanc",
                    imageId = R.drawable.cashback_carre_blanc
                ),
                RollerCard.Data(
                    title = "Carrefour",
                    imageId = R.drawable.cashback_carrefour
                ),
                RollerCard.Data(
                    title = "Doot",
                    imageId = R.drawable.cashback_dott
                ),
                RollerCard.Data(
                    title = "Franprix",
                    imageId = R.drawable.cashback_franprix
                ),
                RollerCard.Data(
                    title = "Franprix Appli",
                    imageId = R.drawable.cashback_franprix_appli
                ),
                RollerCard.Data(
                    title = "Getir",
                    imageId = R.drawable.cashback_getir
                ),

                RollerCard.Data(
                    title = "Kaporal",
                    imageId = R.drawable.cashback_kaporal
                ),

                RollerCard.Data(
                    title = "Kombo",
                    imageId = R.drawable.cashback_kombo
                ),
                RollerCard.Data(
                    title = "Cityscoot",
                    imageId = R.drawable.cashback_cityscoot
                ),
                RollerCard.Data(
                    title = "Club Leader\nPrice",
                    imageId = R.drawable.cashback_leader_price
                ),
                RollerCard.Data(
                    title = "Cojean",
                    imageId = R.drawable.cashback_cojean
                ),
                RollerCard.Data(
                    title = "Marionnaud",
                    imageId = R.drawable.cashback_marionnaud
                ),

                RollerCard.Data(
                    title = "Molotov",
                    imageId = R.drawable.cashback_molotov
                ),

                RollerCard.Data(
                    title = "My Vitibox",
                    imageId = R.drawable.cashback_my_vitibox
                ),
                RollerCard.Data(
                    title = "leCab",
                    imageId = R.drawable.cashback_lecab
                ),
                RollerCard.Data(
                    title = "Le Slip\nFrançais",
                    imageId = R.drawable.cashback_le_slip_francais
                ),
                RollerCard.Data(
                    title = "L'Exception",
                    imageId = R.drawable.cashback_exception
                ),
            )
        )

        offers = SectionSimpleTile.Data(
            title = "Toute l'offre Tezov bank!",
            template = SimpleTile.Template.IconTop,
            tile = listOf(
                SimpleTile.Data(
                    title = "Comptes et cartes",
                    iconId = R.drawable.img_account_card
                ),
                SimpleTile.Data(
                    title = "Épargne",
                    iconId = R.drawable.img_coin
                ),
                SimpleTile.Data(
                    title = "Crédit",
                    iconId = R.drawable.img_credit
                ),
                SimpleTile.Data(
                    title = "Assurances",
                    iconId = R.drawable.img_insurance
                ),
                SimpleTile.Data(
                    title = "Compte professionnel",
                    iconId = R.drawable.img_account_pro
                ),
                SimpleTile.Data(
                    title = "Bourse",
                    iconId = R.drawable.img_market
                ),
                SimpleTile.Data(
                    title = "Offre enfants",
                    iconId = R.drawable.img_children
                ),
                SimpleTile.Data(
                    title = "Mobilité bancaire",
                    iconId = R.drawable.img_account_mobility
                ),
            )
        )

        tips = SectionSimpleRow.Data(
            title = "Retrouvez nos astuces",
            rows = listOf(
                SimpleRow.Data(
                    title = "Valider mes paiements en ligne",
                    iconInfoId = R.drawable.img_payment_confirm
                ),
                SimpleRow.Data(
                    title = "Optimiser mes notifications",
                    iconInfoId = R.drawable.img_notification
                ),
                SimpleRow.Data(
                    title = "Déposer un chèque en agence",
                    iconInfoId = R.drawable.img_cheque_agency
                ),
            )
        )

    }


}