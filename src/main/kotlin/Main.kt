fun main(args: Array<String>) {

    val notVegan: MutableList<String> = mutableListOf(
        "chicken", "fish", "pork", "beef", "milk",
        "egg", "lamb", "crab", "lobster", "veal",
        "goat", "turkey", "duck"
    )

    val vegan: MutableList<String> = mutableListOf(
        "orange", "apple", "pear", "banana", "grape",
        "kiwi", "tomato", "avocado", "celery", "strawberry", "blueberry",
        "raspberry", "blackberry", "lettuce", "cucumber", "cherry",
        "walnut", "almond", "peanut", "lemon", "lime"
    )

    val numOfItems = 20 // approximate number of items to add
    val acceptableProp = 0.3f // acceptable FP probability

    val filter = ForbiddenFilter(numOfItems, acceptableProp)
    println("Size of bit array:${filter.getSize()}")
    println("False positive probability:${filter.getFpProb()}")
    println("Number of hash functions:${filter.getHashCount()}")

    notVegan.forEach {
        filter.addItem(it)
    }

    notVegan.shuffle()
    vegan.shuffle()

    val testFood = mutableListOf<String>()
        testFood.addAll(notVegan.subList(0, 6))
        testFood.addAll(vegan.subList(0, 11))
    testFood.shuffled()

    testFood.forEach { word ->
        if (filter.test(word)) {
            if (vegan.contains(word)) {
                println("You refused to eat 🤮 '$word', but it's a FP! That's ok, we're not taking any risks ⛔️!")
            } else {
                println("You refused to eat 🤮 '$word', and it is probably not vegan, don't eat it 🐖!")
            }
        } else {
            println("'$word' is definitely vegan 🥦!")
        }
    }
}