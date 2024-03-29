package com.youcode.myrhapi.repositories;

import com.youcode.myrhapi.models.Entities.Agent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long>{
    Agent findByEmail(String email);
}
