package br.senai.sp.jandira.teeeste

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.teeeste.service.RetrofitFactory

import br.senai.sp.jandira.teeeste.ui.theme.TeeesteTheme
import br.senai.sp.jandira.teeeste.view.StartScreen
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    lateinit var apiService: ApiServices



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        apiService = RetrofitFactory.getInstance().create(ApiServices::class.java)
        setContent {
            TeeesteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "start"){
                        composable(route = "start"){
                            StartScreen(navController = navController, onClick = { getUserByID() })
                        }
                    }

                }
            }
        }
    }


   fun getUserByID() {
        lifecycleScope.launch {
            val result = apiService.getUserByID("2")

            if(result.isSuccessful){
                Log.e("GETTING-DATA", "${result.body()?.data}")
            }else{
                Log.e("GETTING-DATA", "${result.message()}")
            }
        }
    }
}



