package com.Flashycards.Flashycards.controllers;

import com.Flashycards.Flashycards.service.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlashcardController {

    @Autowired
    private FlashcardService flashcardService;
}
