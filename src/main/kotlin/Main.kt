package it.setu.controlflow
import java.lang.Integer.parseInt


fun main(args: Array<String>){
    println("The max number is : " +maxOf(4,6));
    printValue(7);
    printRange(6);
    printExpressionResult(13,"15")
    printInferredType()
    printAnimal("Cat")
    println(describe(5))
    println(describe("Hello"))
    println(describe(100L))
    println(describe(2))
    println(describe("other"))
    forEachStandard()
    forEachIndices()
    forEachWithIndex()
    whileWithList()
    workingWithStrings()
    workingWithTemplates()
    nullSafety()
}
fun maxOf(a: Int, b: Int) =
    if (a > b) {
        print("A is greater than B.  " )
        a
    }else {
        print("B is greater than A.  ")
        b
    }

//when construct
fun printValue(value : Int){
    when(value) {
        1 -> println("The value is One")
        2 -> println("The value is Two")
        in 3..5 -> println("The value is between Three and Five")
        6, 7, 8 -> println("The value is either Six, Seven or Eight")
        else -> {
            println("The value is: $value")
        }
    }
}
fun printRange(value: Int){
    when(value){
        in 1..10 -> println ("Between 1..10");
        !in 10..20 -> println ("Outside 10..20")
    }
}
fun printExpressionResult(numberValue: Int, stringValue: String){
    when (numberValue){
        parseInt(stringValue) -> println("stringValue holds the same number as numberValue")
        else -> {
            println("stringValue is not the same number as numberValue")
        }
    }
}

fun printAnimal(aString: String) = when {
        aString.equals("Dog") -> "A dog"
        aString.equals("Cat") -> "A cat"
        aString.contains("pig") -> "A pig of some sort"
        aString.length == 0 ->"Empty String..no Animal"
        else -> "No identifiable animal"

}
fun printInferredType(){
    val number = 3;
    when(number){
        is Int -> println ("My inferred type is Int")
    }
}
fun describe(obj: Any): String = when(obj) {
        1 -> "One"
        "Hello" -> "A Greeting"
        is Long -> "Long Var"
        !is String -> "Not a String"
        else -> "Unknown"
}

fun forEachStandard(){
    val items = listOf("apple", "banana", "kiwi")
    for (item in items){
        println("Item is: $item")
    }
}
fun forEachIndices(){
    val items = listOf("apple", "banana", "kiwi")
    for (index in items.indices){
        println("Item at " + index + " is: " + items[index])
    }
}
fun forEachWithIndex(){
    val items = listOf("apple", "banana", "kiwi")
    for ((index, value) in items.withIndex()){
        println("The item at $index is: $value")
    }
}

fun whileWithList(){
    val items = listOf("apple", "banana", "kiwi")
    var index = 0
    while (index < items.size){
        println ("Item at index: " + index + " is: " +  items[index])
        index++
    }
}
fun workingWithStrings(){
    val aString = "An escaped string!\n"
    print(aString)

    val einstein = """
        Learn from yesterday
        Live for today
        Hope for tomorrow
        The important thing
        is not to stop questioning.
        (Albert Einstein)
    """.trimIndent()
    println(einstein)

    val franklin = """
          |Tell me and I forget.
          |Teach me and I remember.
          |Involve me and I learn.
          |  (Benjamin Franklin)
    """.trimMargin()
    println(franklin)
}
fun workingWithTemplates(){
    var firstString = "This is a String"
    var secondString = "and this is another String"

    //using simple names
    println ("Simple names: $firstString $secondString")

    //using arbitrary expressions in {}
    println("Expressions (cases): ${firstString.uppercase()} ${secondString.lowercase()}")
    println("Expressions (string size): first string is ${firstString.length}")
    println("Expressions (substring): ${firstString.substring(0,2)}")
}

fun nullSafety() {
    var aString :String? = "abc"
    val size = aString?.length   //now this is a syntax error
    aString = null              //compiles
}

