# java execution:
hello.java -> (javac compiler) -> hello.class -> (jre->jvm->) -> machine code

classloader: component in jre which loads classes and other such interfaces in jvm for execution. 

stringpool: storage space in heap memory to store all string objects (all objects within "")

class variable and instance variable

# java notes:
- string pool: where all strings variable are referred towards actual string storage (heap).
- if 2 reference are declared with the same string, the stringpool will contain the same string with both of the references pointing to it. 
- packages can be considered as folders which can be recognised by jdk
- wrapper class: the class which extends the primitive type.
  - forexample, int is a primitive type, and Integer is a wrapper class that wraps int value into an object.
  - boxing: int a = 12; Integer b = a; here i called a primitive type to a wrapper class. this is called boxing.
  - in java compilation, the above boxing is automatically converting int variable into an object. this is called autoboxing.
- transient keyword in Java: when you wish to send data over the internet and want to skip a variable, use transient for skipping it. 
- java garbage collector: deletes unused memory from heap, thus saving space and preventing memory leaks. garbage collection is managed by JVM
