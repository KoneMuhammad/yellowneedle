import com.yellowneedle.yellowneedle.data.dto.ArxivFeed
import com.yellowneedle.yellowneedle.data.source.ArxivFeedClient
import com.yellowneedle.yellowneedle.data.source.ArxivFeedDataSource
import com.yellowneedle.yellowneedle.data.source.ArxivFeedNetworkDatSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import org.junit.Test
import kotlin.test.assertEquals

/**
class FakeNetworkDatasource : ArxivFeedClient {


    override suspend fun <T> get(
        query: String,
        start: Int,
        maxResults: Int,
        parser: (String) -> T
    ): T {

        return parser("")
    }
}

class ArxivFeedNetworkDataSourceTest {

    @Test
    fun ArxivFeedNetworkDataSource_GetArxivFeed_ResponseSuccess() = runTest {
val fakeNetworkDatasource = FakeNetworkDatasource()

val arxivNetworkDataSource = ArxivFeedNetworkDatSource(fakeNetworkDatasource)
        val result = arxivNetworkDataSource.getArxivFeed(query = "", start = 0,){
string -> arxivFeed
        }
        assertEquals( ,result)

    }

    @Test
    fun ArxivFeedNetworkDataSource_GetArxivFeed_ResponseError() = runTest {
        val fakeNetworkDatasource = FakeNetworkDatasource()
        val arxivNetworkDataSource = ArxivFeedNetworkDatSource()
        val result = arxivNetworkDataSource.getArxivFeed("inputchange"){}
    }
}

 **/