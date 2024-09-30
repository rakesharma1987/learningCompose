package com.example.learningcompose.udemyCourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.R
import com.example.learningcompose.udemyCourse.ui.theme.LearningComposeTheme
import com.example.learningcompose.ui.theme.shape

class SwitchDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningComposeTheme {
                SwitchComponent()
            }
        }
    }
}

@Composable
fun SwitchComponent(){
    val switchState = remember {
        mutableStateOf(false)
    }

    val myText = remember {
        mutableStateOf("The image is visible.")
    }

    val myAlphaValue = remember {
        mutableStateOf(1F)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(50.dp))

        Switch(
            checked = switchState.value,
            onCheckedChange = {
                switchState.value = it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Blue,
                checkedTrackColor = Color.Red,
                uncheckedThumbColor = Color.Red,
                uncheckedTrackColor = Color.Blue
            )
        )

        if (!switchState.value){
//            Image(
//                painter = painterResource(id = R.drawable.jetpack_compose),
//                contentDescription = "conpose logo",
//                contentScale = ContentScale.Fit,
//                alignment = Alignment.Center,
//                modifier = Modifier.size(300.dp)
//            )
            myText.value = "The image is visible"
            myAlphaValue.value = 1F
        }else{
//            Spacer(modifier = Modifier.size(300.dp))
            myText.value = "The image is invisible"
            myAlphaValue.value = 0F
        }

        Image(
            painter = painterResource(id = R.drawable.jetpack_compose),
            contentDescription = "conpose logo",
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center,
            modifier = Modifier.size(300.dp).alpha(myAlphaValue.value)
        )

        Spacer(modifier = Modifier.size(50.dp))

        Text(
            text = myText.value,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .background(Color.Blue)
                .width(300.dp)
                .padding(top = 10.dp, bottom = 10.dp),
            textAlign = TextAlign.Center)

    }
}