package com.xuong.poly.hoangcam.screen.user

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.navigation.BottomNavigation
import com.xuong.poly.hoangcam.ui.theme.Inter

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Profile() {
    Scaffold(topBar = {
        TopAppBar(colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color.Black),
            title = {
                Text(
                    text = "Hồ sơ",
                    fontSize = 17.sp,
                    color = Color.White,
                    fontFamily = Inter,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 13.dp),
                    fontWeight = FontWeight.SemiBold
                )
            })
    }, bottomBar = { BottomNavigation() }) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .background(Color.Black)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(Color.Black)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Edit", color = Color.White, fontFamily = Inter, fontSize = 18.sp
                        )
                        Text(
                            text = "Sign out",
                            color = Color.White,
                            fontFamily = Inter,
                            fontSize = 18.sp
                        )

                    }
                }

                Column(
                    modifier = Modifier
                        .weight(7f)
                        .fillMaxWidth()
                        .background(
                            Color("#252121".toColorInt()),
                            shape = RoundedCornerShape(45.dp, 45.dp, 0.dp, 0.dp)
                        )

                ) {
                    var phonenumber by remember { mutableStateOf("") }
                    var name by remember { mutableStateOf("") }
                    var address by remember { mutableStateOf("") }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.align(Alignment.CenterHorizontally)

                    ) {
                        Image(
                            painterResource(id = R.drawable.logo_app),
                            contentDescription = null,
                            Modifier
                                .size(150.dp)
                                .offset(y = (-70).dp)
                        )
                        Text(
                            text = "Cam",
                            color = Color.White,
                            fontFamily = Inter,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.offset(y = (-70).dp)
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState())
                            .offset(y = (-20).dp)
                    ) {

                        Text(
                            text = "Họ tên",
                            fontFamily = Inter,
                            color = Color.White,
                            modifier = Modifier.padding(top = 15.dp)
                        )
                        TextField(
                            value = name,
                            onValueChange = { name = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(67.dp)
                                .padding(vertical = 10.dp)
                                .clip(RoundedCornerShape(10.dp)),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                                disabledContainerColor = Color.White,
                                unfocusedIndicatorColor = Color.White,
                            )
                        )

                        Text(
                            text = "Số điện thoại",
                            fontFamily = Inter,
                            color = Color.White,
                            modifier = Modifier
                        )
                        TextField(
                            value = phonenumber,
                            onValueChange = { phonenumber = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(67.dp)
                                .padding(vertical = 10.dp)
                                .clip(RoundedCornerShape(10.dp)),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                                disabledContainerColor = Color.White,
                                unfocusedIndicatorColor = Color.White,
                            ),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )

                        Text(
                            text = "Địa chỉ",
                            fontFamily = Inter,
                            color = Color.White,
//                    modifier = Modifier.padding(top = 15.dp)
                        )
                        TextField(
                            value = address,
                            onValueChange = { address = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(67.dp)
                                .padding(vertical = 10.dp)
                                .clip(RoundedCornerShape(10.dp)),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                                disabledContainerColor = Color.White,
                                unfocusedIndicatorColor = Color.White,
                            )
                        )
                    }

                }
            }
        }

    }
}
