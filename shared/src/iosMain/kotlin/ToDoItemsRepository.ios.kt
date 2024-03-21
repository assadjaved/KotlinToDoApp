import platform.Foundation.NSArray
import platform.Foundation.NSUserDefaults

class ToDoItemsRepositoryIOS: ToDoItemsRepository {

    override fun getToDoItems(): List<ToDoItem> {
        val userDefaults = NSUserDefaults.standardUserDefaults
        val items = userDefaults.arrayForKey(USER_DEFAULTS_KEY) as? List<String>
        return items?.map { it.toToDoItemModel().mapToDoItem() } ?: emptyList()
    }

    override fun addToDoItem(item: ToDoItem) {
        val userDefaults = NSUserDefaults.standardUserDefaults
        val items = getToDoItems().toMutableList()
        items.add(item)
        userDefaults.setObject(items.map { it.mapToDoItemModel() }.map { it.toJson() } as NSArray, USER_DEFAULTS_KEY)
    }

    override fun removeToDoItem(item: ToDoItem) {
        val userDefaults = NSUserDefaults.standardUserDefaults
        val items = getToDoItems().toMutableList()
        items.removeAll { it.id == item.id }
        userDefaults.setObject(items.map { it.mapToDoItemModel() }.map { it.toJson() } as NSArray, USER_DEFAULTS_KEY)
    }

    override fun updateToDoItem(item: ToDoItem) {
        val userDefaults = NSUserDefaults.standardUserDefaults
        val items = getToDoItems().toMutableList()
        val index = items.indexOfFirst { it.id == item.id }
        if (index != -1) {
            items[index] = item
            userDefaults.setObject(items.map { it.mapToDoItemModel() }.map { it.toJson() } as NSArray, USER_DEFAULTS_KEY)
        }
    }

    companion object {
        private const val USER_DEFAULTS_KEY = "ToDoItems"
    }
}