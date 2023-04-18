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

package com.tezov.bank.ui.page.auth.profile

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.tezov.bank.R
import com.tezov.bank.ui.component.block.SectionSimpleRow
import com.tezov.bank.ui.component.element.SimpleRow
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageProfileState private constructor(
    val header: Header,
    val profils: MutableState<SectionSimpleRow.Data?>,
    val documents: MutableState<SectionSimpleRow.Data?>,
    val offers: MutableState<SectionSimpleRow.Data?>,
    val helps: MutableState<SectionSimpleRow.Data?>,
) : PageState {

    companion object {
        fun create(
            header: Header = Header.empty(),
            profils: MutableState<SectionSimpleRow.Data?> = mutableStateOf(null),
            documents: MutableState<SectionSimpleRow.Data?> = mutableStateOf(null),
            offers: MutableState<SectionSimpleRow.Data?> = mutableStateOf(null),
            helps: MutableState<SectionSimpleRow.Data?> = mutableStateOf(null),

            ) = PageProfileState(
            header = header,
            profils = profils,
            documents = documents,
            offers = offers,
            helps = helps,
        )
    }

    data class Header(
        val name: MutableState<String?>,
        val imageResourceId: MutableState<Int?>
    ) {
        companion object {
            fun empty() = Header(
                mutableStateOf(null),
                mutableStateOf(null),
            )
        }
    }

    init {

        header.apply {
            name.value = "M. Zollver"
            imageResourceId.value = R.drawable.img_suitcase_blue
        }

        profils.value = SectionSimpleRow.Data(
            rows = listOf(
                SimpleRow.Data(
                    title = "Mes infos de profil",
                    iconInfo = R.drawable.ic_profile_line_24dp
                ),
                SimpleRow.Data(
                    title = "Mes paramètres",
                    iconInfo = R.drawable.ic_setting_24dp
                ),
            )
        )

        documents.value = SectionSimpleRow.Data(
            title = "MES DOCUMENTS",
            rows = listOf(
                SimpleRow.Data(title = "Mes RIB et Documents"),
                SimpleRow.Data(title = "Mes assurances"),
                SimpleRow.Data(title = "Suivi de mes demandes"),
            )
        )

        offers.value = SectionSimpleRow.Data(
            title = "L'OFFRE HELLO BANK!",
            rows = listOf(
                SimpleRow.Data(title = "Mon offre"),
                SimpleRow.Data(title = "Bourse"),
                SimpleRow.Data(title = "Parrainage"),
            )
        )

        offers.value = SectionSimpleRow.Data(
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