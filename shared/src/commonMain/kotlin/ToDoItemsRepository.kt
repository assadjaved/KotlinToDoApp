interface ToDoItemsRepository {
    fun getToDoItems(): List<ToDoItem>
    fun addToDoItem(item: ToDoItem)
    fun removeToDoItem(item: ToDoItem)
    fun updateToDoItem(item: ToDoItem)
}