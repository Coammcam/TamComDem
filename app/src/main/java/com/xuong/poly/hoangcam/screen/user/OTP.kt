package com.xuong.poly.hoangcam.screen.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.ui.theme.Inter

@Preview
@Composable
fun OTP() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color("#373232".toColorInt()))
    ) {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(id = R.drawable.logo_app),
                contentDescription = null,
                Modifier.size(280.dp)
            )

            Text(text = "Hello Cam", color = Color.White, fontFamily = Inter, fontSize = 20.sp)
            Text(
                text = "Chúng tôi sẽ gửi bạn mã OTP qua số điện thoại này",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = Inter,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(
                text = "0966658492",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = Inter,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 30.dp, top = 15.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(62.dp)
                        .background(
                            Color("#FE724C".toColorInt()), shape = RoundedCornerShape(50.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(55.dp)
                            .background(
                                Color.White, shape = RoundedCornerShape(50.dp)
                            ), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "0",
                            color = Color.Black,
                            fontFamily = Inter,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .size(62.dp)
                        .background(
                            Color("#FE724C".toColorInt()), shape = RoundedCornerShape(50.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(55.dp)
                            .background(
                                Color.White, shape = RoundedCornerShape(50.dp)
                            ), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "8",
                            color = Color.Black,
                            fontFamily = Inter,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .size(62.dp)
                        .background(
                            Color("#FE724C".toColorInt()), shape = RoundedCornerShape(50.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(55.dp)
                            .background(
                                Color.White, shape = RoundedCornerShape(50.dp)
                            ), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "0",
                            color = Color.Black,
                            fontFamily = Inter,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .size(62.dp)
                        .background(
                            Color("#FE724C".toColorInt()), shape = RoundedCornerShape(50.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(55.dp)
                            .background(
                                Color.White, shape = RoundedCornerShape(50.dp)
                            ), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "4",
                            color = Color.Black,
                            fontFamily = Inter,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Text(
                text = "00:30",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = Inter,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 40.dp, bottom = 25.dp)
            )

            Row {
                Text(
                    text = "Không nhận được mã OTP? ",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(
                    text = "Gửi lại OTP",
                    textAlign = TextAlign.Center,
                    color = Color("#FFA149".toColorInt()),
                    fontFamily = Inter,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(top = 50.dp, bottom = 70.dp),
                colors = ButtonDefaults.buttonColors(Color("#FE724C".toColorInt())),
            ) {
                Text(text = "Xác nhận")
            }
        }
    }
}