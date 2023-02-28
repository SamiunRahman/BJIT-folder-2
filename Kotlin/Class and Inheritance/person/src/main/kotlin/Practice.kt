fun main(){
    val number = listOf(1,2,3,4)
    println("List : $number")
    println("Size: ${number.size}")
    println("First element : ${number[0]}")
    println("Second Element : ${number[1]}")
    println("First: ${number.first()}")
    println("Second: ${number.last()}")
    println("Contains 7 : ${number.contains(7)}")
    println("Contains 4 : ${number.contains(4)}")
    val colors = listOf("Black", "Blue","Green" )
    println("Reversed list: ${colors.reversed()}")
    println("List : $colors")
    println("Sorted list: ${colors.sorted()}")
    val entrees = mutableListOf<String>()
    entrees.add("Noodles")
    println("Entrees : $entrees")
    println("Add spaghetti : ${entrees.add("spaghetti")}")
    println("Entrees : $entrees")
    val moreItems = listOf("ravioli", "lasagna", "fettuccine")
    println("Add all: ${entrees.addAll(moreItems)}")
    println("Entrees : ${entrees.sorted()}")
    println("Remove spagetti: {${entrees.remove("spaghestti")}}")
    println("Entrees: $entrees")
    println("Remove first Element : {${entrees.removeAt(0)}}")
    println("Entrees: $entrees")
    entrees.clear()
    println("Entrees: $entrees")
    println("Empty? : ${entrees.isEmpty()}")
    val guestPerFamily = listOf(2,4,1,3)
    var totalguest = 0
    var index = 0
    while(index < guestPerFamily.size){
        totalguest+= guestPerFamily[index]
        index++
    }
    println("Total Guest Count: $totalguest")
    val names = listOf("Jessica", "Henry", "Alicia", "Jose")
    for(name in names){
        println("$name - Number of Charecters :${name.length}")
    }
    for (item in 'b'..'g'){
        println(item)
    }
    for (item in 1..5){
        println(item)
    }
    for (item in 5 downTo 1){
        println(item)
    }
    val noodles = Noodles()
    val vegetables = Vegetables("Cabbage", "Sprouts", "Onion")
    val vegetables2 = Vegetables()
    val order1 = Order(1)
    order1.addItem(noodles)
    order1.print()

    println()

    val order2 = Order(2)

    order2.addItem(noodles)
    order2.addItem(vegetables)
    order2.print()
println()
    val order3 = Order(3)
    val items = listOf(noodles, vegetables,vegetables2)
    order3.addAll(items)
    order3.print()

}

class Order(val orderNumber: Int){
    private val itemList = mutableListOf<Item>()
    fun addItem(newItem: Item){
        itemList.add(newItem)
    }
    fun addAll(newItems: List<Item>){
        itemList.addAll(newItems)
    }
    fun print(){
        println("Order #${orderNumber}")
        var total = 0
        for(item in itemList){
            println("${item}: $${item.price}")
            total+=item.price
        }
        println("Total : $${total}")
    }

}

open class  Item(val name : String, val price: Int)

class Noodles : Item ("Noodles",10){
    override fun toString(): String {
        return name
    }
}
class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
    override fun toString(): String {
        if(toppings.isEmpty()){
            return name+ " Chefs Choice"
        }
        else
        return name + " " +toppings.joinToString("+ ")
    }
}

