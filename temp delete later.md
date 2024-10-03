## Need of Constructors
- constructors are part of oops.
- constructors are defined to perform initialization of an object. 
```//assume i create 500 such more student objects from s3 to s500.  
/**      -------INTRODUCTION TO CONSTRUCTORS NOTES-------  
 * - for every student compulsory a separate copy of name and roll no will be created * - for all 500 students, 500 roll nos and 500 names will be created * - we are just creating student object in the above lines but we are not assigning any name *   or roll numbers to those student objects. * - when we dont provide any name or roll for an object, jvm will create the variables and assign default values for them. * - so here for all 500 student objects, all students have same name as null and all students have same roll no as 0 * - this same thing for all is meaningless. * - we should perform initialization for the object, otherwise the object is not in a position to provide service properly * - to initialize the object, some special character is required. that special character is CONSTRUCTOR :) * - CONSTRUCTOR concept is specially define to initialize an object. * - what is the main purpose of constructor? it is not to create object. main purpose is to perform initialization, not to *   create object. * - new keyword is responsible to create object, not constructors. * */  
public class student {  
    //consider for every student name and roll no is required.  
    String name;  
    int roll;  
  
    //writing constructor:  
    /**   
     - name of the class and name of the constructors must be same  
     - here below in student constructor, we put compulsion on the user that when student object is created,       compulsory there must be name and roll number as arguments. this compulsion avoids the case from above notes where       every student has null name and 0 roll number. */    student(String name, int roll){  
        this.name = name;  
        this.roll = roll;  
    }  
  
    public static void main(String[] args) {  
        // in the below s1 object, "new" keyword is responsible to create object.  
        // when we write new, for every object separate copy of instance variable will be created. so below, name and roll will be        // created. and for every instance variable, jvm will provide default values.        student s1 = new student("akash", 12);  
        /* here when i write "akash" first, it will map to the constructor's name argument and then it will map the current "akash"  
        * as name property of the student class. i said current "akash" because in the context of constructors, this keyword is        * used to provide current context. in the current context in the above line, name is akash for temporary basis in constructor.   
        * when constructor's this.name = name line executes, this is where the "akash" will be mapped to the object's name variable  
        * so then s1.name will return "akash"        * */        student s2 = new student("samyak", 10);  
        // student s3 = new student(); ->> here if i put empty brackets, constructors will say that compulsory put the name and  
        //                                 roll number. if user doesnot provide name and roll number as parameters then        //                                 error will be thrown  
  
    }  
}
```
