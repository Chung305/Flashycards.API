package com.Flashycards.Flashycards.repositories;

import com.Flashycards.Flashycards.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository <Role, Long> {
}
