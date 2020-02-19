package com.Flashycards.Flashycards.repositories;

import com.Flashycards.Flashycards.models.Flashcards;
import org.springframework.data.repository.CrudRepository;

public interface FlashcardRepository extends CrudRepository<Flashcards, Long> {
}
