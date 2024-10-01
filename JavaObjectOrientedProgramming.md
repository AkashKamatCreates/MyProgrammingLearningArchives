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
