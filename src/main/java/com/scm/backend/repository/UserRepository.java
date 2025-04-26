package com.scm.backend.repository;

import com.scm.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
//@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User,String>
{
}
