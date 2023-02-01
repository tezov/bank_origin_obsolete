/*
 *  *********************************************************************************
 *  Created by Tezov on 01/02/2023 22:00
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/02/2023 21:49
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.help

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.tezov.bank.R
import com.tezov.bank.ui.page.auth.discover.PageDiscoverState
import com.tezov.bank.ui.page.lobby.help_and_service.PageHelpAndServiceState
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageHelpState private constructor(
    val emergencies: SnapshotStateList<ActionRowData>,
    val paymentModes: SnapshotStateList<ActionRowData>,
    val configuration: SnapshotStateList<ActionRowData>,
    val account: SnapshotStateList<ActionRowData>,
    val misc: SnapshotStateList<ActionRowData>,
) : PageState {

    companion object {
        fun create(
            emergencies: SnapshotStateList<ActionRowData> = mutableStateListOf(),
            paymentModes: SnapshotStateList<ActionRowData> = mutableStateListOf(),
            configuration: SnapshotStateList<ActionRowData> = mutableStateListOf(),
            account: SnapshotStateList<ActionRowData> = mutableStateListOf(),
            misc: SnapshotStateList<ActionRowData> = mutableStateListOf(),

        ) = PageHelpState(
            emergencies = emergencies,
            paymentModes = paymentModes,
            configuration = configuration,
            account = account,
            misc = misc,
        )
    }


    data class ActionRowData(
        val title: String,
        val iconActionResourceId: Int = R.drawable.ic_arrow_cut_right_24dp,
    )

    init {

        emergencies.addAll(
            listOf(
                ActionRowData("title"),

            )
        )

        paymentModes.addAll(
            listOf(
                ActionRowData("title"),

                )
        )

        configuration.addAll(
            listOf(
                ActionRowData("title"),

                )
        )

        account.addAll(
            listOf(
                ActionRowData("title"),

                )
        )

        misc.addAll(
            listOf(
                ActionRowData("title"),

                )
        )
    }

}