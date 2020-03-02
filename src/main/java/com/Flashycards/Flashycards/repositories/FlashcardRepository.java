package com.Flashycards.Flashycards.repositories;

import com.Flashycards.Flashycards.models.Flashcards;
import com.Flashycards.Flashycards.models.enums.Categories;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlashcardRepository extends CrudRepository<Flashcards, Long> {
    List<Flashcards> findAllByCategory(Categories categories);
}
