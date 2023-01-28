package com.tezov.lib_core_android_kotlin.ui.component.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*

infix fun KeyBoard.GridCube.provides(value: KeyBoard.GridCube.Style) = KeyBoard.GridCube.local provides value

object KeyBoard {

    object GridCube {

        internal val local: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
            error("not provided")
        }

        @Immutable
        data class Style(
            val background:Int
        )

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,

        ){
            Content(modifier, )
        }

        @OptIn(ExperimentalPagerApi::class)
        @Composable
        private fun Content(
            modifier: Modifier = Modifier,

        ) {

        }
    }

}