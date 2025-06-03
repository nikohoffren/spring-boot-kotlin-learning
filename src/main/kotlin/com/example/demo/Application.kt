package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    @Suppress("JAVA_MODULE_DOES_NOT_EXPORT_PACKAGE")
    runApplication<Application>(*args)
}
