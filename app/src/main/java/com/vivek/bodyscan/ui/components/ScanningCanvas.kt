package com.vivek.bodyscan.ui.components

import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.DrawContext
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.vivek.bodyscan.ui.theme.BaseScreenBGColor
import com.vivek.bodyscan.ui.theme.OverlayScreenBGColor

@Composable
fun ScanningCanvas(
    selectedIconString: String,
    overlayImage: ImageBitmap,
    baseImage: ImageBitmap,
    modifier: Modifier
) {
    var scannedOffset by remember { mutableStateOf(Offset(-500f, -500f)) }

    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(OverlayScreenBGColor)
            .padding(4.dp)
            .pointerInput(Unit) {
                detectDragGestures { change, _ ->
                    scannedOffset = change.position
                }
            }
    ) {
        val imageWidth = overlayImage.width
        val imageHeight = overlayImage.height

        val canvasWidth = size.width
        val canvasHeight = size.height

        val circle = Path().apply {
            addOval(oval = Rect(scannedOffset, 300f))
        }

        // Overlay Image
        drawImage(
            image = overlayImage,
            dstOffset = IntOffset(
                x = center.x.toInt() - (imageWidth),
                y = center.y.toInt() - (imageHeight)
            ),
            dstSize = IntSize(width = overlayImage.width * 2, height = overlayImage.height * 2)
        )

        clipPath(circle, clipOp = ClipOp.Intersect) {
            // Background Color
            drawRect(
                brush = SolidColor(BaseScreenBGColor),
                size = Size(canvasWidth, canvasHeight)
            )

            // Selected Icon Text
            drawBGText(drawContext = drawContext, text = selectedIconString)

            // Base Image
            drawImage(
                image = baseImage,
                dstOffset = IntOffset(
                    x = center.x.toInt() - (imageWidth),
                    y = center.y.toInt() - (imageHeight)
                ),
                dstSize = IntSize(width = overlayImage.width * 2, height = overlayImage.height * 2)
            )
        }
    }
}

fun drawBGText(drawContext: DrawContext, text: String) {
    val paint = android.graphics.Paint().apply {
        textSize = 64f
        color = 0xFFFFFFFF.toInt()
        typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
    }
    drawContext.canvas.nativeCanvas.drawText(text, 50f, 120f, paint)
}

















