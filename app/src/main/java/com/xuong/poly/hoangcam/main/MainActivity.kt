package com.xuong.poly.hoangcam.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import com.xuong.poly.hoangcam.screen.CartScreenView
import com.xuong.poly.hoangcam.screen.MainView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
//            MainView(modifier = Modifier)
            CartScreenView(modifier = Modifier)
        }
    }
}
