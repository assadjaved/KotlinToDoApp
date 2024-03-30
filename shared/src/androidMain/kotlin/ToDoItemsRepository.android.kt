internal actual fun TodoItemsLocalRepository(): ToDoItemsRepository = ToDoItemsLocalRepository()

class ToDoItemsLocalRepository: ToDoItemsRepository {
    override suspend fun getToDoItems(): ToDoItemsResult {
        //TODO: Implement
        return ToDoItemsResult.Error(Exception("Not implemented"))
    }

    override suspend fun addToDoItem(item: AddToDoItem): ToDoItemResult {
        //TODO: Implement
        return ToDoItemResult.Error(Exception("Not implemented"))
    }

    override suspend fun deleteToDoItem(id: Int): ToDoItemResult {
        //TODO: Implement
        return ToDoItemResult.Error(Exception("Not implemented"))
    }

    override suspend fun updateToDoItem(item: UpdateToDoItem): ToDoItemResult {
        //TODO: Implement
        return ToDoItemResult.Error(Exception("Not implemented"))
    }
}