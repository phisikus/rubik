# rubik

This project provides simple representation of Rubik's Cube in Scala. It supports transformations/rotations and allows to display the end result (thanks to usage of JMonkeyEngine). You can create cubes of different sizes, serialize and deserialize them (chill/Kryo library). The code is mostly FP and contains unit tests for the more complicated functions. 

The goal of this toy project is to provide a model for future experiments with different algorithms.

![Image of Rubik's Cube](http://phisikus.platinum.linux.pl/img/cube.png)


## Usage

You can run tests using Maven:

	mvn clean test
  
... or build a jar package with dependencies...

	mvn package
  
...and run it using:
   
     java -jar ./cube-viewer/target/cube-viewer-*-jar-with-dependencies.jar
	
	
## License
Check LICENSE file.



