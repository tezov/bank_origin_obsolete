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

package com.tezov.bank.ui.page.auth.help

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.tezov.bank.R
import com.tezov.bank.ui.component.block.SectionSimpleRow
import com.tezov.bank.ui.component.element.SimpleRow
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageHelpState private constructor(
    val header: Header,
    val emergencies: MutableState<SectionSimpleRow.Data?>,
    val paymentModes: MutableState<SectionSimpleRow.Data?>,
    val configuration: MutableState<SectionSimpleRow.Data?>,
    val account: MutableState<SectionSimpleRow.Data?>,
    val misc: MutableState<SectionSimpleRow.Data?>,
) : PageState {

    companion object {
        fun create(
            header: Header = Header.empty(),
            emergencies: MutableState<SectionSimpleRow.Data?> = mutableStateOf(null),
            paymentModes: MutableState<SectionSimpleRow.Data?> = mutableStateOf(null),
            configuration: MutableState<SectionSimpleRow.Data?> = mutableStateOf(null),
            account: MutableState<SectionSimpleRow.Data?> = mutableStateOf(null),
            misc: MutableState<SectionSimpleRow.Data?> = mutableStateOf(null),
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

        emergencies.value = SectionSimpleRow.Data(
            title = "Urgence",
            icon = R.drawable.ic_call_24dp,
            rows = listOf(
                SimpleRow.Data(title = "Paiment carte ou retrait refusé"),
                SimpleRow.Data(title = "Perte ou vol de ma carte"),
                SimpleRow.Data(title = "Victime d'une fraude"),
                SimpleRow.Data(title = "Assistance déplacements et voyage"),
                SimpleRow.Data(title = "Assistance médicale et juridique"),
                SimpleRow.Data(title = "Sinistre habitation, auto ou appareils mobiles"),
            )
        )

        paymentModes.value = SectionSimpleRow.Data(
            title = "Moyens de paiment",
            icon = R.drawable.ic_call_24dp,
            rows = listOf(
                SimpleRow.Data(title = "Carte bancaire"),
                SimpleRow.Data(title = "Virement"),
                SimpleRow.Data(title = "Prélèvement"),
                SimpleRow.Data(title = "Chéque"),
            )
        )

        configuration.value = SectionSimpleRow.Data(
            title = "Profile, paramétres et sécurité",
            icon = R.drawable.ic_call_24dp,
            rows = listOf(
                SimpleRow.Data(title = "Clé Digitale"),
                SimpleRow.Data(title = "Adresse postale"),
                SimpleRow.Data(title = "Adresse email"),
                SimpleRow.Data(title = "Numéro de téléphone"),
                SimpleRow.Data(title = "Pièce d'identité"),
            )
        )

        account.value = SectionSimpleRow.Data(
            title = "Comptes, épargnes, crédit, assurance",
            icon = R.drawable.ic_call_24dp,
            rows = listOf(
                SimpleRow.Data(title = "Relevés, RIB"),
                SimpleRow.Data(title = "Ouverture de compte individuel"),
                SimpleRow.Data(title = "Ouverture de compte joint"),
                SimpleRow.Data(title = "Clôture de compte"),
                SimpleRow.Data(title = "Épargne et investissements"),
                SimpleRow.Data(title = "Crédit immobilier"),
                SimpleRow.Data(title = "Crédit à la consommation"),
                SimpleRow.Data(title = "Assurance"),
            )
        )

        misc.value = SectionSimpleRow.Data(
            title = "Autres",
            icon = R.drawable.ic_call_24dp,
            rows = listOf(
                SimpleRow.Data(title = "Parrainage"),
                SimpleRow.Data(title = "Signaler un problème technique"),
                SimpleRow.Data(title = "Faire une réclamation"),
                SimpleRow.Data(title = "Transmettre un document"),
            )
        )

    }

}