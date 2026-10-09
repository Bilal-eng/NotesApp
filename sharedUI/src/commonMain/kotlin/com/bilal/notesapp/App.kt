package com.bilal.notesapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.bilal.notesapp.core.designsystem.theme.AppDimensions
import com.bilal.notesapp.core.designsystem.theme.NotesTheme
import notesapp.sharedui.generated.resources.Res
import notesapp.sharedui.generated.resources.theme_app_name
import notesapp.sharedui.generated.resources.theme_category_ideas
import notesapp.sharedui.generated.resources.theme_category_journal
import notesapp.sharedui.generated.resources.theme_category_plans
import notesapp.sharedui.generated.resources.theme_greeting_hide
import notesapp.sharedui.generated.resources.theme_greeting_show
import notesapp.sharedui.generated.resources.theme_hero_subtitle
import notesapp.sharedui.generated.resources.theme_hero_title
import notesapp.sharedui.generated.resources.theme_note_body
import notesapp.sharedui.generated.resources.theme_note_label
import notesapp.sharedui.generated.resources.theme_note_title
import notesapp.sharedui.generated.resources.theme_sample_label
import org.jetbrains.compose.resources.stringResource

@Composable
fun App() {
    NotesTheme {
        var showContent by remember { mutableStateOf(false) }
        val greeting = remember { Greeting().greet() }

        AppContent(
            showContent = showContent,
            greeting = greeting,
            onToggleContent = { showContent = !showContent },
        )
    }
}

@Composable
private fun AppContent(
    showContent: Boolean,
    greeting: String,
    onToggleContent: () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
    ) {
        Box(
            modifier = Modifier.fillMaxSize().safeContentPadding(),
            contentAlignment = Alignment.TopCenter,
        ) {
            Column(
                modifier = Modifier
                    .widthIn(max = AppDimensions.contentMaxWidth)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(AppDimensions.screenPadding),
                verticalArrangement = Arrangement.spacedBy(AppDimensions.spacingSection),
            ) {
                Text(
                    text = stringResource(Res.string.theme_app_name),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                )
                Column(verticalArrangement = Arrangement.spacedBy(AppDimensions.spacingRegular)) {
                    Text(
                        text = stringResource(Res.string.theme_hero_title),
                        style = MaterialTheme.typography.headlineLarge,
                    )
                    Text(
                        text = stringResource(Res.string.theme_hero_subtitle),
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
                ThemeSampleCard()
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(AppDimensions.spacingMedium),
                    verticalArrangement = Arrangement.spacedBy(AppDimensions.spacingMedium),
                ) {
                    ThemeTag(
                        text = stringResource(Res.string.theme_category_ideas),
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                    ThemeTag(
                        text = stringResource(Res.string.theme_category_plans),
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    )
                    ThemeTag(
                        text = stringResource(Res.string.theme_category_journal),
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    )
                }
                Button(onClick = onToggleContent) {
                    Text(
                        text = stringResource(
                            if (showContent) Res.string.theme_greeting_hide
                            else Res.string.theme_greeting_show,
                        ),
                    )
                }
                AnimatedVisibility(showContent) {
                    Surface(
                        shape = MaterialTheme.shapes.large,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    ) {
                        Text(
                            text = greeting,
                            modifier = Modifier.fillMaxWidth().padding(AppDimensions.spacingLarge),
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ThemeSampleCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
    ) {
        Column(
            modifier = Modifier.padding(AppDimensions.cardPadding),
            verticalArrangement = Arrangement.spacedBy(AppDimensions.spacingLarge),
        ) {
            Text(
                text = stringResource(Res.string.theme_note_label),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.tertiary,
            )
            Text(
                text = stringResource(Res.string.theme_note_title),
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = stringResource(Res.string.theme_note_body),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            Text(
                text = stringResource(Res.string.theme_sample_label),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Composable
private fun ThemeTag(text: String, containerColor: Color, contentColor: Color) {
    Surface(
        color = containerColor,
        contentColor = contentColor,
        shape = MaterialTheme.shapes.small,
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(
                horizontal = AppDimensions.spacingRegular,
                vertical = AppDimensions.spacingMedium,
            ),
            style = MaterialTheme.typography.labelLarge,
        )
    }
}

@Preview(name = "Paper — light", showBackground = true, widthDp = 390, heightDp = 844)
@Composable
private fun AppLightPreview() {
    NotesTheme(darkTheme = false) {
        AppContent(
            showContent = true,
            greeting = "Hello, Android!",
            onToggleContent = {},
        )
    }
}

@Preview(name = "Paper — dark", showBackground = true, widthDp = 390, heightDp = 844)
@Composable
private fun AppDarkPreview() {
    NotesTheme(darkTheme = true) {
        AppContent(
            showContent = true,
            greeting = "Hello, Android!",
            onToggleContent = {},
        )
    }
}

@Preview(name = "Paper — Turkish, large text", locale = "tr", fontScale = 1.5f, widthDp = 390, heightDp = 844)
@Composable
private fun AppTurkishPreview() {
    NotesTheme(darkTheme = false) {
        AppContent(
            showContent = true,
            greeting = "Merhaba! Çç Ğğ İı Öö Şş Üü",
            onToggleContent = {},
        )
    }
}
