package com.xuong.poly.hoangcam.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.ui.theme.Inter
import com.xuong.poly.hoangcam.ui.theme.primary1

@Composable
fun HeaderWithAvatar(
    modifier: Modifier,
    leadingIcon: Boolean = true,
    name: String,
    trailingIcon: Boolean = true,
    navController: NavController? = null
) {
    Column(
        modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color("#252121".toColorInt()))
                .padding(vertical = 12.dp, horizontal = 4.dp)
            ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (leadingIcon && navController != null) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painterResource(id = R.drawable.back),
                        contentDescription = "Back",
//                    modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )
                }
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
        Divider(modifier, 3.dp, Color.Black)
    }
}

@Preview(showBackground = false)
@Composable
private fun Preview() {
    HeaderWithAvatar(
        modifier = Modifier, leadingIcon = true, name = "Cum tứm đim", trailingIcon = true, navController = NavController(
            LocalContext.current)
    )
}