import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
internal data class ToDoItemModel(
    val id: Int,
    val title: String,
    val description: String,
    val priority: Int,
    @SerialName("created_at")
    val createdAt: Long,
    @SerialName("completed_at")
    val completedAt: Long? = null
)

internal fun ToDoItemModel.toJson(): String = Json.encodeToString(this)

internal fun String.toToDoItemModel(): ToDoItemModel = Json.decodeFromString(this)

@Serializable
internal data class AddToDoItemModel(
    val title: String,
    val description: String,
    val priority: Int
)

@Serializable
internal data class UpdateToDoItemModel(
    val id: Int,
    val title: String,
    val description: String,
    val priority: Int,
    val completedAt: Long? = null
)