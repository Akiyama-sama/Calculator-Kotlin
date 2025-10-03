package com.mio.ktnote

sealed class CalculatorOperation {
    object Add: CalculatorOperation();
    object Subtract: CalculatorOperation();
    object Multiply: CalculatorOperation();
    object Divide: CalculatorOperation();
}