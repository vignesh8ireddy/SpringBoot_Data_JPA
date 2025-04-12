# Spring Boot DATA JPA

* Spring Data is the main module in the Spring framework, Spring Data JPA, Spring Data JDBC, Spring Data MongoDB, and 
more than 30 other modules are the submodules of Spring Data.
* Spring JDBC X Spring Data JDBC
  * Spring JDBC provides abstraction on plain JDBC and simplifies persistence logic development in JDBC style itself.
  * Spring Data JDBC is one O-R mapping mechanism to develop the persistence logic. It is combination of Spring JDBC and
  Spring ORM modules.
* Need of ORM Persistence Technology
  * A java application can read and write data to a file using IO Streams, and it can work with Relational database
  using plain JDBC or ORM (Object Relational Mapping) Technology.
  * Limitations of using plain JDBC for developing persistence logics:
    1. Plain JDBC persistence logic use SQL queries which are DB specific, so changing DB s/w becomes difficult.
    2. Involves a lot of Boilerplate code.
    3. All the Exceptions are Checked Exceptions, so one has to handle and propagate each of them separately.
    4. ResultSet object is not Serializable by default, so need to convert the ResultSet to other Collection data to
    send the data over the network.
  * To Overcome the above limitations we use ORM persistence technology with the support of JPA (Java Persistence API)
  software like Hibernate, Ibatis, Toplink, etc.
  *  ORM (Object Relational Mapping) : Technique of mapping Relational DB Table and Java Bean/Class, where columns of 
  the table are linked with properties of the java class to allow to develop persistence logic without SQL 
  queries which is independent of DB s/w.
    * It achieves synchronization between java objects and DB table records where modification done in the objects
    reflect in the DB table records and vice-versa.
  * ORM technology internally generates the plain JDBC persistence logics specific to DB s/w accordingly.
  * The Java Bean class which is mapped to the DB table is called Model/Entity class.
  * Advantages of the ORM Technology
    1. No need of writing DB s/w specific SQL queries (internally generated automatically)
    2. Boilerplate code is reduced drastically.
    3. Most of the Exceptions in ORM Technology are UnChecked.
    4. Select operation records are returned as a List of Model class objects, making it easy to send the List over the
    network.
    5. Supports advanced features like Caching, TimeStamping and Versioning of the records.
    6. Provides multiple kinds of generators to generate the id values for the records dynamically.
  * Major Drawback of the ORM Technology
    * If one has to read large no. of records of the DB table, then large no. of objects has to be created for the Model
    class this may lead to memory issues and application crashing.
    * Solution: In such cases of select operations, use plain JDBC instead of ORM technology, which creates only one
    ResultSet Object containing the large no. of records of the DB table
* Before Spring Data Module, a Spring application has to use Spring JDBC or Spring ORM modules to communicate with
Relational DB s/w, MongoDB api + MongoDB drivers to work with MongoDB s/w, Cassandra api + Cassandra drivers to work 
with Cassandra DB s/w, Neo4j api + Neo4j drivers to work with Neo4j DB s/w...
  * Spring didn't have any unified module to work with any NoSQL DB s/w like it has Spring ORM module to work with any
  SQL DB s/w.
* Spring Data Module provides single unified module to work with both SQL and NoSQL DB s/w by providing multiple
submodules.
  * Spring Data JPA submodule is used to work with any SQL DB s/w, it provides abstraction on ORM technology.
  * Spring Data MongoDB submodule is used to work with MongoDB DB s/w, it provides abstraction on MongoDB api.
  * Likewise, Spring Data Cassandra, Spring Data Neo4J, Spring Data Redis, Spring Data Elasticsearch, etc. are provided
  the Spring Data Module.

### Spring Boot Data JPA

* Spring Boot Data JPA internally uses Hibernate as ORM JPA Technology.
* Develop and Map the Model class using the following groups of annotations given by different vendors
  1. JPA annotations (portable across multiple DB s/ws)
  2. Java Config annotations (given by JDK)
  3. Hibernate specific annotations
  4. Third party annotations
  * Use the above order to prefer the annotations while using them.
* In Spring Boot Data JPA, to develop persistence logics we must develop a custom DAO interface that directly/indirectly
extends predefined Repository interface given by Spring Data JPA to inherit different levels of common methods that are
required for persistence operations.
  * No need of developing any implementation class for this custom DAO interface, because the Spring Data JPA internally
  generates an InMemory Proxy classes (Proxy Design Pattern) with DB s/w specific persistence logics as implementation
  class of the custom dao interface we developed.
* Predefined Repository Interface Hierarchy in Spring 2.x
  * Repository<T, ID extends Serializable> (Marker Interface)
    * CrudRepository<T, ID extends Serializable> (Interface with 12 methods signature)
      * PagingAndSortingRepository<T, ID extends Serializable> (Interface with 2 methods signature)
        * JpaRepository<T,ID> (Interface with 15 methods signature)
        * MongoRepository<T,ID> (Interface with 4 methods signature)
        * Neo4JRepository<T,ID> (Interface with x methods signature)
        * CassandraRepository<T,ID> (Interface with y methods signature)
* Predefined Repository Interface Hierarchy in Spring 3.x
   * Repository<T, ID extends Serializable> (Marker Interface)
      * CrudRepository<T, ID extends Serializable> (Interface with 12 methods signature)
        * JpaRepository<T,ID> (Interface with 15 methods signature)
        * MongoRepository<T,ID> (Interface with 4 methods signature)
        * Neo4JRepository<T,ID> (Interface with x methods signature)
        * CassandraRepository<T,ID> (Interface with y methods signature)
      * PagingAndSortingRepository<T, ID extends Serializable> (Interface with 2 methods signature)
        * JpaRepository<T,ID> (Interface with 15 methods signature)
      > JpaRepository<T,ID> extends CrudRepository<T,ID>, PagingAndSortingRepository<T,ID>
* Spring Boot Data JPA Application Setup
  * Maven Dependencies (Spring Data JPA, Lombok API, Oracle Driver/Mysql Driver)
  * application.properties file
  <pre>
    #spring data jpa's datasource properties
    spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
    spring.datasource.url=jdbc:oracle:thin:@localhost:1521/XE
    spring.datasource.username=system
    spring.datasource.password=manager
     
    #JPA Hibernate properties
    spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update/create/validate/create-drop/none
  </pre>
  
  <pre>
    Note: The following are JDBC Driver Class Names and URLs for popular Relational DB s/w
  
    MySQL Driver Class Name= com.mysql.cj.jdbc.Driver
    MySQL JDBC URL= jdbc:mysql://[hostname]:[port]/[database_name]
                    jdbc:mysql://localhost:3306/mydatabase

    Oracle Driver Class Name= oracle.jdbc.OracleDriver
    Oracle JDBC URL= jdbc:oracle:thin:@[hostname]:[port]:[SID]
                     jdbc:oracle:thin:@localhost:1521/XE

    PostgreSQL Driver Class Name=org.postgresql.Driver
    PostgreSQL JDBC URL= jdbc:postgresql://[hostname]:[port]/[database_name]
                         jdbc:postgresql://localhost:5432/mydatabase
  </pre>
  
  * Model layer
    * @Entity, @Table(name=""), @Id, @Column(name="", length=int), @Transient
    * @GeneratedValue(strategy=GenerationType.AUTO/SEQUENCE/TABLE/IDENTITY) is applicable along with @Id
    * Generally, one Model class represents one DB table.
  * DAO layer (persistence layer)
    * SubInterface of JpaRepository(I)
  * service layer (@Service classes)
    * Business Interface with Business methods' signature
    * Business Interface Impl class (@Component) with methods' implementation
  * TestRunner class implementing CommandLine Interface.
* Because of the Spring Data JPA starter, the JPA's EntityManager Object comes as a spring bean through 
autoconfiguration and EntityManager Object holds instance of the DataSource which is also made as spring bean 
automatically through autoconfiguration.
* Working Flow a Spring Boot Data JPA Application
  1. Bootstrapping of Spring Boot App
  2. Read application.properties file to Environment object
  3. Using the Environment object, @EnableAutoConfiguration of @SpringBootApplication makes the following classes as
  spring beans.
     * HikariDataSource pointing to the DB
     * EntityManager Object encapsulating the activated Hibernate's SessionFactory, Session objects and also above
     DataSource object pointing to the DB
  4. @ComponentScan of @SpringBootApplication scan all the packages for the stereotype classes and make them as spring
  beans, also InMemory proxy class is created with @Repository annotation
  5. IOC container performs pre-instantiation of singleton scope beans and the following objects are created
     * HikariDataSource
     * EntityManager (This EntityManager Object has above HikariDataSource reference and injection happens at 
     autowiring)
     * InMemory Proxy class
     * User defined singleton scope stereotype classes' objects
  6. Autowiring takes place.
  7. Singleton scope beans are kept in IOC Cache.
* CrudRepository(I) methods
  * Create: save(S), saveAll(Iterable\<S>); \<S extends T>
  * Read: findAll(), findById(ID), findAllById(Iterable<ID>), existById(ID)
    * Optional API and UseCases
      * Optional.of(T), Optional.get(), Optional.isPresent(), Optional.orElseThrow(), etc.
  * Update: uses Create methods
  * Delete: deleteAll(), deleteById(ID), deleteAllById(Iterable<ID>), delete(? extends T),
            deleteAll(Iterable<? extends T>)
* The methods in the dynamically generated InMemory proxy class throws only Unchecked exceptions, which are propagated
to client class through the service class, so handle them at either at service class or client class(recommended).
* PagingAndSortingRepository(I)
  * findAll(Sort), findAll(Pageable)
  * Sort.by(DIRECTION,String...):Sort
  * PageRequest.of(int,int):Pageable, PageRequest.of(int,int,Sort):Pageable => first sorting, then pagination happens.
* JpaRepository(I)
  * findAll(Example\<S>,Sort), getReferenceById(ID), saveAndFlush(S), saveAllAndFlush(Iterable\<S>)
    * \<S extend T>
    * Example class X Optional class
    * JpaRepository.getReferenceById(ID) X CrudRepository.findById(ID)
      * lazy loading of record X eager loading of record from DB
      * application.properties=> enable lazy loading no transaction=true
* Finder methods in Spring Data JPA
  * These are abstract method declarations done in custom repository interface extending predefined interface, their
  implementations are generated in InMemory Proxy class.
  * Syntax:: public \<RT> findBy\<PropertyName(s)><Condition(s)>(parameters)
  ```
    public List<Movie> findByMname(String mname);//same as findByMnameEquals(String mname);
    public List<Movie> findByMnameStartingWith(String initChars);
    public List<Movie> findByMnameEndingWith(String endChars);
    public Iterable<Movie> findByMnameContaining(String subChars);
    public Iterable<Movie> findByMnameEqualsIgnoreCase(String mname);
  ```
  * Static Scalar Projections
  * Dynamic Scalar Projections
* @Query Methods
   * Named parameters & Positional parameters (@Param)
   * @Transactional, @Modifying
* @Version, @CreationTimeStamp and @UpdateTimestamp
* Working with Date and Time
  * LocalDate, LocalTime and LocalDateTime
* Working with BOB and LOB
* Associations
* Interacting with multiple DB s/w