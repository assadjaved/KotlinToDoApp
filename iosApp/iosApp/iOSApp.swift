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
    private let todoItemsManager = ToDoItemsManager(repositoryType: .local)
    
    init() {
        mainTest()
    }
    
    private func mainTest() {
        
        Task {
            do {
                
                // create

//                let item1 = try await todoItemsManager.addToDoItem(
//                    item: .init(title: "new task", description: "new task descp", priority: .high)
//                )
//                
//                print(item1)
//                
//                let item2 = try await todoItemsManager.addToDoItem(
//                    item: .init(title: "new new task", description: "new new task descp", priority: .medium)
//                )
//                
//                print(item2)
                
                
                // read

//                let items = try await todoItemsManager.getToDoItems()
//                print(items)
                
                
                // update
                
//                let item1 = try await todoItemsManager.updateToDoItem(
//                    item: .init(id: 100, title: "task 1 title", description: "task 1 descp", priority: .low, completedAt: nil)
//                )
//                
//                print(item1)

//                let item2 = try await todoItemsManager.updateToDoItem(
//                    item: .init(id: 17, title: "task 1 title", description: "task 1 descp", priority: .low, completedAt: nil)
//                )
//                
//                print(item2)
//                
//                let items = try await todoItemsManager.getToDoItems()
//                print(items)
                
                
                // delete
                
//                let item1 = try await todoItemsManager.deleteToDoItem(id: 100)
//                print(item1)
//
//                let item2 = try await todoItemsManager.deleteToDoItem(id: 17)
//                print(item2)
//
//                let item3 = try await todoItemsManager.deleteToDoItem(id: 18)
//                print(item3)
//                
//                let items = try await todoItemsManager.getToDoItems()
//                print(items)
                
                
            } catch let error {
                print(error)
            }
        }
    }
}
