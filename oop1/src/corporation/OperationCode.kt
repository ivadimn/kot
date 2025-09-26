package corporation

enum class OperationCode(val title: String) {
    EXIT("Выход"),
    REGISTER_NEW_ITEM("Регистрация нового продукта"),
    SHOW_ALL_ITEMS("Показать все продукты"),
    REMOVE_ITEM("Удалить продукт"),
    REGISTER_NEW_EMPLOYEE("Принять нового работника"),
    FIRE_EMPLOYEE("Уволить работника"),
    SHOW_ALL_EMPLOYEES("Показать всех работников"),
    CHANGE_SALARY("Изменить зарплату"),
    CHANGE_AGE("Изменить возраст"),
}