package com.youcode.myrhapi.models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "verified_accounts")
public class VerifiedAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long code;
    private LocalDateTime expiredAt;
    private String email;
}
