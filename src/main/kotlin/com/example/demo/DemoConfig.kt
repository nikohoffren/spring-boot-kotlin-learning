package com.example.demo

import org.springframework.stereotype.Service
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
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

    //* Creating instance of the class (Formatter interface) on the fly (inline implementation)
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

    //* Register StringHelpers as a bean for Thymeleaf advanced usage
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

//* Example: Service class with regular methods (no @Bean needed)
@Service
class MathService {
    fun add(a: Int, b: Int): Int = a + b
    fun multiply(a: Int, b: Int): Int = a * b
}

//* Example: Controller with handler methods (no @Bean needed)
@Controller
class ExampleController(private val mathService: MathService) {
    @GetMapping("/sum")
    fun sum(): String {
        val result = mathService.add(2, 3)
        return "Sum is $result"
    }
}

//* Example: Utility class (can be registered as a bean)
class StringHelpers {
    fun reverse(input: String): String = input.reversed()
}
