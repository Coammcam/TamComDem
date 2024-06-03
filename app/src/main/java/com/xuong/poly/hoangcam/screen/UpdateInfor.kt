package com.xuong.poly.hoangcam.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
@Composable
fun UpdateInfor() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color("#373232".toColorInt())),

        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Image(
                painterResource(id = R.drawable.logo_app),
                contentDescription = null,
                Modifier
                    .size(280.dp)
                    .padding(top = 20.dp)
            )

            Text(text = "Hello Cam", color = Color.White, fontFamily = Inter, fontSize = 20.sp)
            Text(
                text = "Vui lòng cập nhật thông tin chính xác để\n" + " thuận tiện cho việc giao hàng",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = Inter,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                var phonenumber by remember { mutableStateOf("") }
                var ward by remember { mutableStateOf("") }
                var street by remember { mutableStateOf("") }
                var number by remember { mutableStateOf("") }

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
                    text = "Phường",
                    fontFamily = Inter,
                    color = Color.White,
                    modifier = Modifier.padding(top = 15.dp)
                )
                TextField(
                    value = ward,
                    onValueChange = { ward = it },
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
                    text = "Đường",
                    fontFamily = Inter,
                    color = Color.White,
                    modifier = Modifier.padding(top = 15.dp)
                )
                TextField(
                    value = street,
                    onValueChange = { street = it },
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
                    text = "Số nhà",
                    fontFamily = Inter,
                    color = Color.White,
                    modifier = Modifier.padding(top = 15.dp)
                )
                TextField(
                    value = number,
                    onValueChange = { number = it },
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
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(bottom = 60.dp),
                colors = ButtonDefaults.buttonColors(Color("#FE724C".toColorInt())),
            ) {
                Text(text = "Xác nhận")
            }

        }
    }
}