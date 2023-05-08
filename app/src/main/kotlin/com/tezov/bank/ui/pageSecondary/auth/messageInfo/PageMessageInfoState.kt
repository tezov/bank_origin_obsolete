/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 15:29
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 15:12
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.pageSecondary.auth.messageInfo

import com.tezov.bank.ui.component.block.SectionMessageRow
import com.tezov.bank.ui.component.element.MessageRow
import com.tezov.lib_core_android_kotlin.ui.component.block.HorizontalPager
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageMessageInfoState private constructor() : PageState {

    var header: Header? = null
    var messages: SectionMessageRow.Data? = null

    companion object {
        fun create() = PageMessageInfoState()
    }

    data class Header(
        val tabNotification: HorizontalPager.WithTabRow.Tab? = null,
        val tabMessageBox: HorizontalPager.WithTabRow.Tab? = null,
    )

    init {

        header = Header(
            tabNotification = HorizontalPager.WithTabRow.Tab("Notifications"),
            tabMessageBox = HorizontalPager.WithTabRow.Tab("Messagerie"),
        )

        messages = SectionMessageRow.Data(
            rows = listOf(
                MessageRow.Data(
                    title = "Opératon refusée",
                    subtitle = "Samedi 22 avril",
                    active = true
                ),
                MessageRow.Data(
                    title = "Vos avantages Premier printemps-été 2023",
                    subtitle = "Lundi 17 avril",
                    active = false
                ),
                MessageRow.Data(
                    title = "Evolutions tarifaires au 7 juin 2023",
                    subtitle = "Lundi 03 avril",
                    active = false
                ),
                MessageRow.Data(
                    title = "Virements: nouvelle liste de bénéficiaires",
                    subtitle = "Mardi 21 mars",
                    active = true
                ),
                MessageRow.Data(
                    title = "Sécurité: Spoofing, la fraude par téléphone",
                    subtitle = "Lundi 06 février",
                    active = false
                ),
                MessageRow.Data(
                    title = "Fonds de Garantie des Dépots et de Résolution",
                    subtitle = "Mercredi 18 janvier",
                    active = false
                ),
                MessageRow.Data(
                    title = "Modification de votre convention de compte",
                    subtitle = "Mercredi 18 janvier",
                    active = false
                ),
                MessageRow.Data(
                    title = "Virements: nouvelle liste de bénéficiaires",
                    subtitle = "Samedi 14 janvier",
                    active = false
                ),
                MessageRow.Data(
                    title = "Opératon refusée",
                    subtitle = "Lundi 06 janvier",
                    active = false
                ),
            )
        )


    }

}