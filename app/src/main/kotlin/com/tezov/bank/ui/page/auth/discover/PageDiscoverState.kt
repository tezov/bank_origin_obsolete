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

package com.tezov.bank.ui.page.auth.discover

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.tezov.bank.R
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PageDiscoverState private constructor(
    val cardWithButtonData: SnapshotStateList<CardButtonData>,
    val cardWithLinkData: SnapshotStateList<CardLinkData>,
    val actionCardData: SnapshotStateList<ActionRowRichData>,
    val actionRowData: SnapshotStateList<ActionRowData>,
) : PageState {

    companion object {
        fun create(
            cardWithButtonData: SnapshotStateList<CardButtonData> = mutableStateListOf(),
            cardWithLinkData: SnapshotStateList<CardLinkData> = mutableStateListOf(),
            actionCardData: SnapshotStateList<ActionRowRichData> = mutableStateListOf(),
            actionRowData: SnapshotStateList<ActionRowData> = mutableStateListOf(),
        ) = PageDiscoverState(
            cardWithButtonData = cardWithButtonData,
            cardWithLinkData = cardWithLinkData,
            actionCardData = actionCardData,
            actionRowData = actionRowData,
        )
    }

    data class CardButtonData(
        val title:String,
        val text:String,
        val textButton:String,
        val iconResourceId:Int,
    )

    data class CardLinkData(
        val title:String,
        val text:String,
        val textLink:String,
        val iconResourceId:Int,
    )

    data class ActionCardData(
        val title: String,
        val iconResourceId: Int,
    )

    data class ActionRowRichData(
        val title: String,
        val iconInfoResourceId: Int? = null,
        val iconActionResourceId: Int = R.drawable.ic_arrow_cut_right_24dp,
    )

    data class ActionRowData(
        val title: String,
        val iconActionResourceId: Int = R.drawable.ic_arrow_cut_right_24dp,
    )


    init {
        cardWithButtonData.addAll(
            listOf(
                CardButtonData("title", "text", "button", R.drawable.ic_call_24dp),

            )
        )

        cardWithLinkData.addAll(
            listOf(
                CardLinkData("title", "text", "link", R.drawable.ic_call_24dp),

            )
        )

        actionCardData.addAll(
            listOf(
                ActionRowRichData("title", R.drawable.ic_call_24dp),

            )
        )

        actionRowData.addAll(
            listOf(
                ActionRowData("title"),
                ActionRowData("title"),
                ActionRowData("title"),
                ActionRowData("title"),
            )
        )

    }


}