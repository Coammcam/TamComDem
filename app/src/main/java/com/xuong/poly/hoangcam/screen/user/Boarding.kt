package com.xuong.poly.hoangcam.screen.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.main.ROUTE_SCREEN_NAME
import kotlinx.coroutines.delay

@Composable
fun Boarding(navController: NavHostController) {

    LaunchedEffect(Unit) {
        delay(1500) // 3-second delay
        navController.navigate(ROUTE_SCREEN_NAME.LOGIN.name)
    }

    Box(modifier = Modifier
        .background(Color("#282222".toColorInt()))
        .fillMaxSize()) {
        Image(
            painterResource(id = R.drawable.logo_app),
            contentDescription = null,
            modifier = Modifier.align(
                Alignment.Center
            ).size(350.dp)
        )
    }
}