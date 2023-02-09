/*
 *  *********************************************************************************
 *  Created by Tezov on 09/02/2023 19:39
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 09/02/2023 19:31
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
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageProfileState private constructor(
    val header: Header,
    val profils: MutableState<SectionActionRow.Data?>,
    val documents: MutableState<SectionActionRow.Data?>,
    val offers: MutableState<SectionActionRow.Data?>,
    val helps: MutableState<SectionActionRow.Data?>,
    ) : PageState {

    companion object {
        fun create(
            header: Header = Header.empty(),
            profils: MutableState<SectionActionRow.Data?> = mutableStateOf(null),
            documents: MutableState<SectionActionRow.Data?> = mutableStateOf(null),
            offers: MutableState<SectionActionRow.Data?> = mutableStateOf(null),
            helps: MutableState<SectionActionRow.Data?> = mutableStateOf(null),

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
            name.value = "M.Zollver"
            imageResourceId.value = R.drawable.img_suitcase_blue
        }

        profils.value = SectionActionRow.Data(
            rows = listOf(
                ActionRow.Data(title = "Mes infos de profil", iconInfoResourceId = R.drawable.ic_profile_line_24dp),
                ActionRow.Data(title = "Mes paramètres", iconInfoResourceId = R.drawable.ic_setting_24dp),
            )
        )

        documents.value = SectionActionRow.Data(
            title = "MES DOCUMENTS",
            rows = listOf(
                ActionRow.Data(title = "Mes RIB et Documents"),
                ActionRow.Data(title = "Mes assurances"),
                ActionRow.Data(title = "Suivi de mes demandes"),
            )
        )

        offers.value = SectionActionRow.Data(
            title = "L'OFFRE HELLO BANK!",
            rows = listOf(
                ActionRow.Data(title = "Mon offre"),
                ActionRow.Data(title = "Bourse"),
                ActionRow.Data(title = "Parrainage"),
            )
        )

        offers.value = SectionActionRow.Data(
            title = "AIDE",
            rows = listOf(
                ActionRow.Data(title = "Service sourds et malentendants"),
                ActionRow.Data(title = "Trouver un distributeur"),
                ActionRow.Data(title = "Accéder à l'assistance technique"),
                ActionRow.Data(title = "Sécurité et infos légales"),
            )
        )

    }


}