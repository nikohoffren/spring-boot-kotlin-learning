package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.beans.factory.annotation.Autowired

@Controller
class PageController @Autowired constructor(
    private val greetingService: GreetingService,
) {
    @GetMapping("/")
    fun home(model: org.springframework.ui.Model): String {
        val greeting = greetingService.getGreeting()
        model.addAttribute("greeting", greeting)
        model.addAttribute("reversedGreeting", StringHelpers().reverse(greeting))
        return "home"
    }

    @GetMapping("/about")
    fun about(): String {
        return "about"
    }
}
