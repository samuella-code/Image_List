package com.hfad.pictures

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun Footer(
    modifier: Modifier = Modifier,
    onFeedClick: () -> Unit,
    onProgressClick: () -> Unit,
    onCenterButtonClick: () -> Unit,
    onStoreClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        FooterItem(icon = Icons.Rounded.ThumbUp, text = "Feed", onClick = onFeedClick)
        FooterItem(icon = Icons.Rounded.List, text = "Progress", onClick = onProgressClick)
        FooterCenterButton(onClick = onCenterButtonClick)
        FooterItem(icon = Icons.Rounded.ShoppingCart, text = "Store", onClick = onStoreClick, color = Color.Blue)
        FooterItem(icon = Icons.Rounded.Menu, text = "Menu", onClick = onMenuClick)
    }
}
@Composable
fun FooterItem(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit,
    color: Color = LocalContentColor.current
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = color,
            modifier = Modifier.size(24.dp).clickable(onClick = onClick)
        )
        Text(text = text)
    }
}
@Composable
fun FooterCenterButton(onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(48.dp)
            .clickable(onClick = onClick)
            .clip(CircleShape)
            .background(Color.White)
    ) {
        Text(text = "V", color = Color.White)
    }
}