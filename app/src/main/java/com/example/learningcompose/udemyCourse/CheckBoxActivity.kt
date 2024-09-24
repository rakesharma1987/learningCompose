package com.example.learningcompose.udemyCourse

import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.udemyCourse.ui.theme.LearningComposeTheme

class CheckBoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CheckboxExample()
                }
            }
        }
    }
}

@Composable
fun CheckboxExample(){
    val resultText = remember {
        mutableStateOf("What is yor gender")
    }
    val cbMale = remember {
        mutableStateOf(false)
    }

    val cbFemale = remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp),
        verticalArrangement = Arrangement.Top) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(100.dp)
                .background(color = Color.Black)
                .padding(0.dp, 20.dp, 0.dp, 0.dp),
            contentAlignment = Alignment.Center){
            Text(
                text = resultText.value,
                color = Color.White,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.SansSerif,
            )
        }
        Spacer(modifier = Modifier.size(10.dp))

        Column {
            Row(verticalAlignment = Alignment.CenterVertically){
                Checkbox(
                    checked = cbMale.value,
                    onCheckedChange = {
                        cbMale.value = it
                        if (cbMale.value){
                            resultText.value = "Your gender is male"
                            cbFemale.value = false
                        }else{
                            resultText.value = "What is yor gender"
                        }
                    },
                    colors = CheckboxDefaults.colors()
                )
                Text(text = "Male", fontSize = 20.sp, color = Color.Black)
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = cbFemale.value,
                onCheckedChange = {
                    cbFemale.value = it
                    if(cbFemale.value){
                        resultText.value = "Your gender is female"
                        cbMale.value = false
                    }else{
                        resultText.value = "What is yor gender"
                    }

                },
                colors = CheckboxDefaults.colors()
            )

            Text(text = "Female", fontSize = 20.sp, color = Color.Black)
        }


    }
}

@Preview
@Composable
fun CheckboxExamplePreview(){
    CheckboxExample()
}