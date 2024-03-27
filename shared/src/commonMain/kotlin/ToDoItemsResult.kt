sealed class TodoItemsResult {
    data class Value(val todoItems: List<ToDoItem>) : TodoItemsResult()
    data class Error(val error: Throwable) : TodoItemsResult()
}

sealed class ToDoItemResult {
    data class Value(val todoItem: ToDoItem) : ToDoItemResult()
    data class Error(val error: Throwable) : ToDoItemResult()
}
