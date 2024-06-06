package com.xuong.poly.hoangcam.screen.user

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.model.ItemModel
import com.xuong.poly.hoangcam.navigation.BottomNavigation

@Composable
private fun HeaderView(modifier: Modifier){
    Column(
        modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(Color.Gray)
            .padding(25.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = modifier
                .size(width = 50.dp, height = 50.dp)
                .background(Color.Blue)
                .clip(RoundedCornerShape(20.dp)))
            Text(
                text = "Placeholder",
                modifier.padding(start = 5.dp),
                fontSize = 20.sp,
                color = Color.White,
            )
        }
        Box(
            modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(10.dp)
        ){
            Spacer(
                modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(Color.Cyan)
            )
            Column(
                modifier.padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Spacer(
                        modifier
                            .size(width = 20.dp, height = 20.dp)
                            .background(Color.Black))
                }
                Text(
                    text = "Placeholder",
                    modifier
                        .background(Color.Black, RoundedCornerShape(25.dp))
                        .padding(start = 5.dp, end = 5.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = Color.White
                )
                Text(
                    text = "Placeholder",
                    modifier.padding(top = 3.dp, bottom = 3.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                )
                Text(
                    text = "Placeholder",
                    fontSize = 13.sp
                )
            }
        }
    }
}

private data class ChipModel(val id: Int, val name: String, val image: Int)

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun FilterChip(modifier: Modifier, data: ChipModel){

    var selected by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier
            .clickable { selected = !selected }
            .size(height = 100.dp, width = 80.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = data.name,
            modifier.basicMarquee(Int.MAX_VALUE),
            color = if(selected) Color("#FE724C".toColorInt()) else Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight(600),
            maxLines = 1
        )
//        Spacer(
//            modifier
//                .size(70.dp)
//                .background(Color.Gray))
        Image(
            painterResource(id = data.image),
            "",
            modifier = modifier
                .size(70.dp)
                .clip(RoundedCornerShape(20.dp)),

        )
    }
}

@Composable
private fun ListItem(modifier: Modifier, data: ItemModel){

    var quantity by rememberSaveable {
        mutableIntStateOf(data.quantity)
    }

    Row(
        modifier
            .padding(start = 10.dp, end = 10.dp)
            .clip(RoundedCornerShape(15.dp))
            .fillMaxWidth()
            .height(100.dp)
            .background(Color("#2F2D2D".toColorInt()))
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painterResource(id = data.image),
            "",
            modifier
                .size(70.dp)
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = data.name,
                fontSize = 20.sp,
                color = Color.White
            )
            Text(
                text = String.format("%.0f", data.price) + "K",
                fontSize = 20.sp,
                color = Color.White
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "-",
                modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .border(1.dp, Color("#FE724C".toColorInt()), RoundedCornerShape(25.dp))
                    .clickable {
                        if (quantity > 0) quantity--
                    },
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color("#FE724C".toColorInt())
            )
            Text(
                text = if (quantity<10) "0$quantity" else "$quantity",
                modifier.padding(8.dp),
                fontSize = 19.sp,
                color = Color.White
            )
            Text(
                text = "+",
                modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(Color("#FE724C".toColorInt()))
//                    .border(1.dp, Color.Black, RoundedCornerShape(25.dp))
                    .clickable {
                        quantity++
                    },
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}

@Composable
fun MainView(modifier: Modifier){

    val listChip = mutableListOf<ChipModel>()
    val listItem = mutableListOf<ItemModel>()

    for (nums in 1..4){
        listChip.add(ChipModel(nums, "Đồ ăn thêm", R.drawable.comsuon))
    }

    for (nums in 1..20){
        listItem.add(ItemModel(nums, "Test $nums", 10f, 1, R.drawable.comsuon, 1))
    }

    Scaffold(
        bottomBar = {
            BottomNavigation()
        }
    ) { paddingValues ->
        LazyColumn (
            modifier
                .background(Color("#252121".toColorInt()))
                .padding(paddingValues),
//                modifier.padding(start = 10.dp, end = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            content = {
                item {
                    HeaderView(modifier)
                }
                item {
                    Row(
                        modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        for (chip in listChip){
                            FilterChip(modifier = modifier, data = chip)
                        }
                    }
                }
                items(listItem, key = {item -> item.id}){item ->
                    ListItem(modifier = modifier, data = item)
                }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Previewing(){
//    HeaderView(modifier = Modifier)
//    FilterChip(modifier = Modifier, data = ChipModel("Đồ ăn thêm", 0))
//    ListItem(modifier = Modifier, data = ItemModel(0, "test", 10f, 1, 0))
    MainView(modifier = Modifier)
}