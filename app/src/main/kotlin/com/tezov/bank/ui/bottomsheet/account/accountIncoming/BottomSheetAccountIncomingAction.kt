/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 14:37
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 14:19
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.bottomsheet.account.accountIncoming

import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.bottomSheet.BottomSheetAction

class BottomSheetAccountIncomingAction private constructor(
    private val action: com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheetAction,
) : BottomSheetAction<BottomSheetAccountIncomingState> {


    companion object {
        fun create(
            action: com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheetAction,
        ) = BottomSheetAccountIncomingAction(
            action = action,
        )
    }


    fun onClickClose() {
        action.close()
    }

}