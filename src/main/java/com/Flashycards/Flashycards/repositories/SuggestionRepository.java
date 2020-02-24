package com.Flashycards.Flashycards.repositories;

import com.Flashycards.Flashycards.models.Suggestion;
import com.Flashycards.Flashycards.models.enums.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuggestionRepository extends CrudRepository<Suggestion, Long> {

    List<Suggestion> findAllByCategory(Categories category);
}
