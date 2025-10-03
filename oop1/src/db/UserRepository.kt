package db

class UserRepository : Repository {
    override fun getUsers(): List<UserData?> {
        val list = listOf<UserData?>(
            UserData("Vasia", "va@mail.com", 34),
            UserData("Petr", "pt@mail.com", 28),
            UserData("Anna", "ann@mail.com", 18),
            null,
            UserData("Pavel", "pv@mail.com", 48),
            null,
            null,
            UserData("David", "dv@mail.com", 25),
            UserData(null, null,null),
            UserData(null, "va@mail.com", 34),
            null,
            UserData("John", null, 34),
            UserData("Alex", "va@mail.com", null),
            null
        )
        return list
    }
}