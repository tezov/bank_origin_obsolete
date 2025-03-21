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

package com.tezov.lib_core_android_kotlin.ui.di.module


import androidx.activity.ComponentActivity
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.lifecycleScope
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigation
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigationAction
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigationState
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBar
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBarAction
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBarState
import com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheet
import com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheetAction
import com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheetState
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogState
import com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar
import com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.SnackbarAction
import com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.SnackbarState
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.di.annotation.qualifier.*
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentContextLazy
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentContextMap
import com.tezov.lib_core_android_kotlin.ui.di.helper.ComposableHolder
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


object ModuleCoreUiActivity {

    @Module
    class Provider {
        @ScopeCoreUiActivity
        @QualifierCoroutineScopeMain
        @Provides
        fun provideCoroutineScope() = State.CoroutineScope()

    }

    @Module
    class MapperContext {

        @ScopeCoreUiActivity
        @Provides
        fun provideContextMain(
            state: State.ActivityMainState,
            action: Action.ActivityMainAction
        ) = ComponentContextLazy.make(state, action)

        @ScopeCoreUiActivity
        @Provides
        fun provideContextSub(
            bottomSheet: ComponentContextLazy<BottomSheetState, BottomSheetAction>,
            snackbar: ComponentContextLazy<SnackbarState, SnackbarAction>,
            dialog: ComponentContextLazy<DialogState, DialogAction>,
            bottomNavigation: ComponentContextLazy<BottomNavigationState, BottomNavigationAction>,
            topAppBar: ComponentContextLazy<TopAppBarState, TopAppBarAction>,
        ) = ComponentContextMap.make(
            BottomSheet::class.java to bottomSheet,
            Snackbar::class.java to snackbar,
            Dialog::class.java to dialog,
            BottomNavigation::class.java to bottomNavigation,
            TopAppBar::class.java to topAppBar,
        )


        @ScopeCoreUiActivity
        @Provides
        fun provideBottomSheetContext(
            state: State.BottomSheetState,
            action: Action.BottomSheetAction
        ) = ComponentContextLazy.make(state, action)

        @ScopeCoreUiActivity
        @Provides
        fun provideSnackbarContext(
            state: State.SnackbarState,
            action: Action.SnackbarAction
        ) = ComponentContextLazy.make(state, action)

        @ScopeCoreUiActivity
        @Provides
        fun provideDialogContext(
            state: State.DialogState,
            action: Action.DialogAction
        ) = ComponentContextLazy.make(state, action)

        @ScopeCoreUiActivity
        @Provides
        fun provideBottomNavigationContext(
            state: State.BottomNavigationState,
            action: Action.BottomNavigationAction
        ) = ComponentContextLazy.make(state, action)

        @ScopeCoreUiActivity
        @Provides
        fun provideTopNavigationContext(
            state: State.TopNavigationState,
            action: Action.TopNavigationAction
        ) = ComponentContextLazy.make(state, action)

    }

    object State {

        class CoroutineScope : ComposableHolder<kotlinx.coroutines.CoroutineScope>() {
            @androidx.compose.runtime.Composable
            override fun create() = (LocalContext.current as ComponentActivity).lifecycleScope
        }

        @ScopeCoreUiActivity
        class ActivityMainState @Inject constructor(
            private val scaffoldState: ScaffoldState
        ) : ComposableHolder<com.tezov.lib_core_android_kotlin.ui.activity.ActivityMainState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.lib_core_android_kotlin.ui.activity.ActivityMainState.create(scaffoldState.get())
        }

        @ScopeCoreUiActivity
        class ScaffoldState @Inject constructor() :
            ComposableHolder<androidx.compose.material.ScaffoldState>() {
            @androidx.compose.runtime.Composable
            override fun create() = ScaffoldState(
                DrawerState(DrawerValue.Closed, confirmStateChange = { true }),
                SnackbarHostState()
            )
        }

        @ScopeCoreUiActivity
        class SnackbarState @Inject constructor(private val scaffoldState: ScaffoldState) :
            ComposableHolder<com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.SnackbarState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.SnackbarState.create(
                    scaffoldState.get().snackbarHostState
                )
        }

        @ScopeCoreUiActivity
        class BottomSheetState @Inject constructor() :
            ComposableHolder<com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheetState>() {
            @OptIn(ExperimentalMaterialApi::class)
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheetState.create()
        }

        @ScopeCoreUiActivity
        class DialogState @Inject constructor() :
            ComposableHolder<com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogState.create()
        }

        @ScopeCoreUiActivity
        class BottomNavigationState @Inject constructor() :
            ComposableHolder<com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigationState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigationState.create()
        }

        @ScopeCoreUiActivity
        class TopNavigationState @Inject constructor() : ComposableHolder<TopAppBarState>() {
            @androidx.compose.runtime.Composable
            override fun create() = TopAppBarState.create()
        }
    }

    object Action {

        @ScopeCoreUiActivity
        class ActivityMainAction @Inject constructor(
            @QualifierCoroutineScopeMain private val coroutineScope: State.CoroutineScope,
            private val navigationController: NavigationController,
        ) : ComposableHolder<com.tezov.lib_core_android_kotlin.ui.activity.ActivityMainAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.lib_core_android_kotlin.ui.activity.ActivityMainAction.create(
                    coroutineScope = coroutineScope.get(),
                    navigationController = navigationController.get(),
                )
        }

        @ScopeCoreUiActivity
        class SnackbarAction @Inject constructor(
            @QualifierCoroutineScopeMain private val coroutineScope: State.CoroutineScope,
            private val scaffoldState: State.ScaffoldState,
        ) : ComposableHolder<com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.SnackbarAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.SnackbarAction.create(
                    coroutineScope.get(),
                    scaffoldState.get().snackbarHostState,
                )
        }

        @ScopeCoreUiActivity
        class BottomSheetAction @Inject constructor(
            private val bottomSheetState: State.BottomSheetState,
        ) : ComposableHolder<com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheetAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheetAction.create(
                    bottomSheetState.get()
                )
        }

        @ScopeCoreUiActivity
        class DialogAction @Inject constructor(
            private val dialogState: State.DialogState,
        ) : ComposableHolder<com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction.create(
                    dialogState.get()
                )
        }

        @ScopeCoreUiActivity
        class BottomNavigationAction @Inject constructor(
            private val navigationController: NavigationController,
        ) : ComposableHolder<com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigationAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigationAction.create(
                    navigationController.get()
                )
        }

        @ScopeCoreUiActivity
        class TopNavigationAction @Inject constructor(
            private val navigationController: NavigationController,
        ) : ComposableHolder<TopAppBarAction>() {
            @androidx.compose.runtime.Composable
            override fun create() = TopAppBarAction.create(
                navigationController.get()
            )
        }

        @ScopeCoreUiActivity
        class NavigationController @Inject constructor(
            private val snackbarAction: SnackbarAction
        ) : ComposableHolder<com.tezov.lib_core_android_kotlin.navigation.NavigationController>() {

            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.lib_core_android_kotlin.navigation.NavigationController.create(
                    snackbarAction.get()
                )
        }

    }

}

