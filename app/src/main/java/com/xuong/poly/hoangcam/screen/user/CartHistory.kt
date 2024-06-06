package com.xuong.poly.hoangcam.screen.user

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.xuong.poly.hoangcam.navigation.BottomNavigation
import com.xuong.poly.hoangcam.ui.theme.Inter

data class Bill(
    val request: String, val quantity: Int, val date: String, val time: String, val price: Float
)

val ListBill = mutableListOf(
    Bill("Đơn hàng đã chấp nhận", 3, "10/3/2024", "9:20", 98f),
    Bill("Đơn hàng đã bị huỷ", 3, "10/3/2024", "9:20", 98f),
    Bill("Đơn hàng đã được giao", 3, "10/3/2024", "9:20", 98f),
    Bill("Đơn hàng đã được giao", 3, "10/3/2024", "9:20", 98f),
    Bill("Đơn hàng đã được giao", 3, "10/3/2024", "9:20", 98f),
    Bill("Đơn hàng đã bị huỷ", 3, "10/3/2024", "9:20", 98f),
)

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CartHistory() {
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
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .background(Color.Black)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(ListBill) { model ->
                    RowBill(model = model)
                }
            }
        }
    }


}

@Composable
fun RowBill(model: Bill) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .background(Color("#2F2D2D".toColorInt()), shape = RoundedCornerShape(20.dp))
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp, top = 10.dp, bottom = 5.dp)
        ) {
            if (model.request == "Đơn hàng đã bị huỷ") {
                Text(text = model.request, color = Color.Red, fontSize = 16.sp)
            } else if (model.request == "Đơn hàng đã được giao") {
                Text(text = model.request, color = Color.Green, fontSize = 16.sp)
            } else {
                Text(text = model.request, color = Color.White, fontSize = 16.sp)
            }
            Text(text = model.quantity.toString(), color = Color.White, fontSize = 16.sp)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp, top = 5.dp, bottom = 10.dp)
        ) {
            Row() {
                Text(text = model.date, color = Color.White, fontSize = 16.sp)
                Text(
                    text = model.time,
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
            }
            Text(text = String.format("%.0f", model.price) + "k", color = Color.White, fontSize = 16.sp)
        }
    }
}