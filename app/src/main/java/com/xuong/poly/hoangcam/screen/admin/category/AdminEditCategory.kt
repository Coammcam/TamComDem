package com.xuong.poly.hoangcam.screen.admin.category


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.api.HttpReq
import com.xuong.poly.hoangcam.component.HeaderWithAvatar
import com.xuong.poly.hoangcam.model.CategoryModel
import com.xuong.poly.hoangcam.model.FoodModel
import com.xuong.poly.hoangcam.ui.theme.Inter
import com.xuong.poly.hoangcam.viewmodel.AdminCategoryModel

@Composable
fun AdminEditCategory(navController: NavHostController) {

    val adminCategoryModel: AdminCategoryModel = viewModel()
    adminCategoryModel.getCategory()
    val categories by adminCategoryModel.categories.observeAsState(emptyArray<CategoryModel>().toList())

    Scaffold(topBar = {
        HeaderWithAvatar(
            modifier = Modifier,
            leadingIcon = true,
            name = "Cum tứm đim",
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
                items(categories, key = {item -> item.id!!}) { model ->
                    RowListType(model = model)
                }
            }
        }
    }
}

@Composable
fun RowListType(model: CategoryModel) {
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
            painterResource(id = R.drawable.edit),
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
    AdminEditCategory(navController = NavHostController(context = LocalContext.current))
}