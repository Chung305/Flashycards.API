package com.Flashycards.Flashycards.service;

import com.Flashycards.Flashycards.models.Suggestion;
import com.Flashycards.Flashycards.dao.SuggestionDAO;
import com.Flashycards.Flashycards.models.enums.Categories;
import com.Flashycards.Flashycards.repositories.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SuggestionService {

    @Autowired
    private SuggestionRepository suggestionRepository;

    public Suggestion createSuggestion(SuggestionDAO suggestion) {
        Suggestion newSuggestion = new Suggestion();
        newSuggestion.setCategory(Categories.getCategory(suggestion.getCategory()));
        newSuggestion.setQuestion(suggestion.getQuestion());
        newSuggestion.setDislike_count(0);
        newSuggestion.setLike_count(0);
        newSuggestion.setDate_created(LocalDate.now());

        return suggestionRepository.save(newSuggestion);
    }

    public Suggestion updateSuggestion(SuggestionDAO suggestion, Long id) {
        Optional<Suggestion> update = suggestionRepository.findById(id);

        if(update.isPresent()){
            update.get().setCategory(Categories.getCategory(suggestion.getCategory()));
            update.get().setQuestion(suggestion.getQuestion());
            return suggestionRepository.save(update.get());
        }

        return null;
    }

    public Suggestion getSuggestionById(Long id) {
        if(suggestionRepository.existsById(id))
            return suggestionRepository.findById(id).get();

        return null;
    }

    public List<Suggestion> findSuggestionByCategory(Integer categories) {
        return suggestionRepository.findAllByCategory(Categories.getCategory(categories));
    }

    public Iterable<Suggestion> findAllSuggestion() {
        return suggestionRepository.findAll();
    }
}
