package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
class ContactController {
    private var lastContactSubmission: ContactForm? = null

    @GetMapping("/contact")
    fun contact(): String {
        return "contact"
    }

    @PostMapping("/contact")
    fun handleContact(
        @RequestParam name: String,
        @RequestParam email: String,
        @RequestParam message: String,
        redirectAttributes: RedirectAttributes
    ): String {
        val form = ContactForm(name, email, message)
        lastContactSubmission = form
        redirectAttributes.addFlashAttribute("contactInfo", form)
        redirectAttributes.addFlashAttribute("contactSuccess", true)
        return "redirect:/"
    }
}

data class ContactForm(val name: String, val email: String, val message: String)
