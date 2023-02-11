package com.example.jetpackcomposeapp.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.jetpackcomposeapp.R
import com.example.jetpackcomposeapp.events.DoorsStateEvent
import com.example.jetpackcomposeapp.events.UIEvent
import com.example.jetpackcomposeapp.screens.carruleitems.DoorsRuleContainer
import com.example.jetpackcomposeapp.screens.carruleitems.EngineRuleContainer
import com.example.jetpackcomposeapp.screens.dialogs.DefaultAlert
import com.example.jetpackcomposeapp.screens.dialogs.DefaultSnackbar
import com.example.jetpackcomposeapp.screens.indicator.DotsIndicator
import com.example.jetpackcomposeapp.ui.theme.primaryCremea
import com.example.jetpackcomposeapp.ui.theme.primaryGray
import com.example.jetpackcomposeapp.util.DateUtil
import com.ramcosta.composedestinations.annotation.Destination


@OptIn(ExperimentalLifecycleComposeApi::class)
@Destination
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    val state = viewModel.uiState.value
    val carName: String by viewModel.carName.collectAsStateWithLifecycle()
    val carMiles: Int by viewModel.carMiles.collectAsStateWithLifecycle()
    val carDoorsState: Boolean by viewModel.carDoorsLocked.collectAsStateWithLifecycle()

    //start to counting update time once
    LaunchedEffect(false) {
        viewModel.onEvent(UIEvent.OnRefreshedPage)
    }

    //tried to create timer here
/*
    var ticks by remember { mutableStateOf(0L) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(1000L)
            ticks++
        }
    }*/

    Surface(color = Color.White) {
        val snackState = remember { SnackbarHostState() }
        val context = LocalContext.current
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            //collecting doors state changes and showing snackbar with corresponding msg
            LaunchedEffect(key1 = context) {
                viewModel.doorsStateChangeEvent.collect { event ->
                    val message =
                        if (event is DoorsStateEvent.Locked) context.resources.getString(R.string.doors_locked) else
                            context.resources.getString(R.string.doors_unlocked)
                    snackState.showSnackbar(message)
                }
            }
            // showing alert dialog if need
            if (state.isShowingDialog) {
                //set needed text to dialog depends on doors' state
                val text =
                    if (state.isClickedLock) stringResource(R.string.lock_in_text) else stringResource(
                        R.string.unlock_in_text
                    )
                val buttonText =
                    if (state.isClickedLock) stringResource(R.string.lock) else stringResource(R.string.unlock)
                DefaultAlert(
                    title = stringResource(R.string.are_you_sure),
                    text = stringResource(
                        R.string.please_confirm_that_you_want_to_change_doors_state,
                        text, carName
                    ),
                    confirmBtnText = stringResource(id = R.string.yes_confirm, buttonText),
                    cancelBtnText = stringResource(id = R.string.cancel),
                    onDismiss = {
                        viewModel.onEvent(UIEvent.OpenDialogStateChanged(false))
                        if (it)
                            viewModel.onEvent(UIEvent.OnDoorsStateChanged(state.isClickedLock))
                    }
                )
            }
            ConstraintLayout(
                modifier = Modifier.fillMaxSize(),
            ) {
                val (carData, divider1, divider2, updatedDate, carImage, pagerIndicator, carOptions, carEngine) = createRefs()
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

                //Row for Car name and miles data
                Row(horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(carData) {
                            top.linkTo(parent.top)
                            bottom.linkTo(guildLineFromTop1)
                            height = Dimension.fillToConstraints
                        }) {
                    Text(
                        text = stringResource(id = R.string.my_car_name, carName),
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
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Text(
                            text = stringResource(id = R.string.miles, carMiles),
                            style = MaterialTheme.typography.h2.merge(),
                            color = Color.Black,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(start = 5.dp),
                            textAlign = TextAlign.Start,
                        )
                    }
                }

                //Box for first gradient background
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.LightGray, Color.White), startY = 6f
                        )
                    )
                    .constrainAs(divider1) {
                        top.linkTo(guildLineFromTop1)
                        bottom.linkTo(guildLineFromTop2)
                        height = Dimension.fillToConstraints
                    })

                {}

                //Box for second gradient background
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(primaryGray, Color.White), startY = 8.0f
                        )
                    )
                    .constrainAs(divider2) {
                        top.linkTo(guildLineFromTop2)
                        bottom.linkTo(parent.bottom)
                        height = Dimension.fillToConstraints
                    })

                {}
                //Image for car photo
                Image(painterResource(R.drawable.photo_car),
                    contentDescription = "Car Photo",
                    modifier = Modifier.constrainAs(carImage) {
                        top.linkTo(guildLineFromTop2)
                        bottom.linkTo(guildLineFromTop2)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        height = Dimension.wrapContent
                        width = Dimension.wrapContent
                    })
                //Row for pager indicator
                Row(horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.constrainAs(pagerIndicator) {
                        top.linkTo(guildLineFromTop3)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        height = Dimension.wrapContent
                        width = Dimension.wrapContent
                    }) {
                    DotsIndicator(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        totalDots = 3,
                        selectedIndex = 0
                    )
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add icon",
                        tint = Color.LightGray,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }

                //Row for refresh data
                Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
                    .clickable {
                        viewModel.onEvent(UIEvent.OnRefreshedPage)
                    }
                    .constrainAs(updatedDate) {
                        top.linkTo(guildLineFromTop4)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        height = Dimension.wrapContent
                        width = Dimension.wrapContent
                    }) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Refresh",
                        tint = primaryCremea,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Text(
                        text = DateUtil.getIntervalAgoSinceNow(state.updatedDate),
                        style = MaterialTheme.typography.h5.merge(),
                        color = Color.DarkGray,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 5.dp),
                        textAlign = TextAlign.Start,
                    )
                }

                //Container for doors state changing buttons
                DoorsRuleContainer(
                    modifier = Modifier.constrainAs(carOptions) {
                        top.linkTo(guildLineFromTop5)
                        bottom.linkTo(guildLineFromTop6)
                        start.linkTo(guildLineFromStart1)
                        end.linkTo(guildLineFromStart2)
                        height = Dimension.fillToConstraints
                        width = Dimension.fillToConstraints
                    },
                    isClickedLock = state.isClickedLock,
                    isLoading = state.isShowingLoading,
                    isDoorsLocked = carDoorsState,
                    onClick = {
                        viewModel.onEvent(UIEvent.OpenDialogStateChanged(true))
                        viewModel.onEvent(UIEvent.OnAskForDoorsStateChanged(it))
                    },
                )


                //Container for engine state changing buttons
                EngineRuleContainer(modifier = Modifier.constrainAs(carEngine) {
                    top.linkTo(guildLineFromTop5)
                    bottom.linkTo(guildLineFromTop6)
                    start.linkTo(guildLineFromStart3)
                    end.linkTo(guildLineFromStart4)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                })
            }


            DefaultSnackbar(
                snackbarHostState = snackState,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(10.dp),
                showIcon = true,
                icon = R.drawable.ic_check_circle
            )
        }
    }
}
