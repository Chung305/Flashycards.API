package com.Flashycards.Flashycards.repositories;

import com.Flashycards.Flashycards.models.Flashcards;
import com.Flashycards.Flashycards.models.enums.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlashcardRepository extends CrudRepository<Flashcards, Long> {
    List<Flashcards> findAllByCategory(Categories categories);
}
