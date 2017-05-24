package com.example.demo.controller

import com.example.demo.entity.Language
import com.example.demo.repository.LanguageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 言語情報を操作する.
 */
@RestController
class LanguageController(
    @Autowired private val languageRepository: LanguageRepository
) {
    @GetMapping("/languages")
    fun show(): List<Language> = languageRepository.findAll()
}
