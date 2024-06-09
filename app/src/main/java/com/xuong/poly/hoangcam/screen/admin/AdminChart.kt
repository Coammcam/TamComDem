package com.xuong.poly.hoangcam.screen.admin

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.component.HeaderWithAvatar
import com.xuong.poly.hoangcam.model.ItemChart
import com.xuong.poly.hoangcam.navigation.AdminBottomNavigation
import java.util.Calendar

val ListChart = mutableListOf(
    ItemChart("ID21220554", "03/03/2023", "09:53", "Hoàn thành", 57f),
    ItemChart("ID21220554", "03/03/2023", "09:53", "Hoàn thành", 57f),
    ItemChart("ID21220554", "03/03/2023", "09:53", "Hoàn thành", 57f),
    ItemChart("ID21220554", "03/03/2023", "09:53", "Hoàn thành", 57f),
    ItemChart("ID21220554", "03/03/2023", "09:53", "Hoàn thành", 57f),
)

@Preview
@Composable
fun RowChart() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding()
            .background(Color("#2F2D2D".toColorInt()), shape = RoundedCornerShape(8.dp))
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = "ID21220554", color = Color.White)
                Text(text = "03/03/2023", color = Color.White)
                Text(text = "09:53", color = Color.White)
            }

            Column {
                Text(text = "Hoàn thành", color = Color.White)
                Text(text = "57k", color = Color.White)

            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdminChart(navController: NavHostController) {
    Scaffold(topBar = {
        HeaderWithAvatar(
            modifier = Modifier,
            leadingIcon = false,
            name = "Tấm cơm đêm",
            trailingIcon = false,
            navController = navController
        )
    }, bottomBar = { AdminBottomNavigation(navController) }) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .background(Color("#252121".toColorInt()))
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                var selectedTabIndex by remember { mutableStateOf(0) }
                val tabs = listOf("Doanh thu", "Biểu đồ")

                TabRow(selectedTabIndex = selectedTabIndex) {
                    tabs.forEachIndexed { index, title ->
                        Tab(selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            text = { Text(title) })
                    }
                }

                Column(modifier = Modifier.padding(16.dp, 32.dp, 16.dp, 8.dp)) {
                    DatePickerRow(label = "Từ ngày  ")
                    Spacer(modifier = Modifier.size(16.dp))
                    DatePickerRow(label = "Đến ngày")

                    when (selectedTabIndex) {
                        0 -> RevenueScreen()
                        1 -> ChartScreen()
                    }
                }

                Spacer(
                    modifier = Modifier
                        .height(3.dp)
                        .fillMaxWidth()
                        .background(Color.Black)
                )


            }
        }
    }
}

@Composable
fun DatePickerRow(label: String) {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .border(
                    BorderStroke(width = 1.dp, Color.Black), shape = RoundedCornerShape(5.dp)
                )
                .background(Color("#2F2D2D".toColorInt()), shape = RoundedCornerShape(5.dp))
                .padding(12.dp),
        ) {
            Text(
                text = "$label",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier.padding(end = 16.dp)
            )
        }

        DatePickerTextField()
    }
}

@Composable
fun DatePickerTextField() {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    var date by remember { mutableStateOf("") }

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            date = "$dayOfMonth/${month + 1}/$year"
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp)
            .clickable { datePickerDialog.show() }
            .border(BorderStroke(width = 1.dp, Color.Black), shape = RoundedCornerShape(5.dp))
            .background(Color("#2F2D2D".toColorInt()), shape = RoundedCornerShape(5.dp))
            .padding(12.dp),
    ) {
        Text(
            text = date, modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun RevenueScreen() {
    Box(
        modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
    ) {
        // Nội dung của màn hình Doanh thu ở đây
    }
}

@Composable
fun ChartScreen() {
    Box(
        modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
    ) {
        // Nội dung của màn hình Biểu đồ ở đây
    }
}

@Preview
@Composable
private fun Preview() {
    AdminChart(navController = NavHostController(context = LocalContext.current))
}