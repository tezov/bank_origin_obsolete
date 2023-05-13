/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

package com.tezov.bank.ui.pageMain.auth.payment

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction

class PagePaymentAction private constructor(
    private val navigationController: NavigationController,
) :
    PageAction<PagePaymentState> {


    companion object {
        @Composable
        fun create(
            navigationController: NavigationController
        ) = PagePaymentAction(
            navigationController = navigationController,
        )
    }

    fun onClickCardsSmall(index: Int) {
        navigationController.showSnackBarNotImplemented("click card small $index")
    }

    fun onClickCardsLarge(index: Int) {
        navigationController.showSnackBarNotImplemented("click card large $index")
    }


}