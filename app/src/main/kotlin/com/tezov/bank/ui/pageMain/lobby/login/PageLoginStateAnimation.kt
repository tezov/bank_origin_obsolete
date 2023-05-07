/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 17:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 03/05/2023 21:39
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.screen.login

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.properties.Delegates

data class PageLoginStateAnimation(
    private val animationStep: MutableTransitionState<AnimationStep>,
    val animatedLogo: AnimatedLogo,
    val animatedScreen: AnimatedScreen,
) {

    enum class AnimationStep {
        Idle,
        Running,
        Done;

        companion object {
            val Saver = run {
                val keyStep = "keyStep"
                mapSaver(
                    save = { mapOf(keyStep to it.currentState.name) },
                    restore = { MutableTransitionState(valueOf(it[keyStep] as String)) }
                )
            }
        }
    }

    companion object {
        val ANIMATION_LOGO_WIDTH = 200.dp
        const val ANIMATION_LOGO_SMALL_SCALE = 1.8f
        const val ANIMATION_TRANSLATE_DURATION_ms = 500

        @Composable
        fun remember(): PageLoginStateAnimation {
            val animationStep by rememberSaveable(stateSaver = AnimationStep.Saver) {
                mutableStateOf(MutableTransitionState(AnimationStep.Done))
            }
            val animatedLogo = AnimatedLogo(TransitionLogoTranslate()).apply {
                width = ANIMATION_LOGO_WIDTH
            }
            val animatedScreen = AnimatedScreen(TransitionScreenFade())
            return PageLoginStateAnimation(animationStep, animatedLogo, animatedScreen)
        }
    }

    var onAnimationEnd: (() -> Unit)? = null
    val isNotDone get() = animationStep.currentState != AnimationStep.Done
    val isDone get() = animationStep.currentState == AnimationStep.Done

    fun startTransition() {
        with(animationStep) {
            if (isIdle && (currentState == AnimationStep.Idle || currentState == AnimationStep.Done)) {
                targetState = AnimationStep.Running
            }
        }
    }

    @Composable
    fun updateTransition() {
        with(animationStep) {
            when {
                isIdle && currentState == AnimationStep.Running -> {
                    animationStep.targetState = AnimationStep.Done
                    onAnimationEnd?.invoke()
                }
                else -> {}
            }
        }
        val transition = updateTransition(animationStep)
        animatedLogo.transition.update(transition)
        animatedScreen.transition.update(transition)
    }

    class AnimatedLogo(val transition: TransitionLogo) {
        var width by Delegates.notNull<Dp>()
        fun animate(modifier: Modifier) = transition.animate(
            this,
            modifier
                .width(width)
                .aspectRatio(1.0f)
        )
    }

    abstract class TransitionLogo {
        @Composable
        internal abstract fun update(transition: Transition<AnimationStep>)
        abstract fun animate(animatedLogo: AnimatedLogo, modifier: Modifier): Modifier
    }

    class TransitionLogoTranslate : TransitionLogo() {
        lateinit var translateFactor: State<Float>
        lateinit var scaleProgress: State<Float>

        @Composable
        override fun update(transition: Transition<AnimationStep>) {
            translateFactor = transition.animateFloat(
                transitionSpec = {
                    tween(durationMillis = ANIMATION_TRANSLATE_DURATION_ms, easing = LinearEasing)
                }
            ) { s ->
                when (s) {
                    AnimationStep.Idle -> 1.0f
                    else -> 0.0f
                }
            }
            scaleProgress = transition.animateFloat(
                transitionSpec = {
                    tween(durationMillis = ANIMATION_TRANSLATE_DURATION_ms, easing = LinearEasing)
                }
            ) { s ->
                when (s) {
                    AnimationStep.Idle -> ANIMATION_LOGO_SMALL_SCALE
                    else -> 1.0f
                }
            }
        }

        override fun animate(animatedLogo: AnimatedLogo, modifier: Modifier) =
            modifier
                .scale(scaleProgress.value)
                .graphicsLayer {
                    translationY = (animatedLogo.width * translateFactor.value).toPx()
                }
    }

    class AnimatedScreen(val transition: TransitionScreen) {
        fun animate(modifier: Modifier) = transition.animate(this, modifier)
    }

    abstract class TransitionScreen {
        @Composable
        internal abstract fun update(transition: Transition<AnimationStep>)
        abstract fun animate(animatedLogo: AnimatedScreen, modifier: Modifier): Modifier
    }

    class TransitionScreenFade : TransitionScreen() {
        lateinit var fadeFactor: State<Float>
        lateinit var scaleProgress: State<Float>

        @Composable
        override fun update(transition: Transition<AnimationStep>) {
            fadeFactor = transition.animateFloat(
                transitionSpec = {
                    tween(durationMillis = ANIMATION_TRANSLATE_DURATION_ms, easing = LinearEasing)
                }
            ) { s ->
                when (s) {
                    AnimationStep.Idle -> 0.0f
                    else -> 1.0f
                }
            }
            scaleProgress = transition.animateFloat(
                transitionSpec = {
                    tween(durationMillis = ANIMATION_TRANSLATE_DURATION_ms, easing = LinearEasing)
                }
            ) { s ->
                when (s) {
                    AnimationStep.Idle -> 0.5f
                    else -> 1.0f
                }
            }
        }

        override fun animate(animatedLogo: AnimatedScreen, modifier: Modifier) =
            modifier
                .alpha(fadeFactor.value)
                .scale(scaleProgress.value)
    }


}