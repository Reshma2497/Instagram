package com.vipulasri.jetinstagram.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vipulasri.jetinstagram.R

@Composable
fun Card(location: String,cardtype: String) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 16.dp),
        shape = RoundedCornerShape(1.dp),
        elevation = 4.dp,
        backgroundColor = Color.LightGray
    ) {
        if (cardtype == "music") {
            Icon(
                ImageVector.vectorResource(id = R.drawable.ic_music),
                contentDescription = ""
            )
            Text(
                text = location,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(
                   start = 30.dp
                )
            )
        }
        else {
            Text(text = location, textAlign = TextAlign.Center, modifier = Modifier.padding(
                horizontal=5.dp, vertical = 5.dp))
        }

    }
}
@Composable
fun ListOfCard(list: List<String>, cardtype: String) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
    ) {
        items(count = list.size) { index ->
            val location = list[index]
            Card(location, cardtype)
        }
    }
}