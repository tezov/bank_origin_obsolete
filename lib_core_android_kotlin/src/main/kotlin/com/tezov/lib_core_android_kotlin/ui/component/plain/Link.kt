/*
 *  *********************************************************************************
 *  Created by Tezov on 05/03/2023 20:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/03/2023 20:09
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.plain

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitStateDual
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.State.resolve
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateDualColor

object Link {

    object Underlined{

        open class Style(
            val outfitText: OutfitTextStateDualColor = OutfitTextStateDualColor(
                outfitState = OutfitStateDual(
                    active = Color.Black,
                    inactive = Color.Gray,
                )
            ),
        ){
            companion object{

                open class Builder internal constructor(style: Style) {
                    var outfitText = style.outfitText

                    internal fun get() = Style(
                        outfitText = outfitText,
                    )
                }

                @Composable
                fun Style.copy(builder: @Composable Builder.()->Unit = {}) = Builder(this).also {
                    it.builder()
                }.get()

            }

            constructor(style: Style) : this(
                outfitText = style.outfitText,
            )
        }

        @Composable
        operator fun invoke(
            text:String,
            modifier: Modifier = Modifier,
            enabled: Boolean = true,
            style:Style = Style(),
            onClick: () -> Unit = {},
        ){
            ClickableText(
                modifier = modifier,
                text = AnnotatedString(text),
                style = style.outfitText.resolve(enabled),
            ) {
                onClick()
            }
        }

    }

}