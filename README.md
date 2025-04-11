# Spring Boot DATA JPA

1. Spring Boot Data JPA Application Setup
    * Maven Dependencies (Spring Data JPA, Lombok API, Oracle Driver/Mysql Driver)
    * application.properties file<br/>
        
        #spring data jpa's datasource properties<br/>
        * spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
        * spring.datasource.url=jdbc:oracle:thin:@localhost:1521/XE
        * spring.datasource.username=system
        * spring.datasource.password=manager <br/>
        
        #JPA Hibernate properties <br/>
        * spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
        * spring.jpa.show-sql=true
        * spring.jpa.hibernate.ddl-auto=update
    * model layer (@Component classes)
    * DAO layer (persistence layer)
        * SubInterface of JpaRepository(I)
    * service layer (@Service classes)
        * Business Interface with Business methods' signature
        * Business Interface Impl class (@Component) with methods' implementation
    * TestRunner class implementing CommandLine Interface.
2. Repository(I), CrudRepository(I), PagingAndSortingRepository(I) and JpaRepository(I)
    * Optional class
    * Sorty.by()
    * Pageable()
    * PageRequest.of()
3. @Query
    * Named parameters & Positional parameters (@Param)
    * @Transactional, @Modifying
4. Working with Date and Time
    * LocalDate, LocalTime and LocalDateTime
5. @Version, @CreationTimeStamp and @UpdateTimestamp
