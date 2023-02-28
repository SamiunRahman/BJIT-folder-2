fun main(){

    val a = square(3)
    val sqr: (Int) -> Int = { it*it }
    println(sqr(655))
    val add: (Int,Int) ->Int = { a,b -> a+b }
    println(addition(45,65))
    println(add(5234,1234))
    prinAny()
    val printAny: () -> Unit = {
        println("Test 2")
    }
    printAny()

    val peopleNames = listOf("Fred","Abott", "Ann", "Barbara", "Joe")
    println(peopleNames.sorted())
    println(peopleNames.sortedWith { str1: String, str2: String -> str1.length - str2.length })


}