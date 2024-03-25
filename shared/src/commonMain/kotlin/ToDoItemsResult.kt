sealed class TodoItemsResult {
    data class Value(val todoItems: List<ToDoItem>) : TodoItemsResult()
    data class Error(val error: Throwable) : TodoItemsResult()
}

sealed class UpdateToDoItemResult {
    data class Value(val todoItem: ToDoItem) : UpdateToDoItemResult()
    data class Error(val error: Throwable) : UpdateToDoItemResult()
}

sealed class AddToDoItemResult {
    data class Value(val todoItem: ToDoItem) : AddToDoItemResult()
    data class Error(val error: Throwable) : AddToDoItemResult()
}