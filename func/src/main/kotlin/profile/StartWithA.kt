package profile

class StartWithA : Condidtion {
    override fun isSuitable(person: Person): Boolean {
        return person.firstName.startsWith("A")
    }
}