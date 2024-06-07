package com.xuong.poly.hoangcam.screen.admin


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.xuong.poly.hoangcam.main.ROUTE_SCREEN_NAME
import com.xuong.poly.hoangcam.navigation.AdminBottomNavigation
import com.xuong.poly.hoangcam.ui.theme.Inter

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdminManagerCategories(navController: NavHostController) {
    Scaffold(topBar = {
        HeaderWithAvatar(
            modifier = Modifier,
            leadingIcon = true,
            name = "Cum tứm đim",
            trailingIcon = false,
            navController = navController
        )
    }, bottomBar = { AdminBottomNavigation(navController) }) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .background(Color.Black)
                .fillMaxSize()

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 3.dp)
                    .background(Color("#252121".toColorInt()))
                    .padding(16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController?.navigate(ROUTE_SCREEN_NAME.ADMINADDCATEGORY.name)
                        }) {
                    Image(
                        painterResource(id = R.drawable.logo_app),
                        contentDescription = null,
                        Modifier.size(45.dp)
                    )
                    Text(
                        text = "Thêm loại món ăn",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontFamily = Inter,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController?.navigate(ROUTE_SCREEN_NAME.ADMINEDITCATEGORY.name)
                        }) {
                    Image(
                        painterResource(id = R.drawable.logo_app),
                        contentDescription = null,
                        Modifier.size(45.dp)
                    )
                    Text(
                        text = "Sửa loại món ăn",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontFamily = Inter,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController?.navigate(ROUTE_SCREEN_NAME.ADMINDELETECATEGORY.name)
                        }) {
                    Image(
                        painterResource(id = R.drawable.logo_app),
                        contentDescription = null,
                        Modifier.size(45.dp)
                    )
                    Text(
                        text = "Xoá loại món ăn",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontFamily = Inter,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }
        }
    }
}
