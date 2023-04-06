/*
 *  *********************************************************************************
 *  Created by Tezov on 06/04/2023 23:14
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/04/2023 23:14
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.type.primaire.dpSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPalette.Color.Style.Companion.asPaletteColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPalette.Size.Style.Companion.asPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteColorSemantic
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Semantic.Style.Companion.asStateSemantic
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitStateDual
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitStateSemantic
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style.Nucleus.Color as ButtonNucleus
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link.StateColor.Style.Nucleus.Color as LinkNucleus
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.StateColor.Style.Nucleus as FrameNucleus

val MaterialTheme.colorsCommonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localCommon.current

infix fun MaterialTheme.provides(value: ThemeColorsExtended.Common) =
    ThemeColorsExtended.localCommon provides value

val MaterialTheme.colorsButtonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localButtons.current

infix fun MaterialTheme.provides(value: ThemeColorsExtended.Buttons) =
    ThemeColorsExtended.localButtons provides value

val MaterialTheme.colorsLinkExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localLinks.current

infix fun MaterialTheme.provides(value: ThemeColorsExtended.Links) =
    ThemeColorsExtended.localLinks provides value


object ThemeColorsExtended {

    class Common(
        val background: OutfitPaletteColor,
        val onBackground: OutfitPaletteColor,

        val primary: OutfitPaletteColor,
        val onPrimary: OutfitPaletteColor,

        backgroundElevated: OutfitPaletteColor? = null,
        onBackgroundElevated: OutfitPaletteColor? = null,

        backgroundModal: OutfitPaletteColor? = null,
        onBackgroundModal: OutfitPaletteColor? = null,

        secondary: OutfitPaletteColor? = null,
        onSecondary: OutfitPaletteColor? = null,

        tertiary: OutfitPaletteColor? = null,
        onTertiary: OutfitPaletteColor? = null,

        semantic: OutfitPaletteColorSemantic? = null,
        onSemantic: OutfitPaletteColorSemantic? = null,

        ) {

        val backgroundElevated: OutfitPaletteColor by DelegateNullFallBack(
            backgroundElevated,
            lazyFallBackValue = { background })
        val onBackgroundElevated: OutfitPaletteColor by DelegateNullFallBack(
            onBackgroundElevated,
            lazyFallBackValue = { onBackground })

        val backgroundModal: OutfitPaletteColor by DelegateNullFallBack(
            backgroundModal,
            lazyFallBackValue = { background })
        val onBackgroundModal: OutfitPaletteColor by DelegateNullFallBack(
            onBackgroundModal,
            lazyFallBackValue = { onBackground })

        val secondary: OutfitPaletteColor by DelegateNullFallBack(
            secondary,
            lazyFallBackValue = { primary })
        val onSecondary: OutfitPaletteColor by DelegateNullFallBack(
            onSecondary,
            lazyFallBackValue = { onPrimary })
        val tertiary: OutfitPaletteColor by DelegateNullFallBack(
            tertiary,
            lazyFallBackValue = { primary })
        val onTertiary: OutfitPaletteColor by DelegateNullFallBack(
            onTertiary,
            lazyFallBackValue = { onPrimary })

        val semantic: OutfitPaletteColorSemantic by DelegateNullFallBack(
            semantic,
            lazyFallBackValue = { OutfitPaletteColorSemantic(primary) })
        val onSemantic: OutfitPaletteColorSemantic by DelegateNullFallBack(
            onSemantic,
            lazyFallBackValue = { OutfitPaletteColorSemantic(onPrimary) })

    }

    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

    class Icons(
        modal: OutfitPaletteColorSemantic? = null,
        info: OutfitPaletteColorSemantic? = null,
        action: OutfitPaletteColorSemantic? = null,
        fieldInfo: OutfitPaletteColorSemantic? = null,
        fieldAction: OutfitPaletteColorSemantic? = null,
    ) : DelegateNullFallBack.Group<OutfitPaletteColorSemantic>{

        val modal: OutfitPaletteColorSemantic by DelegateNullFallBack(modal)
        val info: OutfitPaletteColorSemantic by DelegateNullFallBack(info)
        val action: OutfitPaletteColorSemantic by DelegateNullFallBack(action)
        val fieldInfo: OutfitPaletteColorSemantic by DelegateNullFallBack(fieldInfo)
        val fieldAction: OutfitPaletteColorSemantic by DelegateNullFallBack(fieldAction)

        override fun groupFallBackRefs() =
            listOf(modal, info, action, fieldInfo, fieldAction)

        init {
            groupLazyFallBackValue = {
                OutfitStateSemantic(Color.Gray.copy(alpha = 0.5f).asPaletteColor)
            }
        }

    }
    internal val localIcons: ProvidableCompositionLocal<Icons> = staticCompositionLocalOf {
        error("not provided")
    }

    class Buttons(
        primary: ButtonNucleus? = null,
        secondary: ButtonNucleus? = null,
        tertiary: ButtonNucleus? = null,
        confirm: ButtonNucleus? = null,
        cancel: ButtonNucleus? = null,
        proceed: ButtonNucleus? = null,
    ) : DelegateNullFallBack.Group<ButtonNucleus> {

        val primary: ButtonNucleus by DelegateNullFallBack(primary)
        val secondary: ButtonNucleus by DelegateNullFallBack(secondary)
        val tertiary: ButtonNucleus by DelegateNullFallBack(tertiary)
        val confirm: ButtonNucleus by DelegateNullFallBack(confirm)
        val cancel: ButtonNucleus by DelegateNullFallBack(cancel)
        val proceed: ButtonNucleus by DelegateNullFallBack(proceed)

        override fun groupFallBackRefs() =
            listOf(primary, secondary, tertiary, confirm, cancel, proceed)

        init {
            groupLazyFallBackValue = {
                ButtonNucleus(
                    nucleusFrame = FrameNucleus.Color(
                        nucleusShape = OutfitStateDual(
                            active = Color.Gray.copy(alpha = 0.5f),
                            inactive = Color.Gray.copy(alpha = 0.75f)
                        ),
                        nucleusBorder = OutfitStateDual(
                            active = Color.Black,
                            inactive = Color.Black.copy(alpha = 0.5f)
                        )
                    ),
                    nucleusText = OutfitStateDual(
                        active = Color.Black,
                        inactive = Color.Black.copy(alpha = 0.25f)
                    )
                )
            }
        }
    }

    internal val localButtons: ProvidableCompositionLocal<Buttons> = staticCompositionLocalOf {
        error("not provided")
    }

    class Links(
        primary: LinkNucleus? = null,
        secondary: LinkNucleus? = null,
        tertiary: LinkNucleus? = null,
    ) : DelegateNullFallBack.Group<LinkNucleus> {

        val primary: LinkNucleus by DelegateNullFallBack(primary)
        val secondary: LinkNucleus by DelegateNullFallBack(secondary)
        val tertiary: LinkNucleus by DelegateNullFallBack(tertiary)

        override fun groupFallBackRefs() = listOf(primary, secondary, tertiary)

        init {
            groupLazyFallBackValue = {
                LinkNucleus(
                    nucleusText = OutfitStateDual(
                        active = Color.Black,
                        inactive = Color.Black.copy(alpha = 0.25f)
                    )
                )
            }
        }
    }

    internal val localLinks: ProvidableCompositionLocal<Links> = staticCompositionLocalOf {
        error("not provided")
    }

}




