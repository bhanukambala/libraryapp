# ===============================
# = DATA SOURCE
# ===============================
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url =jdbc:mysql://localhost:3306/booksdb
spring.datasource.username =bhanu
spring.datasource.password=Bhanu@73

# ===============================
# JPA / HIBERNATE / with hsql
# ===============================
spring.jpa.show-sql = false
spring.jpa.hibernate.ddl-auto = create
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
hibernate.format_sql=true;
# ===============================