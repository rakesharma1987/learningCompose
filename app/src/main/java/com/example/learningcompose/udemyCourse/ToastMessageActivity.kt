package com.example.learningcompose.udemyCourse

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.learningcompose.udemyCourse.ui.theme.LearningComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToastMessageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningComposeTheme {

                    Column {
                        ToastMessageComponent()
                        SnackbarMessage()
                    }
            }
        }
    }

    @Composable
    private fun ToastMessageComponent() {
        val context = LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    Toast.makeText(context, "This is demo toast message.", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text(
                    text = "Show Toast Message"
                )
            }

            SnackbarMessage()
        }
    }
}

@Composable
fun SnackbarMessage(){
    val context = LocalContext.current
    val mySnackbarHostState = remember {
        SnackbarHostState()
    }

    Scaffold(
        snackbarHost = {
          SnackbarHost(
              hostState = mySnackbarHostState
          ){
              Snackbar(
                  snackbarData = it,
                  containerColor = Color.Red,
                  contentColor = Color.White,
                  actionColor = Color.Black,
                  dismissActionContentColor = Color.Black
              )
          }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Button(
                    onClick = {
                        CoroutineScope(Dispatchers.Main).launch {
                            val result = mySnackbarHostState.showSnackbar(
                                "This is demo snackbar message.",
                                "Retry",
                                duration = SnackbarDuration.Short,
                                withDismissAction = true
                                )
                            if (result == SnackbarResult.ActionPerformed){
                                Toast.makeText(context, "Action performed", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                ) {
                    Text(
                        text = "Snack bar Message"
                    )
                }
            }

        }
    )
}
