``` java
package org.example;

public class oops {
    public static void main(String[] args){
        Car bmw = new Car(6, "M5 Coup");
//        System.out.println(bmw.carName);
//        String name = "hello";
//        name = "world";
//        System.out.println(name);
//
//        bmw.drive();
//        bmw.stop();

        SUV bigcar = new SUV("newsuvcar", 30, 4);
        bmw.offroading();
        bigcar.offroading();

        PrivateInfo person1 = new PrivateInfo("john", "AZ", 1123484732);
        person1.getAddress();
        person1.getName();
        person1.getPhone();
        person1.setName("doe");
        person1.getName();
    }
}

abstract class ab{
    abstract void abmethod();

//    public abstract void me();

    int a = 12;
    public ab(){}
    public  ab(int a){
        this.a = a;
    }
}
class concrete extends ab implements animal{
    public void sleep(){
        System.out.println("sleeping");
    }
    public void eat(){
        System.out.println("eating");
    }
    public void abmethod(){
        System.out.println("hi from concrete...");
    }
}
interface animal{
    void sleep();
    void eat();

    default void sound(){
        System.out.println("animal sounds");
    }
//    void sound();
}

class PrivateInfo{
    private String name;
    public void setName(String name){
        this.name = name;
    }
    public void getName(){
        System.out.println(name);
    }
    private String address;

    public void getAddress(){
        System.out.println(address);
    }
    public void setAddress(String add){
        this.address = add;
    }
    private int phone;


    public void getPhone(){
        System.out.println(phone);
    }
    public void setPhone(int phone){
        this.phone = phone;
    }

    public PrivateInfo(String name, String address, int phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public PrivateInfo(){}

}
class Car{
    int mileage;
    String carName;
    public Car(){
    }
    public void offroading(){
        System.out.println("sedans donot have good offroading!");
    }
    public Car(int mileage, String carName){
        this.mileage = mileage;
        this.carName = carName;
    }
    public void drive(){
        System.out.println("driving");
    }
    public void stop(){
        System.out.println("break!!");
    }
}
class SUV extends Car{
    int groundclearance;
    public SUV(String carName, int groundclearance, int mileage){
        super(mileage, carName);
        this.groundclearance = groundclearance;
    }
    @Override
    public void offroading(){
        System.out.println("car has good offroading");
    }
}
```

## Class and Object
class is a blueprint
object is the 'object' made out of the blueprint (which is class here)

class is used to create object using a constructor. 
constructor returns nothing, but it isnt a void funciton either. its just a constructor

if there is a constructor to construct objects, there is indeed has to be a destructor to delete unused objects from memory. in cpp, we can also declare destructor.
in java there is no destructor since java has garbage collector which deletes unused objects from memory. 


## Poly-Morphism
2 types: compile time(discussed here) and run time polymorphism
polymorphism means different functions with same name. 

eg: 
public void printinfo(int age){sout(age);}   // let this be function A
public void printinfo(String name){sout(name)'}   // let this be function B

here if in the main function user types printinfo(23) or some other integer value, function A is called. 
if the main funciton user types printinfo('akash') or any other string value, function B will be called. 

function overloading(same named functions in the same class)

Function overloading == compiletime polymorphism == polymorphism in general


## Inheritance
when a class can use properties, or methods or functions from other class, this is known as inheritance. 
inheritance is of 4 types: 
1. Single level inheritance (derived class inherits from base class) 
2. Multi level inheritance (derived class inherits from another derived class which inherits from base class)
3. Hierarchial inheritance (multiple derived class inherits from a single base class directly)
4. Hybrid inheritance (all above mixed together)
5. Multiple inheritance in cpp (in java, multiple inheritance of classes is not provided. Interfaces in java is used to implement multiple inheritance)


## Packages:
package is similar type of codes, methods, functions grouped together for easy readabliity and understanding of code by other coders on the same project. 
in any project, a package can be a project or a different java file. to import package, use import on top of the working code. 

2 types: built-in packages: which comes in built with the programming language
user defined packages: made by the user


## Access Modifier:
public: can be accessed by anyone from this or other package
default(no access modifier specified): can be accessed only by the same package and the package imported into the default declared code. 

![image](https://github.com/AkashKamatCreates/MyProgrammingLearningArchives/assets/100783004/9fe5c77a-726c-4d25-a7f3-2c42d96c900d)
//source of image: https://www.javatpoint.com/access-modifiers

private can be accessed by other function using getters and setters. 


## Encapsulation: 
data and their funciton are combined into a single entity
data hiding can be used to hide data or show data to and from the right person using access modifiers. 

## Abstraction: 
hiding code implementation and behind the scenes working from user and only showing user concerned data is called Abstraction. (hiding complexity form users to avoid complexity)
abstract class is just an empty template. the working classes of a code extends the abstract class to use methods from the abstract class. abstract class will never be directly touched by the user, since it is empty with just function blueprint. 


