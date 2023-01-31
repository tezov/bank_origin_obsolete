/*
 *  *********************************************************************************
 *  Created by Tezov on 31/01/2023 19:25
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 31/01/2023 19:25
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.profile

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction

class PageProfileAction private constructor(
    private val navigationController: NavigationController,
) :
    PageAction<PageProfileState> {


    companion object {
        @Composable
         fun create(
            navigationController: NavigationController
        ) = PageProfileAction(
                navigationController = navigationController,
            )
    }


}