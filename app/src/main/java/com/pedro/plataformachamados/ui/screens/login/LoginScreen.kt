package com.pedro.plataformachamados.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedro.plataformachamados.R
import com.pedro.plataformachamados.ui.components.login.BoxCreateAccount
import com.pedro.plataformachamados.ui.components.login.FormLogin
import com.pedro.plataformachamados.ui.theme.BlueDark
import com.pedro.plataformachamados.ui.theme.Gray600
import com.pedro.plataformachamados.ui.theme.TypographyPersonalizada

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = Gray600)
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(R.drawable.logo_icondark),
                contentDescription = "logo_icondark"
            )
            Text(text = "HelpDesk", style = TypographyPersonalizada.textXl, color = BlueDark)
        }

        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {

            FormLogin(
                email = "",
                password = "",
                emailHasError = false,
                passwordHasError = false,
                helperTextEmail = "",
                helperTextPassword = "",
                onEmailChanged = {},
                onPasswordChanged = {},
                onClickLogin = {}
            )

            BoxCreateAccount(
                onGoToCreateAccount = {}
            )
        }


    }
}


@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}