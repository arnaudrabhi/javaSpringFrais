package fr.limayrac.declarationFrais.declarationFrais.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String role;

    // getters and setters

    @OneToMany(mappedBy = "user")
    private List<ExpenseDeclaration> expenseDeclarations;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private BankDetails bankDetails;

    // getters and setters
}
