package fr.limayrac.declarationFrais.declarationFrais.Entities;

import jakarta.persistence.*;

@Entity
public class ExpenseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeFrais;
    private Double montant;

    @ManyToOne
    @JoinColumn(name = "declaration_id")
    private ExpenseDeclaration expenseDeclaration;

    // getters and setters
}
