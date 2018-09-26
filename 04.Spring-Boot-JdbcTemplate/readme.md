## Spring Boot中使用JdbcTemplate 

 * 个人觉得JdbcTemplate相较于MyBaits，Hibernate等数据库框架更容易上手，对SQL的操作也更为直观方便，所以在项目中也是一个不错的选择。在Spring Boot开启JdbcTemplate很简单，只需要引入spring-boot-starter-jdbc依赖即可。JdbcTemplate封装了许多SQL操作，具体可查阅官方文档https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html。
 
 * 数据库驱动为ojdbc6 ！  