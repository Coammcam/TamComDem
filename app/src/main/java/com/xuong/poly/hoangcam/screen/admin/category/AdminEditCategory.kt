package com.xuong.poly.hoangcam.screen.admin.category


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.xuong.poly.hoangcam.model.CategoryModel
import com.xuong.poly.hoangcam.ui.theme.primary1
import com.xuong.poly.hoangcam.viewmodel.AdminCategoryModel

@Composable
fun AdminEditCategory(navController: NavHostController) {

    val adminCategoryModel: AdminCategoryModel = viewModel()
    adminCategoryModel.getCategory()
    val categories by adminCategoryModel.categories.observeAsState(emptyArray<CategoryModel>().toList())

    Scaffold(
        topBar = {
            HeaderWithAvatar(
                modifier = Modifier,
                leadingIcon = true,
                name = "Tấm cơm đêm",
                trailingIcon = false,
                navController = navController
            )
        },
        containerColor = primary1
    ) { contentPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            contentPadding = contentPadding,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(categories, key = {item -> item.id!!}){
                RowList(it.id!!, it.name, ActionType.Edit, func = { navController.navigate("updateScreen/${it.id}") })
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

//@Composable
//fun RowListType(model: CategoryModel) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = 20.dp)
//            .background(Color("#2F2D2D".toColorInt()), shape = RoundedCornerShape(10.dp))
//            .padding(vertical = 24.dp, horizontal = 16.dp),
//    ) {
//        Text(
//            text = model.id!!,
//            modifier = Modifier.weight(3f),
//            color = Color.White,
//            fontFamily = Inter,
//            fontSize = 15.sp
//        )
//        Text(
//            text = model.name,
//            modifier = Modifier.weight(8f),
//            color = Color.White,
//            fontFamily = Inter,
//            fontSize = 15.sp
//        )
//        Icon(
//            painterResource(id = R.drawable.edit),
//            contentDescription = null,
//            Modifier
//                .size(20.dp)
//                .weight(1f),
//            tint = Color.White
//        )
//    }
//}

@Preview
@Composable
private fun Preview() {
    AdminEditCategory(navController = NavHostController(context = LocalContext.current))
}