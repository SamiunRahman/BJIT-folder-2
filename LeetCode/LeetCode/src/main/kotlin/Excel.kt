fun main(){
    var s = "10#11#12"
    var output = ""
    var char = ""

    for(i in 0..s.length){
        if((i+2<s.length)&&s[i+2]=='#'){
            char+=s[i]
            char+=s[i+1]
            var key = 'a'+(char.toInt()-1)
            output+=key
            char=""
        }
        else if( i ==s.length-1 && s[i]!='#'){
            char += s[i]
            var key1 = 'a'+(char.toInt()-1)
            output+=key1
            char=""
        }
        else if((i+1<s.length)&&s[i+1]!='#' && s[i]!='#'){
            println(s[i])

            char += s[i]
            var key1 = 'a'+(char.toInt()-1)
            output+=key1
            char=""
        }

    }
    println(output)
}