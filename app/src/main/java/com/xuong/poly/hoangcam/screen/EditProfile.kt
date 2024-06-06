package com.xuong.poly.hoangcam.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.ui.theme.Inter

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EditProfile() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize().background(Color.Black),
        ) {
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()
                    .background(Color.Black)
            ) {
                Box(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Sửa hồ sơ",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontFamily = Inter,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.SemiBold
                    )

                    Icon(
                        painterResource(id = R.drawable.back),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(7f)
                    .fillMaxWidth()
                    .background(Color("#252121".toColorInt()),shape = RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp))

            ) {
                Box(
                    modifier = Modifier.align(Alignment.CenterHorizontally).offset(y = (-70).dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.avatar),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape)
                            .border(3.dp, Color.Gray, CircleShape),
                    )

                    Box(
                        modifier = Modifier
                            .offset(x = (-10).dp, y = (-10).dp)
                            .size(30.dp)
                            .background(Color.White, shape = RoundedCornerShape(50.dp))
                            .align(Alignment.BottomEnd),
                    ) {
                        Box(
                            modifier = Modifier.align(Alignment.Center)
                        ) {
                            Icon(
                                painterResource(id = R.drawable.camera),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp)
                                    .align(Alignment.Center),
                                tint = Color.Black
                            )
                        }
                    }
                }


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                        .offset(y = (-20).dp)
                ) {
                    var phonenumber by remember { mutableStateOf("") }
                    var name by remember { mutableStateOf("") }
                    var address by remember { mutableStateOf("") }

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

                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color("#FE724C".toColorInt())),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 70.dp, vertical = 40.dp)

                    ) {
                        Text(
                            text = "Lưu",
                            modifier = Modifier.padding(vertical = 8.dp),
                            fontSize = 17.sp,
                            fontFamily = Inter,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

        }
    }


}
