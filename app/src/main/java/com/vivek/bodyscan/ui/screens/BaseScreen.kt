package com.vivek.bodyscan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vivek.bodyscan.ui.theme.BaseScreenBGColor

@Composable
fun BaseScreen(selectedIconString: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BaseScreenBGColor)
    ) {
        // Selected Icon Text
        Row(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.TopCenter),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = selectedIconString,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onPrimary
            )
        }

        // Base Image
//            Image(
//                painter = painterResource(id = baseImage),
//                contentDescription = "Base Image",
//                modifier = Modifier
//                    .padding(bottom = 16.dp, top = 8.dp)
//                    .align(Alignment.CenterHorizontally)
//                    .size(height = 600.dp, width = 300.dp)
//            )
    }
}























