import com.yellowneedle.yellowneedle.data.source.KtorClient
import com.yellowneedle.yellowneedle.data.source.KtorHTTPClient
import org.junit.Test

class randoTest: KtorClient{



    override suspend fun <T> get(
        query: String,
        start: Int,
        maxResults: Int,
        parser: (String) -> T
    ): T {
        val xyz = "asdas"
        return parser(xyz)
    }
}
class HTTPClientTest {

    @Test
    fun HTTPClient_NetworkRequest_ResponseSuccess() {


    }
}