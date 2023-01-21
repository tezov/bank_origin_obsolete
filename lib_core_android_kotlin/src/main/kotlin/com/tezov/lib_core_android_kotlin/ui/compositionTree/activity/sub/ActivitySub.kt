package com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub

import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition

interface ActivitySub<S: ActivitySubState, A: ActivitySubAction<S>>: Composition<S, A>