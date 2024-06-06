package com.xuong.poly.hoangcam.screen.user


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.xuong.poly.hoangcam.ui.theme.Inter

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UploadImage() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
        ) {
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()
                    .background(Color.Black)
            ) {
                Box(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Chỉnh sửa ảnh",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontFamily = Inter,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.SemiBold
                    )

                    Icon(
                        painterResource(id = R.drawable.back),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(7f)
                    .fillMaxWidth()
                    .background(
                        Color("#252121".toColorInt()),
                        shape = RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp)
                    )

            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .offset(y = (-100).dp),
                ) {
                    Column() {
                        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                            Image(
                                painterResource(id = R.drawable.avatar),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(200.dp)
                                    .clip(CircleShape)
                                    .border(3.dp, Color.Gray, CircleShape),
                            )
                        }

                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color("#D9D9D9".toColorInt())),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(110.dp, 40.dp, 110.dp, 10.dp)

                        ) {
                            Text(
                                text = "Chọn ảnh từ thư viện",
                                modifier = Modifier.padding(vertical = 8.dp),
                                fontSize = 9.sp,
                                fontFamily = Inter,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black
                            )
                        }

                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color("#D9D9D9".toColorInt())),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 110.dp)

                        ) {
                            Text(
                                text = "Chụp ảnh mới",
                                modifier = Modifier.padding(vertical = 8.dp),
                                fontSize = 9.sp,
                                fontFamily = Inter,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black
                            )
                        }

                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color("#FE724C".toColorInt())),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(70.dp, 40.dp, 70.dp, 0.dp)

                        ) {
                            Text(
                                text = "Lưu",
                                modifier = Modifier.padding(vertical = 8.dp),
                                fontSize = 17.sp,
                                fontFamily = Inter,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
        }
    }


}
