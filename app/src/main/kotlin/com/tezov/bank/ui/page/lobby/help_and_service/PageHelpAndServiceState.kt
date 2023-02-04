/*
 *  *********************************************************************************
 *  Created by Tezov on 04/02/2023 18:53
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/02/2023 18:45
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.lobby.help_and_service

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.tezov.bank.R
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.leaf.ActionCard
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.bank.ui.page.auth.help.PageHelpState
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageHelpAndServiceState private constructor(
    val header: Header,
    val helpAndServices: MutableState<SectionActionCard.Data?>,
    val contacts: MutableState<SectionActionRow.Data?>,
    val notices: MutableState<SectionActionRow.Data?>,
) : PageState {

    companion object {
        @Composable
        fun create(
            header: Header = Header.empty(),
            helpAndServices: MutableState<SectionActionCard.Data?> = mutableStateOf(null),
            contacts: MutableState<SectionActionRow.Data?> = mutableStateOf(null),
            notices: MutableState<SectionActionRow.Data?> = mutableStateOf(null),
        ) = PageHelpAndServiceState(
        header = header,
            helpAndServices = helpAndServices,
            contacts = contacts,
            notices = notices,
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

        helpAndServices.value = SectionActionCard.Data(
            cards = listOf(
                ActionCard.Simple.Data("Opposer une carte", R.drawable.ic_crisis_24dp),
                ActionCard.Simple.Data("Contester un prélèvement", R.drawable.ic_argue_24dp),
                ActionCard.Simple.Data("Suivre mon dossier", R.drawable.ic_checklist_24dp),
                ActionCard.Simple.Data("Trouver un distributeur", R.drawable.ic_atm_24dp),
                ActionCard.Simple.Data("Retirer à l'étranger", R.drawable.ic_explore_24dp),
                ActionCard.Simple.Data("Découvrir l'application", R.drawable.ic_search_24dp),
                ActionCard.Simple.Data("Accéder à l'assitance technique", R.drawable.ic_help_24dp),
            )
        )

        contacts.value = SectionActionRow.Data(
            title = "CONTACTER LA HELLO TEAM",
            rows = listOf(
                ActionRow.Data(title = "Appeler", iconInfoResourceId = R.drawable.ic_call_24dp),
                ActionRow.Data(title = "Service sourds et malentendats", iconInfoResourceId = R.drawable.ic_hearing_disabled_24dp),
            )
        )

        notices.value = SectionActionRow.Data(
            title = "MENTION LEGALES",
            rows = listOf(
                ActionRow.Data(title = "Mentions légales"),
                ActionRow.Data(title = "Mentions légales Bourse"),
                ActionRow.Data(title = "Politique des cookies"),
                ActionRow.Data(title = "Paramètres des cookies"),
                ActionRow.Data(title = "A propos de l'accessibilité"),
            )
        )

    }


}