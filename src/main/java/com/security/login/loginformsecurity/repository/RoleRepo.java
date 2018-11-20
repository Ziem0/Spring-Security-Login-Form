package com.security.login.loginformsecurity.repository;

import com.security.login.loginformsecurity.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role,Integer> {
}
