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


    public Score createUserScore(Long id, Integer category, Double flashcardSize, Double correct) {
        User user = userRepository.getOne(id);
        Categories setCategory = Categories.getCategory(category);

        Double user_score = Double.parseDouble(
                String.format("%.2f", ((correct / flashcardSize) * 100))
        );

        Score newScore = new Score(setCategory, user_score, user);

        return scoreRepository.save(newScore);
    }

    public Score updateUserScore(Long userId, Integer category, Double flashcardSize, Double correct) {
        User user = userRepository.getOne(userId);
        Categories setCategory = Categories.getCategory(category);

        Double user_score = Double.parseDouble(
                String.format("%.2f", ((correct / flashcardSize) * 100))
        );
        List<Score> userScoresList = scoreRepository.findAllByUser(user);

        for(Score each : userScoresList){
            if(each.getCategories().equals(setCategory)) {
                each.setScore(user_score);
                scoreRepository.save(each);
                return each;
            }
        }

        return null;
    }

    public List<Score> getUserScores(Long userId) {
        User user = userRepository.getOne(userId);

        return scoreRepository.findAllByUser(user);
    }
}
