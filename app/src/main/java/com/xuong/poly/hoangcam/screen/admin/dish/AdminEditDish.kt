package com.xuong.poly.hoangcam.screen.admin.dish


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.api.HttpReq
import com.xuong.poly.hoangcam.component.HeaderWithAvatar
import com.xuong.poly.hoangcam.model.FoodModel
import com.xuong.poly.hoangcam.navigation.AdminBottomNavigation
import com.xuong.poly.hoangcam.ui.theme.Inter
import com.xuong.poly.hoangcam.ui.theme.primary1

private val api = HttpReq.getInstance()

@Composable
fun AdminEditDish(navController: NavHostController) {

    val foods = rememberSaveable() {
        mutableListOf<FoodModel>()
    }

    LaunchedEffect(key1 = Unit) {
        foods.addAll(api.getFoods().body()!!.toMutableList())
    }

    Scaffold(
        topBar = {
            HeaderWithAvatar(
                modifier = Modifier,
                leadingIcon = true,
                name = "Cum tứm đim",
                trailingIcon = false,
                navController = navController)
        }, bottomBar = {
            AdminBottomNavigation(navController)
        },
        containerColor = primary1
    ) { contentPadding ->
//        Box(
//            modifier = Modifier
//                .padding(contentPadding)
//                .background(Color.Black)
//                .fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            Column(
//                modifier = Modifier
//                    .padding(top = 3.dp, bottom = 3.dp)
//                    .fillMaxSize()
//                    .background(Color("#252121".toColorInt()))
//                    .padding(16.dp),
//                ) {
//
//            }
//
//        }
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(10.dp),
            contentPadding = contentPadding,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(foods) { model ->
                RowListDish(model = model)
            }
        }
    }
}
//
//val listDish = mutableListOf(
//    ItemTypeFood(1, "sườn"),
//    ItemTypeFood(2, "Sườn mỡ"),
//    ItemTypeFood(3, "Thịt chó"),
//)

@Composable
fun RowListDish(model: FoodModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
//            .padding(bottom = 20.dp)
            .background(Color("#2F2D2D".toColorInt()), shape = RoundedCornerShape(10.dp))
            .padding(vertical = 24.dp, horizontal = 16.dp),
    ) {
        Text(
            text = model.id,
            modifier = Modifier.weight(3f),
            color = Color.White,
            fontFamily = Inter,
            fontSize = 15.sp
        )
        Text(
            text = model.name,
            modifier = Modifier.weight(8f),
            color = Color.White,
            fontFamily = Inter,
            fontSize = 15.sp
        )
        Icon(
            painterResource(id = R.drawable.edit),
            contentDescription = null,
            Modifier
                .size(20.dp)
                .weight(1f),
            tint = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    AdminEditDish(navController = NavHostController(context = LocalContext.current))
}