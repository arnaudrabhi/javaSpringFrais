package fr.limayrac.declarationFrais.declarationFrais.Entities;

import jakarta.persistence.*;

@Entity
public class BankDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulaireCompte;
    private String numeroCompte;
    private String nomBanque;

    @OneToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    // getters and setters
}

