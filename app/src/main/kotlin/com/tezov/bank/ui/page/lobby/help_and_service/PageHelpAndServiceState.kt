/*
 *  *********************************************************************************
 *  Created by Tezov on 01/02/2023 21:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/02/2023 20:19
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.lobby.help_and_service

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.tezov.bank.R
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageHelpAndServiceState private constructor(
    val helpAndServices: SnapshotStateList<ActionCardData>,
    val contacts: SnapshotStateList<ActionRowData>,
    val notices: SnapshotStateList<ActionRowData>,
) : PageState {

    companion object {
        @Composable
        fun create(
            helpAndServices: SnapshotStateList<ActionCardData> = mutableStateListOf(),
            contacts: SnapshotStateList<ActionRowData> = mutableStateListOf(),
            notices: SnapshotStateList<ActionRowData> = mutableStateListOf(),
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

    data class ActionRowData(
        val title: String,
        val iconInfoResourceId: Int? = null,
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
        contacts.addAll(
            listOf(
                ActionRowData("Appeler", R.drawable.ic_call_24dp),
                ActionRowData(
                    "Service sourds et malentendats",
                    R.drawable.ic_hearing_disabled_24dp
                ),
            )
        )
        notices.addAll(
            listOf(
                ActionRowData("Mentions légales"),
                ActionRowData("Mentions légales Bourse"),
                ActionRowData("Politique des cookies"),
                ActionRowData("Paramètres des cookies"),
                ActionRowData("A propos de l'accessibilité"),
            )
        )

    }


}