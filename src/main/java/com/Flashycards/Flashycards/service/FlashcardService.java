package com.Flashycards.Flashycards.service;

import com.Flashycards.Flashycards.dao.FlashcardDAO;
import com.Flashycards.Flashycards.models.Flashcards;
import com.Flashycards.Flashycards.models.enums.Categories;
import com.Flashycards.Flashycards.repositories.FlashcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

@Service
public class FlashcardService {

    @Autowired
    private FlashcardRepository flashcardRepository;

    public Flashcards createFlashcard(Integer category, FlashcardDAO flashcard) {
        Flashcards newFlashcard = new Flashcards();

        newFlashcard.setCategory(Categories.getCategory(category));
        newFlashcard.setQuestion(flashcard.getQuestion());
        newFlashcard.setAnswer(flashcard.getAnswer());

        return flashcardRepository.save(newFlashcard);
    }

    public Flashcards updateFlashcard(Long flashcardId, FlashcardDAO flashcard) {
        Flashcards flashcards = new Flashcards();

        if(flashcardRepository.existsById(flashcardId)){
            flashcards = flashcardRepository.findById(flashcardId).get();
            flashcards.setQuestion(flashcard.getQuestion());
            flashcards.setAnswer(flashcard.getAnswer());
        }

        return flashcards;
    }

    public Boolean deleteFlashcard(Long flashcardId) {
        if(flashcardRepository.existsById(flashcardId)){
            flashcardRepository.deleteById(flashcardId);
            return true;
        }
        return false;
    }

    public List<Flashcards> findAllByCategory(Integer category) {
        Categories categories = Categories.getCategory(category);

        return flashcardRepository.findAllByCategory(categories);
    }


    public Stack<Flashcards> studyFindAllByCategory(Integer category) {
        List<Flashcards> flashcardsList = findAllByCategory(category);

        Stack<Flashcards> flashcardsStack = new Stack<>();
        flashcardsStack.addAll(flashcardsList);

        Collections.shuffle(flashcardsStack);

        return flashcardsStack;
    }

    public Stack<Flashcards> studyFindAllByCategory(Integer category1, Integer category2) {
        Stack<Flashcards> flashcardsStack = new Stack<>();
        flashcardsStack.addAll(findAllByCategory(category1));
        flashcardsStack.addAll(findAllByCategory(category2));

        Collections.shuffle(flashcardsStack);

        return flashcardsStack;
    }
}
