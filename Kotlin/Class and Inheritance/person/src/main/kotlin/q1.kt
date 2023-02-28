fun main(){
    val arrayList = listOf<String>("abc","car","ada","racecar","cool")
    var palindrome = ""
    for (string in arrayList){
        if(string.equals(string.reversed())){
            palindrome= string
            break
        }
    }

    println(palindrome)
}