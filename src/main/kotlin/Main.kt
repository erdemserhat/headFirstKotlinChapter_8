fun main(args: Array<String>) {
    println("Hello World!")

    //Chapter 8. nulls and exceptions: Safe and Sound

    /**
     * In default, Kotlin programming language does not allow null value
     * for example below code;
     * So, when you define any value in kotlin it type automatically is defined
     * as non-nullable value.
     */

    //var exString:String=null;

    //Compiler says String value cannot be null

    /**
     *  we can explicitly state that the value we define can be null by
     *  writing '?' at the end of the data type like this;
     */

    var exString:String?=null
    //compiler is okay if we state that the value can be nullable.

    var exChar:Char?=null
    var exInt:Int?=null

    /**
     * When you assign a variable to null value this means that your variable's
     * reference refers nothing.
     */

    /**
     * you can think your variable as remote control
     * and object is a TV, so that's why when you implement polymorphism
     * for example User user = new Student(),In this case,
     * you are only capable of use User data type's functions even though
     * your TV suppors more functionality.
     */

    //you can define nullable type the function's return type like this;

    fun isPrime(candidateNumber:Int):Boolean?{
        if(candidateNumber==0 || candidateNumber==1) return false
        else if(candidateNumber==2) return true
        else {
            val sqrtOfNumber = Math.sqrt(candidateNumber.toDouble()).toInt()
            var flag = true;
            for (i in 2..sqrtOfNumber step 1) {
                if (candidateNumber % i == 0) flag = false

            }
            //isPrime function can return null values in the case of candidate number is negative.
            if (candidateNumber < 0) return null
            return if (flag) true else false
        }
    }

    println("isPrime(-12) returns ${isPrime(-12)} " +
            "because the argument is negative")

    //Additionally, o function's parameter can be nullable

    fun primesInRange(a:Int?, b:Int?=null):ArrayList<Int?>{
        var primes:ArrayList<Int?> = ArrayList()
        if(a!=null && b!=null) {
            for (i in a..b) {
                if(isPrime(i)==true){
                    primes.add(i)
                }

            }
        }else if(b==null && a!=null){
            val c=a+100

            for (i in a..c) {
                if(isPrime(i)==true){
                    primes.add(i)
                }

            }

        }
        return primes

    }

    //If we run the above function with null parameter;

    //we set that if the second parameter is null b will be a+100
    val myPrimes = primesInRange(100,null)

    for ((index, element) in myPrimes.withIndex()){
        println("My ${index+1}. prime is $element")
    }
    //you can just pass the particular arguments to function by setting default values.
    val myPrimes2= primesInRange(a=100)


    //And of course, you can define an array which contains nullable types like this;

    var myNullableArrayList:ArrayList<Int?> = ArrayList()
    myNullableArrayList=primesInRange(500,550)
    myNullableArrayList.add(null)

    for((index,element) in myNullableArrayList.withIndex()){
        println("$index. prime is $element")

    }
    //When you want to define a variable with nullable type you must explicitly define its data type;
    //for example you cannot do like this;

    var x =null
    // what is the data type of x ?? ; we don't know and of course compiler as well
    //so this doesn't make sense.

    //for example, if we check the data type of x whether is a morph of Any Data Type
    //(every class inherits "Any" class without having said that)

    println("x is ${if (x is Any) "" else "NOT"} a kind of 'Any' ")

    //we must explicitly indicate the variable's data type like this;

    data class Person(
            val name:String,
            val surname:String,
            val isMarry:Boolean
            ){

    }

    val ali:Person?=Person("Ali","Erdem",true)

    println("ali is ${if (ali is Any) "" else "NOT"}a 'Any' object")

    //How to access a nullable type's function's and properties;

    //Let's define a nullable variable


    data class Animal(
        val name:String?,
        val color:String,
        val age:Int
    ){
        fun feed(){
            println("$name is eating some food...")
        }
    }

    //this assignation states an Animal object the variable name =annaCat with can be nullable
    val annaCat:Animal?=Animal("Anna","BlackBrown",19)

    //if we try to reach some of its properties or behaviors.

    // println(annaCat.feed()) -> compilet gets upset because annaCat can be null and cause errors
    //Instead,

    //We will control that whether annaCat is null or not;

    if (annaCat != null) {
        //So this approach is safer, now we are sure that annaCat is not null
        annaCat.feed()
    }

    //But there is some another catch

    class myCat{
        var cat:Animal? = Animal("Anna","BlackBrown",19)

        fun meow(){
            //we cannot do this ;
            //cat.feed()
            //but why????
        }
    }

    //Keep things safe with safe calls
    //— Using safe calls.
    //Safe calls let you access functions and properties in a simgle operation without
    //you having to perform a separate null-check.
    //?. is the safe call operator

    annaCat?.feed()
    //means only call feed() function variable refers a real object (not null)
    //this is like saying if(annaCat!=null){annaCat.feed()}
    //this is named as "Safe Call".


    //you can chain safe calls together, for example, like this ;

    data class Car(
        val model:String?,
        val age:Int?
    )

    data class Gallery(
        val car:ArrayList<Car?>
    )

    val myGallery:Gallery?=Gallery(arrayListOf<Car?>(Car("bmw",12),Car("bmw",12)))


    System.err.println(myGallery?.car?.get(1).toString())
    //This chain controls Gallery is null or not and car is null or not
    //So if one of them is null entire expression returns null.
    //Clearly; If

    var car2:Car? = myGallery?.car?.get(1)

    System.err.println("car2==car ${if(car2==myGallery?.car?.get(1)) "true" else "false"}")
    println(car2.toString())
    println(myGallery?.car?.get(1).toString())

    System.err.println("car2===car : ${if(car2===myGallery?.car?.get(1)) "true" else "false"}")


















}

