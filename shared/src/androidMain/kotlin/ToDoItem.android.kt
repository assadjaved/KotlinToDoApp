actual fun ToDoItem.createdDateStr(): String {
    val date = java.util.Date(createdAt)
    val dateFormatter = java.text.SimpleDateFormat("EE, MMM d, yyyy")
    return dateFormatter.format(date)
}

actual fun ToDoItem.completedDateStr(): String? {
    return completedAt?.let {
        val date = java.util.Date(it)
        val dateFormatter = java.text.SimpleDateFormat("EE, MMM d, yyyy")
        dateFormatter.format(date)
    }
}