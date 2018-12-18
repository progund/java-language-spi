# Java Language SPI - Service Provider Interface
This directory contains source code for our topic page about SPI on [wiki.juneday.se](http://wiki.juneday.se/mediawiki/index.php/Java:Language_-_SPI).

# To compile and run the example
## Compiling the application
`javac org/progund/student/StudentParserManager.java org/progund/student/Student.java org/progund/student/StudentDemo.java`
## Compiling the CSV provider
`cd providers/csv/`

`javac -cp . com/foo/parser/StudentJsonParser.java`

See the wiki for more instructions.