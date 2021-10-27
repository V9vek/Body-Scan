package com.vivek.bodyscan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.vivek.bodyscan.ui.screens.BodyScanScreen
import com.vivek.bodyscan.ui.theme.BodyScanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BodyScanTheme {
                Surface(color = MaterialTheme.colors.background) {
                    BodyScanScreen()
                }
            }
        }
    }
}
