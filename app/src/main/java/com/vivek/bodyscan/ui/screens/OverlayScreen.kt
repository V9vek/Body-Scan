package com.vivek.bodyscan.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vivek.bodyscan.R
import com.vivek.bodyscan.ui.theme.BaseScreenBGColor
import com.vivek.bodyscan.ui.theme.OverlayScreenBGColor
import com.vivek.bodyscan.util.BaseImageConstants.BLOOD
import com.vivek.bodyscan.util.BaseImageConstants.BONES
import com.vivek.bodyscan.util.BaseImageConstants.DIGESTION
import com.vivek.bodyscan.util.BaseImageConstants.MUSCLES
import com.vivek.bodyscan.util.BaseImageConstants.NERVES

@Composable
fun OverlayScreen(
    onSelectedIcon: (String) -> Unit,
    modifier: Modifier
) {
    var isRowOpen by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
    ) {
        // IconsRow
        Row(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconsRow(
                modifier = Modifier,
                isRowOpen = isRowOpen,
                onToggleRow = { isRowOpen = it },
                onSelectedIcon = onSelectedIcon
            )
        }
    }
}

@Composable
fun IconsRow(
    modifier: Modifier,
    isRowOpen: Boolean,
    onToggleRow: (Boolean) -> Unit,
    onSelectedIcon: (String) -> Unit
) {
    val toggleRow = { onToggleRow(!isRowOpen) }

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(color = BaseScreenBGColor)
            .padding(horizontal = if (isRowOpen) 8.dp else 0.dp)
            .animateContentSize(),
    ) {
        if (!isRowOpen) {
            Icon(
                imageVector = Icons.Rounded.ArrowBackIosNew,
                contentDescription = "Open Row Icon",
                tint = OverlayScreenBGColor,
                modifier = Modifier
                    .padding(4.dp)
                    .clickable { toggleRow() }
                    .size(36.dp)
                    .padding(6.dp)
            )
        } else {
            CustomIcon(icon = painterResource(id = R.drawable.icon_bone),
                onClick = {
                    onSelectedIcon(BONES)
                    toggleRow()
                })
            CustomIcon(
                icon = painterResource(id = R.drawable.icon_blood),
                onClick = {
                    onSelectedIcon(BLOOD)
                    toggleRow()
                })
            CustomIcon(
                icon = painterResource(id = R.drawable.icon_nerves),
                onClick = {
                    onSelectedIcon(NERVES)
                    toggleRow()
                })
            CustomIcon(
                icon = painterResource(id = R.drawable.icon_digestion),
                onClick = {
                    onSelectedIcon(DIGESTION)
                    toggleRow()
                })
            CustomIcon(
                icon = painterResource(id = R.drawable.icon_muscles),
                onClick = {
                    onSelectedIcon(MUSCLES)
                    toggleRow()
                })
        }
    }
}

@Composable
fun CustomIcon(
    icon: Painter,
    size: Dp = 36.dp,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .clip(CircleShape)
            .background(OverlayScreenBGColor.copy(alpha = 0.1f))
    ) {
        Icon(
            painter = icon,
            contentDescription = "",
            tint = OverlayScreenBGColor,
            modifier = Modifier
                .clickable { onClick() }
                .size(size)
                .padding(6.dp)
        )
    }
}









