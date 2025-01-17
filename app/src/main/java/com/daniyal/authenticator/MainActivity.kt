package com.daniyal.authenticator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.daniyal.authenticator.styles.AuthenticatorStyleFourView
import com.daniyal.authenticator.styles.AuthenticatorStyleOneView
import com.daniyal.authenticator.styles.AuthenticatorStyleThreeView
import com.daniyal.authenticator.styles.AuthenticatorStyleTwoView
import com.daniyal.authenticator.ui.theme.AuthenticatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AuthenticatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(innerPadding),
                    ) {

                        AuthenticatorStyleOneView(
                            isTextHidden = true,
                            onOtpTextChange = { value ->
                                println("Style 1: $value")
                            }
                        )

                        Spacer(modifier = Modifier.height(20.dp))
                        AuthenticatorStyleOneView(
                            isTextHidden = false,
                            onOtpTextChange = { value ->
                                println("Style 1: $value")
                            }
                        )

                        Spacer(modifier = Modifier.height(40.dp))
                        AuthenticatorStyleTwoView(
                            isTextHidden = true,
                            onOtpTextChange = { value ->
                                println("Style 2: $value")
                            }
                        )

                        Spacer(modifier = Modifier.height(40.dp))
                        AuthenticatorStyleTwoView(
                            isTextHidden = false,
                            onOtpTextChange = { value ->
                                println("Style 2: $value")
                            }
                        )

                        Spacer(modifier = Modifier.height(40.dp))
                        AuthenticatorStyleThreeView(
                            isTextHidden = true,
                            onOtpTextChange = { value ->
                                println("Style 3: $value")
                            }
                        )

                        Spacer(modifier = Modifier.height(40.dp))
                        AuthenticatorStyleThreeView(
                            isTextHidden = false,
                            onOtpTextChange = { value ->
                                println("Style 3: $value")
                            }
                        )

                        Spacer(modifier = Modifier.height(40.dp))
                        AuthenticatorStyleFourView(
                            isTextHidden = true,
                            onOtpTextChange = { value ->
                                println("Style 4: $value")
                            }
                        )

                        Spacer(modifier = Modifier.height(40.dp))
                        AuthenticatorStyleFourView(
                            isTextHidden = false,
                            onOtpTextChange = { value ->
                                println("Style 4: $value")
                            }
                        )
                    }
                }
            }
        }
    }
}