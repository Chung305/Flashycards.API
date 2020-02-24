package com.Flashycards.Flashycards.service;

import com.Flashycards.Flashycards.models.Score;
import com.Flashycards.Flashycards.models.User;
import com.Flashycards.Flashycards.models.enums.Categories;
import com.Flashycards.Flashycards.repositories.ScoreRepository;
import com.Flashycards.Flashycards.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private UserRepository userRepository;


    public Double createUserScore(Long id, Integer category, Double flashcardSize, Double correct) {
        User user = userRepository.getOne(id);
        Categories setCategory = Categories.getCategory(category);

        Double user_score = Double.parseDouble(
                String.format("%.2f", ((correct / flashcardSize) * 100))
        );

        Score newScore = new Score(setCategory, user_score, user);
        user.getScores().add(newScore);

        userRepository.save(user);

        return user_score;
    }

    public Score updateUserScore(Long userId, Integer category, Double flashcardSize, Double correct) {
        User user = userRepository.getOne(userId);
        Categories setCategory = Categories.getCategory(category);

        Double user_score = Double.parseDouble(
                String.format("%.2f", ((correct / flashcardSize) * 100))
        );

        
        return null;

    }
}
