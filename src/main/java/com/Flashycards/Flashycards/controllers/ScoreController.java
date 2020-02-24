package com.Flashycards.Flashycards.controllers;

import com.Flashycards.Flashycards.models.Score;
import com.Flashycards.Flashycards.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    /**
     * @param userId => User ID
     * @param category => Category of the Test
     * @param flashcardSize => Number of flashcards in the stack
     * @param correct => How many correct flashcard questions answered
     * @return Returns User Score
     */

    @PostMapping("/{userId}/{category}/{flashcardSize}/{correct}")
    public ResponseEntity<Score> createUserScore (
            @PathVariable Long userId, @PathVariable Integer category,
            @PathVariable Double flashcardSize, @PathVariable Double correct){
        return new ResponseEntity<>(scoreService.createUserScore(userId, category, flashcardSize, correct), HttpStatus.CREATED);

    }

    @PutMapping("/update/{userId}/{category}/{flashcardSize}/{correct}")
    public ResponseEntity<Score> updateUserScore(
            @PathVariable Long userId, @PathVariable Integer category,
            @PathVariable Double flashcardSize, @PathVariable Double correct){
        return new ResponseEntity<>(scoreService.updateUserScore(userId, category, flashcardSize, correct), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Score>> getUserScores(@PathVariable Long userId){
        return new ResponseEntity<>(scoreService.getUserScores(userId), HttpStatus.OK);
    }

}
