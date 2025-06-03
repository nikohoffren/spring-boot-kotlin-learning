package com.example.demo

import org.springframework.stereotype.Service
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

//* */ Example: Service class with regular methods (no @Bean needed)
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
