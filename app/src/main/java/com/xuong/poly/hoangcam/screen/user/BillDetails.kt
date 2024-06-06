package com.xuong.poly.hoangcam.screen.user


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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

data class MenuItem(
    val category: String, val name: String, val quantity: Int, val price: Float
)

// TODO: conflict giua lazycolumn va verticalScroll

@Composable
fun OrderSummary(menuItems: List<MenuItem>) {
    LazyColumn(
        modifier = Modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val categories = menuItems.groupBy { it.category }

        categories.forEach { (category, items) ->
            item {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Số lượng món $category:", fontWeight = FontWeight.Bold, color = Color.White
                    )
                    Text(
                        text = "${items.sumOf { it.quantity }}",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End, color = Color.White
                    )
                }
                items.forEach { item ->
                    if (item.quantity > 0) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = item.name, color = Color.White)
                            Text(text = item.quantity.toString(), color = Color.White)
                        }
                    }
                }
                Row {
                    Text(
                        text = "Tổng tiền món $category: ", fontWeight = FontWeight.Bold, color = Color.White
                    )

                    Text(
                        text = "${items.sumOf { it.quantity.toDouble() * it.price.toDouble() }}k",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End, color = Color.White

                    )
                }
                Divider(color = Color.Gray, thickness = 1.dp)
            }
        }
        item {
            val totalQuantity = menuItems.sumOf { it.quantity }
            Row {
                Text(text = "Tổng số lượng: ", fontWeight = FontWeight.Bold, color = Color.White)
                Text(
                    text = "$totalQuantity",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End, color = Color.White
                )
            }
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOrderSummary() {
    val menuItems = listOf(
        MenuItem("món chính", "Sườn a", 3, 25f),
        MenuItem("món thêm", "Trứng", 2, 5f),
        MenuItem("món thêm", "Bánh mì", 1, 10f),
        MenuItem("món chính", "Sườn b", 1, 25f),
        MenuItem("món chính", "Sườn c", 2, 25f),
        MenuItem("món khác", "Nước", 2, 3f)
    )
    MaterialTheme {
        OrderSummary(menuItems = menuItems)
    }
}

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BillDetails() {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Chi tiết đơn hàng",
                    color = Color.White,
                    fontSize = 17.sp,
                    fontFamily = Inter,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 13.dp),
                    fontWeight = FontWeight.ExtraBold
                )
            },
            colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color("#252121".toColorInt()))
        )
    }, bottomBar = { BottomNavigation() }) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Cum Túm Đim",
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 3.dp)
                )
                Text(
                    text = "110 Tô Ký, P.Trung Mỹ Tây, Quận 12",
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 3.dp)
                )
                Text(
                    text = "0879175310",
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 3.dp)
                )
                Text(
                    text = "Hóa Đơn Thanh Toán",
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 3.dp)
                )
                Text(
                    text = "Ngày: 16-05-2023",
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 3.dp)
                )
                Row {
                    Text(
                        text = "Trạng thái đơn hàng: ",
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 3.dp)
                    )
                    Text(
                        text = "Đã thanh toán",
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        color = Color("#008000".toColorInt()),
                        modifier = Modifier.padding(vertical = 3.dp)
                    )
                }

                PreviewOrderSummary()

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Số nhà : 22/333",
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 3.dp)
                    )
                    Text(
                        text = "Đường : Trung Mỹ Tây 1",
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 3.dp)
                    )
                    Text(
                        text = "Phường: Tân Thới Nhất",
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 3.dp)
                    )
                    Text(
                        text = "Quận: 12",
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 3.dp)
                    )
                    Text(
                        text = "Thành Phố: Hồ Chí Minh",
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 3.dp)
                    )
                }
                
                Divider(color = Color.Gray, thickness = 1.dp)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Tổng tiền",
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 3.dp),
                        fontSize = 18.sp
                    )
                    Text(
                        text = "75",
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 3.dp),
                        fontSize = 18.sp

                    )
                }
            }
        }
    }
}