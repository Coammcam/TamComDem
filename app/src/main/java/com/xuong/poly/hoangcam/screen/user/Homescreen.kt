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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.model.FoodModel
import com.xuong.poly.hoangcam.navigation.BottomNavigation
import com.xuong.poly.hoangcam.ui.theme.Inter

@Composable
private fun HeaderView(modifier: Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(Color("#312F2E".toColorInt()))
            .padding(25.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = R.drawable.logo_app),
                contentDescription = "null",
                modifier = modifier
                    .size(width = 50.dp, height = 50.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
            Text(
                text = "Cum tứm đim",
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
        ) {
            Image(
                painterResource(id = R.drawable.banner),
                contentDescription = null,
                Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier.padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
                ) {
                    Image(
                        painterResource(id = R.drawable.heart),
                        contentDescription = null,
                        Modifier.size(20.dp)
                    )
                }
                Text(
                    text = "Free Delivery",
                    modifier
                        .background(Color("#FB8500".toColorInt()), RoundedCornerShape(25.dp))
                        .padding(horizontal = 20.dp, vertical = 5.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = Color.White
                )

                Text(
                    text = "PizzaApp",
                    modifier.padding(vertical = 1.dp),
                    fontSize = 25.sp,
                    fontWeight = FontWeight(600),
                    color = Color.White,
                    fontFamily = Inter
                )
                Text(
                    text = "Akid Lotfi, Oran.",
                    fontSize = 13.sp,
                    color = Color.White,
                    fontFamily = Inter
                )
            }
        }
    }
}

private data class ChipModel(val id: Int, val name: String, val image: Int)

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun FilterChip(modifier: Modifier, data: ChipModel) {

    var selected by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier
            .clickable { selected = !selected }
            .size(height = 100.dp, width = 80.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = data.name,
            modifier.basicMarquee(Int.MAX_VALUE),
            color = if (selected) Color("#FE724C".toColorInt()) else Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight(600),
            maxLines = 1
        )

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
private fun ListItem(modifier: Modifier, data: FoodModel) {

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
                text = data.name, fontSize = 20.sp, color = Color.White
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
                text = if (quantity < 10) "0$quantity" else "$quantity",
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
fun MainView(modifier: Modifier, navController: NavHostController) {

    val listChip = mutableListOf<ChipModel>()
    val listItem = mutableListOf<FoodModel>()

    for (nums in 1..4) {
        listChip.add(ChipModel(nums, "Đồ ăn thêm", R.drawable.comsuon))
    }

    for (nums in 1..20){
        listItem.add(FoodModel(nums.toString(), "Test $nums", 10f, 1, R.drawable.comsuon, 1))
    }

    Scaffold(bottomBar = {
        BottomNavigation()
    }) { paddingValues ->
        LazyColumn(
            modifier
                .background(Color("#252121".toColorInt()))
                .padding(paddingValues),
//                modifier.padding(start = 10.dp, end = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp), content = {
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
                        for (chip in listChip) {
                            FilterChip(modifier = modifier, data = chip)
                        }
                    }
                }
                items(listItem, key = { item -> item.id!! }) { item ->
                    ListItem(modifier = modifier, data = item)
                }
            })
    }
}

@Preview
@Composable
fun Previewing() {
    MainView(modifier = Modifier, navController = NavHostController(LocalContext.current))
}