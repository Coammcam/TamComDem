package com.xuong.poly.hoangcam.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.main.ROUTE_SCREEN_NAME
import com.xuong.poly.hoangcam.ui.theme.Inter

@Composable
fun AdminBottomNavigation(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        modifier = Modifier.background(Color("#312C2C".toColorInt())),
        containerColor = MaterialTheme.colorScheme.contentColorFor(Color.Transparent),
    ) {
        val selectedColor = Color("#FFB703".toColorInt())
        val unselectedColor = Color.White

        NavigationBarItem(
            selected = currentRoute == ROUTE_SCREEN_NAME.ADMINHOME.name,
            onClick = {
                if (currentRoute != ROUTE_SCREEN_NAME.ADMINHOME.name) {
                    navController.navigate(ROUTE_SCREEN_NAME.ADMINHOME.name) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true

                    }
                }
            },
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(id = R.drawable.home),
                        contentDescription = null,
                        Modifier.size(35.dp),
                        tint = if (currentRoute == ROUTE_SCREEN_NAME.ADMINHOME.name) selectedColor else unselectedColor
                        )
                    Text(
                        text = "Trang chủ",
                        fontSize = 13.sp,
                        fontFamily = Inter,
                        color = if (currentRoute == ROUTE_SCREEN_NAME.ADMINHOME.name) selectedColor else unselectedColor,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                unselectedIconColor = unselectedColor,
                selectedTextColor = selectedColor,
                unselectedTextColor = unselectedColor,
                indicatorColor = Color("#312C2C".toColorInt())
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(id = R.drawable.chart),
                        contentDescription = null,
                        Modifier.size(35.dp),
//                        if (selectedColor == true) {
//                            Color("#FFB703".toColorInt())
//                        } else {
//                            Color.White
//                        }
                    )
                    Text(
                        text = "Thống kê",
                        fontSize = 13.sp,
                        fontFamily = Inter,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                unselectedIconColor = unselectedColor,
                selectedTextColor = selectedColor,
                unselectedTextColor = unselectedColor,
                indicatorColor = Color("#312C2C".toColorInt())
            )
        )
        NavigationBarItem(
            selected = currentRoute == ROUTE_SCREEN_NAME.ADMINMANAGER.name,
            onClick = {
                if (currentRoute != ROUTE_SCREEN_NAME.ADMINMANAGER.name) {
                    navController.navigate(ROUTE_SCREEN_NAME.ADMINMANAGER.name) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            },
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(id = R.drawable.manager),
                        contentDescription = null,
                        Modifier.size(35.dp),
                        tint = if (currentRoute == ROUTE_SCREEN_NAME.ADMINMANAGER.name) selectedColor else unselectedColor
                    )
                    Text(
                        text = "Quản lý",
                        fontSize = 13.sp,
                        fontFamily = Inter,
                        color = if (currentRoute == ROUTE_SCREEN_NAME.ADMINMANAGER.name) selectedColor else unselectedColor,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                unselectedIconColor = unselectedColor,
                selectedTextColor = selectedColor,
                unselectedTextColor = unselectedColor,
                indicatorColor = Color("#312C2C".toColorInt())
            )
            )
        NavigationBarItem(
            selected = currentRoute == ROUTE_SCREEN_NAME.ADMINSUPPORT.name,
            onClick = {
                if (currentRoute != ROUTE_SCREEN_NAME.ADMINSUPPORT.name) {
                    navController.navigate(ROUTE_SCREEN_NAME.ADMINSUPPORT.name) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            },
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(id = R.drawable.profile),
                        contentDescription = null,
                        Modifier.size(35.dp),
                    )
                    Text(
                        text = "Hỗ trợ",
                        fontSize = 13.sp,
                        fontFamily = Inter,
                        color = if (currentRoute == ROUTE_SCREEN_NAME.ADMINSUPPORT.name) selectedColor else unselectedColor,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = selectedColor,
                unselectedIconColor = unselectedColor,
                selectedTextColor = selectedColor,
                unselectedTextColor = unselectedColor,
                indicatorColor = Color("#312C2C".toColorInt())
            )
        )
    }
}