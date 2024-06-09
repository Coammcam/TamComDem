package com.xuong.poly.hoangcam.screen.admin.category


import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.xuong.poly.hoangcam.component.HeaderWithAvatar
import com.xuong.poly.hoangcam.model.CategoryModel
import com.xuong.poly.hoangcam.ui.theme.Inter
import com.xuong.poly.hoangcam.viewmodel.AdminCategoryModel


@Composable
fun AdminAddCategory(navController: NavHostController) {

    val adminCategoryModel: AdminCategoryModel = viewModel()
    val statusCode by adminCategoryModel.statusCode.observeAsState(initial = 0)

    val context = LocalContext.current

    //check http status
    when(statusCode){
        0 -> {}
        201->{
            adminCategoryModel.resetStatus()
            Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show()
        }
        else->{
            Toast.makeText(context, "Thêm thành bại", Toast.LENGTH_SHORT).show()
        }
    }

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
                .fillMaxSize()
                .padding(contentPadding)
                .background(Color("#252121".toColorInt()))
                .padding(16.dp, 150.dp, 16.dp, 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var categoryName by remember {
                mutableStateOf("")
            }
            TextField(value = categoryName,
                onValueChange = { categoryName = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .clip(RoundedCornerShape(10.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                ),
                placeholder = { Text(text = "Nhập loại món ăn", fontSize = 16.sp) })

            Button(
                onClick = {
                        adminCategoryModel.addCategory(CategoryModel(null, categoryName))
                          },
                modifier = Modifier.padding(top = 50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color("#FFB703".toColorInt())),
            ) {
                Text(
                    text = "Thêm",
                    color = Color.Black,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(vertical = 2.dp, horizontal = 16.dp)
                )
            }

        }
    }
}
