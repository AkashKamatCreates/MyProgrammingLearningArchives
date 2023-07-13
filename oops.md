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



