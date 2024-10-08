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
## Method Signature
- this concept is important for overloading and overriding (polymorphism)
- method signature is a unique way of identifying methods in java. 
- naming convention of method signatures: method signature contains 
	- name of the method
	- followed by argument types (and the order in which arguments are listed)
- in java, return type of a method is not part of method signature. in other languages return type can also be part of method signature. 
- compiler will use method signature while method calls. while resolving method calls, compiler will use method signatures. 
- for every class compiler will maintain a method table which will contain signatures of all methods in the class. 
- within the same class, 2 methods of same signatures is not allowed. now same signature means same name and same argument. compiler will throw error. no matter if the return type of the methods are different, if the signature(name and arguments) are same, compiler will throw error.
## Overloading Introduction
- major concept in oops
- 2 methods are overloading when both have same name and different argument. for example m1(int age) and m1(String name), here both the methods are totally valid since method signatures here are different in terms of arguments. these 2 methods are said to be overloaded since they have same name but different argument types.
- in c language, method overloading concept is not available since c doesnot implement OOPs
- for **method overloading**, you cannot have multiple methods with the same name and the same parameter type, even if the parameter names are different. The **method signatures** must be unique, which means they must differ by the number of parameters, their types, or their order. so m1(int age), m1(int height) will be invalid since both have same name and argument types even if the argument names are different. 
- why is overloading called compile time polymorphism: method resolution means which method has to be executed. method resolution work is taken care by compiler based on reference type but not based on runtime object. this is why overloading is called compile time polymorphism or static polymorphism or early binding. 
- here runtime object is the dummy and jvm is not responsible for resolution, compiler is responsible. 
## Method Overloading: Case Study -1 (automatic promotion of argument)
- ``` public class over {  
	    public void m1(int a){  
	        System.out.println("int arg");  
	    }  
	    public void m1(float a){  
	        System.out.println("float arg");  
	    }  
	    public static void main(String[] args) {  
	        over o = new over();  
	        o.m1(10);  
	        o.m1(19.7f);  
	        o.m1('a');   // in this case, the compiler will convert the char 'a' into its int value to return int arg as output.
	    }  
	}```
- when you input a char for an int method, the compiler wont give error, instead it will convert the input char into an integer value to make the method work.this automatic conversion of the arguments internally is called automatic promotion. below is the promotion sequence:
	- byte->short->int->long->float->double
		- eg: if the method signature has float and user put in byte as the argument while using the method, the compiler will first convert it into short, and check if the short matches with the method signature. the answer is no so compiler will convert the current short into int, then same procedure convert to long, and then finally to float. compiler checks that the float argument is what is specified in the method signature and thus is completely valid. hence no error is raised by the compiler during this whole process.
		- if user gives a long argument to an int method, compiler will throw error since the flow of automatic promotion cannot go backwards. since int comes before long, compiler cannot change the long to int. compiler can only change from long to float and from float to double. not in reverse. thus we will get compile time error. 
	- char->int->long->float->double
- so summary: in overloading, if there isnt an exact match with the method argument type, compiler wont immediately throw an error, it will try to convert the given argument by user into the argument in the method signature. if the conversion is successful according to the above sequence, there will be no error. 
- the whole process of compiler automatically converting the user argument type and try to adjust to the method signature argument is called automatic promotion. 
## Method Overloading: Case Study -2 (child first, parent later)
- if there are 2 methods called m1(String s){string arg} and m1(object o){object arg}, and user writes m1(null), since string is child of object class, the m1(null) will return String arg as output since child class methods always have more priority than parent class. thats why when we put m1(null), the compiler will say that null is valid for both m1(object) and m1(String) but lets return String arg as answer since it is the child class and Object is the superior parent class. 
- in the above example, the automatic promotion is like this: 
	- null -> string -> object 
	- generally: user input argument -> child class first -> then the parent class if child class not matching.
- although there is automatic promotion, if the user method arguments are matching the method signatures exactly, the exact matching method will get the highest priority no matter who is child and who is parent. the child first parent later logic is only when none of the child and parent's method signature matches the user method argument. 
## Method Overloading: Case Study -3 (method with argument of same inheritance level)
- there are 2 methods: m1(String s){string version} and m1(StringBuffer sb){stringbuffer version}. both methods are clearly overloaded. m1("akash") will return string. but m1(new StringBuffer("akash")), here stringbuffer will get the match since exact match will get the highest priority. hence in the new stringbuilder argument, it will return stringbuffer version.
- case: m1(null). now here user has given null argument to m1. since null can be both String and StringBuffer. here we can say that according to the case study 2 above, the child class should get the priority to execute. but here both String class and StringBuffer class sit on the same level as both extend the Object class. between String and StringBuffer, no one is child and no one is parent. in this case, compiler will raise compile time error. this is because if priority is given to string, then stringbuffer will ask the compiler what did he do wrong to deserve not being selected. if compiler choose stringbuffer, it would be unfair to the String class and vice versa. 
- this is why there will be compile time error thrown when 2 overloading methods with the arguments of same inheritance level are fed with null from user argument. 
## Method Overloading: Case Study -4 (int argument to m1(int i) or m1(int... i)? new concept vs old concept)
- 2 overloading methods m1(int i) and m1(int... i). note: here int... suggest that there can be multiple inputs to the second m1 method. 
- m1() with empty value, second m1(int... i) will get the chance because int... can expect any number of values including 0. but the first m1(int i) method will definitely expect one int value as argument. thats why m1(int... i) will get chance when m1() no arguments are passed. 
- now case: if user puts m1(10); then the first m1(int i) will win because the "int... i" argument was developed later than the int. int came and then much later the int... stuff came into launch in later java versions. whenever there is a method overloading fight betn old and new arguments to the compiler, the old arguments always win. therefore m1(int i) will win. 
- now the knowledge of which concepts are old and which are new are not of importance to the programmer. only general idea is sufficient that old concepts are given priority. 
## Method Overloading: Case Study -5 (same name, same arguments, but different order of arguments)
- 2 overloading methods: m1(int i, float f) and m1(float f, int i). 
- m1(10, 10.5f) here due to exact match, m1(int i, float f) will get used. 
- m1(10.5f, 10) here due to exact match, m1(float f, int i) will get used. 
- m1(10, 10) here compile time error: 
	- the first method can be used by automatic promotion of second 10 to float.
	- the second method can be used by automatic promotion of the first 10 to float. 
	- now since both the methods are applicable, compiler cannot make a fair choice between choosing appropriate method since both of them work. so here compiler will throw compile time error indicating that it cannot choose or be biased towards or unfair towards any one method. 
## Method Overloading: Case Study -6 (parent reference and child object. whose overloading method has more priority?)
- regular case: if the parent class has m1(parent version) and the extended child class has m1(child version), then in the test class, i can create parent p = new parent() and i can use p.m1() which will return parent version. similarly i can create child c = new child() and i can use c.m1() which will return child version. regular stuff....
- special case: now if i use parent reference to create child version: parent p = new child(), and use p.m1() then it will return parent version. below is the reason for this
- In overloading, method resolution is always taken care of by compiler based on reference type. runtime object is never going to play any role. 
- so whoever's reference is used, the compiler will give more priority to them and compiler wont care about whose runtime object is created. thats why reference class's method will be used. 
## Method Overriding
- a child class can access all parent class methods. if a child class wants to use parent class method but wants some changes in the parent method implementation, it can be done with overriding (@overriding annotation). this process is called method overriding 
- method overriding: child class changes implementation of parent class method. 
- the child class method which is implementing the same parent class method in a different way is called overriding method. and the parent class method which is being overridden is called overridden method. 
- method resolution: child c = new child(); c.marry() here child method(overridden marry method from parent) will be used. now parent p = new child(), p.marry(). here compiler will check if marry method is there in parent class. if there is a marry method in parent class, compiler will give green signal that everythings running smoothly or else if there is no marry method in parent, compiler will give compile time error. at runtime, jvm is always going to check what is the runtime object. here in this case when parent p = new child(), runtime object is child. now jvm will check if the child class is overriding the parent's marry method or not. if yes, jvm will give use the overriding marry method from the child class. 
- in overriding, method resolution is taken care by jvm. This mechanism is called **dynamic method dispatch**, where the method to be executed is determined by the **runtime object type** rather than the **reference type**. this is why overriding is called runtime polymorphism or dynamic polymorphism or late binding. 
## Method Overriding Rules Part -1
- in overriding, method names must be same and argument types must be same. so method signatures of parent and child overriding methods must be same. 
- return type: in method overriding return types of methods must be same until 1.4 java version. from 1.5 java version, covariant return types are also allowed. covariant means the child of the return type is allowed. for example, parent method: public object(return type) m1(){return null}, and public object(return type) m1(){return null}. now from 1.5 version java, i can override the m1 parent method as public String(return type) m1(){return null}. this is because String is child of object class in java. so you can use child return type of the parent methods return type too.  
- to compile a java file into an older version, we use javac -source 1.4 P.java
- if parent return type is object, child class return can be object, string, stringbuffer etc... if parent is number return type, child method can return number , Intger, Float, etc. same for if its N, child can be Float, Double, Integer, etc... but it cannot be that parent is String and child return type is Object. this is not allowed. 
- if parent return type is double, but child return type is int, this is NOT allowed since covariant return type concept is applicable only for object types not for primitives (int, float, boolean etc...)
## Method Overriding Rules Part -2
- parent class has private void m1(). here child class cannot override the private method m1 since m1 wont be visible outside the parent class. 
- so overriding is not applicable when parent method is private.
- if parent class has private void m1() and child class has private void m1(), both will be independent and not know about each other. they are on their own and are totally valid. this is not overriding, but just nature of private methods. 
- if parent has final method as public final void m1(), child class cannot override since overridden method is final. final means not changable. this will throw compile time error. 
- parent method to child method overriding scenarios: final to non final - not allowed. non final to final - yes allowed. abstract to non abstract - yes allowed. non abstract to abstract - yes allowed. synchronized to non synchronized and vice versa - yes allowed. native to non native and vice versa - yes allowed. strictfp to non strictfp - yes allowed. 
- from above rules, one conclusion is that final to non final is not allowed to be overridden since final methods are non changable. 
## Method Overriding Rules Part -3
- if parent class p has public void m1() and child class wants to override method m1 as protected void m1(), this is not allowed since we are reducing the scope of access modifier. 
- in conclusion: the child's overriding method can have larger access modifier scope than parent but cannot be less than parent. for example, if parent is public but class is protected, default or private, this is not allowed. if parent is default or protected and child is public, this is perfectly valid. 
- child class method should have same or more scope of access modifier than parent class's method. 
- only take care that parent class method cannot be private and expected to be overridden. private methods scope ends with the class and the child class wont be able to access the private parent method ever. 
## Method Overriding Rules Part -4
- checked exceptions: root of java exception hierarchy is throwable. throwable has exception and error child classes. under exception many children are there like runtime exception, ioexception, ioexception etc... similarly for each children many other exception are there. under error, VMerror is there, outofmemoryerror is there, stackoverflowerror etc are there. now the thing is that runtime exceptions, its children and all error and their child classes come under unchecked exception. except these 2, everything else are checked exception. 
- either child should throw same exception or throw the exception which is child of the exception that parent throws. this is also example of covariant return types.
- cases:
	- case 1: valid
		- p: public void m1() throws exception
		- c: public void m1()
		- if child class throws any checked exception, compulsory parent class must throw the same checked exception that the child just threw. 
		- for unchecked exception, no rule like the above. for unchecked exception, anywhere exception may occur no problem.
	- case 2: invalid, compile time error
		- p: public void m1() 
		- c: public void m1() throws exception
	- case 3: valid, either child should throw same exception or throw the exception which is child of the exception that parent throws. 
		- p: public void m1() throws exception
		- c: public void m1() throws IOException
	- case 4: not valid, since parent should throw same or higher level exception than parent
		- p: public void m1() throws IOexception
		- c: public void m1() throws exception
	- case 5: valid
		- p: public void m1() throws IOexception
		- c: public void m1() throws EOFException, FNFE
	- case 6: not valid, Interrupted Exception (IE) is greater than IOexception.
		- p: public void m1() throws IOexception
		- c: public void m1() throws EOFException, IE
	- case 7: valid since NullPointerExceptions are unchecked, so unchecked exceptions can be anywhere without any rules to parent or child.
		- p: public void m1() throws IOexception
		- c: public void m1() throws EOFException, NPE
	- case 8: valid, here child class throws only unchecked exceptions which has no particular rules. so this case is valid. 
		- p: public void m1() throws IOException
		- c: public void m1() throws AE, NPE
## Method Hiding
- static method means class method, not related to object. instance method means object related method. 
- what if i want to override static method of parent with non static method in the child class. or if i want to override instance method of parent with child class's static method... both of these scenarios are not allowed. this will throw compile time error. it is because one is object related and other is class related. 
	- Method Hiding: if both child class and parent class methods are static then its valid.  if parent class method is static and the child class method is also declared static, this is perfectly valid but it is not overriding, it is called *method hiding* 
- in method hiding, method resolution is taken care by compiler based on reference type.  in the above example, if i do parent p = new child, the parent's method will be used instead of child's method given that both parent and child's methods are static. since both are static, it is not method overriding but it is method hiding. 
- if the methods are non static then it is called overriding and the method resolution is taken care by jvm at runtime. runtime object is considered. 
- diff betn method hiding and overriding: 
	- MH: both parent and child class method should be static
	- O: both parent and child class method should be non static. if either of them is static but not both then error will be thrown.
	- MH: method resolution is taken care of by compiler based on reference type. parent p = new child() here parent method will be used
	- O: method resolution is taken care of by jvm based on runtime object. parent p = new child() here child method will be used since the runtime object is of child even if the reference type is of parent. 
	- MH: method hiding is compiletime or static polymorphism or early binding. 
	- O: overriding is runtime or dynamic polymorphism or late binding. 
## Overriding with respect to var-arg methods
- in parent class: public void m1(int... i) and in child class: public void m1(int i). 
	- if the arguments are different but the method name is same, it is not overriding but it is overloading. overloading happens at compile time with reference type given importance. 
	- so parent p = new child: here parent's method will execute according to overloading rules. 
	- only if both child and parent method are var-arg, then it becomes overriding (method resolution based on runtime object by jvm). otherwise its our regular overloading because of different argument types. 
## Overriding with respect to variables
- instance variable is a non static variable. 
- *OVERRIDING CONCEPT ONLY APPLICABLE FOR METHODS, NOT VARIABLES*
- variable resolution is always taken care of by compiler with reference type in mind.
- defining same variable as the parent class in the child class is called variable hiding or variable shadowing. 
- in parent class: String s = "parent" and in child class: String s = "child". 
	- parent p = new parent() sout(s) will give parent
	- child c = new child() sout(s) will give child
	- parent p = new child() sout(s) will give parent //so all 3 scenario are giving parentchildparent which we will call pcp
- rules are same whether the variable is static or instance.
	- since this is based on reference type, it doesnot matter if one of them is static and other is instance or vice versa. below listed are the scenarios...
	- here i is instance and s is static, p is parent and c is child: 
		- pi and ci : pcp (here pcp means parent, then child, then parent as per the example given above)
		- ps and cs : pcp
		- pi and cs: pcp
		- ps and ci: pcp 
## Overloading vs Overriding
- method names: 
	- ol: method names must be same
	- or: method names must be same
- arugment types: 
	- ol: argument types must be different (atleast order)
	- or: argument types must be same (including order)
- private/final/static methods:
	- ol: all 3 types of methods can be overloaded
	- or: private is not visible so not or, final cannot be changed so no or, for static method, both parent and child methods must be static, only then or.
- return type:
	- ol: no restrictions, return types may or maynot be same
	- or: return types must be same from 1.4 version. from 1.5 version, covariant return types allowed (int... i)
- throws clause:
	- ol: no restrictions for throw clause (exceptions)
	- or: if child class method throws any checked exception, compulsory parent class method should throw the same checked exception of parent
- method resolution: 
	- ol: compiler based on reference type
	- or: jvm based on runtime object
- other names: 
	- ol: compile time polymorphism or static polymorphism or early binding (early because compilation happens before runtime)
	- or: runtime polymorphism or dynamic polymorphism or late binding (since runtime happens later, after compilation)
## Polymorphism Summary
- polymorphism: poly means many, morphs means forms. so many forms.
- one name but multiple forms
- mobile phone is very good example of polymorphism. phone is camera, phone is a telephone, phone is a notepad, phone is a tv, phone is a music player, phone is a communication device, phone is a library etc... 
- programming example: abs(int)/ abs(float) / abs(long) here overloading is there. 
- polymorphism:
	- static/compile time/early binding:
		- overloading
		- method hiding
		- variable hiding
	- dynamic / runtime / late binding: 
		- overriding
## 3 Pillars of OOPs
- encapsulation, Inheritance, polymorphism
- Encapsulation:
	- main purpose of encapsulation: Security (hiding implementations and private etc...)
	- under encapsulation:
		- data hiding
		- abstraction
- Inheritance:
	- main purpose: reusability of code (reusing parent methods etc...)
- Polymorphism: 
	- main purpose: flexibility of reusing method with some customization in child class
- commonly it is known that there are 4 pillars of oops as encapsulation, inheritance, abstraction and polymorphism. abstraction is considered a pillar. in interviews, we say 4 pillars as it is commonly accepted answer. but for internal understanding, we know that there are only 3 pillars with abstraction being a part of encapsulation. 
## 3 checks of Object Type Casting: 
- scenario: Object o = new String("akash"); StringBuilder sb = (StringBuilder) o; valid or not? 
	- upto compilation: since o is object type and we want to convert it into stringbuilder, it is a parent to child relationship which is valid. if there is no relation, compile time error will be thrown. 
- syntax for type casting: A b = (c) d; here we are converting d type object to c type. and then we are assigning c type object with A type reference variable. 
- there are going to be 3 checks, 2 done by compiler and 1 done by jvm: 
	- compile time checking 1: the type of d and c must have some relationship. compiler will check whether the conversion of d type to c type is legal or not. checking 2: if legal, it will check if assigning of c to A type reference variable is legal or not. these are 2 conditions that compiler will check. 
	- run time checking by jvm: in the first example, object o is assigned type of String. now since String is not derived type from StringBuilder(c), neither is string a child of c(stringbuilder), this will return a runtime error because jvm checks for runtime objects. exact exception: RuntimeException: ClassCastException
- Object o = new String("akash"); String s = (String)o; this is completely valid since o is of string type and we are converting o to string which is the same. remember, the o should be either same level or of parent type while type casting. This is a **downcast**, meaning you're casting the reference variable `o` (which is of type `Object`) back to `String`. This works because the actual object referred to by `o` is a `String`. When typecasting in Java, the object being cast must either be of the same type or a subtype of the target class. In this case, since `o` is actually a `String`, the cast is valid.
## Object Type Casting - Case Study
- scenario, consider this hierarchy of classes:
	- Object:
		- base 1: 
			- der 1
			- der 2
		- base 2:
			- der 3
			- der 4
- now the cases: 
	- base2 b = new der4(); this is valid
	- case 1: der4 d = (der4) b; this is valid
	- case 2: base1 b1 = (base1)b; this is not valid since no relation betn base 2 and base 1
	- case 3: base2 b2 = (base2) b; this is valid
	- case 4: Object o = (der3)b; not valid since internally b is der4. since der4 and der3 have no relation, this is not valid at runtime and we will get runtime exception.
	- case 5: base2 b3 = (base1)b; since base2 and base1 are not connected, therefore not valid and will throw compiletime error according to rules in the prior topic.
## Internal Things of Object Type Casting: 
- c extends b and b extends a. when typecast of (b)c then here b is type reference and c is type runtime object. 
- (a)((b)c) here total is a type but internal object is of c type. so in typecasting, reference variable can be changed but not runtime object. 
- String s = new String("akash"); Object o = (Object)s; this is acceptable. 
	- because of this type casting, internally there is not going to be any new object. for the same object, new reference variable will be there. thats it. in heap, same object will be there but in the stack area of jvm, new reference variable will point to the object. so only one object in this case but 2 reference variables. 
	- we can check the above point by doing sout(s== o) which will return true since both point to the same object.
- scenario: parent p has m1 method, child c has m2 method and child c = new child():
	- c.m1() perfectly valid
	- c.m2() perfectly valid
	- ((p)c).m1() since typecasting to parent, happily it can call m1. so valid
	- ((p)c).m2() compile time error since c is casted into parent type. parent doesnot have access to m2 method which belongs to the child. not valid. here internally, parent p = new child() is happening when we type cast it like this. so we just cannot call child's m2 method like p.m2() so this is not valid.

## Need of Constructors
- constructors are part of oops.
- constructors are defined to perform initialization of an object. 
```java 
package org.example;  
  
//assume i create 500 such more student objects from s3 to s500.  
// /**      -------INTRODUCTION TO CONSTRUCTORS NOTES-------  
// * - for every student compulsory a separate copy of name and roll no will be created  
// * - for all 500 students, 500 roll nos and 500 names will be created  
// * - we are just creating student object in the above lines but we are not assigning any name  
// *   or roll numbers to those student objects.  
// * - when we dont provide any name or roll for an object, jvm will create the variables and assign default values for them.  
// * - so here for all 500 student objects, all students have same name as null and all students have same roll no as 0  
// * - this same thing for all is meaningless.  
// * - we should perform initialization for the object, otherwise the object is not in a position to provide service properly  
// * - to initialize the object, some special character is required. that special character is CONSTRUCTOR :)  
// * - CONSTRUCTOR concept is specially define to initialize an object.  
// * - what is the main purpose of constructor? it is not to create object. main purpose is to perform initialization, not to  
// *   create object.  
// * - new keyword is responsible to create object, not constructors.  
// * */  
  
public class student {  
    //consider for every student name and roll no is required.  
    String name;  
    int roll;  
    // writing constructor:  
//     - name of the class and name of the constructors must be same  
//     - here below in student constructor, we put compulsion on the user that when student object is created,  
//       compulsory there must be name and roll number as arguments. this compulsion avoids the case from above notes where  
//       every student has null name and 0 roll number. */  
    student(String name, int roll){  
        this.name = name;  
        this.roll = roll;  
    }  
  
    public static void main(String[] args) {  
        // in the below s1 object, "new" keyword is responsible to create object.  
        // when we write new, for every object separate copy of instance variable will be created. so below, name and roll will be        // created. and for every instance variable, jvm will provide default values.        student s1 = new student("akash", 12);  
//        /* here when i write "akash" first, it will map to the constructor's name argument and then it will map the current "akash"  
//        * as name property of the student class. i said current "akash" because in the context of constructors, this keyword is  
//        * used to provide current context. in the current context in the above line, name is akash for temporary basis in constructor.  
//        * when constructor's this.name = name line executes, this is where the "akash" will be mapped to the object's name variable  
//        * so then s1.name will return "akash"  
//        * */  
        student s2 = new student("samyak", 10);  
        // student s3 = new student(); ->> here if i put empty brackets, constructors will say that compulsory put the name and  
        //                                 roll number. if user doesnot provide name and roll number as parameters then        //                                 error will be thrown  
    }  
}
  
```
- just after new keyword creates object, constructor will be executed. 
- for every new object, constructor will be executed. if there are 100 objects, 100 times constructor will run. 
## Rules of Constructors: 
- constructor name to be same as class name
- return type concept is not applicable for constructors. even void is not allowed. constructors are only there for initialization of reference variables, not to return anything. 
- constructor is not a method and so there no need for return type. 
- if you give void in front of the constructor, compiler wont give any error. instead compiler treats it as a regular method, not as a constructor. 
- access modifier for constructor: only applicable modifiers for constructors are public, default, protected, private. rest are not allowed(eg final, static etc not allowed)
- singleton class: such classes where we can create only one object are called singleton classes. for singleton classes, we have to use private modifiers for constructors. 
## default constructor
- Every class in java, including abstract and all, has a constructor. the constructor is either user defined or a default constructor is given by compiler.
- in a class, if you don't provide any constructor, compiler will provide a default constructor.
- if you are not writing even one constructor, only then compiler will give default constructor. if you write one constructor, then compiler wont give you a default constructor because compiler will think that this person is experienced so no need to give default constructor. 
- there cannot exist default constructors as well as user defined constructors simultaneously in a class. 
- default constructor is always no arg constructor. eg: Student(){};
- access modifier of default constructor is always same as class modifier. but this rule is only applicable for public and default class since outerclass cannot be private.
- default constructor has no code, it only contains only one line, super. eg: Student(){super()}. it is a no-argument call to super class constructor. 
## Default Constructor Case Study
- scenario: u is user code, c is compiler code.
	- if u doesnot have any constructor, c will add default constructor with super() which will call empty or no argument call to super class. 
	- if u class is public, default class by c will be public too. 
	- if u has constructor of void return type, c will generate default constructor since constructors cannot have a return type. since user has written void in front of constructor, compiler will think of it as any other method instead than a constructor. so c will generate a default constructor
	- if u has constructor, c wont create default constructor. 
		- the first line in a constructor should be super() or this. if user dont write anything here in his constructor, compiler will add a super keyword in the code and fix user's default constructor. so compiler is very helpful to correct user's constructors. 
		- no matter if you create 100 other constructors for the class, if you write one empty constructor, the compiler will help you by adding super() to it. if you write 0 constructors, compiler will provide default constructor.
		- if user creates a perfect constructor with no empty constructor, and user writes for each constructor's first line as either this keyword or super keyword, this is perfect case where compiler wont do anything since user has perfectly written all constructor(s). 
## Various Cases of super() and this()
- first line inside the constructor must be this or super. if you dont write anything, compiler will place super there. 
- cases: 
	- case 1: 
		- if we define constructor in which first line is sout("hello") and second line is super(), this will give error since this and super() are only allowed as the first line of constructor. in this case, compile error will be given.
		- if user places first line as super and then sout line as 2nd line, this is valid and no error will be thrown.
	- case 2:
		- constructor in which first line is super(), second line is this(), third line is sout("hi"). here the compiler will throw compile time error. this is because super and this should be in first line. here super is in first line which is correct, but this is in second line. this cannot be in second line. this is why there will be error. 
		- so in conclusion, we can use either this or super as first line but not both. so in a constructor, there is either super or this but never both or else compiler will throw error.
	- case 3: 
		- in method, we cannot use super(). if we use, we will get compile time error. this is because we can use super() and this() only in constructor. outside constructor, no one understands what is super or this. 
## Difference between super(), this() and super, this
- super() and this() are constructor calls to call superclass constructors and current constructor respectively. super and this are keyword in java to refer superclass members and current class members. 
- we can use super() and this() in constructor in first line only. we can use super and this anywhere except static area.
- we can use either super() or this() but not both. super and this keyword we can use any number of times. 
- eg: parent class has String s = "parent" and child class has String s = "child". if i call sout(this.s) in child class, it will output "child". if i put sout(super.s) it will output "parent".
- BEWARE: we can use super and this keyword anywhere except static methods. this is because static means no relation to object. 
## Constructor Overloading
```java   
public class college {  
    String name;  
    int phone;  
    String address;  
    int roll;  
      
    //students who are willing to share only name, phone and roll will be using this constructors  
    college(String name, int phone, int roll){  
        this.name = name;  
        this.phone = phone;  
        this.roll = roll;  
    }  
      
    //students who are willing to share only name will be using this constructors  
    college(String name){  
        this.name = name;  
    }  
    //students who are willing to share only name, phone will be using this constructors  
    college(String name, int phone){  
        this.name = name;  
        this.phone = phone;  
    }  
}
```
- the above code is excellent example of constructor overloading where for each scenario of input, there is a separate constructor. so same name, different arguments which is called overloading in general. 
- there can be as many constructors as a programmer wish for. 
- compiler will match what the user's arguments can use the available constructors and use that particular constructor. 
## Constructor Inheritance and Overriding
- inheritance and overriding concepts are not applicable for constructors. 
- parent constructor is not available to child. 
- no arg constructor is available to parent, but not to the child. 
- abstract class will also have a constructor, it will be used when a child class creates an object. 
- if i can use parent's constructor with super() keyword, why we say that inheritance is not applicable for constructors? it is because when we call super(), the child directly uses the parent's constructor from inside of parent class. but when inheriting methods from parent, the child has his own method which he can edit by overriding or change parameters by overloading. 
- interfaces dont have constructors. if we define, we will get compile time error. this is because since every variable inside interface is public static final, we know that static areas cannot work with constructors. 
## cases for Constructors
- test(){this(10)} and another constructor test(int i){this()}. here both are seemingly calling each other. this is called recursive constructor call. compiler will throw compile time error since constructors are taken care of by compiler very carefully. it will notice recursion and throw compile time error. 
- if the parent class constructor has no default or super() constructor but a user defined constructor like p(int i){super()}, and then if child class extends parent class but the child class has no constructor, the compiler will create a default super constructor for the child class. the problem is that the parent class has constructor of p(int i). this is where child class comes into problem because it doesnt have any variable of integer. it will throw compile time error. to avoid this, **it is highly recommended to manage all cases of constructors in parent class so that child has no problem**
- if parent throws some checked exception, compulsory the child constructor should handle the parent's exception. you cannot use try and catch in the child constructor since first line of the constructor should be either super() or this(). so to handle parent constructor's exceptions, child class constructor should use throws keyword to throws parent exception.

