fun main() {
    val string = "hello there hello hello blue blue blue blue"
    var words = mutableMapOf<String,Int>()
    var wordsplit = string.split(" ")
    for(word in wordsplit){
        if(words.containsKey(word)){
            words[word]= words[word]!!+1
        }
        else words.put(word,1)
    }

    println(words.maxBy { it.value })
    checkCherecter(string)
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
}

fun checkCherecter(string: String) {
    val charCount = mutableMapOf<Char, Int>()
    for(i in 0..string.length-1){
        val charecter = string[i]
        if(charecter!=' '){
            if(charCount.containsKey(charecter)){
                charCount[charecter]= charCount[charecter]!!+1
            }
            else charCount.put(charecter,1)
        }

    }
    charCount.forEach {
     println("${it.key}: ${it.value} ")
    }
}

fun square(a: Int): Int{
    return a*a
}

fun addition(a: Int, b: Int): Int{
    return a+b
}
fun prinAny(): Unit{ println(" Test ")
}