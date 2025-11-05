package com.yellowneedle.yellowneedle.ui.screen

import android.R.attr.translationY
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.yellowneedle.yellowneedle.ui.theme.YellowNeedleTheme
import com.yellowneedle.yellowneedle.ui.viewmodel.SearchViewModel

@Composable
fun SummaryScreenRoute(
    viewmodel: SearchViewModel = hiltViewModel(),
    index: Int
) {
    SummaryLayout(
        text = {viewmodel.uIState.value.results.entries[index].summary?: "Information Unavailable Right Now"}

    )
}

@Composable
fun SummaryLayout(text: () -> String, modifier: Modifier = Modifier) {
    Box() {
        CardWithShadow(
            modifier = Modifier
                .height(719.dp)
                .width(347.dp)
                .align(Alignment.TopCenter)
                .offset(y = 97.dp)
                .graphicsLayer {
                    shadowElevation = 50.dp.toPx()
                    translationY = 61.5f
                    clip = true
                }
                .padding(12.dp)) {
            SearchScreenText(
                modifier = modifier,
                text = text(),
                textStyle = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = Int.MAX_VALUE
            )
        }
    }
}

@Composable
fun CardWithShadow(modifier: Modifier = Modifier, content: @Composable (ColumnScope.() -> Unit)) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(contentColor = Color(0xFFFFFF)),
        modifier = modifier,
        content = content

    )
}


@Preview(showBackground = true, name = "Light", widthDp = 411, heightDp = 915)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark", widthDp = 411, heightDp = 915)
@Composable
fun SummaryScreenPreview() {
    YellowNeedleTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(contentColor = Color(0xFFFFFF)),
                modifier = Modifier
                    .height(719.dp)
                    .width(347.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = 97.dp)
                    .graphicsLayer {
                        shadowElevation = 50.dp.toPx()  // approximate Figma blur
                        translationY = 61.5f           // vertical offset
                        clip = true
                    }
                    .padding(12.dp)
            ) { }
        }
    }
}
