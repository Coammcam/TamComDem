package com.xuong.poly.hoangcam.screen.admin


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.navigation.NavHostController
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.component.HeaderWithAvatar
import com.xuong.poly.hoangcam.navigation.AdminBottomNavigation
import com.xuong.poly.hoangcam.ui.theme.Inter

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdminSupport(navController: NavHostController) {
    Scaffold(topBar = {
        HeaderWithAvatar(
            modifier = Modifier, leadingIcon = false, name = "Cum tứm đim", trailingIcon = false, navController = navController
        )
    }, bottomBar = { AdminBottomNavigation(navController) }) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(top = 3.dp, bottom = 3.dp)
                .fillMaxSize()
                .background(Color("#252121".toColorInt()))
                .padding(30.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.zalo),
                    contentDescription = null,
                    Modifier.size(50.dp)
                )
                Text(
                    text = "0966658492",
                    fontFamily = Inter,
                    color = Color.White,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(horizontal = 30.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.gmail),
                    contentDescription = null,
                    Modifier.size(50.dp)
                )
                Text(
                    text = "hoangcamph403517@fpt.edu.vn",
                    fontFamily = Inter,
                    color = Color.White,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(horizontal = 30.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.safari),
                    contentDescription = null,
                    Modifier.size(50.dp)
                )
                Text(
                    text = "https://comtamdem.com",
                    fontFamily = Inter,
                    color = Color.White,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(horizontal = 30.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    AdminSupport(navController = NavHostController(context = LocalContext.current))
}