# mybatisplus with redis 使用Lettuce

## pom
springboot2.0  使用Lettuce
'<dependency>
	
	<groupId>org.springframework.boot</groupId>
	
	<artifactId>spring-boot-starter-cache</artifactId>
	
</dependency>

<dependency>
	
	<groupId>org.springframework.boot</groupId>
	
	<artifactId>spring-boot-starter-data-redis</artifactId>
	
</dependency>
'
springboot2.0
`<parent>

      <groupId>org.springframework.boot</groupId>
      
      <artifactId>spring-boot-starter-parent</artifactId>
      
      <version>2.2.4.RELEASE</version>
      
      <relativePath/> <!-- lookup parent from repository -->
      
</parent>`


## application.properties

#Redis数据库索引（默认为0）

spring.redis.database=1

#Redis服务器地址

spring.redis.host=127.0.0.1

#Redis服务器连接端口

spring.redis.port=6379

#Redis服务器连接密码（默认为空）

spring.redis.password=

spring.data.redis.repositories.enabled=false

#连接池最大连接数（使用负值表示没有限制)

spring.redis.Lettuce.pool.max-active=10

#连接池最大阻塞等待时间（使用负值表示没有限制）

spring.redis.Lettuce.pool.max-wait=-1

#连接池中的最大空闲连接

spring.redis.Lettuce.pool.max-idle=8

#连接池中的最小空闲连接

spring.redis.Lettuce.pool.min-idle=0

#连接超时时间（毫秒）

spring.redis.timeout=300
