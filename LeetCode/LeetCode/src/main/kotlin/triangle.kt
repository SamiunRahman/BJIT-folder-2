import kotlin.random.Random

fun main(){
    var triangle = mutableListOf<MutableList<Int>>()
    var list = mutableListOf<Int>()
    var sum =0
    var index =0
    var x=0
    var y =0
    var z = 0
    for(i in 0..5){

        for (j in 0..i){
            var num = Random.nextInt(10)
            list.add(num)
        }
        triangle.add(list)
        println(list)
        list = mutableListOf<Int>()

    }
    for(i in triangle){
            println()
    }
    println(sum)

}