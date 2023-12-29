package fr.limayrac.declarationFrais.declarationFrais.Entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String password;

    @OneToMany(mappedBy = "professor")
    private List<ExpenseDeclaration> expenseDeclarations;

    @OneToOne(mappedBy = "professor", cascade = CascadeType.ALL)
    private BankDetails bankDetails;

    // getters and setters
}
