package com.example.learningcompose.basicLayoutsCodelab

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningcompose.R
import com.example.learningcompose.model.FavouriteCollectionItem


@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier){
    LazyRow(modifier = modifier) {
        items(favouriteCollectionData()){ item ->
            AlignYourBodyElement(drawableRes = item.image, txt = item.text)
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
fun AlignYourBodyRowPreview(){
    AlignYourBodyRow()
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawableRes: Int,
    txt: String,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(drawableRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = txt,
            modifier =Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
            )

    }
}

//@Composable
//@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
//fun AlignYourBodyElementPreview(){
//    AlignYourBodyElement(
//        drawableRes = R.drawable.female_avatar,
//        txt = stringResource(id = R.string.app_name),
//        modifier = Modifier.padding(8.dp)
//    )
//
//}

fun favouriteCollectionData(): List<FavouriteCollectionItem>{
    val favouriteData = mutableListOf<FavouriteCollectionItem>()
    favouriteData.add(FavouriteCollectionItem(R.drawable.female_avatar, "Text 1"))
    favouriteData.add(FavouriteCollectionItem(R.drawable.female_avatar, "Text 2"))
    favouriteData.add(FavouriteCollectionItem(R.drawable.female_avatar, "Text 3"))
    favouriteData.add(FavouriteCollectionItem(R.drawable.female_avatar, "Text 4"))
    favouriteData.add(FavouriteCollectionItem(R.drawable.female_avatar, "Text 5"))
    favouriteData.add(FavouriteCollectionItem(R.drawable.female_avatar, "Text 6"))
    favouriteData.add(FavouriteCollectionItem(R.drawable.female_avatar, "Text 7"))
    favouriteData.add(FavouriteCollectionItem(R.drawable.female_avatar, "Text 8"))
    favouriteData.add(FavouriteCollectionItem(R.drawable.female_avatar, "Text 9"))
    favouriteData.add(FavouriteCollectionItem(R.drawable.female_avatar, "Text 10"))
    return favouriteData

}