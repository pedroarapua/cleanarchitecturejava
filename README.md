# cleanarchitecturejava

## Application Structure

<img src="docs/images/clean-architecture-diagram-1.png" alt="clean-architecture-diagram-1.png" width="700">
<img src="docs/images/clean-architecture-diagram-2.png" alt="clean-architecture-diagram-2.png" width="700">

##### Core: Entities
* Represent your domain object
* Apply only logic that is applicable in general to the whole entity (e.g. validating the format of an hostname)
* Plain java objects: no frameworks, no annotations

##### Core: Use Cases
* Represent your business actions, it’s what you can do with the application. Expect one use case for each business action
* Pure business logic, plain java (expect maybe some utils libraries like StringUtils)
* Define interfaces for the data that they need in order to apply some logic. One or more dataproviders will implement the interface, but the use case doesn’t know where the data is coming from
* The use case doesn't know who triggered it and how the results are going to be presented (e.g. could be on a web page, or returned as json, or simply logged, etc.)
* Throws business exceptions

##### Dataproviders
* Retrieve and store data from and to a number of sources (database, network devices, file system, 3rd parties, etc.)
* Implement the interfaces defined by the use case
* Use whatever framework is most appropriate (they are going to be isolated here anyway)
* Note: if using an ORM for database access, here you'd have another set of objects in order to represent the mapping to the tables (don't use the core entities as they might be very different)

##### Entrypoints
* Are ways to interact with the application, and typically involve a delivery mechanism (e.g. REST APIs, scheduled jobs, GUI, other systems)
* Trigger a use case and convert the result to the appropriate format for the delivery mechanism
* A GUI would use MVC (or MVP) in here; the controller would trigger a use case

##### Configuration
* Wires everything together
* Frameworks (e.g. for dependency injection) are isolated here
* Has the "dirty details" like Main class, web server configuration, datasource configuration, etc.

***

## Testing Strategy
<img src="docs/images/testing-strategy.png" alt="testing-strategy.png" width="700">

##### Unit Tests
* for TDD (a.k.a. Tests first, to drive design)
* Cover every little detail, aim for 100% coverage
* “Dev to dev” documentation: What should this class do?
* Test individual classes in isolation, very fast

##### Acceptance Tests
* for BDD (a.k.a. Conversations with the stakeholders)
* Demonstrate and document business requirements
* “Business” documentation: What does the system do?
* Test a use case in isolation, very fast (no GUI, no DB, etc.)
* Use your favourite BDD framework (we use [Yatspec](https://github.com/bodar/yatspec))

##### Integration Tests
* Test integration with slow parts (http, database, etc.)
* “Dev” documentation: Does this work as expected?
* Test one layer in isolation (e.g. only rest endpoint, or only data provider). Slow
* Use whatever library makes it easy (e.g. Spring MockMVC; in-memory db)

##### End-to-end Tests
* Test only the critical journeys (e.g. most common happy path)
* Demonstrate “business” end-to-end requirement
* Start the whole app, very slow. Keep these to a minimum

***

## Building and Running the application
* building the application:
```
./mvnw clean package
```
* running the application (from the jar, after having built it):
```
java -jar application/configuration/target/configuration-0.0.1-SNAPSHOT.jar
```
* running the application (on the fly):
```
./mvnw clean spring-boot:run
```
* running the application (in the IDE): open and run the main class
```
com.pedroarapua.cleanarchitecturejava.Application
```