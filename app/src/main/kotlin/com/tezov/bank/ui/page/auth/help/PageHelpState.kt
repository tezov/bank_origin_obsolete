/*
 *  *********************************************************************************
 *  Created by Tezov on 02/02/2023 20:23
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/02/2023 20:21
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.help

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.tezov.bank.R
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageHelpState private constructor(
    val header: Header,
    val emergencies: Section<ActionRowData>,
    val paymentModes: Section<ActionRowData>,
    val configuration: Section<ActionRowData>,
    val account: Section<ActionRowData>,
    val misc: Section<ActionRowData>,
) : PageState {

    companion object {
        fun create(
            header: Header = Header.empty(),
            emergencies: Section<ActionRowData> = Section.empty(),
            paymentModes: Section<ActionRowData> = Section.empty(),
            configuration: Section<ActionRowData> = Section.empty(),
            account: Section<ActionRowData> = Section.empty(),
            misc: Section<ActionRowData> = Section.empty(),
        ) = PageHelpState(
            header = header,
            emergencies = emergencies,
            paymentModes = paymentModes,
            configuration = configuration,
            account = account,
            misc = misc,
        )
    }

    data class Header(
        val headline: MutableState<String?>,
        val title: MutableState<String?>,
        val text: MutableState<String?>
    ) {
        companion object {
            fun empty() = Header(
                mutableStateOf(null),
                mutableStateOf(null),
                mutableStateOf(null),
            )
        }
    }

    data class Section<T>(
        val iconResourceId: MutableState<Int?>,
        val title: MutableState<String?>,
        val datas: SnapshotStateList<T>
    ) {
        companion object {
            fun <T> empty() = Section<T>(
                mutableStateOf(null),
                mutableStateOf(null),
                mutableStateListOf()
            )
        }
    }

    data class ActionRowData(
        val title: String,
        val iconActionResourceId: Int = R.drawable.ic_arrow_cut_right_24dp,
    )

    init {
        header.apply {
            headline.value = "Assistance"
            title.value = "En quoi pouvons-nous vous aider?"
            text.value = "Trouvez une réponse rapide en sélectionnant la thméatique qui correspoond à votre besoin."
        }

        emergencies.apply {
            title.value = "Urgence"
            iconResourceId.value = R.drawable.ic_call_24dp
            datas.addAll(
                listOf(
                    ActionRowData("Paiment carte ou retrait refusé"),
                    ActionRowData("Perte ou vol de ma carte"),
                    ActionRowData("Victime d'une fraude"),
                    ActionRowData("Assistance déplacements et voyage"),
                    ActionRowData("Assistance médicale et juridique"),
                    ActionRowData("Sinistre habitation, auto ou appareils mobiles"),
                )
            )
        }

        paymentModes.apply {
            title.value = "Moyens de paiment"
            iconResourceId.value = R.drawable.ic_call_24dp
            datas.addAll(
                listOf(
                    ActionRowData("Carte bancaire"),
                    ActionRowData("Virement"),
                    ActionRowData("Prélèvement"),
                    ActionRowData("Chéque"),

                    )
            )
        }

        configuration.apply {
            title.value = "Profile, paramétres et sécurité"
            iconResourceId.value = R.drawable.ic_call_24dp
            datas.addAll(
                listOf(
                    ActionRowData("Clé Digitale"),
                    ActionRowData("Adresse postale"),
                    ActionRowData("Adresse email"),
                    ActionRowData("Numéro de téléphone"),
                    ActionRowData("Pièce d'identité"),
                )
            )
        }

        account.apply {
            title.value = "Comptes, épargnes, crédit, assurance"
            iconResourceId.value = R.drawable.ic_call_24dp
            datas.addAll(
                listOf(
                    ActionRowData("Relevés, RIB"),
                    ActionRowData("Ouverture de compte individuel"),
                    ActionRowData("Ouverture de compte joint"),
                    ActionRowData("Clôture de compte"),
                    ActionRowData("Épargne et investissements"),
                    ActionRowData("Crédit immobilier"),
                    ActionRowData("Crédit à la consommation"),
                    ActionRowData("Assurance"),

                    )
            )
        }

        misc.apply {
            title.value = "Autres"
            iconResourceId.value = R.drawable.ic_call_24dp
            datas.addAll(
                listOf(
                    ActionRowData("Parrainage"),
                    ActionRowData("Signaler un problème technique"),
                    ActionRowData("Faire une réclamation"),
                    ActionRowData("Transmettre un document"),
                )
            )
        }
    }

}