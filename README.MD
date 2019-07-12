1.spring-boot-maven-plugin打包出现的问题
spring-boot工程打包编译时，会生成两种jar包，一种是普通的jar，另一种是可执行jar。默认情况下，这两种jar的名称相同，在不做配置的情况下，普通的jar先生成，可执行jar后生成，所以可执行jar会覆盖普通的jar。