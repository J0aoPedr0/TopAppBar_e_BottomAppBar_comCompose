package com.example.trainingcomposable

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    var ctx = LocalContext.current.applicationContext

    var nameField by remember {
        mutableStateOf("")
    }
    var emailField by remember {
        mutableStateOf("")
    }
    var passwordField by remember {
        mutableStateOf("")
    }
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(modifier = Modifier.weight(1f),
                        onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Home, contentDescription = "Home")
                    }
                    IconButton(modifier = Modifier.weight(1f),
                        onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Email, contentDescription = "Home")
                    }
                    IconButton(modifier = Modifier.weight(1f),
                        onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Call, contentDescription = "Home")
                    }
                })

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Filled.Email, contentDescription = "Email")
            }
        },


        topBar = {
            TopAppBar(
                title = { Text(text = "Olá mundo!") },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        }
    ) {}

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 115.dp)
    ) {

        Text(
            text = "Coloque seu nome:",
            fontSize = 24.sp
        )

        OutlinedTextField(
            value = nameField,
            onValueChange = { newText -> nameField = newText },
            label = { Text("Seu nome:") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            placeholder = { Text("Seu nome aqui") },
            leadingIcon = { Icon(Icons.Filled.Face, contentDescription = null) })



        Text(
            modifier = Modifier.padding(top = 50.dp),
            text = "Coloque seu email:",
            fontSize = 24.sp
        )

        OutlinedTextField(
            value = emailField,
            onValueChange = { newText -> emailField = newText },
            label = { Text("Seu Email:") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            placeholder = { Text("Seu Email aqui") },
            leadingIcon = { Icon(Icons.Filled.Email, contentDescription = null) })



        Text(
            modifier = Modifier.padding(top = 50.dp),
            text = "Coloque sua senha:",
            fontSize = 24.sp
        )

        OutlinedTextField(
            value = passwordField,
            onValueChange = { newText -> passwordField = newText },
            label = { Text("Sua senha:") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            placeholder = { Text("Somente números") },
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = null) })

        Button(modifier = Modifier
            .padding(top = 50.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue),
            onClick = {
                Toast.makeText(
                    ctx,
                    "Usuário $nameField cadastrado com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "Logar",
                fontSize = 20.sp,
            )
        }
    }
}


