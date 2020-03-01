package com.Flashycards.Flashycards.controllers;

import com.Flashycards.Flashycards.dao.FlashcardDAO;
import com.Flashycards.Flashycards.models.Flashcards;
import com.Flashycards.Flashycards.service.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("/api/flashcards")
public class FlashcardController {

    @Autowired
    private FlashcardService flashcardService;

    /**
     * Creates a new flashcard for a certain category
     * @param category Integer value for category Enum
     * @param flashcard Data access object for create a flashcard
     * @return returns flashcard entity
     */
    @PostMapping("/create/{category}")
    public ResponseEntity<Flashcards> createFlashcard(@PathVariable Integer category, @RequestBody FlashcardDAO flashcard){
        return new ResponseEntity<>(flashcardService.createFlashcard(category, flashcard), HttpStatus.CREATED);
    }

    /**
     * Updates flashcard by flashcard ID
     * @param flashcardId id to locate flashcard if it exists
     * @param flashcard data access object for updating a flashcard
     * @return returns flashcard entity
     */
    @PutMapping("/update/{flashcardId}")
    public ResponseEntity<Flashcards> updateFlashcard(@PathVariable Long flashcardId, @RequestBody FlashcardDAO flashcard){
        return new ResponseEntity<>(flashcardService.updateFlashcard(flashcardId, flashcard), HttpStatus.OK);
    }

    /**
     * Delete flashcard by flashcard ID
     * @param flashcardId id to locate flashcard if it exists
     * @return true ? false
     */
    @DeleteMapping("/delete/{flashcardId}")
    public ResponseEntity<Boolean> deleteFlashcard (@PathVariable Long flashcardId){
        return new ResponseEntity<>(flashcardService.deleteFlashcard(flashcardId), HttpStatus.OK);
    }

    /**
     * Find all flashcards with a certain category
     * ADMIN use ONLY
     * @param category Integer value of category
     * @return list of flashcards
     */
    @GetMapping("/all/{category}")
    public ResponseEntity<List<Flashcards>> findAllByCategory(@PathVariable Integer category){
        return new ResponseEntity<>(flashcardService.findAllByCategory(category), HttpStatus.OK);
    }


    @GetMapping("/study/{category}")
    public ResponseEntity<Stack<Flashcards>> studyFindAllByCategory(@PathVariable Integer category){
        return new ResponseEntity<>(flashcardService.studyFindAllByCategory(category), HttpStatus.OK);
    }

    @GetMapping("/study/stack/{category1}/{category2}")
    public ResponseEntity<Stack<Flashcards>> stackStudyFindAllByCategory(@PathVariable Integer category1, @PathVariable Integer category2){
        return new ResponseEntity<>(flashcardService.studyFindAllByCategory(category1, category2), HttpStatus.OK);
    }




}
