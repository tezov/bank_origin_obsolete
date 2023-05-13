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

package com.tezov.lib_core_android_kotlin.ui.component.chunk

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.type.primaire.size
import com.tezov.lib_core_android_kotlin.ui.modifier.thenOnNotNull
import com.tezov.lib_core_android_kotlin.ui.theme.style.*

object Image {

    object Simple {

        class StyleBuilder internal constructor(style: Style) {
            var size = style.size
            var tint = style.tint

            internal fun get() = Style(
                size = size,
                tint = tint,
            )
        }

        class Style(
            val size: DpSize? = null,
            val tint: Color? = null,
            val contentScale: ContentScale = ContentScale.Fit,
        ) {

            companion object {

                @Composable
                fun Style.copy(builder: @Composable StyleBuilder.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()

            }

            constructor(style: Style) : this(
                size = style.size,
                tint = style.tint,
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: Style = Style(),
            painter: Painter,
            description: String? = null,
        ) {
            Image(
                modifier = modifier.thenOnNotNull(style.size){
                    size(it)
                },
                painter = painter,
                colorFilter = style.tint?.let { ColorFilter.tint(it) },
                contentDescription = description,
                contentScale = style.contentScale
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: Style = Style(),
            resourceId: Int,
            description: String? = null,
        ) {
            invoke(
                modifier,
                style,
                painterResource(id = resourceId),
                description
            )
        }

    }

    object StateColor {

        class StyleBuilder internal constructor(style: Style) {
            var size = style.size
            var tint = style.tint
            var outfitFrame = style.outfitFrame
            var contentScale = style.contentScale

            internal fun get() = Style(
                size = size,
                tint = tint,
                outfitFrame = outfitFrame,
                contentScale = contentScale,
            )
        }

        class Style(
            val size: DpSize? = null,
            val tint: Color? = null,
            val outfitFrame: OutfitFrameStateColor? = null,
            val contentScale: ContentScale = ContentScale.Fit
        ) {

            companion object {

                @Composable
                fun Style.copy(builder: @Composable StyleBuilder.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()

            }

            constructor(style: Style) : this(
                size = style.size,
                tint = style.tint,
                outfitFrame = style.outfitFrame,
                contentScale = style.contentScale,
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: Style = Style(),
            painter: Painter,
            description: String? = null,
            selector: Any? = null
        ) {

            Image(
                modifier = modifier
                    .thenOnNotNull(style.size){
                        size(it)
                    }
                    .thenOnNotNull(style.outfitFrame){
                        background(it, selector)
                    },
                painter = painter,
                colorFilter = style.tint?.let { ColorFilter.tint(it) },
                contentDescription = description,
                contentScale = style.contentScale
            )

        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: Style = Style(),
            resourceId: Int,
            description: String? = null,
            selector: Any? = null
        ) {
            invoke(
                modifier,
                style,
                painterResource(id = resourceId),
                description,
                selector
            )

        }

    }


}