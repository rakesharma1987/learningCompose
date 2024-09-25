package com.example.learningcompose.udemyCourse

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningcompose.R
import com.example.learningcompose.udemyCourse.ui.theme.LearningComposeTheme

class DialogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DialogComponent()
                }
            }
        }
    }
}

@Composable
fun DialogComponent(){
    val dialogStatus = remember {
        mutableStateOf(false)
    }
    val textColor = remember {
        mutableStateOf(Color.White)
    }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                dialogStatus.value = true
            }
        ) {
            Text(text = "Show Dialog", color = textColor.value)
        }

        if (dialogStatus.value){
            AlertDialog(
                onDismissRequest = {dialogStatus.value = true},
//                icon = {Image(painter = painterResource(id = R.drawable.ic_alert), contentDescription = "Alert")},
//                title = { Text(text = "Alert")},
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(painter = painterResource(id = R.drawable.ic_alert), contentDescription = "Alert")
                        Text(text = "Alert")
                    }
                },
                text = { Text(text = "This is dialog demonstration")},
                containerColor = Color.Gray,
                shape = RoundedCornerShape(5.dp),
                confirmButton = {
                    Button(
                        onClick = {
                            dialogStatus.value = false
                            textColor.value = Color.Red
                            Toast.makeText(context, "Dialog confirmed button is clicked", Toast.LENGTH_SHORT).show()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text(text = "Yes", color = Color.Black)
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            dialogStatus.value = false
                            Toast.makeText(context, "Dialog  dismiss button is clicked", Toast.LENGTH_SHORT).show()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text(text = "No", color = Color.Black)
                    }
                }
            )
        }
    }
}