fun main(args: Array<String>) {
    var chicken: OrderInfo= OrderInfo("Chicken Curry",100.0)
    var biriyani: OrderInfo= OrderInfo("Biriyani",200.0)
    val orders = mutableListOf<OrderInfo>()
    println(orders.isEmpty())
    orders.add(chicken)
    orders.add(biriyani)
    chicken.personUp()
    for(i in 0..orders.size-1){
        println(orders[i].foodInfo())
    }
    for (item in 5 downTo -1) print(item)
}