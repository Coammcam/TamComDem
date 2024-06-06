package com.xuong.poly.hoangcam.screen.user

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.navigation.BottomNavigation
import com.xuong.poly.hoangcam.ui.theme.Inter

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Payment() {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Thanh Toán",
                    color = Color.White,
                    fontSize = 17.sp,
                    fontFamily = Inter,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(end = 13.dp),
                    fontWeight = FontWeight.SemiBold
                )
            },
            colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color("#252121".toColorInt()))
        )
    }, bottomBar = { BottomNavigation() }) { contentPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            Column(
//                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(3.dp)
                        .background(Color.Black)
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(Color("#252121".toColorInt()))
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                ) {
                    Text(
                        text = "Địa chỉ nhận hàng",
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 13.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painterResource(id = R.drawable.location),
                            contentDescription = null,
                            Modifier
                                .padding(horizontal = 10.dp)
                                .size(25.dp),
                            tint = Color("#ed383d".toColorInt())
                        )
                        Column {
                            AddressInfor(text = "Tri | 2222222")
                            AddressInfor(text = "22/333 đường Trung Mỹ Tây 1")
                            AddressInfor(text = "phường Tân Thới Nhất")
                            AddressInfor(text = "quận 12, Thành phố Hồ Chí Minh")
                        }
                    }

                    Text(
                        text = "Vui lòng chọn một trong những phương thức sau:",
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 20.dp, top = 13.dp)
                    )

                    ListPaymentMethod(Color("#008000".toColorInt()), R.drawable.paypal, "Paypal")
                    ListPaymentMethod(Color("#800080".toColorInt()), R.drawable.visa, "Visa")
                    ListPaymentMethod(Color("#FFA500".toColorInt()), R.drawable.momo, "Ví MoMo")
                    ListPaymentMethod(Color("#FF69B4".toColorInt()), R.drawable.zalopay, "Zalo Pay")
                    ListPaymentMethod(
                        Color("#FF7F50".toColorInt()), R.drawable.cash, "Thanh toán trực tiếp"
                    )

                    Spacer(
                        modifier = Modifier.height(50.dp)
                    )

                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(3.dp)
                        .background(Color.Black)
                )
            }

            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color("#FE724C".toColorInt())),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text(text = "TIếp theo")
                }
            }
        }
    }
}

@Composable
fun AddressInfor(text: String, color: Color = Color.White, fontSize: TextUnit = 13.sp) {
    Text(text = text, color = color, fontSize = fontSize)
}

@Composable
fun ListPaymentMethod(color: Color, image: Int, content: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(5.dp)
            .background(color = color, shape = RoundedCornerShape(7.dp))
            .height(50.dp)
            .fillMaxWidth()
    ) {
        Image(
            painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .padding(15.dp, 0.dp, 0.dp, 0.dp)
                .height(40.dp)
                .width(40.dp),
            contentScale = ContentScale.Inside
        )

        Text(
            text = content,
            modifier = Modifier
                .weight(1f)
                .padding(50.dp, 0.dp, 0.dp, 0.dp),
            color = Color.White
        )

        RadioButton(selected = false, onClick = { /*TODO*/ })
    }
}