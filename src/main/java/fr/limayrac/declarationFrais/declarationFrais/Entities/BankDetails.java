package fr.limayrac.declarationFrais.declarationFrais.Entities;

import jakarta.persistence.*;

@Entity
public class BankDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomEnregistrement;
    private String nomCompte;
    private String prenomCompte;
    private String IBAN;
    private String nomBanque;

    @ManyToOne
    @JoinColumn(name = "id_Users")
    private Users users;

    @OneToOne
    @JoinColumn(name = "id_ExpenseDeclaration", unique = true)
    private ExpenseDeclaration expenseDeclaration;

    // getters and setters
}


