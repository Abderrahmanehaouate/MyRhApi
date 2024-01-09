package com.youcode.myrhapi.repositories;

import com.youcode.myrhapi.models.Entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
