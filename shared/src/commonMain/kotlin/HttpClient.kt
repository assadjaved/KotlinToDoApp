import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import io.ktor.client.request.*
import io.ktor.client.call.*
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders

class TodoItemsHttpClient {
    private companion object {
        val BASE_URL = "http://localhost:3000"
        val API_VERSION = "v1"
        val TODO_ITEMS_ENDPOINT = "$BASE_URL/${API_VERSION}/todos"
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
            val todoItemModels: List<ToDoItemModel> = httpClient.get(TODO_ITEMS_ENDPOINT).body()
            val toDoItems = todoItemModels.map { it.mapToDoItem() }
            TodoItemsResult.Value(toDoItems)
        } catch (e: Exception) {
            TodoItemsResult.Error(e)
        }
    }

    suspend fun addToDoItem(item: AddToDoItem): ToDoItemResult {
        return try {
            val todoItemModel: ToDoItemModel = httpClient.post(TODO_ITEMS_ENDPOINT) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                setBody(item.mapAddToDoItemModel())
            }.body()
            ToDoItemResult.Value(todoItemModel.mapToDoItem())
        } catch (e: Exception) {
            ToDoItemResult.Error(e)
        }
    }

    suspend fun updateToDoItem(item: ToDoItem): ToDoItemResult {
        return try {
            val todoItemModel: ToDoItemModel = httpClient.put("$TODO_ITEMS_ENDPOINT/${item.id}") {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                setBody(item.mapToDoItemModel())
            }.body()
            ToDoItemResult.Value(todoItemModel.mapToDoItem())
        } catch (e: Exception) {
            ToDoItemResult.Error(e)
        }
    }

    suspend fun deleteToDoItem(id: Int): ToDoItemResult {
        return try {
            val todoItemModel: ToDoItemModel = httpClient.delete("$TODO_ITEMS_ENDPOINT/$id").body()
            ToDoItemResult.Value(todoItemModel.mapToDoItem())
        } catch (e: Exception) {
            ToDoItemResult.Error(e)
        }
    }
}