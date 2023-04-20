package com.vipulasri.jetinstagram.ui.favourite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.data.FavouritesRepository
import com.vipulasri.jetinstagram.data.PostsRepository
import com.vipulasri.jetinstagram.model.User
import com.vipulasri.jetinstagram.ui.home.StoryImage
import java.util.*

@Composable
fun Favorite()
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        MyFavouriteToolbar()
        Divider()
        Suggestion()
        Divider()
        SearchBar()

        val favUsers by FavouritesRepository.favUsers

        LazyColumn (
            modifier = Modifier
                .padding(top = 10.dp)
        ){
            itemsIndexed(favUsers) { _, user ->
                AddUser(user)
            }
        }

    }
}

@Composable
fun MyFavouriteToolbar(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            ImageVector.vectorResource(id = R.drawable.ic_close),
            contentDescription = ""
        )
        Text(
            text = stringResource(R.string.fav_titile).uppercase(Locale.getDefault()),
            //textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .padding(horizontal = 65.dp)
        )
        Icon(
            ImageVector.vectorResource(id = R.drawable.ic_add),
            contentDescription = ""
        )
    }
}

@Composable
fun Suggestion()
{
    Text(
        text = buildAnnotatedString {
            append("New posts from your favorites will appear higher in feed. Only you see who add or remove. ")
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("How it Works")
            }
        },
        style = MaterialTheme.typography.h6,
        color = Color.Black,
        modifier = Modifier
            .background(Color(0xFFEAEAEA)),
        textAlign = TextAlign.Center

    )
}
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
    )
}

@Composable
fun AddUser(fav:User)
{


    Row(
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 5.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = rememberImagePainter(
                data = fav.image,
                builder = {
                    // You can customize the image loading here, e.g.
                    // set placeholder or error images, etc.
                }
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .padding(top = 10.dp, bottom = 10.dp)
                .clip(CircleShape),
                    // Add a default image as a fallback


        )
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(5.dp)
                .align(Alignment.Top)
                .weight(2f),
            horizontalAlignment = Alignment.Start
        ){
            Text(
                text = "${fav.username}",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${fav.name}"
            )
        }
        Button(
            onClick = {},
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = "Add"
            )
        }
    }
}

@Composable
fun DefaultImage(modifier: Modifier = Modifier) {
    Box(modifier = modifier.background(Color.Gray)) {
        Icon(
            painter = painterResource(id = R.drawable.ic_girl),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center),
            tint = Color.White
        )
    }
}
