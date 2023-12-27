package com.youcode.myrhapi.repositories;

import com.youcode.myrhapi.models.Entities.VerifiedAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerifiedAccountRepository extends JpaRepository<VerifiedAccount, Long> {
    Optional<VerifiedAccount> findByEmail(String email);
}
