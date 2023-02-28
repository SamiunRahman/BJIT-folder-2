fun main(){
    val nums = listOf(9,6,4,2,8,3,5,7,1)
    val max = nums.max()
    var missing=0
    for (i in 0..max){
        if(nums.contains(i)){
        }
        else {
            print("Output: ")
            missing = i
        }
    }
    println(missing)
}