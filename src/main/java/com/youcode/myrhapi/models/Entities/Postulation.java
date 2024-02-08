package com.youcode.myrhapi.models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "postulations")
public class Postulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cv;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "job_offer_id")
    private JobOffer jobOffer;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
