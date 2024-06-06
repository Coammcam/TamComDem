package com.xuong.poly.hoangcam.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.xuong.poly.hoangcam.model.ChipModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FilterChip(modifier: Modifier, data: ChipModel){

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
