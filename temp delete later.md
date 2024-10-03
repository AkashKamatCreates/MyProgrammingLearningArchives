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
