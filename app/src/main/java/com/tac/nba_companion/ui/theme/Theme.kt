package com.tac.nba_companion.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC),       // Un violet doux
    onPrimary = Color(0xFF000000),     // Noir pour le texte sur fond violet
    secondary = Color(0xFF03DAC5),     // Cyan vibrant
    onSecondary = Color(0xFF000000),   // Noir pour le texte sur fond cyan
    tertiary = Color(0xFF03DAC5),      // Un autre ton de bleu ou cyan
    onTertiary = Color(0xFF000000),    // Noir pour le texte sur fond tertiary
    background = Color(0xFF121212),    // Arrière-plan très sombre
    onBackground = Color(0xFFFFFFFF),  // Blanc pour le texte sur l'arrière-plan sombre
    surface = Color(0xFF1F1B24),       // Gris foncé pour les surfaces
    onSurface = Color(0xFFFFFFFF),     // Blanc pour le texte sur les surfaces grises
    error = Color(0xFFCF6679),         // Rouge pour les erreurs
    onError = Color(0xFF000000)        // Noir pour le texte sur fond rouge
)

//private val DarkColorScheme = darkColorScheme(
//    primary = Purple80,
//    secondary = PurpleGrey80,
//    tertiary = Pink80
//)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun NbaCompanionTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    // Forcer l'utilisation du thème sombre, indépendamment des préférences du système
    val colorScheme = if (dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        dynamicDarkColorScheme(LocalContext.current)
    } else {
        DarkColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}