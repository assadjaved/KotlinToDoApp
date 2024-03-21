import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter

actual fun ToDoItem.createdDateStr(): String {
    val date = NSDate(createdAt.toDouble() / 1000.0)
    val dateFormatter = NSDateFormatter().apply {
        dateFormat = DateFormat.DATE_FORMAT
    }
    return dateFormatter.stringFromDate(date)
}

actual fun ToDoItem.completedDateStr(): String? {
    return completedAt?.let {
        val date = NSDate(it.toDouble() / 1000.0)
        val dateFormatter = NSDateFormatter().apply {
            dateFormat = DateFormat.DATE_FORMAT
        }
        dateFormatter.stringFromDate(date)
    }
}