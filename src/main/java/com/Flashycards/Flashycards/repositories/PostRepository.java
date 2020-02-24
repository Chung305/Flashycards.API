package com.Flashycards.Flashycards.repositories;

import com.Flashycards.Flashycards.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
