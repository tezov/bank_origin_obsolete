/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 14:37
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 13:58
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.bottomsheet.account.accountIncoming

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.bottomSheet.BottomSheetState

class BottomSheetAccountIncomingState private constructor(

) : BottomSheetState {

    companion object {

        @Composable
        fun create() = BottomSheetAccountIncomingState()
    }

}