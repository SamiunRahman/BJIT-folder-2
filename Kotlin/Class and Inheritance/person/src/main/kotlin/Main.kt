fun main(){
    var s = "codeleet"
    var indices= IntArray(8)
    indices[0]= 4
    indices[1]= 5
    indices[2]=6
    indices[3]= 7
    indices[4]= 0
    indices[5]= 2
    indices[6]= 1
    indices[7]= 3

    var newString=s
    for(i in 0..indices.size-1){
        if(indices.contains(i)){
            //println(indices.get(i))
//            println(s[indices.get(i)])
        }
    }
    println(newString)
}