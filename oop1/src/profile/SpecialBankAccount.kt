package profile

class SpecialBankAccount(
    balance: Int = 0
) : BankAccount(balance) {

    fun specialWithdraw(amount: Int) {
        super.withdraw(amount)
    }
}