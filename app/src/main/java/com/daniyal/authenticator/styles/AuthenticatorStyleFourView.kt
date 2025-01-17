package com.daniyal.authenticator.styles

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.daniyal.authenticator.R
import com.daniyal.authenticator.ui.theme.grayColor

@Composable
fun AuthenticatorStyleFourView(
    modifier: Modifier = Modifier,
    otpCount: Int = 4,
    isTextHidden: Boolean,
    onOtpTextChange: (String) -> Unit,
) {
    var otpCode by rememberSaveable { mutableStateOf("") }

    BasicTextField(
        modifier = modifier.fillMaxWidth(),
        value = TextFieldValue(otpCode, selection = TextRange(otpCode.length)),
        onValueChange = { textFieldValue ->
            if (textFieldValue.text.length <= otpCount) {
                otpCode = textFieldValue.text
                onOtpTextChange.invoke(otpCode)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        visualTransformation = PasswordVisualTransformation(),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .wrapContentWidth()
                    .border(
                        width = 1.dp,
                        shape = RoundedCornerShape(8.dp),
                        color = grayColor
                    )
            ) {
                repeat(otpCount) { index ->
                    AuthenticatorStyleFourItem(
                        index = index,
                        text = otpCode,
                        otpCount = otpCount,
                        isTextHidden = isTextHidden,
                    )
                }
            }
        }
    )
}

@Composable
private fun AuthenticatorStyleFourItem(
    index: Int,
    text: String,
    otpCount: Int = 4,
    isTextHidden: Boolean,
) {
    val showIcon = index < text.length && text[index].toString().isNotEmpty()
    val showVerticalLine = index < otpCount - 1

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(width = 55.dp, height = 50.dp)
            .drawBehind {
                if (showVerticalLine) {
                    val strokeWidth = 2 * density
                    val x = size.width - strokeWidth / 2

                    drawLine(
                        color = grayColor,
                        start = Offset(x, 0f),
                        end = Offset(x, size.height),
                        strokeWidth = strokeWidth
                    )
                }
            }
    ) {
        if (showIcon) {
            if (isTextHidden) {
                Icon(
                    painter = painterResource(R.drawable.ic_access_code),
                    contentDescription = null
                )
            } else {
                Text(
                    text = text[index].toString(),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}