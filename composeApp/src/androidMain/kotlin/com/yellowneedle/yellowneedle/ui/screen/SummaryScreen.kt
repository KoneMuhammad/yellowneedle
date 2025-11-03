package com.yellowneedle.yellowneedle.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yellowneedle.yellowneedle.ui.theme.YellowNeedleTheme

@Preview(showBackground = true, name = "Light")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark")
@Composable
fun SummaryScreenRoute() {
    YellowNeedleTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Card(
                modifier = Modifier
                    .height(123.dp)
                    .width(288.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = -39.dp),
                shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(contentColor = )
            ) {}
            Card() { }
        }
    }
}
