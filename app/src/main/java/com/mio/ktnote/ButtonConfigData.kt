package com.mio.ktnote

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mio.ktnote.ui.theme.LightGray
import com.mio.ktnote.ui.theme.MediumGray
import com.mio.ktnote.ui.theme.Orange

data class CalculatorButtonData(
    val symbol: String,
    val action: CalculatorAction,
     val weight: Float = 1f,
     val color: Color= MediumGray
)

// 2. 定义常量配置列表（List of Lists），一个内部 List 就是一行按钮
val CalculatorButtonRows = listOf(
    // 第一行: AC, DEL, /
    listOf(
        CalculatorButtonData("AC", CalculatorAction.Clear, weight = 2f, color = LightGray), // AC 占 2 份宽度
        CalculatorButtonData("DEL", CalculatorAction.Delete,  weight =1f, color = LightGray),
        CalculatorButtonData("/", CalculatorAction.Operation(CalculatorOperation.Divide), weight =1f, color = Orange),
    ),
    // 第二行: 7, 8, 9, x
    listOf(
        CalculatorButtonData("7", CalculatorAction.Number(7)),
        CalculatorButtonData("8", CalculatorAction.Number(8)),
        CalculatorButtonData("9", CalculatorAction.Number(9)),
        CalculatorButtonData("x", CalculatorAction.Operation(CalculatorOperation.Multiply), color = Orange),
    ),
    // 第三行: 4, 5, 6, -
    listOf(
        CalculatorButtonData("4", CalculatorAction.Number(4)),
        CalculatorButtonData("5", CalculatorAction.Number(5)),
        CalculatorButtonData("6", CalculatorAction.Number(6)),
        CalculatorButtonData("-", CalculatorAction.Operation(CalculatorOperation.Subtract), color = Orange),
    ),
    // 第四行: 1, 2, 3, +
    listOf(
        CalculatorButtonData("1", CalculatorAction.Number(1)),
        CalculatorButtonData("2", CalculatorAction.Number(2)),
        CalculatorButtonData("3", CalculatorAction.Number(3)),
        CalculatorButtonData("+", CalculatorAction.Operation(CalculatorOperation.Add), color = Orange),
    ),
    // 第五行: 0, ., =
    listOf(
        CalculatorButtonData("0", CalculatorAction.Number(0),  weight =2f), // 0 占 2 份宽度
        CalculatorButtonData(".", CalculatorAction.Decimal,     weight =1f),
        CalculatorButtonData("=", CalculatorAction.Calculate,  weight =1f, color = Orange),
    )
)