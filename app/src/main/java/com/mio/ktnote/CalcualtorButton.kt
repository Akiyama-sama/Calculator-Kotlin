package com.mio.ktnote

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    symbol: String,
    onClick: () -> Unit,
    modifier: Modifier,
    color: Color,

){
    Box(
        contentAlignment = Alignment.Center,
        // 将所有修饰符应用在同一个 Box 上
        modifier = modifier

            .fillMaxHeight()
            .padding(4.dp)
            .clip(RoundedCornerShape(percent = 50))
            .background(color)
            .clickable(onClick = onClick)
    ) {
        Text(
            text = symbol,
            fontSize = 34.sp,
            color = Color.White
        )
    }
}