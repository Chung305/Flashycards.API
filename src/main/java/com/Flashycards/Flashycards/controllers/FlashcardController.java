package com.Flashycards.Flashycards.controllers;

import com.Flashycards.Flashycards.dao.flashcardDAO;
import com.Flashycards.Flashycards.models.Flashcards;
import com.Flashycards.Flashycards.service.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flashcards")
public class FlashcardController {

    @Autowired
    private FlashcardService flashcardService;

    @PutMapping("/create/{categoryId}")
    public ResponseEntity<Flashcards> createFlashcard(@RequestBody flashcardDAO flashcard, @PathVariable Integer categoryId){
        return new ResponseEntity<>(flashcardService.createFlashcard(flashcard, categoryId), HttpStatus.CREATED);
    }
}
