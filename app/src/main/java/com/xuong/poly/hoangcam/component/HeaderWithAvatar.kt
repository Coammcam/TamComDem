package com.xuong.poly.hoangcam.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.ui.theme.Inter
import com.xuong.poly.hoangcam.ui.theme.primary1

@Composable
fun HeaderWithAvatar(
    modifier: Modifier, leadingIcon: Boolean = true, name: String, trailingIcon: Boolean = true
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 0.dp, vertical = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (leadingIcon) {
            Icon(
                painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier.size(20.dp),
                tint = Color.White
            )
        }
        Spacer(modifier.width(5.dp))

        Image(
            painterResource(id = R.drawable.logo_app),
            contentDescription = null,
            Modifier.size(45.dp)
        )
        Text(
            text = name,
            color = Color.White,
            fontSize = 17.sp,
            fontFamily = Inter,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(1f)
        )
        if (trailingIcon) {
            Image(
                painterResource(id = R.drawable.bell),
                contentDescription = null,
                modifier.size(20.dp)
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun Preview() {
    HeaderWithAvatar(
        modifier = Modifier, leadingIcon = true, name = "Cum tứm đim", trailingIcon = true
    )
}