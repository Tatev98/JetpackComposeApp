package com.example.jetpackcomposeapp.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackcomposeapp.R
import com.example.jetpackcomposeapp.screens.indicator.DotsIndicator
import com.example.jetpackcomposeapp.ui.theme.*
import com.ramcosta.composedestinations.annotation.Destination


@Destination
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    Surface(color = Color.White) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize(),
        ) {
            val (
                carData, divider1, divider2, updatedDate, carImage, pagerIndicator,
                carOptions, carEngine
            ) = createRefs()
            val guildLineFromTop1 = createGuidelineFromTop(0.162f)
            val guildLineFromTop2 = createGuidelineFromTop(0.34f)
            val guildLineFromTop3 = createGuidelineFromTop(0.48f)
            val guildLineFromTop4 = createGuidelineFromTop(0.1952f)
            val guildLineFromTop5 = createGuidelineFromTop(0.5552f)
            val guildLineFromTop6 = createGuidelineFromTop(0.74f)
            val guildLineFromStart1 = createGuidelineFromStart(0.05f)
            val guildLineFromStart2 = createGuidelineFromStart(0.48f)
            val guildLineFromStart3 = createGuidelineFromStart(0.52f)
            val guildLineFromStart4 = createGuidelineFromStart(0.95f)
            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(carData) {
                        top.linkTo(parent.top)
                        bottom.linkTo(guildLineFromTop1)
                        height = Dimension.fillToConstraints
                    }
            ) {
                Text(
                    text = "Name",
                    style = MaterialTheme.typography.h1.merge(),
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(5f)
                        .padding(end = 10.dp),
                    textAlign = TextAlign.End,
                )
                Divider(
                    color = primaryCremea,
                    modifier = Modifier
                        .height(28.dp)
                        .align(Alignment.CenterVertically)
                        .width(3.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(5f)
                        .align(Alignment.CenterVertically)
                        .padding(start = 10.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_gas_station),
                        contentDescription = "Gas Station",
                        tint = Color.Black,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "120mi",
                        style = MaterialTheme.typography.h2.merge(),
                        color = Color.Black,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 5.dp),
                        textAlign = TextAlign.Start,
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.LightGray, Color.White),
                            startY = 6f
                        )
                    )
                    .constrainAs(divider1) {
                        top.linkTo(guildLineFromTop1)
                        bottom.linkTo(guildLineFromTop2)
                        height = Dimension.fillToConstraints
                    })

            {
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(primaryGray, Color.White),
                            startY = 8.0f
                        )
                    )
                    .constrainAs(divider2) {
                        top.linkTo(guildLineFromTop2)
                        bottom.linkTo(parent.bottom)
                        height = Dimension.fillToConstraints
                    })

            {
            }
            Image(
                painterResource(R.drawable.photo_car),
                contentDescription = "Car Photo",
                modifier = Modifier.constrainAs(carImage) {
                    top.linkTo(guildLineFromTop2)
                    bottom.linkTo(guildLineFromTop2)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    height = Dimension.wrapContent
                    width = Dimension.wrapContent
                }
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .constrainAs(pagerIndicator) {
                        top.linkTo(guildLineFromTop3)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        height = Dimension.wrapContent
                        width = Dimension.wrapContent
                    }
            ) {
                DotsIndicator(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    totalDots = 3,
                    selectedIndex = 0
                )
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add icon",
                    tint = Color.LightGray,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .constrainAs(updatedDate) {
                        top.linkTo(guildLineFromTop4)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        height = Dimension.wrapContent
                        width = Dimension.wrapContent
                    }
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Refresh",
                    tint = primaryCremea,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
                Text(
                    text = "Updated 1 min ago",
                    style = MaterialTheme.typography.h5.merge(),
                    color = Color.DarkGray,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 5.dp),
                    textAlign = TextAlign.Start,
                )
            }
            CarRuleContainer(
                modifier = Modifier
                    .constrainAs(carOptions) {
                        top.linkTo(guildLineFromTop5)
                        bottom.linkTo(guildLineFromTop6)
                        start.linkTo(guildLineFromStart1)
                        end.linkTo(guildLineFromStart2)
                        height = Dimension.fillToConstraints
                        width = Dimension.fillToConstraints
                    }, RuleType.DOORS, true
            )
            CarRuleContainer(
                modifier = Modifier
                    .constrainAs(carEngine) {
                        top.linkTo(guildLineFromTop5)
                        bottom.linkTo(guildLineFromTop6)
                        start.linkTo(guildLineFromStart3)
                        end.linkTo(guildLineFromStart4)
                        height = Dimension.fillToConstraints
                        width = Dimension.fillToConstraints
                    }, RuleType.ENGINE
            )
        }

    }
}


enum class RuleType {
    ENGINE, DOORS
}


//Container for Controlling items
@Composable
fun CarRuleContainer(modifier: Modifier, ruleType: RuleType, isLocked: Boolean = true) {
    ConstraintLayout(
        modifier = modifier
    ) {
        val (
            titleRow, buttonsBackgroundBox, firstButton, secondButton
        ) = createRefs()
        val text = if (ruleType == RuleType.DOORS) "Doors" else "Engine"
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
                text = text,
                style = MaterialTheme.typography.h4.merge(),
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 10.dp),
                textAlign = TextAlign.Start,
            )
            if (ruleType == RuleType.DOORS) {
                Divider(
                    color = Color.LightGray,
                    modifier = Modifier
                        .height(20.dp)
                        .align(Alignment.CenterVertically)
                        .width(2.dp)
                )
                Text(
                    text = "Locked",
                    style = MaterialTheme.typography.h5.merge(),
                    color = lightGray,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 10.dp),
                    textAlign = TextAlign.Start,
                )
            }
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
        if (ruleType == RuleType.DOORS) {
            DoorsRuleItem(
                isLocked = isLocked,
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
            DoorsRuleItem(
                isLocked = !isLocked,
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
        } else {
            EngineRuleItem(
                "START",
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
                "STOP",
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
}


//Item for controlling doors state
@Composable
fun DoorsRuleItem(
    isLocked: Boolean,
    modifier: Modifier
) {

    //for getting dialog opened state
    val openDialog = remember { mutableStateOf(false) }

    //for getting button pressed state
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    var enabled by rememberSaveable { mutableStateOf(true) }

    //change button appearance depends on pressed state
    val color =
        if (isPressed || !enabled) Color.DarkGray else if (isLocked) primaryCremea else Color.Black
    val tint = if (isPressed || !enabled) Color.LightGray else Color.White
    val size = if (isPressed) 50.dp else 60.dp
    val icon = if (isLocked) R.drawable.ic_lock else R.drawable.ic_unlock
    val text = if (isLocked) "lock" else "unlock"
    Button(
        onClick = {
            enabled = false
            openDialog.value = true
        },
        interactionSource = interactionSource,
        modifier = modifier.size(size),
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(contentColor = tint, backgroundColor = color)
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = "Lock",
            tint = tint
        )
    }
    if (openDialog.value) {

        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = "Are you sure?", color = Color.Black)
            },
            text = {
                Text(
                    "Please confirm that you want to $text the doors of \"Car name \"",
                    color = Color.Black
                )
            },
            confirmButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = primaryBlue),
                    onClick = {
                        openDialog.value = false
                    },
                ) {
                    Text("Yes, $text", color = Color.White)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }) {
                    Text("Cancel", color = primaryBlue)
                }
            }
        )
    }
}


//Item for controlling engine state
@Composable
fun EngineRuleItem(
    text: String, modifier: Modifier
) {

    //for getting button pressed state
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()


    //change button appearance depends on pressed state
    val color = if (isPressed) Color.DarkGray else Color.Black
    val textColor = if (isPressed) Color.LightGray else Color.White
    val size = if (isPressed) 50.dp else 60.dp

    Button(
        onClick = {},
        interactionSource = interactionSource,
        modifier = modifier.size(size),
        shape = CircleShape,
        contentPadding = PaddingValues(2.dp),
        colors = ButtonDefaults.buttonColors(contentColor = textColor, backgroundColor = color)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h5.merge(),
            color = textColor,
            modifier = Modifier
                .align(Alignment.CenterVertically),
            textAlign = TextAlign.Center,
        )
    }
}


