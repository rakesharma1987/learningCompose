package com.example.learningcompose.basicLayoutsCodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeSection(modifier: Modifier){
    Column(modifier) {
        SearchBar(
            modifier = Modifier.padding(start = 10.dp, top = 0.dp)
        )
        Text(
            text = "Align your body",
            modifier.padding(start = 10.dp, top = 10.dp)
        )
        AlignYourBodyRow(
            modifier = Modifier.padding(start = 10.dp, top = 10.dp)
        )
        Text(
            text = "Favourite Section",
            modifier.padding(start = 10.dp, top = 10.dp)
        )
        FavouriteCollectionGrid(
            modifier = Modifier.padding(start = 0.dp, top = 5.dp)
        )
    }

}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun HomeSectionPreview() {
    HomeSection(modifier = Modifier)
}