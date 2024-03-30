enum class ToDoItemsRepositoryType {
    LOCAL,
    REMOTE
}

interface ToDoItemsRepository {
    suspend fun getToDoItems(): ToDoItemsResult
    suspend fun addToDoItem(item: AddToDoItem): ToDoItemResult
    suspend fun deleteToDoItem(id: Int): ToDoItemResult
    suspend fun updateToDoItem(item: UpdateToDoItem): ToDoItemResult
}