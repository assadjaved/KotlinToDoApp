fun ToDoItem.mapToDoItemModel(): ToDoItemModel {
    return ToDoItemModel(
        id = this.id,
        title = this.title,
        description = this.description,
        priority = this.priority.value,
        createdAt = this.createdAt,
        completedAt = this.completedAt
    )
}

fun ToDoItemModel.mapToDoItem(): ToDoItem {
    return ToDoItem(
        id = this.id,
        title = this.title,
        description = this.description,
        priority = Priority.fromValue(this.priority),
        createdAt = this.createdAt,
        completedAt = this.completedAt
    )
}

fun AddToDoItem.mapAddToDoItemModel(): AddToDoItemModel {
    return AddToDoItemModel(
        title = this.title,
        description = this.description,
        priority = this.priority.value
    )
}

fun AddToDoItemModel.mapAddToDoItem(): AddToDoItem {
    return AddToDoItem(
        title = this.title,
        description = this.description,
        priority = Priority.fromValue(this.priority)
    )
}