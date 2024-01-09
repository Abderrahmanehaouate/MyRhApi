package com.youcode.myrhapi.models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "candidats")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "postulation_id")
    private Postulation postulation;
}
