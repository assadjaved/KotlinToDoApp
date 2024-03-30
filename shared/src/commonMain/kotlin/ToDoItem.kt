import kotlinx.serialization.Serializable

enum class Priority(val value: Int) {
    HIGH(1),
    MEDIUM(2),
    LOW(3);

    companion object {
        fun fromValue(value: Int): Priority {
            return values().firstOrNull { it.value == value } ?: LOW
        }
    }
}

data class ToDoItem(
    val id: Int,
    val title: String,
    val description: String,
    val priority: Priority,
    val createdAt: Long,
    val completedAt: Long? = null
)

expect fun ToDoItem.createdDateStr(): String

expect fun ToDoItem.completedDateStr(): String?

data class AddToDoItem(
    val title: String,
    val description: String,
    val priority: Priority
)

data class UpdateToDoItem(
    val id: Int,
    val title: String,
    val description: String,
    val priority: Priority,
    val completedAt: Long? = null
)