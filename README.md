# 📋 CustomList

A highly reusable and customizable generic list component built with **Jetpack Compose**. Designed for flexibility, `CustomList` allows developers to render any type of list with built-in support for headers, footers, item spacing, dividers, and empty states — all while maintaining a clean and declarative API.

---

## ✨ Features

- ✅ **Generic type-safe list rendering** (`List<T>`)
- ✅ **Optional header and footer** composables
- ✅ **Support for custom item spacing**
- ✅ **Built-in empty content slot**
- ✅ **Optional item click handler**
- ✅ **Configurable dividers** (color, thickness)
- ✅ **Custom layout alignment and padding**
- ✅ **Material3-friendly styling**
- ✅ **Fully decoupled and reusable** in any Compose-based project

---

## 🔧 Component Definition

```kotlin
@Composable
fun <T> CustomList(
    items: List<T>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    itemSpacing: Dp = 0.dp,
    showDividers: Boolean = false,
    dividerColor: Color = Color.LightGray,
    dividerThickness: Dp = 1.dp,
    header: (@Composable () -> Unit)? = null,
    footer: (@Composable () -> Unit)? = null,
    emptyContent: (@Composable () -> Unit)? = null,
    onItemClick: ((T) -> Unit)? = null,
    itemContent: @Composable (item: T) -> Unit
)
```
## ⚙️ Parameter Reference

| Parameter           | Type                              | Description                                                  |
|---------------------|-----------------------------------|--------------------------------------------------------------|
| `items`             | `List<T>`                         | The list of data items to display                            |
| `modifier`          | `Modifier`                        | Optional modifier for the outer container                    |
| `contentPadding`    | `PaddingValues`                   | Padding around the `LazyColumn`                              |
| `verticalArrangement` | `Arrangement.Vertical`          | Vertical arrangement between items                           |
| `horizontalAlignment` | `Alignment.Horizontal`          | Horizontal alignment inside the column                       |
| `itemSpacing`       | `Dp`                              | Spacing between list items                                   |
| `showDividers`      | `Boolean`                         | If true, draws a divider below each item                     |
| `dividerColor`      | `Color`                           | Divider color (if enabled)                                   |
| `dividerThickness`  | `Dp`                              | Divider thickness (if enabled)                               |
| `header`            | `@Composable () -> Unit?`         | Optional header shown before the list items                  |
| `footer`            | `@Composable () -> Unit?`         | Optional footer shown after the list items                   |
| `emptyContent`      | `@Composable () -> Unit?`         | Content to show if `items` is empty                          |
| `onItemClick`       | `(T) -> Unit?`                    | Optional callback when an item is clicked                    |
| `itemContent`       | `@Composable (item: T) -> Unit`   | Required composable that defines each list item             |

---

## 🧩 Integration Steps

1. Copy `CustomList.kt` into your Compose project under `ui/components/` or any shared UI layer.
2. Import and call `CustomList` anywhere inside your Compose screens.
3. Provide your own data, item renderer, and optional slots (`header`, `footer`, `emptyContent`).

---

## 🛠️ Requirements

- **Kotlin** 1.8+
- **Jetpack Compose** 1.5+
- Compatible with **Material 3** and custom theming.

---

## 📖 License

**MIT License** — Free to use, modify, and distribute in personal or commercial projects.
