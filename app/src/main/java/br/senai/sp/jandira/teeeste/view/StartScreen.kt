package br.senai.sp.jandira.teeeste.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun StartScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column (
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(onClick = {

        }) {
            Text(text = "GET")
        }
        Button(onClick = {

        }) {
            Text(text = "PUT")
        }
        Button(onClick = {

        }) {
            Text(text = "DELETE")
        }
        Button(onClick = {

        }) {
            Text(text = "POST")
        }
    }
}