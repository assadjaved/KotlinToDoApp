import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import io.ktor.client.request.*
import io.ktor.client.call.*

class TodoItemsHttpClient {
    private companion object {
        val BASE_URL = "http://localhost:3000"
        val API_VERSION = "v1"
        val GET_TODO_ITEMS_ENDPOINT = "$BASE_URL/${API_VERSION}/todos"
    }

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getToDoItems(): TodoItemsResult {
        return try {
            val todoItemModels: List<ToDoItemModel> = httpClient.get(GET_TODO_ITEMS_ENDPOINT).body()
            val toDoItems = todoItemModels.map { it.mapToDoItem() }
            TodoItemsResult.Value(toDoItems)
        } catch (e: Exception) {
            TodoItemsResult.Error(e)
        }
    }
}