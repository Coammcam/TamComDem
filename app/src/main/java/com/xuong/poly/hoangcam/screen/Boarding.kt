package com.xuong.poly.hoangcam.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.xuong.poly.hoangcam.R

@Preview
@Composable
fun Boarding() {
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