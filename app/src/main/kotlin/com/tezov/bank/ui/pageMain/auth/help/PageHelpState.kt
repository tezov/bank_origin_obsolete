/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 15:29
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 15:26
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.pageMain.auth.help

import com.tezov.bank.R
import com.tezov.bank.ui.component.block.SectionSimpleRow
import com.tezov.bank.ui.component.element.SimpleRow
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageHelpState private constructor() : PageState {

    var header: Header? = null
    var emergencies: SectionSimpleRow.Data? = null
    var paymentModes: SectionSimpleRow.Data? = null
    var configuration: SectionSimpleRow.Data? = null
    var accounts: SectionSimpleRow.Data? = null
    var misc: SectionSimpleRow.Data? = null

    companion object {
        fun create() = PageHelpState()
    }

    data class Header(
        val headline: String? = null,
        val title: String? = null,
        val body: String? = null
    )

    init {
        header = Header(
            headline = "Assistance",
            title = "En quoi pouvons-nous vous aider?",
            body =
            "Trouvez une réponse rapide en sélectionnant la thématique qui correspoond à votre besoin.",

            )

        emergencies = SectionSimpleRow.Data(
            title = "Urgence",
            iconId = R.drawable.ic_call_24dp,
            rows = listOf(
                SimpleRow.Data(title = "Paiment carte ou retrait refusé"),
                SimpleRow.Data(title = "Perte ou vol de ma carte"),
                SimpleRow.Data(title = "Victime d'une fraude"),
                SimpleRow.Data(title = "Assistance déplacements et voyage"),
                SimpleRow.Data(title = "Assistance médicale et juridique"),
                SimpleRow.Data(title = "Sinistre habitation, auto ou appareils mobiles"),
            )
        )

        paymentModes = SectionSimpleRow.Data(
            title = "Moyens de paiment",
            iconId = R.drawable.ic_call_24dp,
            rows = listOf(
                SimpleRow.Data(title = "Carte bancaire"),
                SimpleRow.Data(title = "Virement"),
                SimpleRow.Data(title = "Prélèvement"),
                SimpleRow.Data(title = "Chéque"),
            )
        )

        configuration = SectionSimpleRow.Data(
            title = "Profile, paramétres et sécurité",
            iconId = R.drawable.ic_call_24dp,
            rows = listOf(
                SimpleRow.Data(title = "Clé Digitale"),
                SimpleRow.Data(title = "Adresse postale"),
                SimpleRow.Data(title = "Adresse email"),
                SimpleRow.Data(title = "Numéro de téléphone"),
                SimpleRow.Data(title = "Pièce d'identité"),
            )
        )

        accounts = SectionSimpleRow.Data(
            title = "Comptes, épargnes, crédit, assurance",
            iconId = R.drawable.ic_call_24dp,
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

        misc = SectionSimpleRow.Data(
            title = "Autres",
            iconId = R.drawable.ic_call_24dp,
            rows = listOf(
                SimpleRow.Data(title = "Parrainage"),
                SimpleRow.Data(title = "Signaler un problème technique"),
                SimpleRow.Data(title = "Faire une réclamation"),
                SimpleRow.Data(title = "Transmettre un document"),
            )
        )

    }

}