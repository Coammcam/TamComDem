package com.xuong.poly.hoangcam.screen.admin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.component.HeaderWithAvatar
import com.xuong.poly.hoangcam.component.ListFoodItem
import com.xuong.poly.hoangcam.model.ItemModel
import com.xuong.poly.hoangcam.ui.theme.primary1
import com.xuong.poly.hoangcam.ui.theme.primary2

val ListCart = mutableListOf<ItemModel>()

@Composable
private fun TotalTextRow(modifier: Modifier, title: String, amount: String){
    Row(
        modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight(500),
            color = Color.White
        )
        Text(
            text = amount,
            fontSize = 20.sp,
            fontWeight = FontWeight(500),
            color = Color.White
        )
    }
}

@Composable
fun AdminOrderDetailView(modifier: Modifier){

    for (nums in 1..2){
        ListCart.add(ItemModel(nums.toString(), "Test", 10f, 1, R.drawable.comsuon, 1))
    }

    Scaffold(
        topBar = {
            HeaderWithAvatar(modifier = modifier, username = "Test")
        },
        containerColor = primary1
    ) {paddingValues ->
        LazyColumn (
            modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = paddingValues,
            content = {
                item{
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(30.dp)
                    ) {
                        Button(
                            modifier = modifier.weight(0.5f),
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(primary2),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(
                                text = "Xác nhận",
                                fontSize = 20.sp
                            )
                        }
                        Button(
                            modifier = modifier.weight(0.5f),
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(primary2),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(
                                text = "Xác nhận",
                                fontSize = 20.sp
                            )
                        }
                    }
                }
                items(ListCart){ item->
                    ListFoodItem(modifier = modifier, data = item, cancelable = false)
                }
                item {
                    Column(
                        modifier,
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Divider(modifier, 1.dp, Color.White)
                        TotalTextRow(modifier = modifier, title = "Số: ", amount = "54")
                        TotalTextRow(modifier = modifier, title = "Đường: ", amount = "14")
                        TotalTextRow(modifier = modifier, title = "Phường: ", amount = "Đông Hưng Thuận")
                        TotalTextRow(modifier = modifier, title = "Quận: ", amount = "12")
                        TotalTextRow(modifier = modifier, title = "Thành Phố: ", amount = "Hồ Chí Mình")
                        Divider(modifier, 1.dp, Color.White)
                        TotalTextRow(modifier = modifier, title = "Giờ: ", amount = "13h25p")
                        TotalTextRow(modifier = modifier, title = "Số Điện Thoại: ", amount = "0866704364")
                        TotalTextRow(modifier = modifier, title = "Số lượng món ăn chính: ", amount = "4")
                        TotalTextRow(modifier = modifier, title = "Số lượng món ăn thêm: ", amount = "3")
                        TotalTextRow(modifier = modifier, title = "Số lượng topping: ", amount = "2")
                        TotalTextRow(modifier = modifier, title = "Số lượng khác: ", amount = "2")
                        TotalTextRow(modifier = modifier, title = "Tổng tiền: ", amount = "133K")
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Previewing4(){
    AdminOrderDetailView(modifier = Modifier)
}