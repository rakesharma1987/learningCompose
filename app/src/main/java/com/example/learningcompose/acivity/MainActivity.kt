package com.example.learningcompose.acivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            SayCheesy("Rakesh")
//            ShowImage()
//            composableButton()
//            TextInputFields()
//            ComposableColumn()
//            ComposableRow()
            ListItem(R.drawable.ic_arc, "Rakesh Sharma", "Android Developer")
//            ComposableBox()
//            CircularImage()
        }
    }
}

@Composable
fun CircularImage(){
    Image(
        painter = painterResource(id = R.drawable.ic_arc),
        contentDescription = "circular image",
        modifier = Modifier
            .size(100.dp)
            .padding(10.dp)
            .clip(CircleShape)
            .border(1.dp, Color.Red, CircleShape)
    )
}

@Preview(showSystemUi = true)
@Composable
fun CircularImagePreview(){
    CircularImage()
}



@Composable
fun ListItem(imageId: Int, name: String, designation: String){
    Row(Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "Profile",
            Modifier.size(40.dp)
        )
        Column {
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = designation, fontWeight = FontWeight.Normal, fontSize = 14.sp)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ListItemPreview(){
    Column {
        ListItem(R.drawable.female_avatar, "Rakesh Sharma", "Android Developer")
        ListItem(R.drawable.female_avatar, "Rakesh Sharma", "Android Developer")
        ListItem(R.drawable.female_avatar, "Rakesh Sharma", "Android Developer")
        ListItem(R.drawable.female_avatar, "Rakesh Sharma", "Android Developer")
        ListItem(R.drawable.female_avatar, "Rakesh Sharma", "Android Developer")
        ListItem(R.drawable.female_avatar, "Rakesh Sharma", "Android Developer")
    }
}

@Composable
fun ComposableBox(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Text(text = "Hello")
        Image(painter = painterResource(id = R.drawable.ic_arc), contentDescription = "")
    }
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFDDFFAF)
@Composable
fun ComposableBoxPreview(){
    ComposableBox()
}


@Composable
fun ComposableRow(){
    Row(modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center) {
        Text(text = "A")
        Text(text = "B")
        
    }
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFDDFFAF)
@Composable
fun ComposableRowPreview(){
    ComposableRow()
}

@Composable
fun ComposableColumn(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Hello Heloo Helo Hlo Hello", fontSize = 20.sp)
        Text(text = "World World World World", fontSize = 20.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFDDFFAF)
@Composable
fun ComposableColumnPreview(){
    ComposableColumn()
}



@Composable
fun TextInputFields(){
    val state = remember{mutableStateOf("")}
    TextField(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        label = {
            Text(text = "Enter your name") },
        placeholder = {})
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFDDFFAF, widthDp = 500, heightDp = 500)
@Composable
fun TextInputFieldsPreview(){
    TextInputFields()
}

@Composable
fun ComposableButton(){
    Button(onClick = {}, enabled = false) {
        Text(text = "Submit")

    }
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFDDFFAF)
@Composable
fun ComposableButtonPreview(){
    ComposableButton()
}

@Composable
fun ShowImage(){
    Image(
        painter = painterResource(id = R.drawable.ic_arc),
        contentDescription = "dummy image",
        colorFilter = ColorFilter.tint(Color.Red),
        contentScale = ContentScale.Crop,
        )
}

@Preview(showBackground = true, showSystemUi = true, widthDp = 300, heightDp = 500, backgroundColor = 0xFFDDFFAF)
@Composable
fun ShowImagePreview(){
    ShowImage()
}

@Composable
private fun SayCheesy(name: String) {
    Text(
        text = "Hello $name",
        fontStyle = FontStyle.Italic,
        color = Color.Red,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        textAlign = TextAlign.Center
    )
}

@Preview(
    showBackground = true, showSystemUi = true, name = "Hello message",
    widthDp = 300, heightDp = 500, backgroundColor = 0xFFDDFFAF
)
@Composable
private fun SayCheesyPreview(name: String = "Android") {
    SayCheesy(name = "Rakesh")
}
