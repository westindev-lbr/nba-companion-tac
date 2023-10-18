package com.tac.nba_companion.ui.register

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ShowRegisterScreen(rvm: RegisterViewModel = viewModel()) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current


    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)
            .shadow(8.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(8.dp)
    ) {

        val keyboardController = LocalSoftwareKeyboardController.current

        Column(
            modifier = Modifier.fillMaxWidth(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "User Registration",
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )

            ShowUserName(rvm)
            ShowEmail(rvm)
            ShowPassword(rvm)
            ShowConfirmPassword(rvm)

            ShowButton(rvm, context)

            ShowPlanText(rvm)
        }
    }
}

@Composable
fun ShowPlanText(rvm: RegisterViewModel) {
    Text(
        text = "name: ${rvm.userName.value}",
        fontSize = 20.sp,
        modifier = Modifier.padding(top = 20.dp, bottom = 10.dp)
    )
    Text(
        text = "email: ${rvm.email.value}",
        fontSize = 20.sp,
        modifier = Modifier.padding(10.dp)
    )
    Text(
        text = "password: ${rvm.password.value}",
        fontSize = 20.sp,
        modifier = Modifier.padding(10.dp)
    )
    Text(
        text = "confirmPass: ${rvm.confirmPassword.value}",
        fontSize = 20.sp,
        modifier = Modifier.padding(10.dp)
    )
}

@Composable
private fun ShowButton(
    rvm: RegisterViewModel,
    context: Context
) {
    Button(onClick = {
        rvm.register()
        Toast.makeText(
            context,
            "${rvm.userName.value} : ${rvm.email.value} : ${rvm.password.value} : ${rvm.confirmPassword.value} ",
            Toast.LENGTH_SHORT
        ).show()
    }, enabled = rvm.isEnabledRegisterButton.value) {
        Text("Register Me")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ShowUserName(rvm: RegisterViewModel) {
    Column(modifier = Modifier.padding(5.dp)) {
        TextField(
            value = rvm.userName.value,
            onValueChange = {
                rvm.userName.value = it
                rvm.validateUserName()
            },
            isError = rvm.isUserNameValid.value,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(5.dp),
            label = { Text("User Name") },
            singleLine = true
        )
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = rvm.userNameErrMsg.value,
            fontSize = 14.sp,
            color = Color.Red
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ShowEmail(rvm: RegisterViewModel) {
    Column(modifier = Modifier.padding(5.dp)) {
        TextField(
            value = rvm.email.value,
            onValueChange = {
                rvm.email.value = it
                rvm.validateEmail()
            },
            isError = rvm.isEmailValid.value,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(5.dp),
            label = { Text("Email") },
            singleLine = true
        )
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = rvm.emailErrMsg.value,
            fontSize = 14.sp,
            color = Color.Red
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ShowPassword(rvm: RegisterViewModel) {
    Column(modifier = Modifier.padding(5.dp)) {
        TextField(
            value = rvm.password.value,
            onValueChange = {
                rvm.password.value = it
                rvm.validatePassword()

            },
            isError = rvm.isPasswordValid.value,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(5.dp),
            label = { Text("Password") },
            singleLine = true
        )

        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = rvm.passwordErrMsg.value,
            fontSize = 14.sp,
            color = Color.Red
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ShowConfirmPassword(rvm: RegisterViewModel) {
    Column(modifier = Modifier.padding(5.dp)) {
        TextField(
            value = rvm.confirmPassword.value,
            onValueChange = {
                rvm.confirmPassword.value = it
                rvm.validateConfirmPassword()
            },
            isError = rvm.isConfirmPasswordValid.value,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(5.dp),
            label = { Text("Confirm Password") },
            singleLine = true
        )
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = rvm.confPasswordErrMsg.value,
            fontSize = 14.sp,
            color = Color.Red
        )
    }
}