package com.xuong.poly.hoangcam.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.xuong.poly.hoangcam.navigation.BottomNavigation
import com.xuong.poly.hoangcam.ui.theme.Inter

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CartHistoryWithoutBills() {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Lịch sử",
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
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
                    .background(Color("#252121".toColorInt())),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painterResource(id = R.drawable.history),
                    contentDescription = null,
                    Modifier.size(170.dp),
                    tint = Color("#d3d3d3".toColorInt())
                )

                Text(
                    text = "Không có đơn hàng",
                    color = Color("#F20000".toColorInt()),
                    fontSize = 20.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 45.dp)
                )

                Text(
                    text = "Nhấn nút màu bên dưới \n" + "để tạo đơn hàng",
                    color = Color.White,
                    fontSize = 17.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 20.dp),
                    textAlign = TextAlign.Center
                )

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier,
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(Color.White),
                ) {
                    Text(
                        text = "Bắt đầu đặt hàng",
                        color = Color.Black,
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                    )
                }
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
                    .background(Color.Black)
            )

        }
    }
}