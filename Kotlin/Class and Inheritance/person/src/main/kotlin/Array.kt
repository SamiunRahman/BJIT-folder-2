fun main(){
    var nums = listOf(1,2,3,4)
    val list = mutableListOf<Int>()
    var sum=0

    for (num in nums){
        sum = 0
        for (i in 0..num){
            sum+=i
        }
        list.add(sum)
    }
    println("Running sum is obtained as follows: $list")
}
