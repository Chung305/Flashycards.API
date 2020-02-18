package com.Flashycards.Flashycards.repositories;

import com.Flashycards.Flashycards.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository <Users, Long> {

}
