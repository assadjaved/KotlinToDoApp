import SwiftUI
import Shared

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
    
    // test code
    private let todoItemsManager = ToDoItemsManager(
        repository: ToDoItemsRepositoryIOS()
    )
    
    private let todoItemsClient = TodoItemsHttpClient()
    
    init() {
        mainTest()
    }
    
    private func mainTest() {
//        todoItemsManager.addToDoItem(
//            item: .init(
//                id: 1,
//                title: "todo1",
//                description: "todo1 desp",
//                isCompleted: false
//            )
//        )
//        
//        todoItemsManager.addToDoItem(
//            item: .init(
//                id: 2,
//                title: "todo2",
//                description: "todo2 desp",
//                isCompleted: false
//            )
//        )
//        
//        let storedTodoItems = todoItemsManager.getToDoItems()
//        print(storedTodoItems)
        
        todoItemsClient.getToDoItems { result, _ in
            if let result = result as? TodoItemsResult.Value {
                print(result.todoItems)
            } else {
                print("error")
            }
        }
    }
}
