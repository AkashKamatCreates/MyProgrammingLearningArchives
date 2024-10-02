## Java Source File Structure
- naming convention of java source file:
	- in java program we can take any number of classes, no restrictions. 
	- one java program can contain multiple classes. but the .java file should contain any one class's name only. for example, class a, then java program should be a.java
	- any number of classes are there in one java program but at most one public class can be there in one program.  the public class should be the name of the java program file. for example public class A{}, then java file will be A.java
	- only one public class is allowed in one java file. the public class name should be the java file name. if there is no public class, then the class names can be any other name. eg: there are 2 classes class a and b. but none of them are public. then the java file name for them can be c.java without any error. but if i declare class b as public then i have to rename the java file as b.java. if not renamed, compile time error will be thrown.
	- there is no relation betn the class which contain psvm block and name of the java file. only public class name and name of file is related. 
		- if there are 4 non public classes with psvm methods, and if i compiled the code, then 4 separate .class file will be generated even if the 4 classes are written in same .java file. 
		- if there are 4 non public classes with psvm methods named a, b, c, and d. and all these classes are written in xyz.java. when xyz.java is compiled, 4 .class files will be generated namely a,b,c,d.class. but xyz.class wont be generated since there was no class named xyz.java. 
		- Case: in 4 classes a, b, c, d, if d class has no main method(psvm) and i compile xyz.java. there will be 4 class files called a, b, c, d.class. but if i run a, b, c, they will run with no error. when i try to run d.class individually in terminal, it gives error saying the class needs a main method (psvm).
## Import
- if i want to use an arraylist, i have to import on top of program import java.util.ArrayList;. instead of this, i can also write java.util.ArrayList<"integer"> list = new java.util.Arraylist<>(); it will work since i am writing fully qualified name of ArrayList which is "java.util.ArrayList". but still importing is more programmer friendly. 
- 2 types of import, explicit and implicit:
	- explicit import means specifying what exactly you need. eg: import java.util.ArrayList;
	- implicit import means importing all classes inside the package. eg: import java.util.*;
	- **good practice is to use explicit import only. its due to increase readability and naming conflict avoidance. in implicit import, readability decreases.**
- for 2 packages, we are not required to import classes in these package. these packages are java.lang (for classes like String, StringBuilder, exception, thread etc...) and default package (current working directory). for classes and interfaces in these 2 packages, we need not import anything :)
- if we want to use implicit import, we have to go to last package in which the class is there and then we can put star. for example, if we want to use pattern class which is inside regex package, we cannot use import java.* or we cannot use java.util.* we have to use import java.util.regex.* so we have to write the last package in which the class or interface might be present and proceed accordingly with star mark. 
## Package Statement
- a package contains group of related classes and interfaces. 
- package is kind of an encapsulation method. 
- having packages help in solving naming conflict: for example, there is a Date class in sql and there is a Date class in util. when i wish to use date, how will the compiler understand what i want exactly? it will see the import statement and see if i am importing java.util.Date or java.sql.Date and proceed accordingly. 
- packages help in modularity: eg all input/output related operations in java are kept in java.io package. all database related classes are kept in java.sql package. this promotes modularity of a language. 
- while defining our classes, it is highly recommended to make it a part of a package. in real projects, **every class and every interface should be a part of some package. its a good practice and highly recommended.**
- **universally accepted naming convention for packages: use client domain name in reverse for packages. we use internet domain name because it is unique in nature.** 
- in any java source file, atmost one package statement is allowed. this is because if we write 2 package statements, the compiler wont understand which package to put the .class file into. for this reason, atmost one (one or zero) package statements are allowed. if you write 2 or more package statements, compiler will give compile time error. 
- **Compiling with `-d .` to place the `.class` file in the current working directory:**
	- When you use `javac -d . test.java`, the dot (`.`) tells the compiler to create the directory structure based on the package name at the top of the Java file within the current working directory.
	- If your `test.java` has a package declaration like `package com.akashkamat.company.package1;`, then the compiler will create the folder structure `com/akashkamat/company/package1` under the current working directory and place the `test.class` file inside it.
- Compiling with `-d E:` to place the `.class` file in a different directory:
	- If you run `javac -d E: test.java`, the compiler will create the appropriate folder structure under the `E:` directory based on the package declaration.
	- If the package declaration is `package com.akashkamat.company.package1;`, the directory `E:\com\akashkamat\company\package1\` will be created, and the `test.class` file will be placed inside that directory.
	- Make sure that `E:` is a valid drive, and you should also include the correct folder paths if you're specifying a location within a directory on that drive, for example, `E:\somefolder`.
- **in a java file, if you want to include package statement, make sure its the very first line. only after that import is allowed. if you write import statements and then package, compiler will give error**
- **good order of a java file: package statement (at most one) -> import statements (any number of statements) -> class/interface/enum(any number of statements)**
## Class Level Modifiers: public and default
- public modifier: if a class is public, we can access it from anywhere within, outside package, literally anywhere. 
- Default modifier: if class is default (no public keyword written) it is accessible within the same package. 
- abstract modifier: if the class is abstract, object creation is not possible. object creation is also called instantiation. class instantiation of an abstract class is not possible 
- final modifier: if the class is final, child class creation is not possible.
- for top level (outer) classes, which modifiers are applicable? 
	- public
	- default
	- abstract
	- final 
	- strictfp (not important)
- for inner classes:
	- all outer class modifiers: public, default, abstract, final, strictfp
	- private
	- protected
	- static
- when you want to use public class A into class B, you have to import it into B.java. import com.package.A; throughout the project, the public class is accessible, you just have to import it properly. 
- if class is not declared by any modifier, default modifier works. but outside the package, the class is not accessible because the import statement wont be able to find the class since it is of default modifier. 
- when you want to use default class, you  don't need any import statement since if its present in the same package, you can directly call it. also if its outside package, you wont be able to use it.
## Abstract Method
- abstract modifiers are applicable for methods, class. there is no abstract variable. 
- abstract means not complete or partial or not clear. 
- only abstract classes can have abstract methods. you cannot write abstract methods in public or default or other modifiers class. 
- what is abstract method: method which has no implementation, it only has declaration. child classes are responsible to provide implementation. 
- rule to declare abstract method: 
	- abstract methods cannot have body. in java, body or implementation means adding curly braces after brackets. eg: abstract int getdetails(){};. here the curly braces are wrong. correct is "abstract int getdetails();"
	- if you didnt give curly braces to a normal method, compulsory you have to declare the method as abstract. but if you dont declare abstract, you have to provide implementation. if you dont follow, compile error will be thrown. 
	- correct is public abstract void ();
	- public void method(){}; this is not abstract but it has implementation since {} is there so its a valid non abstract method. 
	- also, **it is good convention to write public abstract methodname and not abstract public methodname. public should come before abstract.** 
- even if there is only one abstract method in the class, the class has to be declared abstract. 
## Abstract class
- abstract class means partially implemented class. when a class is not completely implemented or is partially implemented and is not clear about concrete implementation, such classes should be declared abstract class. 
- we cannot create object from abstract class. 
- abstract class can contain 0 number of abstract methods. you can declare a concrete class as abstract if you dont want object creation of the methods in it. This can be useful if you want to create a base class that provides common functionality for subclasses but should never be instantiated on its own. eg: HttpServlet is an abstract class which doesnt have any abstract class. 
- whenever we are extending abstract class, compulsory we should have implementation of all abstract methods in it. if there are 100 abstract methods, we have to implement each one of them in the child class compulsory... otherwise we will get compile time error. 
- we can temporarily extend the abstract class into a child abstract class and implement only one method. this is called as abstract class chaining. if there are 100s of abstract methods in the parent abstract class and i want to implement only one abstract method, then i can create a child abstract class as: public abstract class childabs extends parentabs{ public void m1(){}; //former abstract method now having an implementation} then we can create a concrete class and extend the childabs class where we can create object of the childabs and use the abstract method earlier. 
- we use abstract class and abstract methods for half implementations or not complete implementations. without abstract classes the code will run just fine with direct concrete methods and classes but the concrete class may forget to implement some method. for example, a car class must have airbags method and brake method implemented. this compulsion of implementation can be enforced using abstract methods and classes.
## Method Modifiers: public and default
- member here can be a variable or a method. 
- public: if the class is default but the method is public, you cannot access the method in child class. for example: class a has public method eat. you cannot use the method due to the class not being public. 
- if you want to access the method outside the package, the class and method both should be public. if the method is default and the class is public, you will not be able to access the method outside the package. 
- private: if variable or method is declared as private, its accessible only to the same class. private is also called class level. 
	- private is class level
	- default is package level
	- public is global level 
- "Private methods act as temporary helper methods within a class, providing internal functionality that assists public methods, while remaining hidden from external access."
- **it is highly recommended to keep as many variables private as possible to keep high privacy and good encapsulation.** 
- **recommended modifier for a method is public so that as many class as possible can use the method freely** 
## Method Modifiers: protected
- protected methods and variables are accessible throughout the same package but outside the package only in child classes. 
- protected = default + child classes outside package.
- in the child class outside the package who want to use the parent class protected method, we cannot use parent reference to use the method. we cannot write A a = new A() -> a.m1(), we have to use childcl c = new childcl -> c.m1() where m1 is the protected method in the A parent class. the childcl is the child class which is extending the parent a class. 
- public>protected>default>private
## Interface
- Interface: Any service requirement specification (SRS). another definition: any contract betn client and service provider. definition 3: interface was pure abstract class. 
- for example, for running jsp and servlet applications, compulsory a server should be initiated like tomcat etc. so for servlet's srs document, there is a server compulsion. and that compulsion can be achieved with interface. 
- interface never talks about implementation. every method inside an interface is public and abstract. 
- interface was considered as 100% abstract. but it changed to not 100% because from 1.8 version, default and static methods were allowed in interface. from 1.9 version, private methods are also allowed. so the definition of interface where its 100% abstract class becomes wrong. 
- we use implements keyword to implement an interface. 
- no matter if the methods inside the interface are default or public, their implementation in the concrete class should be public compulsory. 
- in interface even if you dont write public void m1(), and just write void m1(); the m1() method will be considered public. 
- if there are 10 methods in an interface, and you implement only one method in a concrete class, the compiler will throw an error, compelling you to implement all methods, as per the rules of interfaces. To defer the implementation of some methods, you can declare your class as abstract. By doing so, you don't need to implement all interface methods immediately. However, any concrete class that extends the abstract class must implement all the remaining methods from the interface. This process of partial implementation through abstract classes can be referred to as class chaining, but ultimately, the final concrete class is responsible for fulfilling the contract of the interface by implementing all abstract methods. so there is no way to bypass interface rules!!!
## Data Hiding
- data hiding: hiding of data. our internal data should not go out directly. for example password is necessary before loging in online banking. 
- for example: if i want to hide the account balance and when user asks for his account balance, he should go through authentication process to be able to access the account balance number... ` class Account{ private double balance; public double getBalance(){ // here the authentication code of login and pass -> if valid: return balance.} }`
- what is the main purpose of data hiding: *SECURITY*
- **highest recommended modifier while data hiding is *private***
## Abstraction
- abstraction is oops feature.
- abstraction means not complete. for example, he thinks in abstraction, he is not open minded person, etc... not complete implementation is also called abstraction. similar to abstract class. 
- in terms of java, Abstraction: Hiding internal implementation, just highlight set of services that is available. but cannot show the internal implementation due to security reasons. 
- real life example: atms will swipe your card, you will enter the pin and get money. they will happily assist you to that level. but they will never tell you what is the internal algorithm for pin check, what is the auth algo, where is the auth server located etc... sensitive details like this are hidden from the daily user. 
- another pros of abstraction is (enhancement, maintainability, modularity) that the ui screen stays the same but the internal implementation can be improved without the user knowing what happened behind the scene. the behind the scene hiding is due to abstraction. eg: bank atms upgraded their pin auth algo to a superior and harder to crack algo internally. but the customer will have no idea what happened and when they changed the algo due to excellent abstraction use. 
## Encapsulation
- process of grouping related methods and variables together for efficient modularity is called encapsulation. it improves overall quality of code and is easy for readability and updating. 
- every java class is an example of encapsulation. 
- if any component follows data hiding and abstraction, that component is said be encapsulated component. 
- encapsulation = data hiding + abstraction
- for a component to be encapsulated, it should compulsorily have data hiding and abstraction. without these 2, there is no encapsulation. 
- another definition: hiding data behind methods. 
- all advantages of data hiding and abstraction are also applicable to encapsulation. security, enhancement, modularity, maintainability. 
## Tightly Encapsulated Class
- A class is tightly encapsulated if and only if every variable present inside the class is private. each and every variable in the class must be private for it to be called tightly encapsulated class. 
- if class a has private variables only and class b has private variables only. if class b extends class a, still class b is tightly encapsulated. if a non tightly encapsulated class is extended by b, then b becomes non tightly encapsulated since it has access to the non private variable from the parent class. so in conclusion, if you extend a non tightly encapsulated class (parent class), you(child class) will become non tightly encapsulated class. 
## Inheritance
- Inheritance is also known as Is-A relationship
- adv of inheritance: code reusability. 
- inheritance uses extends keyword. 
- inheritance is always from parent to child, not from child to parent. explanation: if parent class has m1 method and child class has m2() method, total methods that parent class has access to is 1 which is m1. but the child class has access to m2() as well as parent's m1() method. this is the parent to child inheritance. (class child extends parent). even if we use parent reference to create child object like this: parent p = new child(), still the parent wont be able to access the m2() method from the child. now lets reverse the scenario, if we write child c = new parent(), we will get compile time error. this is because inheritance is from parent to child, not child to parent. this is why we cannot create parent object from child reference. 
## Importance of Inheritance
- scenario: develop a loan module where i have to handle 3 types of loans (housing, car, personal). 
	- without inheritance: lets say in housing loan class, there are 300 methods. in class personal loan, there are 300 methods, in class car loan, there are 300 methods. so there are in total 900 methods in loan module. lets assume i spent 90 hours to develop these 900 methods. 
	- with inheritance: lets say i found that from those 900 methods above, 250 methods are common like getremainingloanamount etc. i can write a common class to write all 250 common methods and then this common class can act as a parent to home, car, and personal loan class. all the homeloanclass, carclass, personalclass will act as a child class because they extend the common class to access the 250 common methods. this saves so much time of the programmer and increases readability of the code. 
- inheritance is a very powerful tool to increase productivity and reduce overall development time. 
- total java api classes are implemented based on inheritance. super class for all java classes is Object. there are many children of this object class namely string, stringbuffer, number, math, throwable (exception, error), etc... 
- so Object is the root class for all java API 
- in java almost 4300 classes are present for java 9 version. almost all of them use inheritance. 
- inshort, inheritance is used by multiple child classes to access common parent class methods that can be used by multiple child classes instead of each child class implement the repeatitive methods.
## Type of Inheritance
- single inheritance: 
	- class a extended by class b. one child class, one parent class. if one child class extends one parent class, this is called as single inheritance. 
- multiple inheritance:
	- when there are multiple parents but only one child class. this is called multiple inheritance. java doesnot support multiple inheritance (refer diamond problem).
- multi-level inheritance: 
	- when class a extends class b and class b extends class c. this is like chained inheritance. since on diagram it looks like levels that a is able to access methods from b and c, and b is able to access methods from c, it is called multi level inheritance. 
	- beware, multiple inheritance is different from multi-level inheritance. multiple inheritance is where there are multiple parents. in multi-level inheritance, at a time only one child and one parent is there, but the parent can be a child of some other class and the child can be a parent of some other class like a chain or a ladder. 
- hierarchical inheritance: 
	- opposite of multiple inheritance. this type of inheritance has one parent but multiple children. parent class p is extended by class a, b, c, d and so on... 
- hybrid inheritance: 
	- using multiple types of inheritance(listed above) at once.
- java doesnot support: 
	- multiple inheritance
	- hybrid inheritance (only when multiple inheritance is included)
## Multiple Inheritance
- multiple inheritance is not supported in java. 
- why isnt multiple inheritance not supported: assume there are 2 parents p1 and p2 class. they have methods of same name called parentmethod. when class c extends p1 and p2 and wants to use the parentmethod, jvm  will get confused as to whose parentmethod does the child wish to use? does it want to use parentmethod of p1 parent or p2 parent. to avoid this confusion, multiple inheritance is not allowed. this problem of same name of 2 parent is also called diamond access problem or ambiguity problem. 
- solution? implementing interfaces: 
	- When a child class implements two parent interfaces that have the same method name (e.g., `m1()`), it must provide a single implementation of `m1()` in the child class. This implementation will satisfy the method requirements for both interfaces, resolving any ambiguity regarding which method to use. Since the method signatures are identical (same name and parameters), the child class's implementation does not need to distinguish between the two interfaces. Thus, the child class defines `m1()` once, and this implementation will be used for both interfaces, effectively eliminating any potential conflicts.
	- When a class in Java implements multiple interfaces that contain methods with the **same name** (e.g., `m1()`), there is **no ambiguity** about which method is implemented. This is because interfaces **only declare method signatures** without implementation (unless the method is a `default` method). As a result, the child class only needs to **provide one implementation** of `m1()`, which satisfies all interfaces containing that method.
- how python allows multiple inheritance: if there are 2 parents p1 and p2 with same method name m1(), the child class will extend both the parents like this: class child(p1, p2). now when child calls m1() method, the p1's m1() method will be executed since in the brackets, p1 is written first. if p1 doesnot have m1() method, p2's m1() method will be executed. so the priority wise ordering in the brackets is there which beautifully solves multiple inheritance problem. 
## Cyclic Inheritance
- cyclic inheritance is not supported in java. 
- class a extends a / class a extends b which extends a. there is a cycle or a closed loop of inheritance. this is not supported in java or any other language. this is because it is just not required in real world use case. 
- for example, if a extends a, why to extend to yourself, it would be like giving money to yourself from yourself. its unneccessary. another scenario: A extends B and B extends A. if both classes have access to each others method, why not just write both of them as a same class... this is why cyclic inheritance is flawed and not implemented in any language. 
