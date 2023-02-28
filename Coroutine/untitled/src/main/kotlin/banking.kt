interface MobileBanking {
    fun transaction(transactionType: String, amount: Double)
}

class Bkash: MobileBanking {
    override fun transaction(transactionType: String, amount: Double) {
        when (transactionType.toUpperCase()) {
            "PAYMENT" -> println("Paying $amount BDT using Bkash")
            "CASH_OUT" -> println("Cashing out $amount BDT using Bkash")
        }
    }
}

class Rocket: MobileBanking {
    override fun transaction(transactionType: String, amount: Double) {
        when (transactionType.toUpperCase()) {
            "PAYMENT" -> println("Paying $amount BDT using Rocket")
            "CASH_OUT" -> println("Cashing out $amount BDT using Rocket")
        }
    }
}

class MobileBankingFactory {
    companion object {
        fun getMobileBanking(mobileBankingType: String): MobileBanking? {
            when(mobileBankingType.toUpperCase()) {
                "BKASH" -> return Bkash()
                "ROCKET" -> return Rocket()
                else -> return null
            }
        }
    }
}

fun main(){
    val payment = MobileBankingFactory.getMobileBanking("Bkash")
}
