package com.youcode.myrhapi.models.Entities;

import com.youcode.myrhapi.models.Enums.EducationLevel;
import com.youcode.myrhapi.models.Enums.Status;
import jakarta.persistence.*;
import jakarta.xml.soap.Text;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "job_offers")
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String profile;
    private String city;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = true)
    private Long salary;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "jobOffer" , cascade = CascadeType.ALL)
    private List<Postulation> postulations;
}
