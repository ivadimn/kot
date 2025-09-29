package files

class Employee(val id: Int, val name: String) {
    val _tasks = mutableListOf<Task>()
    val tasks: List<Task>
        get() = _tasks.toList()


    val _archivedTasks = mutableListOf<Task>() // TODO: Реализовать функциональность архивирования задач
    val archivedTasks: List<Task>
        get() = _archivedTasks.toList()

    fun addTask(task: Task) {
        _tasks.add(task)
        println("Добавлена задача: ${task.title} для сотрудника $name.")
    }

    fun removeTask(taskId: Int) {
        val task = _tasks.find { it.id == taskId }
        if (task != null) {
            _tasks.remove(task)
            println("Задача ${task.title} удалена.")
        } else {
            println("Задача с ID $taskId не найдена.")
        }
    }

    fun updateTaskStatus(taskId: Int, newStatus: String) {
        val task = _tasks.find { it.id == taskId }
        if (task != null) {
            val newTask = task.copy(status = newStatus)
            val index = _tasks.indexOf(task)
            _archivedTasks.add(task)
            _tasks[index] = newTask
            println("Статус задачи ${task.title} изменен на '$newStatus'.")
        } else {
            println("Задача с ID $taskId не найдена.")
        }
    }

    fun changeTaskAssignee(taskId: Int, newAssignee: String) {
        val task = _tasks.find { it.id == taskId }
        if (task != null) {
            val newTask = task.copy(assignedTo = newAssignee)
            val index = _tasks.indexOf(task)
            _archivedTasks.add(task)
            _tasks[index] = newTask
            println("Задача ${task.title} переназначена на $newAssignee.")
        } else {
            println("Задача с ID $taskId не найдена.")
        }
    }

    fun updateTaskPriority(taskId: Int, newPriority: String) {
        val task = _tasks.find { it.id == taskId }
        if (task != null) {
            val newTask = task.copy(priority = newPriority)
            val index = _tasks.indexOf(task)
            _archivedTasks.add(task)
            _tasks[index] = newTask
            println("Приоритет задачи ${task.title} изменен на '$newPriority'.")
        } else {
            println("Задача с ID $taskId не найдена.")
        }
    }

    fun modifyTaskDetails(taskId: Int, newTitle: String, newDescription: String) {
        val task = _tasks.find { it.id == taskId }
        if (task != null) {
            val newTask = task.copy(title = newTitle, description = newDescription)
            val index = _tasks.indexOf(task)
            _archivedTasks.add(task)
            _tasks[index] = newTask
            println("Детали задачи ${task.id} обновлены.")
        } else {
            println("Задача с ID $taskId не найдена.")
        }
    }

    fun printTasks() {
        println("Список задач для сотрудника $name:")
        _tasks.forEach { it.printTaskInfo() }
    }
}