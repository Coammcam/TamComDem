package com.xuong.poly.hoangcam.screen.admin.dish


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.xuong.poly.hoangcam.component.ActionType
import com.xuong.poly.hoangcam.component.HeaderWithAvatar
import com.xuong.poly.hoangcam.component.RowList
import com.xuong.poly.hoangcam.model.ItemTypeFood
import com.xuong.poly.hoangcam.model.FoodModel
import com.xuong.poly.hoangcam.ui.theme.Inter
import com.xuong.poly.hoangcam.viewmodel.AdminDishModel

@Composable
fun AdminDeleteDish(navController: NavHostController) {

    val adminDishModel: AdminDishModel = viewModel()
    adminDishModel.getDishes()
    val dishes by adminDishModel.dishes.observeAsState(emptyArray<FoodModel>().toList())

    Scaffold(topBar = {
        HeaderWithAvatar(
            modifier = Modifier,
            leadingIcon = true,
            name = "Tấm cơm đêm",
            trailingIcon = false,
            navController = navController
        )
    }) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .background(Color("#252121".toColorInt()))
                .padding(16.dp),

            ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(dishes, key = {item -> item.id!!}) { model ->
                    RowListTDish_del(model = model)
                }
            }
        }
    }
}

@Composable
fun RowListTDish_del(model: FoodModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
            .background(Color("#2F2D2D".toColorInt()), shape = RoundedCornerShape(10.dp))
            .padding(vertical = 24.dp, horizontal = 16.dp),
    ) {
        Text(
            text = model.id!!,
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
            painterResource(id = R.drawable.delete),
            contentDescription = null,
            Modifier
                .size(20.dp)
                .weight(1f),
            tint = Color.White
        )
    }
}

@Preview
@Composable
private fun Preview() {
    AdminDeleteDish(navController = NavHostController(context = LocalContext.current))
}