package com.xuong.poly.hoangcam.screen.admin.category


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.component.ActionType
import com.xuong.poly.hoangcam.component.Dialog
import com.xuong.poly.hoangcam.component.HeaderWithAvatar
import com.xuong.poly.hoangcam.component.RowList
import com.xuong.poly.hoangcam.model.ItemTypeFood
import com.xuong.poly.hoangcam.model.CategoryModel
import com.xuong.poly.hoangcam.ui.theme.Inter
import com.xuong.poly.hoangcam.viewmodel.AdminCategoryModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdminDeleteCategory(navController: NavHostController) {

    val adminCategoryModel: AdminCategoryModel = viewModel()
    adminCategoryModel.getCategory()
    val categories by adminCategoryModel.categories.observeAsState(emptyArray<CategoryModel>().toList())

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
                items(categories, key = {item -> item.id!!}){
                    RowListType_del(model = it)
                }
            }
        }
    }
}

val listTypeCategory_del = mutableListOf(
    CategoryModel("1", "Bì chả"),
    CategoryModel("2", "Sườn mỡ"),
    CategoryModel("3", "Sườn nạc"),
)

//
//@Composable
//fun RowListType_del(model: ItemTypeFood) {
//    var showDialog by remember { mutableStateOf(false) }
//    if (showDialog) {
//        Dialog(
//            title = "Cảnh báo",
//            message = "Khi xóa dữ liệu sẽ không được phục hồi",
//            onConfirm = {
//                // TODO: logic delete
//                showDialog = false
//            },
//            onDismiss = {
//                showDialog = false
//            }
//        )
//    }
//
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = 20.dp)
//            .background(Color("#2F2D2D".toColorInt()), shape = RoundedCornerShape(10.dp))
//            .padding(vertical = 24.dp, horizontal = 16.dp),
//    ) {
//        Text(
//            text = model.id.toString(),
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
//            painterResource(id = R.drawable.delete),
//            contentDescription = null,
//            Modifier
//                .size(20.dp)
//                .weight(1f)
//                .clickable {
//                    showDialog = true
//                },
//            tint = Color.White
//        )
//    }
//}

@Preview
@Composable
private fun Preview() {
    AdminDeleteCategory(navController = NavHostController(context = LocalContext.current))
}