package com.google.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.calculator.model.CalculatorViewModel
import com.google.calculator.ui.theme.Background
import com.google.calculator.ui.theme.ComposeCalculatorTheme
import com.google.calculator.view.CalculatorMainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCalculatorTheme {

                val viewModel = viewModels<CalculatorViewModel>()
                val state = viewModel.value.state
                val buttonSpacing = 8.dp

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Background)
                        .wrapContentHeight()
                ) {
                    CalculatorMainScreen(
                        state,
                        buttonSpacing,
                        onAction = {
                            viewModel.value.onAction(it)
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Background)
                            .padding(12.dp)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCalculatorTheme {
        //
    }
}