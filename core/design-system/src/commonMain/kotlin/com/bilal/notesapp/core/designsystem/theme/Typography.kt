package com.bilal.notesapp.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bilal.notesapp.core.designsystem.resources.Res
import com.bilal.notesapp.core.designsystem.resources.plus_jakarta_sans_bold
import com.bilal.notesapp.core.designsystem.resources.plus_jakarta_sans_medium
import com.bilal.notesapp.core.designsystem.resources.plus_jakarta_sans_regular
import com.bilal.notesapp.core.designsystem.resources.plus_jakarta_sans_semibold
import org.jetbrains.compose.resources.Font

@Composable
internal fun notesTypography(): Typography {
    // Bundled weights keep the same appearance offline, without a downloadable-font provider.
    val regular = Font(Res.font.plus_jakarta_sans_regular, FontWeight.Normal)
    val medium = Font(Res.font.plus_jakarta_sans_medium, FontWeight.Medium)
    val semibold = Font(Res.font.plus_jakarta_sans_semibold, FontWeight.SemiBold)
    val bold = Font(Res.font.plus_jakarta_sans_bold, FontWeight.Bold)
    val fontFamily = remember(regular, medium, semibold, bold) {
        FontFamily(regular, medium, semibold, bold)
    }

    return remember(fontFamily) {
        val baseline = Typography(
            displayLarge = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 57.sp,
                lineHeight = 64.sp,
                letterSpacing = (-0.25).sp,
            ),
            displayMedium = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 45.sp,
                lineHeight = 52.sp,
                letterSpacing = 0.sp,
            ),
            displaySmall = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 36.sp,
                lineHeight = 44.sp,
                letterSpacing = 0.sp,
            ),
            headlineLarge = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 32.sp,
                lineHeight = 40.sp,
                letterSpacing = 0.sp,
            ),
            headlineMedium = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 28.sp,
                lineHeight = 36.sp,
                letterSpacing = 0.sp,
            ),
            headlineSmall = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                lineHeight = 32.sp,
                letterSpacing = 0.sp,
            ),
            titleLarge = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp,
            ),
            titleMedium = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.15.sp,
            ),
            titleSmall = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp,
            ),
            bodyLarge = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
            ),
            bodyMedium = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp,
            ),
            bodySmall = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.4.sp,
            ),
            labelLarge = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp,
            ),
            labelMedium = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp,
            ),
            labelSmall = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp,
            ),
        )

        // Expressive variants use the same family and scale, with a stronger weight.
        baseline.copy(
            displayLargeEmphasized = baseline.displayLarge.copy(fontWeight = FontWeight.Bold),
            displayMediumEmphasized = baseline.displayMedium.copy(fontWeight = FontWeight.Bold),
            displaySmallEmphasized = baseline.displaySmall.copy(fontWeight = FontWeight.Bold),
            headlineLargeEmphasized = baseline.headlineLarge.copy(fontWeight = FontWeight.Bold),
            headlineMediumEmphasized = baseline.headlineMedium.copy(fontWeight = FontWeight.Bold),
            headlineSmallEmphasized = baseline.headlineSmall.copy(fontWeight = FontWeight.Bold),
            titleLargeEmphasized = baseline.titleLarge.copy(fontWeight = FontWeight.Bold),
            titleMediumEmphasized = baseline.titleMedium.copy(fontWeight = FontWeight.Bold),
            titleSmallEmphasized = baseline.titleSmall.copy(fontWeight = FontWeight.Bold),
            bodyLargeEmphasized = baseline.bodyLarge.copy(fontWeight = FontWeight.Medium),
            bodyMediumEmphasized = baseline.bodyMedium.copy(fontWeight = FontWeight.Medium),
            bodySmallEmphasized = baseline.bodySmall.copy(fontWeight = FontWeight.Medium),
            labelLargeEmphasized = baseline.labelLarge.copy(fontWeight = FontWeight.SemiBold),
            labelMediumEmphasized = baseline.labelMedium.copy(fontWeight = FontWeight.SemiBold),
            labelSmallEmphasized = baseline.labelSmall.copy(fontWeight = FontWeight.SemiBold),
        )
    }
}
