/*
 *  *********************************************************************************
 *  Created by Tezov on 05/02/2023 13:38
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/02/2023 13:11
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.payment

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.tezov.bank.R
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.leaf.ActionCard
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PagePaymentState private constructor(
    val header: Header,
    val cardSmall: MutableState<SectionActionCard.Data?>,
    val cardLarge: MutableState<SectionActionCard.Data?>,
) : PageState {

    companion object {
        fun create(
            header: Header = Header.empty(),
            cardSmall: MutableState<SectionActionCard.Data?> = mutableStateOf(null),
            cardLarge: MutableState<SectionActionCard.Data?> = mutableStateOf(null),
        ) = PagePaymentState(
            header = header,
            cardSmall = cardSmall,
            cardLarge = cardLarge,
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
            headline.value = "Aide & Service"
        }

        cardSmall.value = SectionActionCard.Data(
            cards = listOf(
                ActionCard.Data(
                    title = "Partager mon RIB",
                    iconResourceId = R.drawable.img_rib
                ),
                ActionCard.Data(
                    title = "Faire un virement",
                    iconResourceId = R.drawable.img_transfert
                ),
                ActionCard.Data(
                    title = "Gérer mes chèques",
                    iconResourceId = R.drawable.img_cheque
                ),
                ActionCard.Data(
                    title = "Gérer mes cartes",
                    iconResourceId = R.drawable.img_card
                ),
            )
        )

        cardLarge.value = SectionActionCard.Data(
            cards = listOf(
                ActionCard.Data(
                    title = "Lyf Pay",
                    template = ActionCard.Template.IconEnd,
                    subtitle = "Payer avec votre mobile.",
                    iconResourceId = R.drawable.img_lyf
                ),
                ActionCard.Data(
                    title = "Paylib",
                    template = ActionCard.Template.IconEnd,
                    subtitle = "Envoyer de l'argent vers un mobile",
                    iconResourceId = R.drawable.img_paylib
                ),
                ActionCard.Data(
                    title = "PaypPal",
                    template = ActionCard.Template.IconEnd,
                    subtitle = "Payer en ligne",
                    iconResourceId = R.drawable.img_paypal
                ),
            )
        )

    }

}