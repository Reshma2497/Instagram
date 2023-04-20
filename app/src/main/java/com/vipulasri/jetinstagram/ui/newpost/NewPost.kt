package com.vipulasri.jetinstagram.ui.newpost

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import java.util.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.ui.components.ListOfCard
import com.vipulasri.jetinstagram.ui.components.TitleWithAction
import com.vipulasri.jetinstagram.ui.components.ToggleButton


@Composable
fun NewPost() {
    Column(
        modifier = Modifier
            .fillMaxWidth().verticalScroll(rememberScrollState())
     //   .height(30.dp)
//        .background(Color.LightGray)
//        .padding(horizontal = 10.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyToolbar()
        Divider()
        Caption()
        Divider()
        TitleWithAction(name = "Tag People")
        Divider()
        TitleWithAction(name = "Add Location")
        val locations =
            listOf("New York", "London", "Tokyo", "Paris", "Los Angeles")
        ListOfCard(locations, "locations")
        Divider()
        TitleWithAction(name = "Add Music")
        val music =
            listOf("Beautiful Day", "Birthday", "Happy moments", "Sunrise", "Let me love you ")
        ListOfCard(music, "music")
        Divider()
        TitleWithAction(name = "Add Fundraiser")
        Divider()
        PostToInstagram()
        Divider()
        ShareToFacebook()
        Divider()
        TitleWithAction(name = "Advanced Settings")

    }

}


@Composable
fun MyToolbar(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        //Icon(ImageVector.vectorResource(R.drawable.ic_backarrow))
        Icon(
            ImageVector.vectorResource(id = R.drawable.ic_backarrow),
            contentDescription = ""
        )
        Text(
            text = stringResource(R.string.title).uppercase(Locale.getDefault()),
            //textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .padding(horizontal = 65.dp)
        )
        Text(
            text = "Share",
            style = MaterialTheme.typography.button,
            color = Color.Blue
        )

    }
}

@Composable
fun Caption(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 10.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_girl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .size(100.dp)
                .padding(top = 10.dp, bottom = 10.dp)
        )
        Text(
            text = "Write a Caption...",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 110.dp)
        )

    }
}

@Composable
fun PostToInstagram(modifier: Modifier=Modifier)
{
    Text(text = "Post to other Instagram accounts",
        style = MaterialTheme.typography.h6,
        modifier = Modifier
            .padding(horizontal = 10.dp))
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 10.dp) ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_girl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .padding(top = 10.dp, bottom = 10.dp)
                .clip(CircleShape)
        )
        Text(
            text = "Ayushi",
           // textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
//            modifier = Modifier
//                .padding(start = 20.dp)
        )
       ToggleButton(false)

    }
}

@Composable
fun ShareToFacebook(modifier: Modifier=Modifier)
{
    Row(modifier = modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(horizontal = 10.dp) ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Share to Facebook",
            style = MaterialTheme.typography.h6
        )
        ToggleButton(true)
    }
    Text(
        text = buildAnnotatedString {
            append("Sharing as ")
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Ayushi")
            }
            append(". Audience is ")
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Friends")
            }
        },
        style = MaterialTheme.typography.h6,
        color = Color.Gray,
        modifier = Modifier.padding(start = 10.dp)
    )
}
