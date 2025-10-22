package com.yellowneedle.yellowneedle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}

@Composable
fun PdfViewer(pdfFile: String, modifier: Modifier = Modifier) {
    AndroidView(
        factory = { context ->
            PDFView(context, null).apply {
                fromFile(pdfFile)
                    .enableSwipe(true)
                    .swipeHorizontal(false)
                    .enableDoubletap(true)
                    .defaultPage(0)
                    .load()
            }
        },
        modifier = modifier
    )
}