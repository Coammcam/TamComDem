package com.xuong.poly.hoangcam.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xuong.poly.hoangcam.ui.theme.primary1

@Composable
fun HeaderWithAvatar(modifier: Modifier, username: String){
    Row(
        modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(primary1)
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = modifier
            .size(60.dp)
            .background(Color.White)
        )
        Text(
            text = username,
            modifier.padding(10.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(600),
            color = Color.White,
        )
    }
}