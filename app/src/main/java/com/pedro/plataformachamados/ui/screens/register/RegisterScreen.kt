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
import com.pedro.plataformachamados.ui.components.register.BoxGoToLogin
import com.pedro.plataformachamados.ui.components.register.FormRegister
import com.pedro.plataformachamados.ui.theme.BlueDark
import com.pedro.plataformachamados.ui.theme.Gray600
import com.pedro.plataformachamados.ui.theme.TypographyPersonalizada

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        12.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(40.dp),
                        painter = painterResource(R.drawable.logo_icondark),
                        contentDescription = "logo_icondark"
                    )
                    Text(
                        text = "HelpDesk",
                        style = TypographyPersonalizada.textXl,
                        color = BlueDark
                    )
                }

                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    FormRegister(
                        name = "",
                        onNameChanged = { },
                        helperTextName = "",
                        nameHasError = false,
                        email = "",
                        onEmailChanged = {},
                        helperTextEmail = "",
                        emailHasError = false,
                        password = "",
                        onPasswordChanged = {},
                        helperTextPassword = "Mínimo de 6 dígitos",
                        passwordHasError = false,
                        onClickRegister = {}
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
        navigateToLogin ={}
    )
}