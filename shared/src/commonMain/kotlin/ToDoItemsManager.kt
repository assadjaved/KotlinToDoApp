internal expect fun TodoItemsLocalRepository(): ToDoItemsRepository

class ToDoItemsManager(private val repositoryType: ToDoItemsRepositoryType) {

    private val repository: ToDoItemsRepository = when (repositoryType) {
        ToDoItemsRepositoryType.LOCAL -> TodoItemsLocalRepository()
        ToDoItemsRepositoryType.REMOTE -> TodoItemsRemoteRepository()
    }
    suspend fun getToDoItems(): ToDoItemsResult {
        return repository.getToDoItems()
    }

    suspend fun addToDoItem(item: AddToDoItem): ToDoItemResult {
        return repository.addToDoItem(item)
    }

    suspend fun deleteToDoItem(id: Int): ToDoItemResult {
        return repository.deleteToDoItem(id)
    }

    suspend fun updateToDoItem(item: UpdateToDoItem): ToDoItemResult {
        return repository.updateToDoItem(item)
    }
}