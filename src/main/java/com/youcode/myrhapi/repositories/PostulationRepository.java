package com.youcode.myrhapi.repositories;

import com.youcode.myrhapi.models.Entities.Postulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostulationRepository extends JpaRepository<Postulation, Long>{
}