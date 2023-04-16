/*
 *  *********************************************************************************
 *  Created by Tezov on 16/04/2023 22:13
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 16/04/2023 20:40
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
import com.tezov.bank.ui.component.block.SectionActionCard
import com.tezov.bank.ui.component.block.SectionActionRow
import com.tezov.bank.ui.component.element.ActionCard
import com.tezov.bank.ui.component.element.ActionRow
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
            template = ActionCard.Template.IconTopEnd,
            cards = listOf(
                ActionCard.Data(
                    title = "Opposer une carte",
                    iconInfo = R.drawable.ic_crisis_24dp
                ),
                ActionCard.Data(
                    title = "Contester un prélèvement",
                    iconInfo = R.drawable.ic_argue_24dp
                ),
                ActionCard.Data(
                    title = "Suivre mon dossier",
                    iconInfo = R.drawable.ic_checklist_24dp
                ),
                ActionCard.Data(
                    title = "Trouver un distributeur",
                    iconInfo = R.drawable.ic_atm_24dp
                ),
                ActionCard.Data(
                    title = "Retirer à l'étranger",
                    iconInfo = R.drawable.ic_explore_24dp
                ),
                ActionCard.Data(
                    title = "Découvrir l'application",
                    iconInfo = R.drawable.ic_search_24dp
                ),
                ActionCard.Data(
                    title = "Accéder à l'assitance technique",
                    iconInfo = R.drawable.ic_help_24dp
                ),
            )
        )

        contacts.value = SectionActionRow.Data(
            title = "CONTACTER LA HELLO TEAM",
            rows = listOf(
                ActionRow.Data(title = "Appeler", iconInfo = R.drawable.ic_call_24dp),
                ActionRow.Data(
                    title = "Service sourds et malentendats",
                    iconInfo = R.drawable.ic_hearing_disabled_24dp
                ),
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