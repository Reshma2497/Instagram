package com.vipulasri.jetinstagram.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.vipulasri.jetinstagram.R

@Composable
fun TitleWithAction(name:String, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            //textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(horizontal = 5.dp)
        )
        Icon(
            ImageVector.vectorResource(id = R.drawable.ic_arrowforward),
            contentDescription = ""
        )


    }
}