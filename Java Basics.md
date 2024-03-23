# java execution:
hello.java -> (javac compiler) -> hello.class -> (jre->jvm->) -> machine code

classloader: component in jre which loads classes and other such interfaces in jvm for execution. 

stringpool: storage space in heap memory to store all string objects (all objects within "")

class variable and instance variable

# java notes:
- string pool: where all strings variable are referred towards actual string storage (heap).
- if 2 reference are declared with the same string, the stringpool will contain the same string with both of the references pointing to it. 
- packages can be considered as folders which can be recognised by jdk
