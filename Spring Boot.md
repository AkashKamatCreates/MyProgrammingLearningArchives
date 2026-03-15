# Why SpringBoot?
before spring, there was all the tomcat, web.xml declarations of servlets, and the actual servlets... 
for few servlets its ok but for like 1000 or more servlets, maintaining web.xml became chaotic 

spring/spring framework solved this by introducing IOC (Dependency injection), bean lifecycle management, annotation based configuration, spring mvc, declarative transaction management, loose coupling, AOP, one single servlet caled dispatcher servlet to call all the other controllers, mvc architecture. 

IOC: inversion of control also known as dependency injection is where spring framework manages the bean(object of the needed class) all by itself, so user(programmer) doesnt have to initialize it everytime, it prevents tight coupling between the dependent service and the dependency object. 


now spring framework had few problems or few things that it could improve on... which SPRING BOOT solved: 
- dependency versioning problem 
- introduction of spring boot starter projects which had all dependencies on the compatible level. 
- application setup boilerplate like: 
	- `web.xml`
	- DispatcherServlet registration
	- Component scan config
	- View resolver config
- external server: spring framework used WAR files which only had the java files not the server... so tomcat had to be configured and spun separately. with springboot, we use JAR file which has embedded tomcat server so with one step, we start the server as well as the applicatoin/.
- Autoregistering repetative stuff of spring framework like:
	- dispatcher servlet: spring framework used web.xml for manually registering dispatcher servlet but since people are gonna do it everytime, its kinda mandatory activity to enjoy spring framework. hence springboot took it as an internal activity. 
	- spring MVC etc: we dont need to mention that we are using spring-mvc pattern now. spring will assume we are using it. 

**POM vs application.properties/application.yaml**: POM is from maven/gradle and it has build configuration like what dependencies are in use etc... application.yaml is for run time configurations like env specific values, ports, placeholder username and passwords etc...  there are profiles for application.yaml and they are named as application-dev.yaml or application-test.yaml or application-prod.yaml etc... 

__________________________________________________________________
springboot project setup using start.spring.io 

group: typically companies name in reverse domain name. eg: com.amazon.platform etc 
artifact: Jar/War file name. eg: order-service, user-service etc.
name: Human readable, eg: Order Service... in many projects it simply matches the artifact 
description: short one word explanation of what service/application does, eg: authentication, inventory tracking etc... 
package name: base java package where source code will live. it is conventionally group+artifact. eg: com.amazon.user-service

DTO: Data transfer object...
imagine you want to send or request user data. now the user entity has all stuff including password, credit card info etc... so we dont want to send entire entity fields right? so we use dto... 
dto is a class which specifies what out of the whole entity do we wish to send and receive. 
there are usually 2 dto classes, senderDTO and receiverDTO. these dto then used in service layer to get and send only whats needed so that the sensitive data doesnt get in between transactions. 

# Maven
Before maven, devs had to manualy download jar files from the internet, add them to the project, manage versions themselves and write custom scripts to compile and build them... 
2 important jobs of maven: 
1. Dependency management: in the pom.xml file, we just list down the dependencies that we want and then maven goes to its local cache first and looks if we already have the dependency. if not, maven goes to the internet(maven central) and gets the latest and most compatible dependency for us. so pom.xml is like a shoppig list that we give to our shopper maven. every maven project has one pom.xml file. 
2. build lifecycles: maven does the compile, test, package part of your app... there are many default lifecycles of maven
	1. Validate: checks project is correct 
	2. compile: compiles source code to .class files which are stored in target folder 
	3. test: runs unit tests
	4. package: creates jar/war file of the project which is stored in target folder 
	5. verify: run integration tests 
	6. install: puts JAR in your local 
	7. deploy: pushes to remote repo 
some of the maven lifecycle includes the earlier phases too, for example 
package: validate+compile+test+package
install: validate+compile+test+package+verify+install
**target folder**:
app structure is like:
src, pom.xml, target. 
inside target, we get jar file, classes (.class files), test-classes(compiled test files).
**what do we mean by downloading jar:** before maven, developer would go to spring website, find the download page, download spring.jar manually, drag it into project folder, and tell the ide that "hey i am gonna use this particular jar". maven solved it all by developer just adding stuff he needs  in the pom.xml and maven takes care of all the JAR hell. 

the local cache where maven checks if the dependency is already present and all the spring jar downloading stuff rsides int he /.m2/repository/org. here lot of other folders are present like hibernate, sprngframework jars, core, web jars ,etc... think of it llike your actual dependencyt files are stored here just in case. 

the pom file has 4 parts basically: 
1. who are you (group id, artifactid, version, packaging)
2. parent (starter parent etc)
3. developer dependencies: the dependency that the app actually needs that developers put... its the main part of the shopping list.
4. build plugins: specifies who is taking care of the build stuff. (maven-plugin)

# Annotations

what is annotation and how does java read annotation: 
- its like letting java know what we are doing... its like kind of metadata.
- using Annotation is technically optional in project. but if you arent gonna use annotations, get ready for tedious xml editing for replacing each and every annotations. 
- we use annotation to talk to compiler and tell it the better things that it can do. for example, if we use @Override for an concrete method of an interface, we tell compiler indirectly to check for spelling errors to making sure the method is declared right with the right signature etc... 

annotations for everyday development for springboot: 
- SpringBootApplication
- Controller
- RestController
- RequestMapping
- GetMapping, PostMapping, PutMapping, DeleteMapping
- ResponseBody
- ResponseEntity
- RequestParam
- RequestBody
- PathVariable
- Autowired
- Component
- Service
- Repository
- ComponentScan
- Configuration
- Value and a few more....

bean is java object whose lifecycle is managed by spring container or IOC container. 
bean can be created by two annotations: @Component or @Bean 
@Component when written on top of a class, tells sb to "Create and manage lifecycle for objects of this class". 
most of the time we use component annotation. 
@Bean is always used inside a configuration class. 
so if a class is marked with @Configuration, then we can specify that a method marked with @Bean is used to create or manage the object. sb will still manage the lifecycle of the bean. we use bean when we want some customization to the object(lets say custom constructor which has some value) while creating, otherwise we almost always use component annotation. 
if we use both component and bean(inside te configuration class) then the @bean will get priority.

how springboot finds the beans: using @ComponentScan("package names etc...") this comes below the @SpringBootApplication and tells sb to scan the package and look for @component or @bean or @service etc... 
we should avoid using @ComponenScan if the bean or component or service etc are present inside the package hierarchy of the file marked by @SpringBootApplication since this springbootapplciation already has a componentscan by default... 
only use ComponentScan if the bean etc are present outside of the current package... 

at what time are these beans created: 
1. eagerness: some beans are created when we start the application. eg: beans with singleton scope. 
2. lazy: some beans are created when actually needed. these are created ondemand. beans with  @Lazy annotation are created like such. 
by default all beans are created by eagerness... 

# Lifecycle of a bean: 
1. Application Start 
2. IOC Container started (configuration loaded) 
3. construct bean 
4. inject dependency into constructed bean
5. @PostConstruct
6. use the bean 
7. @PreDestroy
8. Bean destroyed. 
when we start the app, then in teh console logs, we see a line "Initializing Spring embedded WebApplicationContext" this webapplicationcontext is the implementation of spring ioc. 

all of this creation of beans etc is done before port 8080 starts. port 8080 starts after all the configuration and all the bells and whistles... only part left is to use the application. and only lazy beans and such csutom configuration stuff runs after 8080... 

**if ioc is responsible for destroying beans, what does garbage collector do?**: IOC manage bean lifecycle, and gc manages memory. by destroying bean, ioc removes all tis reference, and when bean has no references then the resources are cleaned up (lets say cosing the dbConnection etc). after which gc comes to actually clear up the ram. so to answer: **ioc just drops the bean's reference. the actual clean up is done by GC (free memory, delete the object, managing ram memory etc)** the flow is: ioc destroy bean -> calls @PreDestroy (IOC job) -> Removes its references (IOC Job) -> Object is now orphaned in memory -> GC notices no references exist -> GC frees the ram (GC job0).

# Dependency Injection 
dependency is an object of a class that methods of other class(es) cannot work without. 

@Autowired helps in dependency injection. i looks for a bean of teh required type. if there is a bean, spring will inject it. there are 3 types of dependency injection: 
1. constructor injection 
2. setter injection 
3. field injection 
if bean is not found, spring will create one and inject it. 

#### Before deep dive into dependency injection types, lets understand what dependency injection really is and what problem does springframework and springboot solve...

lets say we have a class called OrderService and another class PaymentService. 
now its obvious that OrderService needs PaymentService so that it can place an order in the warehouse backend with confidence. 

so: 
public class OrderService{
	private PaymentService paymentservice = new PaymentService();
	// other business logic;
}

problem with this is that software codebase is not a static write once and forget thing.... its ever evolving... lets say we wanna ditch paymentservice for a superior paymentservice, if so, then we need to revisit the line 	private PaymentService paymentservice = new PaymentService(); in the orderservice and then use the superior paymentservice methods... this is time consuming and not a good practice since its classic example of tight coupling... 

to tackle this, we have dependency injection where we dont create an object of the class, we just inject the class's interface... 
so the improved codebase looks like this: 
public interface PaymentService(){
	public payment(Account account);
}

and the impl class for the above: 
public interface superiorPaymentService implements PaymentService{
	@Override 
	public payment(Acco0unt account){
		processPayment(account); //the names are for examples, dont focus on details here:)
	}
}

and our Order service class would look like: 
public class OrderService{
	private PaymentService paymentservice; //this line is dependency injection
	// other business logic;
}

spring will automatically take the methods from the implementation class's method to perform business logic wherever the paymentservice is used in the orderservice... 
now we never have to touch the orderservice just for switching the paymentservice provider or other such upgrading stuff... 
**this is the power of dependency injection**

**Question: if two or more implementations are present for an interface which we ahve used for dependency injection in a service class, then which of the implementation will spring pick up?**: by default, spring will throw error "NoUniqueBeanDefinitionException: Expected single matching bean but found 2: < name of the beans>"

so we need to manually specify which one to pick on priority.. this can be done in 3 ways: 
1. @Primary: tells spring "when in doubt, use this one" we declare this on top of the implementation class. 
2. @Qualifier: Tells Spring: "I specifically want this one". for eg: public class OrderService(@Qualifier("SuperiorPaymentService1") PaymentService paymentservice){rest of the logic}
3. @Profile: this is suitable for different implementations in different environments. for example: @Profile("dev") /n public interface superiorPaymentServiceDev implements PaymentService{
	@Override 
	public payment(Acco0unt account){
		processPayment(account); //the names are for examples, dont focus on details here:)
	}} and similar stuff can be done for test, prod etc... 
4. variable name matching: if there are 2 implementations lets say impl1 and impl2, then in our OrderService: 
	public class OrderService{
		private PaymentService impl1; //spring will pick the impl1 for the further operations. 
		// other business logic;
	}
we can use @Autowired here before the line of dependency injection (considering that we have done field injection).

### 1. Field Injection 
Field injection is where you directly declare dependency using the @AutoWired annotation. 
it looks much more clean than constructor or setter injection but there are 2 problems: 
1. cant make it final: field injections canot be made final and so they are of mutable state which is not good. someone can accidentaly reassign it. field injection takes the "Final" safety away.  for example, in the above examples, we have PaymentService paymentservice. what if i do paymentservice=null; i can do it when there is no final involved, and this code will compile just fine... this is the problem... **Question: why cant field injection support final keyword?**: in java, final means the value must be set at construction time. field injection happens after construction. these two ideas simply dont work together. thats why we cannot set a field injection as final. 
2. Spring dependency: @Autowired is a spring propriatery thing... the application has to be of springframework or springboot for it to apply dependency injection. 
### 2. Constructor Injection
constructor injection uses constructors to inject... 
```java 
@Service //this annotation is enough for constructor injection, no need for //@Autowired
public class OrderService{
	private final PaymentSerice paymentService;
	
	//this ensures that whenever orderservice object is created, it must have a paymentservice fed to it. 
	public OrderService(PaymentService paymentService){
		this.paymentService = paymentService;
	}
	
	public String placeOrder(){
		return paymentService.pay();
	}
}
```
in the above code what if there is no paymentservice passed in the constructor of orderservice? springboot will crash (not go to the default constructor) and it will gthrow "Application failed to start", parameter 0 of constructor in orderservice required a bean of type paymentservice that could not be found. 
**this is why constructor injection is better than field injection. field injection wont give any error when a dependency bean is missing... it would keep going and debugging such applicaiton is time consuming... constructor injection stops you at the start itself.**
### 3. Setter Injection
setter injection is where we inject dependencies via setter method... 
```java 
@Service 
public class OrderService{
	private final PaymentSerice paymentService;//common step in all types of injections. 
	
	@Autowired 
	public void setPaymentService(PaymentService paymentService){
		this.paymentService = paymentService;
	}
	
	public String placeOrder(){
		return paymentService.pay();
	}
}
```
here spring will create orderservice usuing default constructor, here paymentservice will be null at this point. 
then spring finds @Autowired on setter. now spring will set a bean for paymentService. 

Compared to constructor: 
constructor injection: object born WITH Dependency
setter injection: object born THEN Dependency

real usecase for setter injection: when dependency is optional. for example @Autowired(required=false) //required false tells spring to not crash the application if it doesnt find the loggingservice bean. 
private LoggingService loggingService; we can use public void setLoggingService(LoggingService loggingService){this.loggingService = loggingService;}

**same as field injection, setter injection cannot be final since access modifiers are set at construction time. setters run after. they simply dont work together.**
setter injection is still better than field injection since with field injection we need mockito to use reflections while testing fake implementations.  but with setter injection and constructor injectoins, our unit test methods are straight forward. 
**Question: who actually calls this setter method?**: spring calls this setter method... this is where IOC steps in to help from "creation to destruction, all bean lifecycle...".

### Comparing all 3 types of dependency injectors:
1. Field injector: spring uses reflection, nobody "calls" it. 
2. setter injector: spring uses the setter method. 
3. constructor injector: spring uses the constructor. 

**Question: if field injection is really so bad, why is it a thing? it shouldnt exist:** field injection was created for simpliicity and rapid development. it was useful when spring was new and people were learning, small internal apps where testing wasnt priority, or rapid prototyping(just get it working fast), or less boilerplate code... lateron the community realized that the tradeoffs weren't worth at a real scale. 

### When to use what type of dependency injection:
- Constructor injection: when dependency is mandatory and class cannot function without it. 
- Setter injection: when dependency is optional and class works fine without it. 
- field injection: building rapid prototype or building a throwaway project(hackathon - no body is writing unit tests in a fast paced env of a hackathon, its all about achieveing the goal anyhow - ends justifying the means)
- Iterating again, **FIELD INJECTION IS NOT TO BE USED IN PRODUCTION CODE!!!!!**

# Bean Scopes
there are 6 types of bean scopes: 
1. Singleton - Default
2. Prototype - New everytime 
3. Request - One per http request
4. Session - one per user session 
5. Application - one per servletcontext
6. websocket - one per websocket session

### Singleton: 
once instance for the entire application. forever. 
on top of class, we can write @scope like: 
@Service
@Scope("singleton")//not required, by default spring will assume singleton scope for a bean 
public class etcetc...

here, App starts -> spring creates One bean of the class -> every class that needs the bean will get teh same object(bean). -> app shuts down, object is destroyed 

When to use: Stateless services. which is most of our services.

### Prototype:
new instance every single time its requested... 
@Scope("prototype")
if 100 classes call it, 100 different beans of that class will be served to the dependent classes. 
IMP: spring creates it but doesnt destroy it. you manage the cleanup by calling @Predestroy
When to use: stateful objects where each caller needs their own fresh instance 

### Request: 
new instance for every HTTP request. bean dies after request ends. 
@Scope("request")
a bit more about what is the meaning of "bean dies after request ends"

user hits a post api on postman 
request starts (bean created here)
spring processes it
hits controller
hits service
hits repo
hits database
builds response 
resopnse sent back to user (bean destroyed here)

//above flow is to be read line by line...

now what if 10 dependent classes hit the api with the same request dependency... 
if 10 api hits are made, that means 10 different http requests, that means 10 different independent beans created... so they are kinda like prototype bean except they die when request ends. 

When to use: storing data specific to one HTTP request like request timing, user context, request metadata etc... 

### Session:
new instance for every user session. dies when session ends. 
@Scope("session")
for example: class ShoppingCart is session scoped, then 
User A: will get his own shopping cart bean 
User B: will get her own shopping cart bean

both shopping cart beans are independent of each other which makes complete sense since shopping cart is a personal object of sort in an ecommerce app. 

When to use: use for above examples, use when user specific data that needs to persist across multiple request like user preference, login state etc... 

### Application:
One instance for the entire web applicaiton, similar to singleton but tied to servletcontext lifecycle. 
@Scope("application")
diff betn singleton and applicaiton scope: 
singleton: one instance per spring applicationcontext
application: one instance per servletContext (web container)
now lemme expaqnd on what applicationcontext and servletcontext really is... 
imagine a microservice architecture with 10 different apps. this means 10 different applicationcontext... think of applicaiotncontext as a singular app. every springboot app has one aplicationcontext. its spring's internal container that holds all beans. 2 applicationcontext never talk to each other and remain isolated. 
we can use application scope and singleton scope in an interchanging way since both act as the same on applicationcontext level. but now imagine a monolith application where multiple springboot applicaitons use the same tomcat... now this is where application scope shines out.. 
the servletcontext concept is where a monolith deployed on a shared tomcat happens. this is generally for legacy enterprise apps. 

when to use: when we are working on a monolith deployed on a shared tomcat and we want systemwide configuration accross all the shared monolith apps. here singleton wont work since 2 spring apps wont talk to each other. use whenever you wanna set globalconfig. 

(dont get confused, in microservice architecture, each of the app has its own tomcat, so applicatoin or singleton act as the same there... )

### WebSocket
new instance for every websocket connection. 
@Scope("websocket")

now 2 users with their own websocket will get their own bean... just like session or request scope. 

When to use: real time apps like chat, live notification, live dashboards.


