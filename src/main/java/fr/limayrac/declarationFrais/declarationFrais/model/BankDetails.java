package fr.limayrac.declarationFrais.declarationFrais.model;

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
    @JoinColumn(name = "id_User")
    private User user;

    @OneToOne
    @JoinColumn(name = "id_ExpenseDeclaration", unique = true)
    private ExpenseDeclaration expenseDeclaration;

    // getters and setters
}


