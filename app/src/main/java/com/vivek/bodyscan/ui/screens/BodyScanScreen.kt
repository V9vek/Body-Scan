package com.vivek.bodyscan.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.vivek.bodyscan.util.BaseImageConstants.BONES

@Composable
fun BodyScanScreen() {
    var currentlySelectedIcon by remember { mutableStateOf(BONES) }

    Box(modifier = Modifier.fillMaxSize()) {
        BaseScreen(currentlySelectedIcon = currentlySelectedIcon)
        OverlayScreen(
            currentlySelectedIcon = currentlySelectedIcon,
            onSelectedIcon = { currentlySelectedIcon = it }
        )
    }
}
























