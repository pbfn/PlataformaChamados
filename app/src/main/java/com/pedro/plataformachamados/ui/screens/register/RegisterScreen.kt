package com.pedro.plataformachamados.ui.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.plataformachamados.R
import com.pedro.plataformachamados.ui.components.LogoIcon
import com.pedro.plataformachamados.ui.components.register.BoxGoToLogin
import com.pedro.plataformachamados.ui.components.register.FormRegister
import com.pedro.plataformachamados.ui.theme.BlueDark
import com.pedro.plataformachamados.ui.theme.Gray600
import com.pedro.plataformachamados.ui.theme.TypographyPersonalizada

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    state: RegisterUiState,
    onEvent: (RegisterUiEvent) -> Unit,
    navigateToLogin: () -> Unit
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
                    FormRegister(
                        name = state.name,
                        onNameChanged = {
                            onEvent(RegisterUiEvent.OnNameChanged(it))
                        },
                        helperTextName = state.helperTextName,
                        nameHasError = state.nameHasError,
                        email = state.email,
                        onEmailChanged = {
                            onEvent(RegisterUiEvent.OnEmailChanged(it))
                        },
                        helperTextEmail = state.helperTextEmail,
                        emailHasError = state.emailHasError,
                        password = state.password,
                        onPasswordChanged = {
                            onEvent(RegisterUiEvent.OnPasswordChanged(it))
                        },
                        helperTextPassword = state.helperTextPassword,
                        passwordHasError = state.passwordHasError,
                        onClickRegister = {
                            onEvent(RegisterUiEvent.OnDoRegister)
                        }
                    )

                    BoxGoToLogin(
                        onGoToLogin = {
                            navigateToLogin()
                        }
                    )
                }


            }
        }
    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen(
        navigateToLogin = {},
        state = RegisterUiState(),
        onEvent = {}
    )
}