package com.vipulasri.jetinstagram.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ToggleButton(state:Boolean) {
    var isChecked by remember { mutableStateOf(state) }

   // Row(modifier = Modifier.padding(start = 16.dp)) {
       // Spacer(modifier = Modifier.width(16.dp))
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it },

        )
    //}
}

