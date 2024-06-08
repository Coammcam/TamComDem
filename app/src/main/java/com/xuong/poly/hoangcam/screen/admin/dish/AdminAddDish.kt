package com.xuong.poly.hoangcam.screen.admin.dish

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.api.HttpReq
import com.xuong.poly.hoangcam.component.HeaderWithAvatar
import com.xuong.poly.hoangcam.model.FoodModel
import com.xuong.poly.hoangcam.ui.theme.Inter
import kotlinx.coroutines.launch
import kotlin.random.Random

private val api = HttpReq.getInstance()

@Composable
fun AdminAddDish(navController: NavHostController) {

    val coroutine = rememberCoroutineScope()

    var name: String by remember {
        mutableStateOf("")
    }

    var price: String by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    var expanded by remember { mutableStateOf(false) }
    val items = listOf("Món chính", "Sườn", "Sườn mỡ")
    var selectedIndex by remember { mutableStateOf(0) }


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
                .fillMaxSize()
                .padding(contentPadding)
                .background(Color("#252121".toColorInt()))
                .padding(16.dp, 0.dp, 16.dp, 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color("#D9DCDF".toColorInt()), shape = RoundedCornerShape(5.dp))
                    .border(
                        width = 1.dp, color = Color.White, shape = RoundedCornerShape(5.dp)
                    ), contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(id = R.drawable.add),
                        contentDescription = null,
                        Modifier.size(15.dp)
                    )

                    Text(text = "Thêm hình ảnh", fontSize = 10.sp, fontFamily = Inter)
                }
            }


            Column(
            ) {
                Text(text = "Loại Món", fontFamily = Inter, color = Color.White)
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .clickable { expanded = true }
                    .padding(16.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = items[selectedIndex],
                            fontSize = 16.sp,
                            color = Color.Black,
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            painter = painterResource(id = R.drawable.more),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                ) {
                    items.forEachIndexed { index, item ->
                        DropdownMenuItem(text = {
                            Text(
                                text = item, modifier = Modifier
                            )
                        }, onClick = {
                            selectedIndex = index
                            expanded = false
                        })
                    }
                }

                Text(text = "Giá", fontFamily = Inter, color = Color.White)

                TextField(value = price,
                    onValueChange = { price = it},
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
                    placeholder = { Text(text = "Nhập giá món ăn", fontSize = 16.sp) })


                Text(text = "Tên món ăn", fontFamily = Inter, color = Color.White)

                TextField(value = name,
                    onValueChange = { name = it },
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
                    placeholder = { Text(text = "Nhập tên món ăn", fontSize = 16.sp) })
            }

            Button(
                onClick = {
                    coroutine.launch {
                        val status = api.addFood(FoodModel("${Random.nextInt()}", name, 69f, 10, 0, 0))
                        if(status.code() == 201){
                            Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(context, "Thêm thành bại", Toast.LENGTH_SHORT).show()
                        }
                    }
//                              println(items[selectedIndex])
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


@Preview
@Composable
private fun Preview() {
    AdminAddDish(navController = NavHostController(LocalContext.current))
}

