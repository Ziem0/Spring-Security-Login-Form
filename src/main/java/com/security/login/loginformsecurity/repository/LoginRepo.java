package com.security.login.loginformsecurity.repository;

import com.security.login.loginformsecurity.models.LoginObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepo extends CrudRepository<LoginObject, Integer> {

	@Query(value = "select o from LoginObject o where o.username = :searchedUsername and password = :searchedPassword")
	Optional<LoginObject> getByUsernameAndPassword(@Param("searchedUsername") String searchedUsername, @Param("searchedPassword") String searchesPassword);

}
