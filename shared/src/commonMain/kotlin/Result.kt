sealed class TodoItemsResult {
    data class Value(val todoItems: List<ToDoItem>) : TodoItemsResult()
    data class Error(val error: Throwable) : TodoItemsResult()
}