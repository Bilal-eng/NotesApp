package com.bilal.notesapp.core.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes

internal val NotesShapes = Shapes(
    extraSmall = RoundedCornerShape(AppDimensions.cornerExtraSmall),
    small = RoundedCornerShape(AppDimensions.cornerSmall),
    medium = RoundedCornerShape(AppDimensions.cornerMedium),
    large = RoundedCornerShape(AppDimensions.cornerLarge),
    largeIncreased = RoundedCornerShape(AppDimensions.cornerLargeIncreased),
    extraLarge = RoundedCornerShape(AppDimensions.cornerExtraLarge),
    extraLargeIncreased = RoundedCornerShape(AppDimensions.cornerExtraLargeIncreased),
    extraExtraLarge = RoundedCornerShape(AppDimensions.cornerExtraExtraLarge),
)
