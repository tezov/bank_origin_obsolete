/*
 *  *********************************************************************************
 *  Created by Tezov on 03/05/2023 21:39
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 03/05/2023 21:05
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
import com.tezov.bank.ui.component.block.SectionSimpleRow
import com.tezov.bank.ui.component.block.SectionSimpleTile
import com.tezov.bank.ui.component.element.SimpleRow
import com.tezov.bank.ui.component.element.SimpleTile
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageHelpAndServiceState private constructor(private val _diCanDispose: MutableState<Boolean>) :
    PageState {
    var header: Header? = null
    var helpAndServices: SectionSimpleTile.Data? = null
    var contacts: SectionSimpleRow.Data? = null
    var notices: SectionSimpleRow.Data? = null

    companion object {
        @Composable
        fun create(
            diCanDispose: MutableState<Boolean> = mutableStateOf(false)
        ) = PageHelpAndServiceState(_diCanDispose = diCanDispose)
    }

    var diCanDispose
        get() = _diCanDispose.value
        set(value) {
            _diCanDispose.value = value
        }

    data class Header(
        val headline: String? = null,
    )

    init {
        header = Header(
            headline = "Aide & Service"
        )
        helpAndServices = SectionSimpleTile.Data(
            template = SimpleTile.Template.IconTopEnd,
            tile = listOf(
                SimpleTile.Data(
                    title = "Opposer une carte",
                    iconInfo = R.drawable.ic_crisis_24dp
                ),
                SimpleTile.Data(
                    title = "Contester un prélèvement",
                    iconInfo = R.drawable.ic_argue_24dp
                ),
                SimpleTile.Data(
                    title = "Suivre mon dossier",
                    iconInfo = R.drawable.ic_checklist_24dp
                ),
                SimpleTile.Data(
                    title = "Trouver un distributeur",
                    iconInfo = R.drawable.ic_atm_24dp
                ),
                SimpleTile.Data(
                    title = "Retirer à l'étranger",
                    iconInfo = R.drawable.ic_explore_24dp
                ),
                SimpleTile.Data(
                    title = "Découvrir l'application",
                    iconInfo = R.drawable.ic_search_24dp
                ),
                SimpleTile.Data(
                    title = "Accéder à l'assitance technique",
                    iconInfo = R.drawable.ic_help_24dp
                ),
            )
        )

        contacts = SectionSimpleRow.Data(
            title = "CONTACTER LA HELLO TEAM",
            rows = listOf(
                SimpleRow.Data(title = "Appeler", iconInfo = R.drawable.ic_call_24dp),
                SimpleRow.Data(
                    title = "Service sourds et malentendats",
                    iconInfo = R.drawable.ic_hearing_disabled_24dp
                ),
            )
        )

        notices = SectionSimpleRow.Data(
            title = "MENTION LEGALES",
            rows = listOf(
                SimpleRow.Data(title = "Mentions légales"),
                SimpleRow.Data(title = "Mentions légales Bourse"),
                SimpleRow.Data(title = "Politique des cookies"),
                SimpleRow.Data(title = "Paramètres des cookies"),
                SimpleRow.Data(title = "A propos de l'accessibilité"),
            )
        )

    }


}