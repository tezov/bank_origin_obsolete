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

package com.tezov.bank.ui.pageMain.auth.profile

import com.tezov.bank.R
import com.tezov.bank.ui.component.block.SectionSimpleRow
import com.tezov.bank.ui.component.element.SimpleRow
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageProfileState private constructor() : PageState {

    var header: Header? = null
    var profils: SectionSimpleRow.Data? = null
    var documents: SectionSimpleRow.Data? = null
    var offers: SectionSimpleRow.Data? = null
    var helps: SectionSimpleRow.Data? = null

    companion object {
        fun create() = PageProfileState()
    }

    data class Header(
        val name: String?=null,
        val imageResourceId: Int?=null,
    )

    init {

        header = Header(
            name = "M. Zollver",
            imageResourceId = R.drawable.img_suitcase_blue,
        )

        profils = SectionSimpleRow.Data(
            rows = listOf(
                SimpleRow.Data(
                    title = "Mes infos de profil",
                    iconInfoId = R.drawable.ic_profile_line_24dp
                ),
                SimpleRow.Data(
                    title = "Mes paramètres",
                    iconInfoId = R.drawable.ic_setting_24dp
                ),
            )
        )

        documents = SectionSimpleRow.Data(
            title = "MES DOCUMENTS",
            rows = listOf(
                SimpleRow.Data(title = "Mes RIB et Documents"),
                SimpleRow.Data(title = "Mes assurances"),
                SimpleRow.Data(title = "Suivi de mes demandes"),
            )
        )

        offers = SectionSimpleRow.Data(
            title = "L'OFFRE HELLO BANK!",
            rows = listOf(
                SimpleRow.Data(title = "Mon offre"),
                SimpleRow.Data(title = "Bourse"),
                SimpleRow.Data(title = "Parrainage"),
            )
        )

        offers = SectionSimpleRow.Data(
            title = "AIDE",
            rows = listOf(
                SimpleRow.Data(title = "Service sourds et malentendants"),
                SimpleRow.Data(title = "Trouver un distributeur"),
                SimpleRow.Data(title = "Accéder à l'assistance technique"),
                SimpleRow.Data(title = "Sécurité et infos légales"),
            )
        )

    }


}