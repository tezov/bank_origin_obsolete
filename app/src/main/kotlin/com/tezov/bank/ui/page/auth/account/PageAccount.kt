/*
 *  *********************************************************************************
 *  Created by Tezov on 19/04/2023 22:26
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/04/2023 22:25
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.account

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.InspectorInfo
import androidx.compose.ui.platform.InspectorValueInfo
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.*
import androidx.compose.ui.util.fastForEachIndexed
import androidx.compose.ui.util.fastMap
import com.tezov.bank.ui.component.block.SectionAccountValueSimpleRow
import com.tezov.bank.ui.component.element.AccountSummaryCard
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.state
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal
import com.tezov.lib_core_android_kotlin.ui.theme.style.background
import kotlin.math.max

object PageAccount : Page<PageAccountState, PageAccountAction> {

    private const val DIVIDER_HEADER_VISIBILITY_START = 0.3f

    @Composable
    override fun Page<PageAccountState, PageAccountAction>.content(innerPadding: PaddingValues) {
        val accessor = AccessorAppUiPage().get(requester = this).contextAccount()
        val action = accessor.action()
        val state = accessor.state()
        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                PageAccountTheme provides PageAccountTheme.provideColors(),
                PageAccountTheme provides PageAccountTheme.provideDimensions(),
            ),
            parent = {
                arrayOf(
                    PageAccountTheme provides PageAccountTheme.provideTypographies(),
                )
            },
            child = {
                arrayOf(
                    PageAccountTheme provides PageAccountTheme.provideStyles(),
                )
            }
        ) {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .background(Color.Gray)
                ){

                    ShrinkableCard(
                        modifier = Modifier.background(Color.Cyan)
                    ){

                        Box(modifier = Modifier
                            .fillMaxWidth(0.3f)
                            .height(75.dp)
                            .heightFactor(1.0f)
                            .background(Color.Red))
                    }

                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .background(Color.Yellow))

                }



            }

//            ColumnCollapsibleHeader(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(PageAccountTheme.colors.background)
//                    .padding(innerPadding),
//                properties = PageAccountTheme.dimensions.headerProperties,
//                header = { progress, progressDp ->
//                    contentHeader(
//                        state.header,
//                        progress,
//                        progressDp
//                    )
//                },
//                body = {
//                    contentBody(state.accountHistories)
//                }
//            )
        }
    }

    @Composable
    private fun ShrinkableCard(
        modifier: Modifier = Modifier,
        content: @Composable ShrinkableCardScope.() -> Unit
    ) {
        val measurePolicy = remember {
            shrinkableCardMeasurePolicy()
        }
        Layout(
            content = { ShrinkableCardInstance.content() },
            measurePolicy = measurePolicy,
            modifier = modifier
        )
    }

    fun shrinkableCardMeasurePolicy(): MeasurePolicy {

        return object : MeasurePolicy {

            val Measurable.heightFactor: Float? get() = (parentData as? ShrinkableCardParentData)?.heightFactor

            override fun MeasureScope.measure(
                measurables: List<Measurable>,
                constraints: Constraints
            ): MeasureResult {
                if (measurables.isEmpty()) {
                    return layout(
                        constraints.minWidth,
                        constraints.minHeight
                    ) {}
                }
                var boxWidth = constraints.minWidth
                var boxHeight = constraints.minHeight
                val placeables = arrayOfNulls<Placeable>(measurables.size)
                measurables.fastForEachIndexed { index, measurable ->
                    val measureConstraints = measurable.heightFactor?.let { factor ->
//                        constraints.copy(maxHeight = measurable.maxIntrinsicHeight(constraints.maxWidth) / 2)
                        constraints
                    } ?: kotlin.run {
                        constraints
                    }
                    val placeable = measurable.measure(measureConstraints)
                    placeables[index] = placeable
                    boxWidth = max(boxWidth, placeable.width)
                    boxHeight = max(boxHeight, placeable.height)
                }
                return layout(boxWidth, boxHeight) {
                    placeables.forEachIndexed { index, placeable ->
                        placeable as Placeable
                        placeable.placeRelative(IntOffset(boxWidth/2, boxHeight/5))
                    }
                }
            }

        }
    }

    interface ShrinkableCardScope {
        fun Modifier.heightFactor(value: Float): Modifier
    }

    object ShrinkableCardInstance : ShrinkableCardScope {

        override fun Modifier.heightFactor(value: Float): Modifier {
            require(value >= 0.0f) { "invalid heightFactor $value; must be greater or equal than zero" }
            require(value <= 1.0f) { "invalid heightFactor $value; must be lesser or equal than zero" }
            return this.then(
                LayoutHeightFactorImpl(
                    value = value,
                    inspectorInfo = debugInspectorInfo {
                        name = "heightFactor"
                        this.value = value
                        properties["value"] = value
                    }
                )
            )
        }
    }

    class LayoutHeightFactorImpl(
        val value: Float,
        inspectorInfo: InspectorInfo.() -> Unit
    ) : ParentDataModifier, InspectorValueInfo(inspectorInfo) {

        override fun Density.modifyParentData(parentData: Any?) =
            ((parentData as? ShrinkableCardParentData) ?: ShrinkableCardParentData()).also {
                it.heightFactor = value
            }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            val otherModifier = other as? LayoutHeightFactorImpl ?: return false
            return value == otherModifier.value
        }

        override fun hashCode(): Int {
            var result = value.hashCode()
            result = 31 * result + value.hashCode()
            return result
        }

        override fun toString(): String =
            "LayoutHeightImpl(weight=$value)"
    }

    data class ShrinkableCardParentData(
        var heightFactor: Float? = null,
    )


    @Composable
    private fun contentHeader(
        header: PageAccountState.Header,
        progress: Float,
        progressDp: Dp,
    ) {
        header.accountSummary.value?.let {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(progressDp)
                    .background(Color.Blue),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {

                AccountSummaryCard(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .background(Color.Red),
                    style = PageAccountTheme.styles.accountSummary,
                    data = it
                )

            }
        }
    }

    @Composable
    private fun contentBody(
        accountHistories : MutableState<List<SectionAccountValueSimpleRow.Data>?>
    ){
        accountHistories.value?.let { list ->
            list.forEach { data ->
                SectionAccountValueSimpleRow(
                    data = data,
                    style = PageAccountTheme.styles.sectionAccountValue
                ) {

                }
            }
        }
    }

    @Composable
    override fun handleOnBackPressed() = DialogAuthCloseAppController.handleOnBackPressed()

}