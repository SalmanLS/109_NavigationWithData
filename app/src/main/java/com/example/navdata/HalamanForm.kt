package com.example.navdata

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun HalamanForm(
    onSubmitButtonClicked: (MutableList<String>) -> Unit
) {
    var namaTxt by remember{ mutableStateOf("")}
    var alamatTxt by remember{ mutableStateOf("")}
    var tlpnTxt by remember { mutableStateOf("")}

    var listData: MutableList<String> = mutableListOf(namaTxt,alamatTxt,tlpnTxt)

}