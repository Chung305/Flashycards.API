package com.Flashycards.Flashycards.controllers;

import com.Flashycards.Flashycards.models.Suggestion;
import com.Flashycards.Flashycards.dao.SuggestionDAO;
import com.Flashycards.Flashycards.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suggestion")
public class SuggestionController {

    @Autowired
    private SuggestionService suggestionService;

    /**
     * Rethink How suggestion is going to function, Refactor later
     */

    @PostMapping("/create")
    public ResponseEntity<Suggestion> createSuggestion (@RequestBody SuggestionDAO suggestion){
        return new ResponseEntity<>(suggestionService.createSuggestion(suggestion), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Suggestion> updateSuggestion(@RequestBody SuggestionDAO suggestion, @PathVariable Long id){
        return new ResponseEntity<>(suggestionService.updateSuggestion(suggestion, id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suggestion> getSuggestionById(@PathVariable Long id){
        return new ResponseEntity<>(suggestionService.getSuggestionById(id), HttpStatus.OK);
    }

    @GetMapping("/{categories}")
    public ResponseEntity<List<Suggestion>> findSuggestionByCategory(@PathVariable Integer categories){
        return new ResponseEntity<>(suggestionService.findSuggestionByCategory(categories), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Suggestion>> findAllSuggestion(){
        return new ResponseEntity<>(suggestionService.findAllSuggestion(), HttpStatus.OK);
    }






}
