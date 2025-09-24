package profile

open class BankAccount(
    private var balance: Int = 0
) {
    fun deposit(amount: Int) {
        this.balance += amount
    }
    protected fun withdraw(amount: Int) {
        if (this.balance >= amount)
            this.balance -= amount
    }

    fun getBalance() : Int {
        return this.balance
    }
}