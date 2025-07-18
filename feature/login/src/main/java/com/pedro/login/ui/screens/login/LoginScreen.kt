package com.pedro.login.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.design_system.R
import com.pedro.design_system.ui.components.LogoIcon
import com.pedro.design_system.ui.theme.Gray600
import com.pedro.login.ui.components.BoxCreateAccount
import com.pedro.login.ui.components.FormLogin

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    state: LoginUiState,
    onEvent: (LoginUiEvent) -> Unit,
    navigateToCreateAccount: () -> Unit
) {

    Box(
        modifier
            .fillMaxSize()
            .background(color = Gray600)
    ) {
        Image(
            painter = painterResource(R.drawable.login_background),
            contentDescription = "image_background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        )
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp),
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 32.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {

                LogoIcon()

                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {

                    FormLogin(
                        email = state.email,
                        password = state.password,
                        emailHasError = state.emailHasError,
                        passwordHasError = state.passwordHasError,
                        helperTextEmail = state.helperTextEmail,
                        helperTextPassword = state.helperTextPassword,
                        onEmailChanged = {
                            onEvent(LoginUiEvent.OnEmailChanged(it))
                        },
                        onPasswordChanged = {
                            onEvent(LoginUiEvent.OnPasswordChanged(it))
                        },
                        onClickLogin = {
                            onEvent(LoginUiEvent.OnDoLogin)
                        }
                    )

                    BoxCreateAccount(
                        onGoToCreateAccount = {
                            navigateToCreateAccount()
                        }
                    )
                }


            }
        }
    }

}


@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        state = LoginUiState(),
        onEvent = {},
        navigateToCreateAccount = {}
    )
}