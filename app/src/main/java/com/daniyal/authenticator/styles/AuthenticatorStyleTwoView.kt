package com.daniyal.authenticator.styles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.daniyal.authenticator.R
import com.daniyal.authenticator.ui.theme.grayColor

@Composable
fun AuthenticatorStyleTwoView(
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
        decorationBox = {
            Row(horizontalArrangement = Arrangement.Center) {
                repeat(otpCount) { index ->
                    AuthenticatorStyleTwoItem(
                        index = index,
                        text = otpCode,
                        isTextHidden = isTextHidden
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    )
}

@Composable
private fun AuthenticatorStyleTwoItem(
    index: Int,
    text: String,
    isTextHidden: Boolean,
) {
    val showIcon = index < text.length && text[index].toString().isNotEmpty()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(50.dp)
            .background(
                shape = RoundedCornerShape(4.dp),
                color = grayColor
            )
            .padding(2.dp),
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