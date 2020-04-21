# mybatisplus with redis 使用Lettuce

## step1:配置pom
springboot2.0  使用Lettuce
'<dependency>
	
	<groupId>org.springframework.boot</groupId>
	
	<artifactId>spring-boot-starter-cache</artifactId>
	
</dependency>

<dependency>
	
	<groupId>org.springframework.boot</groupId>
	
	<artifactId>spring-boot-starter-data-redis</artifactId>
	
</dependency>'

springboot2.0
`<parent>

      <groupId>org.springframework.boot</groupId>
      
      <artifactId>spring-boot-starter-parent</artifactId>
      
      <version>2.2.4.RELEASE</version>
      
      <relativePath/> <!-- lookup parent from repository -->
      
</parent>`


## step2:配置application.properties

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

## step3:编写redis配置类

`package com.example.demo.config;  
  
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;  
import org.springframework.cache.annotation.CachingConfigurerSupport;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.beans.factory.annotation.Value;  
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.data.redis.cache.RedisCacheConfiguration;  
import org.springframework.data.redis.cache.RedisCacheManager;  
import org.springframework.data.redis.cache.RedisCacheWriter;  
import org.springframework.data.redis.connection.RedisPassword;  
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;  
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;  
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;  
import org.springframework.data.redis.core.RedisTemplate;  
import org.springframework.data.redis.serializer.*;  
import com.fasterxml.jackson.annotation.JsonAutoDetect;  
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Duration;
  
@Configuration  
//Redis 缓存配置类  
public class RedisConfig extends CachingConfigurerSupport {  

    @Value("${spring.redis.database}")
    private int database;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxActive;
    @Value("${spring.redis.jedis.pool.max-wait}")
    private int maxWait;
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;
    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;
    @Value("${spring.redis.timeout}")
    private int timeout;

    @Autowired
    private LettuceConnectionFactory lettuceConnectionFactory;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration ();
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setDatabase(database);
        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));

        LettuceClientConfiguration.LettuceClientConfigurationBuilder lettuceClientConfigurationBuilder=LettuceClientConfiguration.builder();
        lettuceClientConfigurationBuilder.commandTimeout(Duration.ofMillis(timeout));
        LettuceConnectionFactory factory = new LettuceConnectionFactory(redisStandaloneConfiguration,
                lettuceClientConfigurationBuilder.build());
        //factory.afterPropertiesSet();
        System.out.println("LettuceConnectionFactory");
        return factory;
    }

    @Bean
    public RedisCacheManager redisCacheManager() {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(lettuceConnectionFactory);

        RedisSerializer stringSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.PUBLIC_ONLY);
        //om.activateDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer));
        redisCacheConfiguration.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()));
        redisCacheConfiguration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer));

        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
    }
}
`

## step4:Application启动类上加上可缓存注解@EnableCaching  
## step5:编写Service类
`
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.cache.annotation.CacheConfig;  
import org.springframework.cache.annotation.CacheEvict;  
import org.springframework.cache.annotation.Cacheable;  
import org.springframework.stereotype.Service;  
import java.util.List;  
@CacheConfig(cacheNames="users")  
@Service(value="UserService")  
public class UserService{  
    @Autowired  
    public UserMapper userMapper;  
    @Cacheable(value="Alluser",key="'users-all'")  
    public List<User> getAllUsers(QueryWrapper<User>wrapper){  
        System.out.println("querying in database!adding cache");
        return userMapper.selectList(wrapper);
    }
    @CacheEvict(value="Alluser",allEntries = true)  
    public void addUser(User user)  
    {
        System.out.println("clear cache!");
        userMapper.insert(user);
    }
}`
