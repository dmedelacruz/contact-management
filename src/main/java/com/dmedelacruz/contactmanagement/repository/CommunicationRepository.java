package com.dmedelacruz.contactmanagement.repository;

import com.dmedelacruz.contactmanagement.model.entity.Communication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationRepository extends JpaRepository<Communication, String> {
}
