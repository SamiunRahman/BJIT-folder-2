fun main(){
    val numRows = 5
    var pascaleRow = mutableListOf<Int>()
    var pascalePrevious = mutableListOf<Int>()
    var finalRow = mutableListOf<Int>()

    for(i in 0..numRows-1){
        for(j in 0..i){
            if(j==0){
                pascaleRow.add(1)
            }
            else if(j==i){
                pascaleRow.add(1)
            }
            else {
                var v = pascalePrevious[j]+pascalePrevious[j-1]
                pascaleRow.add(v)
            }
        }
        pascalePrevious=pascaleRow
        if(i==numRows-1){
            finalRow = pascaleRow
        }
        pascaleRow = mutableListOf<Int>()
    }

}