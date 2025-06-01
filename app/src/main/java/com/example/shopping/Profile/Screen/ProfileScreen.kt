package com.example.shopping.Profile.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopping.R
import com.example.shopping.components.CustomTitle
import com.example.shopping.components.ProfileSection

@Composable
fun ProfileScreen(){

    val profileImage = painterResource(id = R.drawable.profile)

    ProfileSection(
        profileImage = profileImage,
        username = "JKKiddding",
        name = "heloiiw"
    )

}

@Composable
fun ProfileSection(
    profileImage : Painter,
    username : String,
    name : String
){
    Row(
        modifier = Modifier.padding(12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ProfileSection(
            profilePhoto = profileImage,
            profileDesc = "profile image"
        )

        Column {
            CustomTitle(
                header = username,
                fontWeight = FontWeight.Bold
            )

            CustomTitle(
                header = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Thin
            )
        }
    }
}