package com.Flashycards.Flashycards.repositories;

import com.Flashycards.Flashycards.models.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends CrudRepository<Score, Long> {
}
