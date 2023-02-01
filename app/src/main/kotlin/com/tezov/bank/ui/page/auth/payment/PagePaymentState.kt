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

package com.tezov.bank.ui.page.auth.payment

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.tezov.bank.R
import com.tezov.bank.ui.page.auth.discover.PageDiscoverState
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState

class PagePaymentState private constructor(
    val actionCardData: SnapshotStateList<ActionCardData>,
    val actionCardRichData: SnapshotStateList<ActionCardRichData>,
) : PageState {

    companion object {
        fun create(
            actionCardData: SnapshotStateList<ActionCardData> = mutableStateListOf(),
            actionCardRichData: SnapshotStateList<ActionCardRichData> = mutableStateListOf(),
        ) = PagePaymentState(
            actionCardData = actionCardData,
            actionCardRichData = actionCardRichData,
        )
    }


    data class ActionCardData(
        val title: String,
        val iconResourceId: Int,
    )

    data class ActionCardRichData(
        val title: String,
        val subtitle: String,
        val iconResourceId: Int,
    )

    init {

        actionCardData.addAll(
            listOf(
                ActionCardData("title", R.drawable.ic_call_24dp),

            )
        )

        actionCardRichData.addAll(
            listOf(
                ActionCardRichData("title", "subtitle", R.drawable.ic_call_24dp),

            )
        )

    }

}