package com.google.calculator.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.calculator.actions.CalculatorAction
import com.google.calculator.actions.CalculatorOperation
import com.google.calculator.model.CalculatorState
import com.google.calculator.ui.theme.LightGray
import com.google.calculator.ui.theme.MediumGray
import com.google.calculator.ui.theme.Orange
import com.google.calculator.ui.theme.White

@Composable
fun CalculatorMainScreen(
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    onAction: (CalculatorAction) -> Unit?
) {
    Box(modifier = Modifier.then(modifier)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            val equationText =
                state.number1 + (state.operation?.symbol ?: "") + state.number2

            Text(
                text = equationText,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                fontWeight = FontWeight.Normal,
                fontSize = 32.sp,
                color = White,
                maxLines = 2
            )

            //  Dugmad za kalkulator
            FirstRow(buttonSpacing, onAction)
            SecondRow(buttonSpacing, onAction)
            ThirdRow(buttonSpacing, onAction)
            FourthRow(buttonSpacing, onAction)
            FifthRow(buttonSpacing, onAction)

        }
    }
}

@Composable
fun FirstRow(buttonSpacing: Dp, onAction: (CalculatorAction) -> Unit?) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        //  AC
        CalculatorButton(
            symbol = "AC",
            modifier = Modifier
                .background(LightGray)
                .aspectRatio(2f)
                .weight(2f),
            onClick = { onAction(CalculatorAction.Clear) }
        )

        //  Delete
        CalculatorButton(
            symbol = "Del",
            modifier = Modifier
                .background(LightGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = { onAction(CalculatorAction.Delete) }
        )

        //  Deljenje
        CalculatorButton(
            symbol = "/",
            modifier = Modifier
                .background(Orange)
                .aspectRatio(1f)
                .weight(1f),
            onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Divide)) }
        )
    }

}

@Composable
fun SecondRow(buttonSpacing: Dp, onAction: (CalculatorAction) -> Unit?) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {

        CalculatorButton(
            symbol = "7",
            modifier = Modifier
                .background(MediumGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = { onAction(CalculatorAction.Number(7)) }
        )

        CalculatorButton(
            symbol = "8",
            modifier = Modifier
                .background(MediumGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = { onAction(CalculatorAction.Number(8)) }
        )

        CalculatorButton(
            symbol = "9",
            modifier = Modifier
                .background(MediumGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = { onAction(CalculatorAction.Number(9)) }
        )

        //  Mnozenje
        CalculatorButton(
            symbol = "x",
            modifier = Modifier
                .background(Orange)
                .aspectRatio(1f)
                .weight(1f),
            onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Multiply)) }
        )

    }
}

@Composable
fun ThirdRow(buttonSpacing: Dp, onAction: (CalculatorAction) -> Unit?) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {

        CalculatorButton(
            symbol = "4",
            modifier = Modifier
                .background(MediumGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = { onAction(CalculatorAction.Number(4)) }
        )

        CalculatorButton(
            symbol = "5",
            modifier = Modifier
                .background(MediumGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = { onAction(CalculatorAction.Number(5)) }
        )

        CalculatorButton(
            symbol = "6",
            modifier = Modifier
                .background(MediumGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = { onAction(CalculatorAction.Number(6)) }
        )

        //  Oduzimanje
        CalculatorButton(
            symbol = "-",
            modifier = Modifier
                .background(Orange)
                .aspectRatio(1f)
                .weight(1f),
            onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Subtract)) }
        )

    }

}


@Composable
fun FourthRow(buttonSpacing: Dp, onAction: (CalculatorAction) -> Unit?) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {

        CalculatorButton(
            symbol = "1",
            modifier = Modifier
                .background(MediumGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = { onAction(CalculatorAction.Number(1)) }
        )

        CalculatorButton(
            symbol = "2",
            modifier = Modifier
                .background(MediumGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = { onAction(CalculatorAction.Number(2)) }
        )

        CalculatorButton(
            symbol = "3",
            modifier = Modifier
                .background(MediumGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = { onAction(CalculatorAction.Number(3)) }
        )

        //  Sabiranje
        CalculatorButton(
            symbol = "+",
            modifier = Modifier
                .background(Orange)
                .aspectRatio(1f)
                .weight(1f),
            onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Add)) }
        )
    }
}

@Composable
fun FifthRow(buttonSpacing: Dp, onAction: (CalculatorAction) -> Unit?) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {

        CalculatorButton(
            symbol = "0",
            modifier = Modifier
                .background(MediumGray)
                .aspectRatio(2f)
                .weight(2f),
            onClick = { onAction(CalculatorAction.Number(0)) }
        )

        //  Decimala
        CalculatorButton(
            symbol = ".",
            modifier = Modifier
                .background(MediumGray)
                .aspectRatio(1f)
                .weight(1f),
            onClick = { onAction(CalculatorAction.Decimal) }
        )

        CalculatorButton(
            symbol = "=",
            modifier = Modifier
                .background(Orange)
                .aspectRatio(1f)
                .weight(1f),
            onClick = { onAction(CalculatorAction.Calculate) }
        )
    }
}


/*
@Preview(showBackground = true)
@Composable
fun ScreenPreview() {

//    CalculatorMainScreen(state = null!!)
}*/
