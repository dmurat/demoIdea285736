package mypackage

import groovy.transform.CompileStatic

@CompileStatic
class MyGroovyClass {
  static void someMethod() {
    List<String> stringList = ["1234", "3456", "56", "78"]

    String stringFromClosureFound = stringList
//        .findAll({ String aString ->
//            println aString // wrong indent
//          aString.size() > 2
//        })
        .find({ String aString -> aString.contains("12") })

    println stringFromClosureFound

    String stringFromLambdaFound = stringList
        .findAll((String aString) -> {
            println aString // wrong indent
          aString.size() > 2
        })
        .find((String aString) -> { // wrong indent
            println aString // wrong indent
          aString.contains("12")
        })

    println stringFromLambdaFound

    Closure<String> someClosure = { String aString ->
        String aNewString = aString.toUpperCase() // wrong indent
      return aNewString
    }

    println someClosure("lower case string")
  }

  static void main(String[] args) {
    someMethod()
  }
}
