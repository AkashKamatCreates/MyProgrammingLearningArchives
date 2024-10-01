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
- 
