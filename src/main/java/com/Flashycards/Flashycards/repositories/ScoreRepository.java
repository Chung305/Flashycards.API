package com.Flashycards.Flashycards.repositories;

import com.Flashycards.Flashycards.models.Score;
import com.Flashycards.Flashycards.models.User;
import com.Flashycards.Flashycards.models.enums.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends CrudRepository<Score, Long> {

    List<Score> findAllByUsers(User user);
    List<Score> findAllByCategories(Categories category);
    Score findByCategoriesAndUsers (User user, Categories category);
}
