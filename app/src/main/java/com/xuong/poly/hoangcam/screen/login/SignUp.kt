package com.xuong.poly.hoangcam.screen.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.ui.theme.Inter
import com.xuong.poly.hoangcam.ui.theme.accent1
import com.xuong.poly.hoangcam.ui.theme.primary1
import com.xuong.poly.hoangcam.viewmodel.LoginViewModel
import kotlin.math.log

@Composable
fun SignUp(navHostController: NavHostController) {

    val context = LocalContext.current

    val loginViewModel: LoginViewModel = viewModel()
    val statusCode by loginViewModel.statusCode.observeAsState(initial = 0)

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var passwordVisible by remember {
        mutableStateOf(false)
    }
    var passwordVisible_cfpw by remember {
        mutableStateOf(false)
    }

    when(statusCode){
        0->{}
        201->{
            loginViewModel.resetStatusCode()
            Toast.makeText(context, "Đăng ký thành công", Toast.LENGTH_SHORT).show()
        }
        else->{
            loginViewModel.resetStatusCode()
            Toast.makeText(context, "Đăng ký thành bại", Toast.LENGTH_SHORT).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primary1)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(
            painterResource(id = R.drawable.logo_app),
            contentDescription = null,
            Modifier
                .size(280.dp)
                .padding(top = 20.dp)
        )

        Text(
            text = "Đăng kí",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp),
            fontSize = 30.sp
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                text = "Email",
                fontFamily = Inter,
                color = Color.White,
                modifier = Modifier.padding(top = 15.dp)
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
                )
            )

            Text(
                text = "Mật khẩu", fontFamily = Inter, color = Color.White, modifier = Modifier
            )
            TextField(
                value = password,
                onValueChange = { password = it },
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
                maxLines = 1
            )

            Text(
                text = "Nhập lại mật khẩu",
                fontFamily = Inter,
                color = Color.White,
//                    modifier = Modifier.padding(top = 15.dp)
            )
            TextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
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
                visualTransformation = if (passwordVisible_cfpw) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val icon =
                        if (passwordVisible_cfpw) R.drawable.visibility_off else R.drawable.visibility
                    Icon(painterResource(id = icon),
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            passwordVisible_cfpw = !passwordVisible_cfpw
                        })
                },
                singleLine = true,
                maxLines = 1
            )
        }
        Button(
            onClick = {
                if(email.isBlank() || password.isBlank() || confirmPassword.isBlank()){
                    Toast.makeText(context, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
                }else if(password != confirmPassword){
                    Toast.makeText(context, "Vui lòng kiểm tra lại mật khẩu", Toast.LENGTH_SHORT).show()
                }else{
                    loginViewModel.SignUp(email, password)
                }
            },
            modifier = Modifier.padding(bottom = 60.dp),
            colors = ButtonDefaults.buttonColors(accent1),
        ) {
            Text(text = "Xác nhận")
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SignUp(navHostController = NavHostController(LocalContext.current))
}