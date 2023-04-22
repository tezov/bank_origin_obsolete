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

package com.tezov.bank.ui.page.auth.payment

import com.tezov.bank.R
import com.tezov.bank.ui.component.block.SectionSimpleTile
import com.tezov.bank.ui.component.element.SimpleTile
import com.tezov.bank.ui.page.auth.help.PageHelpState
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PagePaymentState private constructor() : PageState {

    var header: Header? = null
    var cardSmall: SectionSimpleTile.Data? = null
    var cardLarge: SectionSimpleTile.Data? = null

    companion object {
        fun create() = PagePaymentState()
    }

    data class Header(
        val headline: String? = null,
    )

    init {

        header = Header(
            headline = "Paiments"
        )

        cardSmall = SectionSimpleTile.Data(
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

        cardLarge = SectionSimpleTile.Data(
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