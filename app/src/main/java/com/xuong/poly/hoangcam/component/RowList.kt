package com.xuong.poly.hoangcam.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.xuong.poly.hoangcam.R
import com.xuong.poly.hoangcam.ui.theme.Inter

enum class ActionType {
    Edit, Delete
}

@Composable
fun RowList(id: String, name: String, actionType: ActionType, func: (()->Unit)?) {

    //confirm delete dialog
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        Dialog(title = "Cảnh báo", message = "Khi xóa dữ liệu sẽ không được phục hồi",
            onConfirm = {
                func?.invoke()
                showDialog = false
            }, onDismiss = {
                showDialog = false
            }
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color("#2F2D2D".toColorInt()), shape = RoundedCornerShape(10.dp))
            .padding(vertical = 24.dp, horizontal = 16.dp),
    ) {
        Text(
            text = id,
            modifier = Modifier.weight(3f),
            color = Color.White,
            fontFamily = Inter,
            fontSize = 15.sp
        )
        Text(
            text = name,
            modifier = Modifier.weight(8f),
            color = Color.White,
            fontFamily = Inter,
            fontSize = 15.sp
        )
        when (actionType) {
            ActionType.Edit -> EditIcon(onClick = {func?.invoke()})
            ActionType.Delete -> DeleteIcon(onClick = { showDialog = true })
        }

    }


}

@Composable
fun EditIcon(onClick: () -> Unit) {
    Icon(
        painterResource(id = R.drawable.edit),
        contentDescription = null,
        Modifier.size(20.dp).clickable { onClick.invoke() },
        tint = Color.White
    )
}

@Composable
fun DeleteIcon(onClick: () -> Unit) {
    Icon(
        painterResource(id = R.drawable.delete),
        contentDescription = null,
        Modifier
            .size(20.dp)
            .clickable { onClick.invoke() },
        tint = Color.White,
    )
}