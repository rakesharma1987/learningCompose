package com.example.learningcompose.udemyCourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.learningcompose.udemyCourse.ui.theme.LearningComposeTheme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningComposeTheme {
//                MainPage()
                MyNavigation()
            }
        }
    }
}

@Composable
fun MyNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "MainPage"){
        composable(route = "MainPage") {
            MainPage(navController)
        }

        composable(
            route = "SecondPage/{name}/{age}",
            arguments = listOf(
                navArgument("name"){type = NavType.StringType},
                navArgument("age"){type = NavType.IntType}
            )
            ) {navBackStackEntry ->
            val name = navBackStackEntry.arguments?.getString("name")
            val age = navBackStackEntry.arguments?.getInt("age")
//            SecondPage(navController, name!!, age!!)
            name?.let { userName ->
                age?.let { userAge ->
                    SecondPage(navController, userName, userAge)
                }

            }
        }
    }

}