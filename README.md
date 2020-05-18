## Homework 1 - Design Pattern Code Generator (DePaCoG)

### Overview

This application allows the users to create java source files for a design pattern. It makes use of  [Yet Another Markup Language](https://yaml.org/) and [Apache FreeMarker](https://freemarker.apache.org/docs/index.html). The application itself is built using the **Factory** **Method**, **Template** and **Facade** design patterns. 

"In [software engineering](https://en.wikipedia.org/wiki/Software_engineering), a **software design pattern** is a general, [reusable](https://en.wikipedia.org/wiki/Reusability) solution to a commonly occurring problem within a given context in [software design](https://en.wikipedia.org/wiki/Software_design). It is not a finished design that can be transformed directly into [source](https://en.wikipedia.org/wiki/Source_code) or [machine code](https://en.wikipedia.org/wiki/Machine_code). Rather, it is a description or template for how to solve a problem that can be used in many different situations."

### Instructions

#### Prerequisites

- [Java 9](https://docs.oracle.com/javase/9/) or above
- [Gradle Build Tool](https://gradle.org/)

#### Running the application

1. Clone or download this repository onto your system

2. Open the Command Line Interface and browse to the project directory

3. Build and run the project with the following commands

   ```
   gradle clean build
   ```

   ```
   gradle run
   ```

### Application Design

![](https://bitbucket.org/rahulromilkeswani/rahul_romilkeswani_hw1/raw/d552acf460d943ca49eeaeb02f97c8f0d96f2736/Screenshots/image-20200227150625955.png)

#### Modelling Explanation

1. **Factory Method** : "Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses."

   The InputReaderFactory behaves as a factory to create the InputReader object for the invoked pattern type. Since all the concrete InputReader classes have similar behaviour, it the factory provides an interface to creating the object

2. **Template** : "Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure."

   The InputReader class behaves as a template class which which invokes the deleteFiles() and getInput() methods. 
   The getInput() method is overridden by concrete classes, also it was necessary to avoid the invoking class to access the deleteFiles() method.

3. **Facade** : "Provide an unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use."

   The GeneratorFacade class behaves as a facade class to interact with the ClassGenerator and the YamlGenerator. The InputReader classes are the clients for this facade. 

#### External Libraries Used

1.  [SLF4J](http://www.slf4j.org/index.html) and [LogBack](http://logback.qos.ch/) : For logging

2.  [Lightbender Typesafe Config](https://github.com/lightbend/config) : For configuration library management

3.  [FreeMarker](https://freemarker.apache.org/) : To write templates as .ftl and then realizing them into source files

4.  [SnakeYaml](https://mvnrepository.com/artifact/org.yaml/snakeyaml) : To parse .yaml files. 

5. [Commons IO ](https://commons.apache.org/proper/commons-io/) : To clear output directory at every run.

6. [jUnit](https://junit.org/junit4/) : Testing framework

   

### Output and Simulation

#### Working 

1. The user selects the design pattern number from the menu. 

2. Based on the pattern, the InputReader object is created and it invokes the template method

3.  The output directory is cleared every time when a run starts. This is to avoid issues which might occur when having multiple runs. It might garble up the patterns. 

4. The getInput() method of the reader is called. 

5. It gets the necessary inputs from the user and maps these inputs into a .yaml file. 

6. Once the .yaml file is created, this file is again read and mapped against the appropriate .ftl (template) file to create the source java file

   

#### Sample Run

**NOTE** :  

#### **The source files are generated in the 'src/main/java/Output' directory of the project.** 

#### **Input for methods are seperated by a space.  [eg: "methodName methodType"]**

#### **Menu**

![](https://bitbucket.org/rahulromilkeswani/rahul_romilkeswani_hw1/raw/211c748b74090eee6ea0fc94d54688a089e24bc5/Screenshots/menu.png)

##### Getting Inputs for the pattern

![](https://bitbucket.org/rahulromilkeswani/rahul_romilkeswani_hw1/raw/211c748b74090eee6ea0fc94d54688a089e24bc5/Screenshots/Strategy/Screen%20Shot%202020-02-26%20at%2022.58.51.png)

##### **Generated Source Files**

![](https://bitbucket.org/rahulromilkeswani/rahul_romilkeswani_hw1/raw/211c748b74090eee6ea0fc94d54688a089e24bc5/Screenshots/Strategy/Screen%20Shot%202020-02-26%20at%2022.59.18.png)

![](https://bitbucket.org/rahulromilkeswani/rahul_romilkeswani_hw1/raw/211c748b74090eee6ea0fc94d54688a089e24bc5/Screenshots/Strategy/Screen%20Shot%202020-02-26%20at%2022.59.37.png)

![](https://bitbucket.org/rahulromilkeswani/rahul_romilkeswani_hw1/raw/211c748b74090eee6ea0fc94d54688a089e24bc5/Screenshots/Strategy/Screen%20Shot%202020-02-26%20at%2022.59.58.png)

![](https://bitbucket.org/rahulromilkeswani/rahul_romilkeswani_hw1/raw/211c748b74090eee6ea0fc94d54688a089e24bc5/Screenshots/Strategy/Screen%20Shot%202020-02-26%20at%2023.00.15.png)

Screenshots of runs for all patterns can be found in the Screenshots directory. 

### Limitations

1. The application doesn't handle errors that might occur when keywords are given as inputs. For example, the class name itself being a keyword. 
2. Returns null at the end of the generated method. So giving VOID as the return type when prompted would throw errors in the file. 
3. If a file has been wrongly created, user would have to manually delete the files before the next run. 
4. Output directory is already set. So user would have to copy the source files to the desired path. 
5. Duplicate class names aren't checked for. Results in overwriting. 