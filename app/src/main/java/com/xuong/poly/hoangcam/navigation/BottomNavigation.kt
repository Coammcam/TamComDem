package com.xuong.poly.hoangcam.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.ui.theme.Inter

@Preview(showBackground = true)
@Composable
fun BottomNavigation() {
    NavigationBar(
        modifier = Modifier.background(Color("#312C2C".toColorInt())),
        containerColor = MaterialTheme.colorScheme.contentColorFor(Color.Transparent),
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(id = R.drawable.home),
                        contentDescription = null,
                        Modifier.size(35.dp),
                        tint = Color.White
                    )
                    Text(text = "Trang chủ",fontSize = 13.sp, fontFamily = Inter, color = Color.White, fontWeight = FontWeight.SemiBold)
                }
            },
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(id = R.drawable.history),
                        contentDescription = null,
                        Modifier.size(35.dp),
                        tint = Color.White
                    )
                    Text(text = "Lịch sử",fontSize = 13.sp, fontFamily = Inter, color = Color.White, fontWeight = FontWeight.SemiBold)
                }
            },
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(id = R.drawable.cart),
                        contentDescription = null,
                        Modifier.size(35.dp),
                        tint = Color.White
                    )
                    Text(text = "Giỏ hàng",fontSize = 13.sp, fontFamily = Inter, color = Color.White, fontWeight = FontWeight.SemiBold)
                }
            },

        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(id = R.drawable.profile),
                        contentDescription = null,
                        Modifier.size(35.dp),
                        tint = Color.White
                    )
                    Text(text = "Hồ sơ",fontSize = 13.sp, fontFamily = Inter, color = Color.White, fontWeight = FontWeight.SemiBold)
                }
            },
        )
    }
}
