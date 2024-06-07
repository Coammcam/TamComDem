package com.xuong.poly.hoangcam.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.xuong.poly.hoangcam.model.ItemModel

@Composable
fun ListFoodItem(modifier: Modifier, data: ItemModel, cancelable: Boolean){

    var quantity by rememberSaveable {
        mutableIntStateOf(data.quantity)
    }

    Row(
        modifier
//            .padding(start = 10.dp, end = 10.dp)
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
                .clip(RoundedCornerShape(20.dp))
//                .background(Color.White)
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
                    .alpha(if (cancelable) 0f else 1f)
                    .size(36.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .border(1.dp, Color("#FE724C".toColorInt()), RoundedCornerShape(25.dp))
                    .clickable {
                        if (quantity > 0 && !cancelable) quantity--
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
                    .alpha(if (cancelable) 0f else 1f)
                    .size(36.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(Color("#FE724C".toColorInt()))
//                    .border(1.dp, Color.Black, RoundedCornerShape(25.dp))
                    .clickable {
                        if (!cancelable) quantity++
                    },
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}
