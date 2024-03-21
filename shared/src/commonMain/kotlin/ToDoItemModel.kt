import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class ToDoItemModel(
    val id: Int,
    val title: String,
    val description: String,
    val priority: Int,
    @SerialName("created_at")
    val createdAt: Long,
    @SerialName("completed_at")
    val completedAt: Long? = null
)

fun ToDoItemModel.toJson(): String = Json.encodeToString(this)

fun String.toToDoItemModel(): ToDoItemModel = Json.decodeFromString(this)