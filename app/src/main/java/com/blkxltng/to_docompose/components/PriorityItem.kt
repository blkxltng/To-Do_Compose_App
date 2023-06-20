package com.blkxltng.to_docompose.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.blkxltng.to_docompose.data.models.Priority
import com.blkxltng.to_docompose.ui.theme.LARGE_PADDING
import com.blkxltng.to_docompose.ui.theme.PRIORITY_INDICATOR_SIZE
import com.blkxltng.to_docompose.ui.theme.Typography

@Composable
fun PriorityItem(priority: Priority) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Canvas(modifier = Modifier.size(PRIORITY_INDICATOR_SIZE)) {
            drawCircle(color = priority.color)
        }
        Text(modifier = Modifier.padding(start = LARGE_PADDING),
            text = priority.name,
            style = Typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface)
    }
}

@Composable
@Preview
fun PriorityItemPreview() {
    PriorityItem(priority = Priority.LOW)
}