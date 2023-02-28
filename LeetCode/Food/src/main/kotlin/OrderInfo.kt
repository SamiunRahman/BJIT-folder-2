
class OrderInfo(override val foodName: String, override val foodPrice: Double): Food(){

    var persons: Int =1
    fun foodInfo(): String{
        return ("Item Name: "+foodName+" unite price "+foodPrice.toString()+"\n for "+persons.toString()+" persons\n\n")
    }
    fun personUp(): Boolean{
        if (persons>0){
            persons++
            return true
        }
        else {
            return false
        }
    }
    fun personDown(): Boolean{
        if (persons>1){
            persons--
            return true
        }
        else {
            return false
        }    }
    override fun totalCost(): Double {
        return persons.toDouble()*foodPrice
    }
}