package com.xuong.poly.hoangcam.screen.admin

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.api.HttpReq
import com.xuong.poly.hoangcam.component.HeaderWithAvatar
import com.xuong.poly.hoangcam.model.OrderModel
import com.xuong.poly.hoangcam.navigation.AdminBottomNavigation
import com.xuong.poly.hoangcam.navigation.BottomNavigation
import com.xuong.poly.hoangcam.ui.theme.Inter
import com.xuong.poly.hoangcam.ui.theme.primary1
import com.xuong.poly.hoangcam.ui.theme.primary2
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Composable
private fun OrderListItem(modifier: Modifier, order: OrderModel) {
    Row(
        modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(primary2)
            .padding(start = 30.dp, end = 30.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier
                .fillMaxWidth()
                .weight(0.6f)
        ) {
            Text(
                text = "Đơn hàng ${order.id}",
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight(600)
            )
            Text(
                text = "Trạng thái: ",
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight(600)
            )
        }
        Column(
            modifier
                .fillMaxWidth()
                .weight(0.4f), horizontalAlignment = Alignment.End
        ) {
            Text(
                text = String.format("%.0f", order.total) + "K",
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight(600)
            )
            Text(
                text = if (order.status) "Chấp nhận" else "Từ chối",
                fontSize = 22.sp,
                color = if (order.status) Color.Green else Color.Red,
                fontWeight = FontWeight(600)
            )
        }
    }
}

private val api = HttpReq.getInstance()

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AdminHomeView(modifier: Modifier, navController: NavHostController) {

    val orders = remember {
        mutableStateListOf<OrderModel>()
    }

    val currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
//    val currentDate = ""

    println("init getting data")
    LaunchedEffect(key1 = Unit) {
        println("getting data")
        delay(100)
        orders.addAll(api.getOrders().body()!!.toMutableList())
    }

    Scaffold(
        topBar = {
            HeaderWithAvatar(modifier = modifier, name = "Tấm cơm đêm")
        },
        bottomBar = {
            AdminBottomNavigation(navController)
        },
        containerColor = primary1
    ) { paddingValues ->
        LazyColumn(
            modifier
                .fillMaxSize()
                .padding(10.dp),
            contentPadding = paddingValues,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            content = {
                item {
                    Column(
                        modifier
                            .fillMaxWidth()
                            .padding(vertical = 15.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Today: $currentDate",
                            fontSize = 18.sp,
                            color = Color.White,
                            fontFamily = Inter
                        )
                        Text(
                            text = "Số lượng đơn hàng: ${orders.size}",
                            fontSize = 18.sp,
                            color = Color.White,
                            fontFamily = Inter

                        )
                        Text(
                            buildAnnotatedString {
                                withStyle(SpanStyle(Color.White)) {
                                    append("Doanh thu: ")
                                }
                                withStyle(SpanStyle(Color.Red)) {
                                    append("69K")
                                }
                            },
                            fontFamily = Inter,
                            fontSize = 20.sp,
                        )
                    }
                }
                items(orders, key = { item -> item.id }) { item ->
                    OrderListItem(modifier = modifier, item)
                }
            })
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Previewing3() {
    AdminHomeView(modifier = Modifier, navController = NavHostController(LocalContext.current))
}
