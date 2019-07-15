package com.example.spring

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
open class RedisConfig {

  @Bean
  open fun redisTemplate(factory: RedisConnectionFactory): RedisTemplate<String, Any> {
    val template = RedisTemplate<String, Any>()
    template.connectionFactory = factory
    val jackson2JsonRedisSerializer = Jackson2JsonRedisSerializer(Any::class.java)
    val om = ObjectMapper()
    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL)
    jackson2JsonRedisSerializer.setObjectMapper(om)
    val stringRedisSerializer = StringRedisSerializer()
    // key采用String的序列化方式
    template.keySerializer = stringRedisSerializer
    // hash的key也采用String的序列化方式
    template.hashKeySerializer = stringRedisSerializer
    // value序列化方式采用jackson
    template.valueSerializer = jackson2JsonRedisSerializer
    // hash的value序列化方式采用jackson
    template.hashValueSerializer = jackson2JsonRedisSerializer
    template.afterPropertiesSet()
    return template
  }
}