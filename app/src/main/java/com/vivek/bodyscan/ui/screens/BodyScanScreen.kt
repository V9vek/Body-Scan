package com.vivek.bodyscan.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import com.vivek.bodyscan.R
import com.vivek.bodyscan.ui.components.ScanningCanvas
import com.vivek.bodyscan.util.BaseImageConstants.BLOOD
import com.vivek.bodyscan.util.BaseImageConstants.BONES
import com.vivek.bodyscan.util.BaseImageConstants.DIGESTION
import com.vivek.bodyscan.util.BaseImageConstants.MUSCLES
import com.vivek.bodyscan.util.BaseImageConstants.NERVES

@Composable
fun BodyScanScreen() {
    var selectedIconString by remember { mutableStateOf(BONES) }

    val baseImage = ImageBitmap.imageResource(
        id = when (selectedIconString) {
            BONES -> R.drawable.bones
            BLOOD -> R.drawable.blood
            NERVES -> R.drawable.nerves
            DIGESTION -> R.drawable.digestion
            MUSCLES -> R.drawable.muscles
            else -> R.drawable.body
        }
    )
    val overlayImage = ImageBitmap.imageResource(id = R.drawable.body)

    Box {
        ScanningCanvas(
            selectedIconString = selectedIconString,
            baseImage = baseImage,
            overlayImage = overlayImage,
            modifier = Modifier
        )
        OverlayScreen(
            onSelectedIcon = { selectedIconString = it },
            modifier = Modifier.align(Alignment.TopEnd)
        )
    }
}

























