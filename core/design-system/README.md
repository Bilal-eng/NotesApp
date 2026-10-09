# Paper — NotesApp design system

Paper is a custom Material 3 theme: teal for primary actions, sage for secondary
accents, amber for tertiary accents, and warm paper surfaces. Light and dark
schemes follow the device setting through `NotesTheme`.

## Where each decision lives

All Kotlin theme files are under
`src/commonMain/kotlin/com/bilal/notesapp/core/designsystem/theme`.

| File | Responsibility | How screens use it |
| --- | --- | --- |
| `Color.kt` | Complete light/dark semantic color schemes | `MaterialTheme.colorScheme.primary` |
| `Typography.kt` | Bundled font family, 15 baseline text styles and 15 emphasized variants | `MaterialTheme.typography.titleLarge` |
| `Dimensions.kt` | Spacing, padding, maximum content width and corner sizes | `AppDimensions.screenPadding` |
| `Shape.kt` | Eight Material shape roles built from the corner sizes | `MaterialTheme.shapes.extraLarge` |
| `Theme.kt` | Selects the color scheme and supplies typography and shapes | Wrap the app in `NotesTheme` |

Keep raw colors inside the theme. Pair a container color with its corresponding
content color: for example, `primaryContainer` with `onPrimaryContainer`.
These roles adapt together when the theme changes. Text sizes use `sp` so they
respect the user's font-size preference; layout spacing uses `dp`.

`AppDimensions` is a shared object, not a parameter of `MaterialTheme`.
Changing `screenPadding` affects screens that explicitly read that value; it
does not change every Material component's internal padding.

## Palette and alternatives

The colors were generated with Material Color Utilities 0.4.0, the 2021 role
specification, tonal-spot variant, and standard contrast. Custom HCT palettes:

| Palette | Hue | Chroma |
| --- | ---: | ---: |
| Primary | 183.7797 | 36 |
| Secondary | 145 | 18 |
| Tertiary | 75 | 32 |
| Neutral | 85 | 6 |
| Neutral variant | 85 | 10 |

The generated values are checked into `Color.kt`; the app does not depend on
the generator at runtime. A fixed palette keeps this visual identity consistent
across devices. Android wallpaper-based dynamic color is another option, but it
would change this palette per user and require Android-specific handling.

Plus Jakarta Sans supplies Regular (400), Medium (500), SemiBold (600), and
Bold (700). The font supports Turkish characters and ships in the app, so no
font download is needed at runtime. Bundling adds about 0.5 MB before APK
compression; system fonts would avoid that cost but change the chosen look.
The font's license, pinned source revision, and checksums are in
`src/commonMain/composeResources/files/licenses/plus_jakarta_sans`.
The module enables `androidResources` in its Android target so these Compose
resources are included in the APK as well as having generated Kotlin accessors.

## Preview and module boundaries

`sharedUI` uses this module and contains a theme showcase in `App.kt`. Its
previews cover light mode, dark mode, and Turkish with enlarged text. The sample
card demonstrates the theme; it is not a stored note or a notes feature.

In Android Studio, open `App.kt`, switch to Split or Design, and build/refresh
the previews. Run `androidApp` to inspect the theme on a device or emulator.

The current `core:design-system` and `sharedUI` modules target Android. They do
not style the native SwiftUI app; iOS styling remains a separate learning step.

## References

- [Material 3 color system](https://m3.material.io/styles/color/system/overview)
- [Material 3 typography](https://m3.material.io/styles/typography/overview)
- [Material Color Utilities](https://github.com/material-foundation/material-color-utilities)
- [Plus Jakarta Sans](https://github.com/tokotype/PlusJakartaSans)
