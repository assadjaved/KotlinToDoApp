class ToDoItemsManager(private val repository: ToDoItemsRepository): ToDoItemsRepository {
    override fun getToDoItems(): List<ToDoItem> {
        return repository.getToDoItems()
    }

    override fun addToDoItem(item: ToDoItem) {
        repository.addToDoItem(item)
    }

    override fun removeToDoItem(item: ToDoItem) {
        repository.removeToDoItem(item)
    }

    override fun updateToDoItem(item: ToDoItem) {
        repository.updateToDoItem(item)
    }
}