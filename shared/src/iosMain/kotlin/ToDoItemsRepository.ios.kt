import platform.Foundation.NSArray
import platform.Foundation.NSUserDefaults

internal actual fun TodoItemsLocalRepository(): ToDoItemsRepository = ToDoItemsLocalRepository()

internal class ToDoItemsLocalRepository: ToDoItemsRepository {

    override suspend fun getToDoItems(): ToDoItemsResult {
        val userDefaults = NSUserDefaults.standardUserDefaults
        val items = userDefaults.arrayForKey(USER_DEFAULTS_KEY) as? List<String>
        val todoItems = items?.map { it.toToDoItemModel().mapToDoItem() } ?: emptyList()
        return ToDoItemsResult.Value(todoItems)
    }

    override suspend fun addToDoItem(item: AddToDoItem): ToDoItemResult {
        val userDefaults = NSUserDefaults.standardUserDefaults
        when (val result = getToDoItems()) {
            is ToDoItemsResult.Error -> return ToDoItemResult.Error(result.error)
            is ToDoItemsResult.Value -> {
                val todoItems = result.todoItems.toMutableList()
                val newToDoItem = item.mapToDoItem(
                    id = todoItems.sortedBy { it.id }.lastOrNull()?.id?.plus(1) ?: 1,
                    createdAt = epochMillis()
                )
                todoItems.add(newToDoItem)
                userDefaults.setObject(todoItems.map { it.mapToDoItemModel() }.map { it.toJson() } as NSArray, USER_DEFAULTS_KEY)
                return ToDoItemResult.Value(newToDoItem)
            }
        }
    }

    override suspend fun deleteToDoItem(id: Int): ToDoItemResult {
        val userDefaults = NSUserDefaults.standardUserDefaults
        when (val result = getToDoItems()) {
            is ToDoItemsResult.Error -> return ToDoItemResult.Error(result.error)
            is ToDoItemsResult.Value -> {
                val todoItems = result.todoItems.toMutableList()
                val item = todoItems.firstOrNull { it.id == id } ?: return ToDoItemResult.Error(Exception("Item not found"))
                todoItems.removeAll { it.id == id }
                userDefaults.setObject(todoItems.map { it.mapToDoItemModel() }.map { it.toJson() } as NSArray, USER_DEFAULTS_KEY)
                return ToDoItemResult.Value(item)
            }
        }
    }

    override suspend fun updateToDoItem(item: UpdateToDoItem): ToDoItemResult {
        val userDefaults = NSUserDefaults.standardUserDefaults
        when (val result = getToDoItems()) {
            is ToDoItemsResult.Error -> return ToDoItemResult.Error(result.error)
            is ToDoItemsResult.Value -> {
                val todoItems = result.todoItems.toMutableList()
                val index = todoItems.indexOfFirst { it.id == item.id }
                if (index != -1) {
                    val existingTodoItem = todoItems[index]
                    val updatedTodoItem = item.mapToDoItem(existingTodoItem)
                    todoItems[index] = updatedTodoItem
                    userDefaults.setObject(todoItems.map { it.mapToDoItemModel() }.map { it.toJson() } as NSArray, USER_DEFAULTS_KEY)
                    return ToDoItemResult.Value(updatedTodoItem)
                }
                return ToDoItemResult.Error(Exception("Item not found"))
            }
        }
    }

    companion object {
        private const val USER_DEFAULTS_KEY = "ToDoItems"
    }
}