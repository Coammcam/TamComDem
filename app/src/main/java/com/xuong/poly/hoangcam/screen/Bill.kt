package com.xuong.poly.hoangcam.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

data class TableItem(
    val product: String, val quantity: Int, val price: Float
)

@Composable
fun Table(items: List<TableItem>) {
    val totalAmount = items.sumOf { it.quantity.toDouble() * it.price.toDouble() }

    LazyColumn(
        modifier = Modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // header row
        item {
            Divider(color = Color.Gray, thickness = 1.dp)
            HeaderRow()
            Divider(color = Color.Gray, thickness = 1.dp)
        }

        // data rows
        items(items) { item ->
            TableRow(item)
            Divider(color = Color.Gray, thickness = 1.dp)
        }

        // total amount row
        item {
            FooterRow(totalAmount)
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}

@Composable
fun HeaderRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Mặt hàng", modifier = Modifier.weight(2f), textAlign = TextAlign.Center)
        Text(text = "SL", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
        Text(text = "Giá", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
        Text(text = "Thành tiền", modifier = Modifier.weight(2f), textAlign = TextAlign.Center)
    }
}


@Composable
fun TableRow(item: TableItem) {
    val totalMoney = item.quantity.toFloat() * item.price
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = item.product, modifier = Modifier.weight(2f), textAlign = TextAlign.Center)
        Text(
            text = item.quantity.toString(),
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Text(
            text = "%.0f".format(item.price) + "k",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Text(
            text = "%.0f".format(totalMoney) + "k",
            modifier = Modifier.weight(2f),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun FooterRow(totalAmount: Double) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Tổng: " + "%.0f".format(totalAmount) + "k",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTable() {
    val sampleData = listOf(
        TableItem("Sườn bì chả", 2, 1f),
        TableItem("Sườn bì chả", 2, 1f),
        TableItem("Sườn bì chả", 5, 1f),
        TableItem("Sườn bì chả", 2, 1f),
        TableItem("Sườn bì chả", 2, 1f),
    )
    MaterialTheme {
        Table(items = sampleData)
    }
}

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Bill() {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Bill",
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
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        ) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            ) {}

            Box(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 24.dp)
                    .background(Color.White),

                ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Text(text = "Cum Túm Dim")
                    Text(text = "Đường số 110  Tô Kí, P.Trung Mỹ Tây, Quận 12 ", modifier = Modifier.padding(vertical = 4.dp))
                    Text(text = "ĐT: 0342128462 - 0866704364 ", modifier = Modifier.padding(vertical = 4.dp))
                    Text(text = "Hoá Đơn bán hàng", modifier = Modifier.padding(vertical = 4.dp))
                    Text(text = "Ngày: 14/03/2023", modifier = Modifier.padding(vertical = 4.dp))
                    Text(text = "Giờ vào: 08 : 39", modifier = Modifier.padding(vertical = 4.dp))

                    PreviewTable()
                }
            }
        }
    }
}