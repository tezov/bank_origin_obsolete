/*
 *  *********************************************************************************
 *  Created by Tezov on 03/02/2023 18:20
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 03/02/2023 18:18
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.lobby.help_and_service

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.res.stringResource
import com.tezov.bank.R
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageHelpAndServiceState private constructor(
    val helpAndServices: SnapshotStateList<ActionCardData>,
    val contacts: MutableState<SectionActionRow.Data?>,
    val notices: MutableState<SectionActionRow.Data?>,
) : PageState {

    companion object {
        @Composable
        fun create(
            helpAndServices: SnapshotStateList<ActionCardData> = mutableStateListOf(),
            contacts: MutableState<SectionActionRow.Data?> = mutableStateOf(null),
            notices: MutableState<SectionActionRow.Data?> = mutableStateOf(null),
        ) = PageHelpAndServiceState(
            helpAndServices = helpAndServices,
            contacts = contacts,
            notices = notices,
        )
    }

    data class ActionCardData(
        val title: String,
        val iconResourceId: Int,
    )

    data class ActionRowRichData(
        val title: String,
        val iconInfoResourceId: Int? = null,
        val iconActionResourceId: Int = R.drawable.ic_arrow_cut_right_24dp,
    )

    data class ActionRowData(
        val title: String,
        val iconActionResourceId: Int = R.drawable.ic_arrow_cut_right_24dp,
    )

    init {
        helpAndServices.addAll(
            listOf(
                ActionCardData("Opposer une carte", R.drawable.ic_crisis_24dp),
                ActionCardData("Contester un prélèvement", R.drawable.ic_argue_24dp),
                ActionCardData("Suivre mon dossier", R.drawable.ic_checklist_24dp),
                ActionCardData("Trouver un distributeur", R.drawable.ic_atm_24dp),
                ActionCardData("Retirer à l'étranger", R.drawable.ic_explore_24dp),
                ActionCardData("Découvrir l'application", R.drawable.ic_search_24dp),
                ActionCardData("Accéder à l'assitance technique", R.drawable.ic_help_24dp),
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