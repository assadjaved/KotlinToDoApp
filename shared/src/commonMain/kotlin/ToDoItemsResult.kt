sealed class ToDoItemsResult {
    data class Value(val todoItems: List<ToDoItem>) : ToDoItemsResult()
    data class Error(val error: Throwable) : ToDoItemsResult()
}

sealed class ToDoItemResult {
    data class Value(val todoItem: ToDoItem) : ToDoItemResult()
    data class Error(val error: Throwable) : ToDoItemResult()
}
