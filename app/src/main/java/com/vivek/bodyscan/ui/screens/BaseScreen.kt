package com.vivek.bodyscan.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vivek.bodyscan.R
import com.vivek.bodyscan.ui.theme.BaseScreenBGColor
import com.vivek.bodyscan.util.BaseImageConstants.BLOOD
import com.vivek.bodyscan.util.BaseImageConstants.BONES
import com.vivek.bodyscan.util.BaseImageConstants.DIGESTION
import com.vivek.bodyscan.util.BaseImageConstants.MUSCLES
import com.vivek.bodyscan.util.BaseImageConstants.NERVES

@Composable
fun BaseScreen(currentlySelectedIcon: String) {
    println(currentlySelectedIcon)

    val baseImage = when (currentlySelectedIcon) {
        BONES -> R.drawable.bones
        BLOOD -> R.drawable.blood
        NERVES -> R.drawable.nerves
        DIGESTION -> R.drawable.digestion
        MUSCLES -> R.drawable.muscles
        else -> R.drawable.body
    }

    val baseDescription = when (currentlySelectedIcon) {
        BONES -> "Bones"
        BLOOD -> "Blood"
        NERVES -> "Nerves"
        DIGESTION -> "Digestion"
        MUSCLES -> "Muscles"
        else -> "Body"
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BaseScreenBGColor)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // TODO: make text dynamic according to selection of icons
                Text(
                    text = baseDescription,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onPrimary
                )
            }

            // Base Image
            Image(
                painter = painterResource(id = baseImage),
                contentDescription = "Base Image",
                modifier = Modifier
                    .padding(bottom = 16.dp, top = 8.dp)
                    .align(Alignment.CenterHorizontally)
                    .size(height = 600.dp, width = 300.dp)
            )
        }
    }
}























