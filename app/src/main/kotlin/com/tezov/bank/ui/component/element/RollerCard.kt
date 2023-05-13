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

package com.tezov.bank.ui.component.element

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Image
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.modifier.thenOnNotNull
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeColorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack


object RollerCard {

    class StyleBuilder internal constructor(
        style: Style
    ) {
        var outfitFrame = style.outfitFrame
        var styleImage = style.styleImage
        var outfitTextTitle = style.outfitTextTitle

        internal fun get() = Style(
            outfitFrame = outfitFrame,
            styleImage = styleImage,
            outfitTextTitle = outfitTextTitle,
        )
    }

    class Style(
        outfitFrame: OutfitFrameStateColor? = null,
        styleImage: Image.Simple.Style? = null,
        val outfitTextTitle: OutfitTextStateColor? = null,
    ) {
        val outfitFrame: OutfitFrameStateColor by DelegateNullFallBack.Ref(
            outfitFrame,
            fallBackValue = {
                ThemeColorsExtended.Dummy.outfitFrameState
            }
        )
        val styleImage: Image.Simple.Style by DelegateNullFallBack.Ref(
            styleImage,
            fallBackValue = {
                Image.Simple.Style(
                    size = DpSize(96.dp)
                )
            }
        )

        companion object {

            @Composable
            fun Style.copy(
                builder: @Composable StyleBuilder.() -> Unit = {}
            ) = StyleBuilder(this).also {
                it.builder()
            }.get()

        }

        constructor(style: Style?) : this(
            outfitFrame = style?.outfitFrame,
            styleImage = style?.styleImage,
            outfitTextTitle = style?.outfitTextTitle,
        )

    }

    data class Data(
        val imageId: Int,
        val title: String,
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style: Style,
        data: Data,
        onClick: (() -> Unit)? = null
    ) {
        Column(
            modifier = modifier
                .background(style.outfitFrame)
                .thenOnNotNull(onClick) {
                    clickable { it() }
                }
                .padding(MaterialTheme.dimensionsPaddingExtended.block.small)
        ) {
            Image.Simple(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                resourceId = data.imageId,
                description = null,
                style = style.styleImage
            )
            Box(
                modifier = Modifier
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.element.small.vertical)
                    .height(40.dp)
            ) {
                Text.StateColor(
                    modifier = Modifier.align(Alignment.BottomStart),
                    text = data.title,
                    style = style.outfitTextTitle
                )
            }
        }
    }


}




