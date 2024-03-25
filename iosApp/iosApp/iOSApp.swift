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
//                todoItemsManager.addToDoItem(
//                    item: .init(
//                        id: 1,
//                        title: "todo1",
//                        description: "todo1 desp",
//                        isCompleted: false
//                    )
//                )
//        
//                todoItemsManager.addToDoItem(
//                    item: .init(
//                        id: 2,
//                        title: "todo2",
//                        description: "todo2 desp",
//                        isCompleted: false
//                    )
//                )
//        
//                let storedTodoItems = todoItemsManager.getToDoItems()
//                print(storedTodoItems)
        
//        Task {
//            do {
//                let addResult = try await todoItemsClient.addToDoItem(
//                    item: .init(
//                        title: "Call mom",
//                        description: "Ask how mom's doing and update her about your life",
//                        priority: .high
//                    )
//                )
//                print(addResult)
//                
//                let updateResult = try await todoItemsClient.updateToDoItem(
//                    item: .init(
//                        id: 6,
//                        title: "Do Exercise ;)",
//                        description: "Go for a 30-minute run on the track ",
//                        priority: .high,
//                        createdAt: 0,
//                        completedAt: nil
//                    )
//                )
//                print(updateResult)
//                
//                let getResult = try await todoItemsClient.getToDoItems()
//                switch onEnum(of: getResult) {
//                case .value(let items):
//                    print(items)
//                case .error(let error):
//                    print(error )
//                }
//            } catch let error {
//                print(error)
//            }
//        }
    }
}
