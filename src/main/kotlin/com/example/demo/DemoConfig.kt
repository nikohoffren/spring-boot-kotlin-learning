package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.format.Formatter
import java.text.ParseException
import java.util.*

@Configuration
class DemoConfig {
    @Bean
    fun greetingService(): GreetingService = GreetingService()

    @Bean
    fun dateFormatter(): Formatter<Date> = object : Formatter<Date> {
        override fun parse(text: String, locale: Locale): Date = Date(text.toLong())
        override fun print(date: Date, locale: Locale): String = date.time.toString()
    }

    @Bean
    fun stringUtil(): StringUtil = StringUtil()

    @Bean
    @Scope("prototype")
    fun randomIdGenerator(): RandomIdGenerator = RandomIdGenerator()

    //* */ Register StringHelpers as a bean for Thymeleaf advanced usage
    @Bean("stringHelpers")
    fun stringHelpers(): StringHelpers = StringHelpers()
}

class GreetingService {
    fun getGreeting(): String = "Hello from the custom Beaasn!!"
}

class StringUtil {
    fun toUpperCase(input: String): String = input.uppercase()
}

class RandomIdGenerator {
    fun generate(): String = UUID.randomUUID().toString()
}
