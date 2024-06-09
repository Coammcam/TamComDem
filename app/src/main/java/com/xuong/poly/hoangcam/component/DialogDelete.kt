package com.xuong.poly.hoangcam.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.xuong.poly.hoangcam.ui.theme.Inter
import com.xuong.poly.hoangcam.ui.theme.accent1

@Composable
fun Dialog(
    title: String, message: String, onConfirm: () -> Unit, onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = title, fontFamily = Inter, fontSize = 20.sp) },
        text = { Text(text = message, fontFamily = Inter, fontSize = 16.sp) },
        confirmButton = {
            OutlinedButton(onClick = onConfirm, colors = ButtonDefaults.buttonColors(accent1)) {
                Text(text = "Đồng ý", color = Color.Black, fontFamily = Inter, fontSize = 16.sp)

            }
        },
        dismissButton = {
            Button(onClick = onDismiss, colors = ButtonDefaults.buttonColors(Color.Transparent)) {
                Text(text = "Hủy", color = Color.Black, fontFamily = Inter, fontSize = 16.sp)
            }
        },
        containerColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewDialog() {
    Dialog(title = "Cảnh báo",
        message = "Khi xóa dữ liệu sẽ không được phục hồi",
        onConfirm = {},
        onDismiss = {})

}