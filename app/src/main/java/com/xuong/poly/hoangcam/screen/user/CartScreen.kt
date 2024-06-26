package com.xuong.poly.hoangcam.screen.user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.component.Header
import com.xuong.poly.hoangcam.component.ListFoodItem
import com.xuong.poly.hoangcam.model.FoodModel
import com.xuong.poly.hoangcam.navigation.BottomNavigation

@Composable
private fun StickyHeader(modifier: Modifier, name: String){
    Row(
        modifier.fillMaxWidth()
    ) {
        Text(
            text = name,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

val ListCart = mutableListOf<FoodModel>()

@Composable
private fun TotalTextRow(modifier: Modifier, title: String, amount: Int){
    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight(500),
            color = Color.White
        )
        Text(
            text = amount.toString(),
            fontSize = 20.sp,
            fontWeight = FontWeight(500),
            color = Color.White
        )
    }
}

@Composable
fun CartScreenView(modifier: Modifier){

    val cancelable by rememberSaveable {
        mutableStateOf(false)
    }

    for (nums in 1..2){
        ListCart.add(FoodModel(nums.toString(), "Test", 10f, 1, R.drawable.comsuon, 1))
    }

    Scaffold(
        topBar = {
            Header(modifier = modifier, title = "Giỏ hàng")
        },
        bottomBar = {
            BottomNavigation()
        },
        containerColor = Color("#252121".toColorInt()),
    ) {paddingValues ->
        LazyColumn (
            modifier
//                .background(Color("#252121".toColorInt()))
                .padding(paddingValues)
                .padding(start = 10.dp, end = 10.dp, top = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            content = {
//                item {
//                    StickyHeader(modifier = modifier, name = "Test")
//                }
//                items(ListCart, key = {item -> item.id}){item->
//                    if (item.type == 2){
//                        ListItem(modifier = modifier, data = item, cancelable = true)
//                    }
//                }
//                item{
//                    Divider(modifier, 1.dp, Color.Black)
//                }
//                item {
//                    StickyHeader(modifier = modifier, name = "Test")
//                }
                items(ListCart){ item->
                    if (item.type == 1){
                        ListFoodItem(modifier = modifier, data = item, cancelable = cancelable)
                    }
                }
                item{
                    Divider(modifier, 1.dp, Color.White)
                }
                item {
                    Column(
                        modifier.fillMaxWidth()
                    ) {
                        TotalTextRow(modifier = modifier, title = "Số lượng món chính", amount = 1)
                        TotalTextRow(modifier = modifier, title = "Số lượng món thêm", amount = 1)
                        TotalTextRow(modifier = modifier, title = "Số lượng topping", amount = 1)
                        TotalTextRow(modifier = modifier, title = "Số lượng món thêm", amount = 1)
                        TotalTextRow(modifier = modifier, title = "Tổng số lượng", amount = 1)
                    }
                }
                item{
                    Divider(modifier, 1.dp, Color.White)
                }
                item {
                    TotalTextRow(modifier = modifier, title = "Tổng tiền", amount = 99)
                }
                item {
                    Column(
                        modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                       if(!cancelable){
                           Button(
                               onClick = { /*TODO*/ },
                               modifier.width(150.dp),
                               colors = ButtonDefaults.buttonColors(Color("#FE724C".toColorInt()))
                           ) {
                               Text(
                                   text = "Xoá giỏ hàng"
                               )
                           }
                           Button(
                               onClick = { /*TODO*/ },
                               modifier.width(150.dp),
                               colors = ButtonDefaults.buttonColors(Color("#FE724C".toColorInt()))
                           ) {
                               Text(
                                   text = "Mua"
                               )
                           }
                       }else{
                           Button(
                               onClick = { /*TODO*/ },
                               modifier.width(150.dp),
                               colors = ButtonDefaults.buttonColors(Color("#FE724C".toColorInt()))
                           ) {
                               Text(
                                   text = "Huỷ"
                               )
                           }
                       }
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Previewing2(){
    CartScreenView(modifier = Modifier)
//    StickyHeader(modifier = Modifier, name = "test")
}