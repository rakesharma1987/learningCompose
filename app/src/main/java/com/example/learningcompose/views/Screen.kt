package com.example.learningcompose.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.R
import com.example.learningcompose.model.Category

//@Preview(heightDp = 500)
    @Composable
    fun BlogCategoryPreview(onItemClick: (Category) -> Unit){
        LazyColumn(content = {
            items(categoryList()) { item ->
                BlogCategory(imageId = item.image, name = item.name, designation = item.designation, onClick = { onItemClick(item) })

            }
        })

//        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//            categoryList().map {
//                BlogCategory(it.image, it.name, it.designation)
//            }
//        }
    }

    @Composable
    fun BlogCategory(imageId: Int, name: String, designation: String, onClick: () -> Unit){
        Card(
            elevation = CardDefaults.cardElevation(2.dp),
            modifier = Modifier.padding(8.dp).clickable { onClick() },
            border = BorderStroke(1.dp, Color.Gray),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = "Demo Image",
                    modifier = Modifier
                        .size(48.dp)
                        .padding(8.dp)
                        .weight(.2f)
                )
                ItemDeclaration(name = name, designation = designation, modifier = Modifier.weight(.8f))

            }

        }
    }

    @Composable
    fun ItemDeclaration(name: String, designation: String, modifier: Modifier){
        Column(modifier = modifier) {
            Text(
                text = name,
                color = Color.Black,
                fontSize = 16.sp)
            Text(text = designation,
                color = Color.Black,
                fontSize = 12.sp)
        }
    }


fun categoryList(): MutableList<Category>{
    val categoryList = mutableListOf<Category>()
    categoryList.add(Category(R.drawable.female_avatar, "James", "Android Developer"))
    categoryList.add(Category(R.drawable.ic_arc, "Rakesh", "Java Developer"))
    categoryList.add(Category(R.drawable.ic_launcher_background, "Mukesh", "Php Developer"))
    categoryList.add(Category(R.drawable.female_avatar, "Amit", "Angular Developer"))
    categoryList.add(Category(R.drawable.female_avatar, "Vipin", "Degigner"))
    categoryList.add(Category(R.drawable.female_avatar, "Akahnda", "Admin"))
    categoryList.add(Category(R.drawable.female_avatar, "Aditya", "Angular Developer"))
    categoryList.add(Category(R.drawable.female_avatar, "Surya Prakash", "Team Lead"))
    categoryList.add(Category(R.drawable.female_avatar, "Amit Gupta", "Manager"))
    categoryList.add(Category(R.drawable.female_avatar, "Sunitha", "Manager"))
    categoryList.add(Category(R.drawable.female_avatar, "Aditi", "Hr Manager"))
    categoryList.add(Category(R.drawable.female_avatar, "Vijay Singh", "CEO"))
    categoryList.add(Category(R.drawable.female_avatar, "James", "Android Developer"))
    categoryList.add(Category(R.drawable.ic_arc, "Rakesh", "Java Developer"))
    categoryList.add(Category(R.drawable.ic_launcher_background, "Mukesh", "Php Developer"))
    categoryList.add(Category(R.drawable.female_avatar, "Amit", "Angular Developer"))
    categoryList.add(Category(R.drawable.female_avatar, "Vipin", "Degigner"))
    categoryList.add(Category(R.drawable.female_avatar, "Akahnda", "Admin"))
    categoryList.add(Category(R.drawable.female_avatar, "Aditya", "Angular Developer"))
    categoryList.add(Category(R.drawable.female_avatar, "Surya Prakash", "Team Lead"))
    categoryList.add(Category(R.drawable.female_avatar, "Amit Gupta", "Manager"))
    categoryList.add(Category(R.drawable.female_avatar, "Sunitha", "Manager"))
    categoryList.add(Category(R.drawable.female_avatar, "Aditi", "Hr Manager"))
    categoryList.add(Category(R.drawable.female_avatar, "Vijay Singh", "CEO"))
    return categoryList
}
