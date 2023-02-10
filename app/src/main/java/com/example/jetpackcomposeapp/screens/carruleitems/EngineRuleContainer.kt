package com.example.jetpackcomposeapp.screens.carruleitems

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.jetpackcomposeapp.R


//Container for Controlling Engine state items
@Composable
fun EngineRuleContainer(
    modifier: Modifier
) {
    ConstraintLayout(
        modifier = modifier
    ) {
        val (
            titleRow, buttonsBackgroundBox, firstButton, secondButton
        ) = createRefs()
        val guildLineFromStart1 = createGuidelineFromStart(0.08f)
        val guildLineFromStart2 = createGuidelineFromStart(0.495f)
        val guildLineFromStart3 = createGuidelineFromStart(0.505f)
        val guildLineFromStart4 = createGuidelineFromStart(0.92f)
        Row(
            modifier = Modifier
                .constrainAs(titleRow) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }
                .padding(bottom = 5.dp)
        ) {
            Text(
                text = stringResource(R.string.engine),
                style = MaterialTheme.typography.h4.merge(),
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 10.dp),
                textAlign = TextAlign.Start,
            )
        }
        Box(
            modifier = Modifier
                .constrainAs(buttonsBackgroundBox) {
                    top.linkTo(titleRow.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(Color.White, RectangleShape)) {}

        EngineRuleItem(
            stringResource(R.string.start),
            modifier = Modifier
                .constrainAs(firstButton) {
                    top.linkTo(titleRow.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(guildLineFromStart1)
                    end.linkTo(guildLineFromStart2)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }
        )
        EngineRuleItem(
            stringResource(R.string.stop),
            modifier = Modifier
                .constrainAs(secondButton) {
                    top.linkTo(titleRow.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(guildLineFromStart3)
                    end.linkTo(guildLineFromStart4)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }
        )

    }
}
