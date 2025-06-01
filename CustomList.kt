import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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
) {
    if (items.isEmpty()) {
        emptyContent?.invoke()
        return
    }

    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment
    ) {
        header?.let {
            item {
                it()
            }
        }

        items(items) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = itemSpacing / 2, horizontal = 8.dp)
                    .clickable(enabled = onItemClick != null) {
                        onItemClick?.invoke(item)
                    },
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Box(modifier = Modifier.padding(16.dp)) {
                    itemContent(item)
                }
            }
            if (showDividers && items.indexOf(item) < items.size - 1) {
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    thickness = dividerThickness,
                    color = dividerColor
                )
            }
        }

        footer?.let {
            item {
                it()
            }
        }
    }
}
