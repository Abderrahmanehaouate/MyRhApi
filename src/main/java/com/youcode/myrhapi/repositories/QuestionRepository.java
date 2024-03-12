package com.youcode.myrhapi.repositories;

import com.youcode.myrhapi.models.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
