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

