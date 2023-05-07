/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 17:59
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 17:58
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.pageMain.auth.payment

import androidx.compose.ui.graphics.Color
import com.tezov.bank.R
import com.tezov.bank.ui.component.block.SectionSimpleTile
import com.tezov.bank.ui.component.element.SimpleTile
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
                    iconId = R.drawable.img_rib_share
                ),
                SimpleTile.Data(
                    title = "Faire\nun virement",
                    iconId = R.drawable.img_transfer_money
                ),
                SimpleTile.Data(
                    title = "Gérer\nmes chèques",
                    iconId = R.drawable.img_cheque_manage
                ),
                SimpleTile.Data(
                    title = "Gérer\nmes cartes",
                    iconId = R.drawable.img_card_manage
                ),
            )
        )

        cardLarge = SectionSimpleTile.Data(
            template = SimpleTile.Template.IconEnd,
            tile = listOf(
                SimpleTile.Data(
                    title = "Lyf Pay",
                    subtitle = "Payer avec votre mobile.",
                    iconId = R.drawable.img_lyf,
                    iconColor = Color.Red
                ),
                SimpleTile.Data(
                    title = "Paylib",
                    subtitle = "Envoyer de l'argent vers un mobile",
                    iconId = R.drawable.img_paylib,
                    iconColor = Color.DarkGray
                ),
                SimpleTile.Data(
                    title = "PaypPal",
                    subtitle = "Payer en ligne",
                    iconId = R.drawable.img_paypal,
                    iconColor = Color.Blue
                ),
            )
        )

    }

}