package com.dmedelacruz.contactmanagement.repository;

import com.dmedelacruz.contactmanagement.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
}
