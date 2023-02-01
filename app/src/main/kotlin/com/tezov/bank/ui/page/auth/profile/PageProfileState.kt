/*
 *  *********************************************************************************
 *  Created by Tezov on 01/02/2023 22:00
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/02/2023 21:59
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.profile

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.tezov.bank.R
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageProfileState private constructor(
    val profils: SnapshotStateList<ActionRowRichData>,
    val documents: SnapshotStateList<ActionRowData>,
    val offers: SnapshotStateList<ActionRowData>,
    val help: SnapshotStateList<ActionRowData>,

    ) : PageState {

    companion object {
        fun create(
            profils: SnapshotStateList<ActionRowRichData> = mutableStateListOf(),
            documents: SnapshotStateList<ActionRowData> = mutableStateListOf(),
            offers: SnapshotStateList<ActionRowData> = mutableStateListOf(),
            help: SnapshotStateList<ActionRowData> = mutableStateListOf(),

            ) = PageProfileState(
            profils = profils,
            documents = documents,
            offers = offers,
            help = help,
        )
    }

    data class ActionRowData(
        val title: String,
        val iconActionResourceId: Int = R.drawable.ic_arrow_cut_right_24dp,
    )

    data class ActionRowRichData(
        val title: String,
        val iconInfoResourceId: Int? = null,
        val iconActionResourceId: Int = R.drawable.ic_arrow_cut_right_24dp,
    )


    init {

        profils.addAll(
            listOf(
                ActionRowRichData("title", R.drawable.ic_call_24dp),

                )
        )

        documents.addAll(
            listOf(
                ActionRowData("title"),

                )
        )

        offers.addAll(
            listOf(
                ActionRowData("title"),

                )
        )

        help.addAll(
            listOf(
                ActionRowData("title"),

                )
        )

    }


}