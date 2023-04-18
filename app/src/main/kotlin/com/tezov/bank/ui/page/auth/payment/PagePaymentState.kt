/*
 *  *********************************************************************************
 *  Created by Tezov on 18/04/2023 19:24
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 18/04/2023 19:24
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
import com.tezov.bank.ui.component.block.SectionSimpleTile
import com.tezov.bank.ui.component.element.SimpleTile
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PagePaymentState private constructor(
    val header: Header,
    val cardSmall: MutableState<SectionSimpleTile.Data?>,
    val cardLarge: MutableState<SectionSimpleTile.Data?>,
) : PageState {

    companion object {
        fun create(
            header: Header = Header.empty(),
            cardSmall: MutableState<SectionSimpleTile.Data?> = mutableStateOf(null),
            cardLarge: MutableState<SectionSimpleTile.Data?> = mutableStateOf(null),
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
            headline.value = "Paiments"
        }

        cardSmall.value = SectionSimpleTile.Data(
            template = SimpleTile.Template.IconTopEnd,
            tile = listOf(
                SimpleTile.Data(
                    title = "Partager\nmon RIB",
                    iconInfo = R.drawable.img_rib_share
                ),
                SimpleTile.Data(
                    title = "Faire\nun virement",
                    iconInfo = R.drawable.img_transfer_money
                ),
                SimpleTile.Data(
                    title = "Gérer\nmes chèques",
                    iconInfo = R.drawable.img_cheque_manage
                ),
                SimpleTile.Data(
                    title = "Gérer\nmes cartes",
                    iconInfo = R.drawable.img_card_manage
                ),
            )
        )

        cardLarge.value = SectionSimpleTile.Data(
            template = SimpleTile.Template.IconEnd,
            tile = listOf(
                SimpleTile.Data(
                    title = "Lyf Pay",
                    subtitle = "Payer avec votre mobile.",
                    iconInfo = R.drawable.img_lyf
                ),
                SimpleTile.Data(
                    title = "Paylib",
                    subtitle = "Envoyer de l'argent vers un mobile",
                    iconInfo = R.drawable.img_paylib
                ),
                SimpleTile.Data(
                    title = "PaypPal",
                    subtitle = "Payer en ligne",
                    iconInfo = R.drawable.img_paypal
                ),
            )
        )

    }

}