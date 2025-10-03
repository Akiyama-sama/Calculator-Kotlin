package com.mio.ktnote

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorViewModel : ViewModel()  {
    var state by mutableStateOf(CalculatorState())

    fun onAction(action: CalculatorAction){

        if(state.errorMessage.isNotEmpty()) state.errorMessage=""
        when(action){

            is CalculatorAction.Number -> {
                state.expression += action.number.toString()
            };
            is CalculatorAction.Delete -> state.expression = state.expression.dropLast(1);
            is CalculatorAction.Clear -> {
                state.expression = ""
                state.result = ""
                state.errorMessage=""
            };
            is CalculatorAction.Decimal -> {

                state.expression += ".";
            }
            is CalculatorAction.Operation -> {
                when(action.operation){
                    is CalculatorOperation.Add -> state.expression += "+";
                    is CalculatorOperation.Subtract -> state.expression += "-";
                    is CalculatorOperation.Multiply -> state.expression += "*";
                    is CalculatorOperation.Divide -> state.expression += "/";
                }
            }
            is CalculatorAction.Calculate -> {
                val result = calculate(state.expression)
                if(result.startsWith("错误：")){
                    state.errorMessage=result
                    state.result=""
                    state.expression=""
                }else{
                    state.result=result
                }
                state.expression=""
            }
            ;
        }
    }

    private fun calculate(expression: String): String {
        val trimmedExpression = expression.trim()

        if (trimmedExpression.isEmpty()) {
            return "错误：表达式不能为空。"
        }

        return try {
            // 使用 ExpressionBuilder 来创建和构建表达式
            val expr = ExpressionBuilder(trimmedExpression).build()

            // 计算结果
            val result = expr.evaluate()

            // 检查结果是否非法（例如 NaN 或 Infinity）
            if (result.isInfinite() || result.isNaN()) {
                return "错误：表达式包含非法操作（如除以零）。"
            }

            // 格式化输出
            if (result == result.toLong().toDouble()) {
                result.toLong().toString()
            } else {
                result.toString()
            }

        } catch (e: Exception) {
            // 捕获所有解析错误（如语法错误、不支持的函数等）
            "错误：表达式不合法或计算失败。详细信息: ${e.message}"
        }
    }
}