// *** ToDoItem <---> ToDoItemModel ***
internal fun ToDoItem.mapToDoItemModel(): ToDoItemModel {
    return ToDoItemModel(
        id = this.id,
        title = this.title,
        description = this.description,
        priority = this.priority.value,
        createdAt = this.createdAt,
        completedAt = this.completedAt
    )
}

internal fun ToDoItemModel.mapToDoItem(): ToDoItem {
    return ToDoItem(
        id = this.id,
        title = this.title,
        description = this.description,
        priority = Priority.fromValue(this.priority),
        createdAt = this.createdAt,
        completedAt = this.completedAt
    )
}

// *** AddToDoItem <---> AddToDoItemModel ***
internal fun AddToDoItem.mapAddToDoItemModel(): AddToDoItemModel {
    return AddToDoItemModel(
        title = this.title,
        description = this.description,
        priority = this.priority.value
    )
}

internal fun AddToDoItemModel.mapAddToDoItem(): AddToDoItem {
    return AddToDoItem(
        title = this.title,
        description = this.description,
        priority = Priority.fromValue(this.priority)
    )
}

// *** UpdateToDoItem <---> UpdateToDoItemModel ***
internal fun UpdateToDoItem.mapUpdateToDoItemModel(): UpdateToDoItemModel {
    return UpdateToDoItemModel(
        id = this.id,
        title = this.title,
        description = this.description,
        priority = this.priority.value,
        completedAt = this.completedAt
    )
}

internal fun UpdateToDoItemModel.mapUpdateToDoItem(): UpdateToDoItem {
    return UpdateToDoItem(
        id = this.id,
        title = this.title,
        description = this.description,
        priority = Priority.fromValue(this.priority),
        completedAt = this.completedAt
    )
}

// *** AddToDoItem <---> ToDoItem ***
internal fun AddToDoItem.mapToDoItem(id: Int, createdAt: Long): ToDoItem {
    return ToDoItem(
        id = id,
        title = this.title,
        description = this.description,
        priority = this.priority,
        createdAt = createdAt
    )
}

// *** UpdateToDoItem <---> ToDoItem ***
internal fun UpdateToDoItem.mapToDoItem(item: ToDoItem): ToDoItem {
    return ToDoItem(
        id = this.id,
        title = this.title,
        description = this.description,
        priority = this.priority,
        createdAt = item.createdAt,
        completedAt = this.completedAt
    )
}