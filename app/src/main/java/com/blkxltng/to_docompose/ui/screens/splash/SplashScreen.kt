package com.blkxltng.to_docompose.ui.screens.splash

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.blkxltng.to_docompose.R
import com.blkxltng.to_docompose.ui.theme.LOGO_PADDING
import com.blkxltng.to_docompose.util.Constants.SPLASH_SCREEN_DELAY
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToListScreen: () -> Unit
) {
    var startAnimation by remember { mutableStateOf(false) }
    val offsetState by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else 100.dp,
        animationSpec = tween(
            durationMillis = 1000
        )
    )
    val alphaState by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(SPLASH_SCREEN_DELAY)
        navigateToListScreen()
    }

    Splash(offsetState = offsetState, alphaState = alphaState)
}

@Composable
fun Splash(offsetState: Dp, alphaState: Float) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.primary)
        .offset(y = offsetState)
        .alpha(alpha = alphaState),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.sticky_note),
            contentDescription = stringResource(R.string.splash_screen_image),
            tint = MaterialTheme.colorScheme.onPrimary
        )
        Text(
            modifier = Modifier.padding(bottom = LOGO_PADDING),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.ExtraBold,
            text = stringResource(R.string.splash_screen_logo_text),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    Splash(offsetState = 0.dp, alphaState = 1f)
}
