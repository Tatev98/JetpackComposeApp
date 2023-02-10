package com.example.jetpackcomposeapp.screens.carruleitems

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
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
import com.example.jetpackcomposeapp.ui.theme.lightGray


//Container for Doors State Controlling items
@Composable
fun DoorsRuleContainer(
    modifier: Modifier,
    isClickedLock: Boolean, // if clicked lock button
    isLoading: Boolean, // if loading is showing
    isDoorsLocked: Boolean, // if doors are in locked state
    onClick: (Boolean) -> Unit,
) {
    ConstraintLayout(
        modifier = modifier
    ) {
        val (
            titleRow, buttonsBackgroundBox, firstButton, secondButton
        ) = createRefs()
        val stateText =
            if (isLoading) stringResource(R.string.dots) else if (isDoorsLocked) stringResource(R.string.locked) else stringResource(
                R.string.unlocked
            )
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
                text = stringResource(R.string.doors),
                style = MaterialTheme.typography.h4.merge(),
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 10.dp),
                textAlign = TextAlign.Start,
            )
            Divider(
                color = Color.LightGray,
                modifier = Modifier
                    .height(20.dp)
                    .align(Alignment.CenterVertically)
                    .width(2.dp)
            )
            Text(
                text = stateText,
                style = MaterialTheme.typography.h5.merge(),
                color = lightGray,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 10.dp),
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


        DoorsRuleItem(
            isLockingButton = true,
            isLoading = isLoading && isClickedLock,
            isEnabled = isLoading && !isClickedLock,
            isCurrentState = isDoorsLocked,
            isClickable = !isLoading,
            modifier = Modifier
                .constrainAs(firstButton) {
                    top.linkTo(titleRow.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(guildLineFromStart1)
                    end.linkTo(guildLineFromStart2)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                },
            onClick = onClick,
        )
        DoorsRuleItem(
            isLockingButton = false,
            isLoading = isLoading && !isClickedLock,
            isEnabled = isLoading && isClickedLock,
            isCurrentState = !isDoorsLocked,
            isClickable = !isLoading,
            modifier = Modifier
                .constrainAs(secondButton) {
                    top.linkTo(titleRow.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(guildLineFromStart3)
                    end.linkTo(guildLineFromStart4)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                },
            onClick = onClick,
        )

    }
}
