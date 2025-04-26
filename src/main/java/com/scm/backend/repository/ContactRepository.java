package com.scm.backend.repository;

import com.scm.backend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

//import java.awt.print.Pageable;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
@RepositoryRestResource(path = "contacts" ,collectionResourceRel = "contacts")
public interface ContactRepository extends JpaRepository<Contact,String>
{

    @RestResource(path = "by-email")
    List<Contact> findByEmailContaining(@Param("email") String email, Pageable pageable);

    @RestResource(path = "by-phone",rel = "by-phone"   )
    List<Contact> findByPhoneNumberContainingIgnoreCase(String phoneNumber,Pageable pageable);

    @RestResource(path = "by-name")
    List<Contact> findByNameContainingIgnoreCase(@Param("name") String name,Pageable pageable);
}
