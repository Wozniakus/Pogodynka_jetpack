package com.example.pogodynkafrontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.pogodynkafrontend.data.local.TokenStore
import com.example.pogodynkafrontend.ui.navigation.NavGraph
import com.example.pogodynkafrontend.ui.navigation.Screen
import com.example.pogodynkafrontend.ui.theme.PogodynkaTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var tokenStore: TokenStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PogodynkaTheme {
                val navController = rememberNavController()

                val startDestination =
                    if (tokenStore.isLoggedIn()) {
                        Screen.Weather.route
                    } else {
                        Screen.Auth.route
                    }

                NavGraph(
                    navController = navController,
                    startDestination = startDestination
                )
            }
        }
    }
}
