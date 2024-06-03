package com.xuong.poly.hoangcam.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xuong.poly.hoangcam.R
import androidx.core.graphics.toColorInt
import com.xuong.poly.hoangcam.ui.theme.Inter

@Preview
@Composable
fun Login() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color("#373232".toColorInt()))
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(6f)
                    .fillMaxWidth()
                    .background(Color("#252121".toColorInt()), shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.padding(top = 70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Đăng nhập",
                        fontSize = 32.sp,
                        fontFamily = Inter,
                        fontWeight = FontWeight(900),
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Image(
                        painterResource(id = R.drawable.logo_app),
                        contentDescription = null,
                        Modifier.size(280.dp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .weight(4f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Box() {
                    Image(
                        painterResource(id = R.drawable.google_login),
                        contentDescription = null,
                        Modifier.size(200.dp).padding(bottom = 50.dp)
                    )
                }

            }
        }
    }
}