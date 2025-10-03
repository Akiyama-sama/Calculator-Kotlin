package com.mio.ktnote

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class CalculatorState {
    // 将 expression 定义为 MutableState
    var expression: String by mutableStateOf("");
    // 将 result 定义为 MutableState
    var result: String by mutableStateOf("");
    var errorMessage: String by mutableStateOf("");
}