/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:51
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.help

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.tezov.bank.R
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageHelpState private constructor(
    val header: Header,
    val emergencies: MutableState<SectionActionRow.Data?>,
    val paymentModes: MutableState<SectionActionRow.Data?>,
    val configuration: MutableState<SectionActionRow.Data?>,
    val account: MutableState<SectionActionRow.Data?>,
    val misc: MutableState<SectionActionRow.Data?>,
) : PageState {

    companion object {
        fun create(
            header: Header = Header.empty(),
            emergencies: MutableState<SectionActionRow.Data?> = mutableStateOf(null),
            paymentModes: MutableState<SectionActionRow.Data?> = mutableStateOf(null),
            configuration: MutableState<SectionActionRow.Data?> = mutableStateOf(null),
            account: MutableState<SectionActionRow.Data?> = mutableStateOf(null),
            misc: MutableState<SectionActionRow.Data?> = mutableStateOf(null),
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

    init {
        header.apply {
            headline.value = "Assistance"
            title.value = "En quoi pouvons-nous vous aider?"
            text.value =
                "Trouvez une réponse rapide en sélectionnant la thématique qui correspoond à votre besoin."
        }

        emergencies.value = SectionActionRow.Data(
            title = "Urgence",
            iconResourceId = R.drawable.ic_call_24dp,
            rows = listOf(
                ActionRow.Data(title = "Paiment carte ou retrait refusé"),
                ActionRow.Data(title = "Perte ou vol de ma carte"),
                ActionRow.Data(title = "Victime d'une fraude"),
                ActionRow.Data(title = "Assistance déplacements et voyage"),
                ActionRow.Data(title = "Assistance médicale et juridique"),
                ActionRow.Data(title = "Sinistre habitation, auto ou appareils mobiles"),
            )
        )

        paymentModes.value = SectionActionRow.Data(
            title = "Moyens de paiment",
            iconResourceId = R.drawable.ic_call_24dp,
            rows = listOf(
                ActionRow.Data(title = "Carte bancaire"),
                ActionRow.Data(title = "Virement"),
                ActionRow.Data(title = "Prélèvement"),
                ActionRow.Data(title = "Chéque"),
            )
        )

        configuration.value = SectionActionRow.Data(
            title = "Profile, paramétres et sécurité",
            iconResourceId = R.drawable.ic_call_24dp,
            rows = listOf(
                ActionRow.Data(title = "Clé Digitale"),
                ActionRow.Data(title = "Adresse postale"),
                ActionRow.Data(title = "Adresse email"),
                ActionRow.Data(title = "Numéro de téléphone"),
                ActionRow.Data(title = "Pièce d'identité"),
            )
        )

        account.value = SectionActionRow.Data(
            title = "Comptes, épargnes, crédit, assurance",
            iconResourceId = R.drawable.ic_call_24dp,
            rows = listOf(
                ActionRow.Data(title = "Relevés, RIB"),
                ActionRow.Data(title = "Ouverture de compte individuel"),
                ActionRow.Data(title = "Ouverture de compte joint"),
                ActionRow.Data(title = "Clôture de compte"),
                ActionRow.Data(title = "Épargne et investissements"),
                ActionRow.Data(title = "Crédit immobilier"),
                ActionRow.Data(title = "Crédit à la consommation"),
                ActionRow.Data(title = "Assurance"),
            )
        )

        misc.value = SectionActionRow.Data(
            title = "Autres",
            iconResourceId = R.drawable.ic_call_24dp,
            rows = listOf(
                ActionRow.Data(title = "Parrainage"),
                ActionRow.Data(title = "Signaler un problème technique"),
                ActionRow.Data(title = "Faire une réclamation"),
                ActionRow.Data(title = "Transmettre un document"),
            )
        )

    }

}