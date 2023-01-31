/*
 *  *********************************************************************************
 *  Created by Tezov on 31/01/2023 20:01
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 31/01/2023 19:59
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.help_and_service

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.tezov.bank.R
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageHelpAndServiceState private constructor(
    val helpAndServices:SnapshotStateList<Pair<String, Int>>,
    val contacts:SnapshotStateList<Pair<String, Int>>,
    val notices:SnapshotStateList<String>,
) : PageState {

    companion object {
        @Composable
        fun create(
            helpAndServices:SnapshotStateList<Pair<String, Int>> = mutableStateListOf(),
            contacts:SnapshotStateList<Pair<String, Int>> = mutableStateListOf(),
            notices:SnapshotStateList<String> = mutableStateListOf(),
        ) = PageHelpAndServiceState(
            helpAndServices = helpAndServices,
            contacts = contacts,
            notices = notices,
        )
    }

    init {
        helpAndServices.addAll(
            listOf(
                Pair("Opposer une carte", R.drawable.ic_crisis_24dp),
                Pair("Contester un prélèvement", R.drawable.ic_argue_24dp),
                Pair("Suivre mon dossier", R.drawable.ic_checklist_24dp),
                Pair("Trouver un distributeur", R.drawable.ic_atm_24dp),
                Pair("Retirer à l'étranger", R.drawable.ic_explore_24dp),
                Pair("Découvrir l'application", R.drawable.ic_search_24dp),
                Pair("Accéder à l'assitance technique", R.drawable.ic_help_24dp),
            )
        )
        contacts.addAll(
            listOf(
                Pair("Appeler", R.drawable.ic_call_24dp),
                Pair("Service sourds et malentendats", R.drawable.ic_hearing_disabled_24dp),
            )
        )
        notices.addAll(
            listOf(
                "Mentions légales",
                "Mentions légales Bourse",
                "Politique des cookies",
                "Paramètres des cookies",
                "A propos de l'accessibilité",
            )
        )

    }


}