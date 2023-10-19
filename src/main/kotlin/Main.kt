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

    fun primesInRange(a:Int?, b:Int?=null):ArrayList<Int>{
        var primes:ArrayList<Int> = ArrayList<Int>()
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




}
