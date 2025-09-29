package files

class Task(
    val id: Int,
    val title: String,
    val description: String,
    val assignedTo: String,
    val status: String,
    val priority: String
) {

    fun copy(id: Int = this.id,
             title: String = this.title,
             description: String = this.description,
             assignedTo: String = this.assignedTo,
             status: String = this.assignedTo,
             priority: String = this.priority) : Task {

        return Task(id, title, description, assignedTo, status, priority)
    }

    fun printTaskInfo() {
        println("Задача #$id: $title")
        println("Описание: $description")
        println("Назначена: $assignedTo")
        println("Статус: $status")
        println("Приоритет: $priority")
        println()
    }
}
