fun main(){
    val sample = "letter offer differ letter differ letter mapper letter offer"
    val words = sample.split(" ")
    var wordsCount = mutableMapOf<String, Int>()
    var countWord = mutableMapOf<Int, String>()

    for(word in words){
        if (wordsCount.containsKey(word)){
            wordsCount[word] = wordsCount[word]!!+1
        }
        else wordsCount.put(word, 1)
    }



    wordsCount.forEach {
        println("${it.key}: ${it.value}")

    }

println()
    println()

    wordsCount.forEach{
        countWord.put(it.value,it.key)
    }
    countWord= countWord.toSortedMap()
    println(countWord)
}