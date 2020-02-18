package com.Flashycards.Flashycards.repositories;

import com.Flashycards.Flashycards.models.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends CrudRepository<Comments, Long> {
}
