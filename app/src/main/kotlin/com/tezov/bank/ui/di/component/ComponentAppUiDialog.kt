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

package com.tezov.bank.ui.di.component

import com.tezov.bank.ui.bottomsheet.account.accountIncoming.BottomSheetAccountIncomingAction
import com.tezov.bank.ui.bottomsheet.account.accountIncoming.BottomSheetAccountIncomingState
import com.tezov.bank.ui.di.module.ModuleAppUiDialog
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppConfirmationAction
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppConfirmationState
import com.tezov.bank.ui.dialog.lobby.login.loginAuth.DialogLoginAuthAction
import com.tezov.bank.ui.dialog.lobby.login.loginAuth.DialogLoginAuthState
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiDialog
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentContextLazy
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiDialog
import dagger.Component

object ComponentAppUiDialog {

    @ScopeAppUiDialog
    @Component(
        dependencies = [ComponentCoreUiDialog.EntryPoint::class, ComponentAppUiPage.EntryPoint::class],
        modules = [ModuleAppUiDialog.MapperContext::class]
    )
    interface EntryPoint {

        @Component.Factory
        interface Factory {
            fun create(
                componentCore: ComponentCoreUiDialog.EntryPoint,
                componentAppPage: ComponentAppUiPage.EntryPoint
            ): EntryPoint
        }

        fun contextLoginAuth(): ComponentContextLazy<DialogLoginAuthState, DialogLoginAuthAction>
        fun contextAuthCloseAppConfirmation(): ComponentContextLazy<DialogAuthCloseAppConfirmationState, DialogAuthCloseAppConfirmationAction>

        fun contextAccountIncoming(): ComponentContextLazy<BottomSheetAccountIncomingState, BottomSheetAccountIncomingAction>

    }

}

