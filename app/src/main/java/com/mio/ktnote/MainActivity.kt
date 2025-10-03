package com.mio.ktnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mio.ktnote.ui.theme.KtNoteTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KtNoteTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state


                Calculator(
                    state = state,
                    modifier = Modifier.fillMaxSize(),
                    onAction = viewModel::onAction
                )
            }
        }
    }
}

@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier,
    onAction: (CalculatorAction)->Unit
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF000000))
            .padding(8.dp)

    ) {
        Column(
            modifier = Modifier.fillMaxSize()

                .weight(4f)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = state.expression,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                maxLines=1,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()

                    ,
                fontSize = 80.sp,
            )
            if (state.result.isNotBlank()) {
                Text(
                    text = state.result,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.End,
                    fontSize = 70.sp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            if (state.errorMessage.isNotBlank()) {
                Text(
                    text = state.errorMessage,
                    textAlign = TextAlign.Start,
                    fontSize = 20.sp,
                    color = Color.Red,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Column (
            modifier=Modifier.fillMaxSize()
                .weight(6f)
        ){
            CalculatorButtonRows.forEach{ rowButtons ->
                Row(modifier = Modifier.fillMaxWidth()
                    .weight(1f)

                ) {
                    rowButtons.forEach { button->
                        CalculatorButton(
                            symbol = button.symbol,
                            modifier = Modifier.weight(button.weight),
                            color=button.color,

                            onClick = {
                                onAction(button.action)
                            }
                        )
                    }
                }
            }
        }
    }
}
