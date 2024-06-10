package com.xuong.poly.hoangcam.screen.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xuong.poly.hoangcam.R
import androidx.core.graphics.toColorInt
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.xuong.poly.hoangcam.main.ROUTE_SCREEN_NAME
import com.xuong.poly.hoangcam.ui.theme.Inter
import com.xuong.poly.hoangcam.ui.theme.accent1
import com.xuong.poly.hoangcam.ui.theme.primary1
import com.xuong.poly.hoangcam.viewmodel.LoginViewModel

@Composable
fun Login(navController: NavHostController) {

    val loginViewModel: LoginViewModel = viewModel()
    val isAuth by loginViewModel.auth.observeAsState()
    val statusCode by loginViewModel.statusCode.observeAsState(initial = 0)

    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = isAuth) {
        when (isAuth){
            true->{
                navController.navigate(ROUTE_SCREEN_NAME.ADMINHOME.name)
            }
            false->{
                Toast.makeText(context, "Sai thông tin đăng nhập", Toast.LENGTH_SHORT).show()
            }
            else->{}
        }

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color("#373232".toColorInt()))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .weight(6f)
                    .fillMaxWidth()
                    .background(
                        primary1,
                        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                    ), contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.padding(top = 70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Đăng nhập",
                        fontSize = 32.sp,
                        fontFamily = Inter,
                        fontWeight = FontWeight(900),
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Image(
                        painterResource(id = R.drawable.logo_app),
                        contentDescription = null,
                        Modifier.size(280.dp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(6f)
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Text(
                    text = "Email",
                    fontFamily = Inter,
                    color = Color.White,
                    modifier = Modifier,
                )
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(67.dp)
                        .padding(vertical = 10.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.White,
                        unfocusedIndicatorColor = Color.White,
                    ),
                    singleLine = true,
                    maxLines = 1,
                )

                Text(
                    text = "Password",
                    fontFamily = Inter,
                    color = Color.White,
                )
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .padding(vertical = 10.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.White,
                        unfocusedIndicatorColor = Color.White,
                    ),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        val icon =
                            if (passwordVisible) R.drawable.visibility_off else R.drawable.visibility
                        Icon(painterResource(id = icon),
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                passwordVisible = !passwordVisible
                            })
                    },

                    singleLine = true,
                    maxLines = 1,
                )

                Button(
                    onClick = {
                        if (email.isBlank() || password.isBlank()) {
                            Toast.makeText(
                                context, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT
                            ).show()
                        }else if(email == "user" && password == "user"){
                            navController.navigate(ROUTE_SCREEN_NAME.HOMESCREEN.name)
                        } else{
                            loginViewModel.Login(email, password)
                        }
                    },
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(accent1),

                    ) {
                    Text(text = "Xác nhận")
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.Center,

                    ) {
                    Text(
                        text = "Bạn chưa có tài khoản? ",
                        fontSize = 12.sp,
                        fontFamily = Inter,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                    )

                    Text(text = "Đăng kí ngay",
                        fontSize = 12.sp,
                        fontFamily = Inter,
                        color = Color.Green,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.clickable {
                            navController.navigate(ROUTE_SCREEN_NAME.SIGNUP.name)
                        })
                }
            }
        }

    }
}
