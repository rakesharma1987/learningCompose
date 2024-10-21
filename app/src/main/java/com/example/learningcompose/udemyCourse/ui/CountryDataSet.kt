package com.example.learningcompose.udemyCourse.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.learningcompose.R
import com.example.learningcompose.udemyCourse.model.CountryModel

// https://medium.com/@tangkegaga/snapshot-concept-in-jetpack-compose-6c62dabdb143

@Composable
fun retrieveCountryList(): SnapshotStateList<CountryModel>{
    val countryList = remember {
        mutableStateListOf(
            CountryModel(1, "Argentina", "This is argentina country flag", R.drawable.ic_argentine),
            CountryModel(2, "France", "This is france country flag", R.drawable.ic_france),
            CountryModel(3, "Germany", "This is Germany country flag", R.drawable.ic_germeny),
            CountryModel(4, "India", "This is India country flag", R.drawable.ic_india),
            CountryModel(5, "Ireland", "This is ireland country flag", R.drawable.ic_ireland),
            CountryModel(6, "Italy", "This is italy country flag", R.drawable.ic_netherland),
            CountryModel(7, "Netherland", "This is argentina country flag", R.drawable.ic_argentine),
            CountryModel(8, "Romania", "This is romania country flag", R.drawable.ic_romania),
            CountryModel(9, "Slovakia", "This is slovakia country flag", R.drawable.ic_slovakia),
            CountryModel(10, "Spain", "This is spain country flag", R.drawable.ic_spain),
            CountryModel(11, "Turkey", "This is turkey country flag", R.drawable.ic_turkey)
        )
    }
    return countryList
}